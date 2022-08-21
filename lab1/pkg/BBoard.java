package pkg;
import java.util.*;
import java.io.*;

public class BBoard {		// This is your main file that connects all classes.
	// Think about what your global variables need to be.
	private ArrayList<Message> messageList;
	private ArrayList<User> userList;
	private User mainUser;
	private Scanner s;
	private String title, path;

	// Default constructor that creates a board with a defaulttitle, empty user and message lists,
	// and no current user
	public BBoard() {
		messageList = new ArrayList<>();
		userList = new ArrayList<>();
		s = new Scanner(System.in);
		title = "testBoard";
	}

	// Same as the default constructor except it sets the title of the board
	public BBoard(String ttl) {
		messageList = new ArrayList<>();
		userList = new ArrayList<>();
		s = new Scanner(System.in);
		title = ttl;
	}

	// Gets a filename of a file that stores the user info in a given format (users.txt)
	// Opens and reads the file of all authorized users and passwords
	// Constructs a User object from each name/password pair, and populates the userList ArrayList.
	public void loadUsers(String inputFile) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(inputFile));
		path = inputFile;
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			int split = line.indexOf(' ');
			userList.add(new User(line.substring(0, split), line.substring(split+1)));
		}
	}

	// Asks for and validates a user/password. 
	// This function asks for a username and a password, then checks the userList ArrayList for a matching User.
	// If a match is found, it sets currentUser to the identified User from the list
	// If not, it will keep asking until a match is found or the user types 'q' or 'Q' as username to quit
	// When the users chooses to quit, say "Bye!" and return from the login function
	public void login() {
		boolean logged = false;
		while(!logged) {
			System.out.print("Enter your username ('Q' or 'q' to quit): ");
			String name = s.nextLine();
			if(name.toLowerCase().equals("q")) {
				System.out.println("Bye!");
				return;
			}
			System.out.print("Enter your password: ");
			String pw = s.nextLine();
			for(User u : userList) {
				if(u.check(name, pw)) {
					logged = true;
					mainUser = u;
					System.out.print("Welcome, " + name + "!\n");
					return;
				}
			}
			System.out.println("Invalid username/password.\n");
		}
	}
	
	// Contains main loop of Bulletin Board
	// IF and ONLY IF there is a valid currentUser, enter main loop, displaying menu items
	// --- Display Messages ('D' or 'd')
	// --- Add New Topic ('N' or 'n')
	// --- Add Reply ('R' or 'r')
	// --- Change Password ('P' or 'p')
	// --- Quit ('Q' or 'q')
	// With any wrong input, user is asked to try again
	// Q/q should reset the currentUser to 0 and then end return
	// Note: if login() did not set a valid currentUser, function must immediately return without showing menu
	public void run() throws FileNotFoundException, IOException {
		System.out.println(title);
		login();
		if(mainUser != null) {
			while(true) {
				System.out.print(
					"\nMenu\n" 							   +
					"  - Display Messages ('D' or 'd')\n"  +
					"  - Add New Topic ('N' or 'n')\n" 	   +
					"  - Add Reply ('R' or 'r')\n"     	   +
					"  - Change Password ('P' or 'p')\n"   +
					"  - Quit ('Q' or 'q')\n"			   +
					"Choose an action: "
				);
				switch(s.nextLine().toLowerCase()) {
					case "d": {
						display();
						break;
					}case "n": {
						addTopic();
						break;
					}case "r": {
						addReply();
						break;
					}case "p": {
						setPassword();
						break;
					}case "q": {
						System.out.println("Bye!\n");
						return;
					}
				}
			}
		}
	}

	// Traverse the BBoard's message list, and invote the print function on Topic objects ONLY
	// It will then be the responsibility of the Topic object to invoke the print function recursively on its own replies
	// The BBoard display function will ignore all reply objects in its message list
	private void display() {
		for(Message m : messageList) {
			if(!m.isReply()) {
				m.print(0);
			}
		}
	}


	// This function asks the user to create a new Topic (i.e. the first message of a new discussion "thread")
	// Every Topic includes a subject (single line), and body (single line)

	/* 
	Subject: "Thanks"
	Body: "I love this bulletin board that you made!"
	*/

	// Each Topic also stores the username of currentUser; and message ID, which is (index of its Message + 1)

	// For example, the first message on the board will be a Topic who's index will be stored at 0 in the messageList ArrayList,
	// so its message ID will be (0+1) = 1
	// Once the Topic has been constructed, add it to the messageList
	// This should invoke your inheritance of Topic to Message
	private void addTopic() {
		System.out.print("\nSubject: ");
		String sub = s.nextLine();
		System.out.print("Body: ");
		String bod = s.nextLine();
		messageList.add(new Topic(mainUser.getUsername(), sub, bod, messageList.size()+1));
	}

	// This function asks the user to enter a reply to a given Message (which may be either a Topic or a Reply, so we can handle nested replies).
	//		The addReply function first asks the user for the ID of the Message to which they are replying;
	//		if the number provided is greater than the size of messageList, it should output and error message and loop back,
	// 		continuing to ask for a valid Message ID number until the user enters it or -1.
	// 		(-1 returns to menu, any other negative number asks again for a valid ID number)
	
	// If the ID is valid, then the function asks for the body of the new message, 
	// and constructs the Reply, pushing back the Reply on to the messageList.
	// The subject of the Reply is a copy of the parent Topic's subject with the "Re: " prefix.
	// e.g., suppose the subject of message #9 was "Thanks", the user is replying to that message:


	/*
			Enter Message ID (-1 for Menu): 9
			Body: It was a pleasure implementing this!
	*/

	// Note: As before, the body ends when the user enters an empty line.
	// The above dialog will generate a reply that has "Re: Thanks" as its subject
	// and "It was a pleasure implementing this!" as its body.

	// How will we know what Topic this is a reply to?
	// In addition to keeping a pointer to all the Message objects in BBoard's messageList ArrayList
	// Every Message (wheather Topic or Reply) will also store an ArrayList of pointers to all of its Replies.
	// So whenever we build a Reply, we must immediately store this Message in the parent Message's list. 
	// The Reply's constructor should set the Reply's subject to "Re: " + its parent's subject.
	// Call the addChild function on the parent Message to push back the new Message (to the new Reply) to the parent's childList ArrayList.
	// Finally, push back the Message created to the BBoard's messageList. 
	// Note: When the user chooses to return to the menu, do not call run() again - just return from this addReply function. 
	private void addReply() {
		while(true){
			System.out.print("\nEnter message ID(-1 for menu): ");
			int id = s.nextInt(); s.nextLine(); //TODO: Check for incorrect inputs(non-numeric character)
			if(id == -1) {
				return;
			}
			for(Message m : messageList) {
				if(m.getId() == id) {
					String body = s.nextLine();
					m.addChild(new Reply(mainUser.getUsername(), body, messageList.size()+1));
					return;
				}
			}
			System.out.print("Invalid message ID!\n");
		}
	}

	// This function allows the user to change their current password.
	// The user is asked to provide the old password of the currentUser.
	// 		If the received password matches the currentUser password, then the user will be prompted to enter a new password.
	// 		If the received password doesn't match the currentUser password, then the user will be prompted to re-enter the password. 
	// 		The user is welcome to enter 'c' or 'C' to cancel the setting of a password and return to the menu.
	// Any password is allowed except 'c' or 'C' for allowing the user to quit out to the menu. 
	// Once entered, the user will be told "Password Accepted." and returned to the menu.
	private void setPassword() throws FileNotFoundException, IOException {
		while(true) {
			System.out.print("\nOld password('C' or 'c' to cancel): ");
			String temp = s.nextLine();
			if(temp.toLowerCase().equals("c")) {
				System.out.print("\n\n");
				return;
			}
			else if(mainUser.check(mainUser.getUsername(), temp)) {
				while(true) {
					System.out.print("Please enter your new password: ");
					String temp2 = s.nextLine();
					if(temp.length() >= 3) {
						System.out.println("Password accepted.\n");
						mainUser.setPassword(temp, temp2);
						overwriteUsers(mainUser, temp2);
						return;
					}
					System.out.print("New password must be at least 3 characters.\n\n");
				}
			}
			else {
				System.out.print("Invalid password, please re-enter.\n\n");
			}
		}
	}

	private void overwriteUsers(User u, String pw) throws FileNotFoundException, IOException {
		// Reads given file + adds changed password
		ArrayList<String> users = new ArrayList<>();
		File mainFile = new File(path);
		try (Scanner sc = new Scanner(mainFile)) {
			while(sc.hasNextLine()) {
				String temp = sc.nextLine();
				if(temp.substring(0, temp.indexOf(' ')).equals(u.getUsername())) {
					users.add(u.getUsername() + " " + pw);
				}
				users.add(temp);
			}
		}
		try (// Overwrites file with new data
		BufferedWriter bw = new BufferedWriter(new FileWriter(mainFile))) {
			for(String s : users) {
				bw.write(s);
			}
		}
	}

}
