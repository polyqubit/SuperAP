package pkg;
import java.util.*;

public class Message {
	ArrayList<Message> childList = new ArrayList<>();
	String author, subject, body;
	int id;
	// Default Constructor
	public Message() {
		this("", "", "", -1);
	}

	// Parameterized constructor
	public Message(String auth, String subj, String bod, int i) {
		author = auth;
		subject = subj;
		body = bod;
		id = i;
	}

	// This function is responsbile for printing the Message
	// (whether Topic or Reply), and all of the Message's "subtree" recursively:

	// After printing the Message with indentation n and appropriate format (see output details),
	// it will invoke itself recursively on all of the Replies inside its childList, 
	// incrementing the indentation value at each new level.

	// Note: Each indentation increment represents 2 spaces. e.g. if indentation ==  1, the reply should be indented 2 spaces, 
	// if it's 2, indent by 4 spaces, etc. 
	public void print(int indentation, String title){
		if(indentation == 0) {
			System.out.println("\n------------------------------------------------------");
		}
		indent(indentation); System.out.print("Message #"+id+":"); re(indentation); System.out.println(" \""+title+"\"");
		indent(indentation); System.out.println("From "+author+": \""+body+"\"");
		for(int i=0;i<childList.size();i++) {
			System.out.println();
			childList.get(i).print(indentation+1, title);
		}
		if(indentation == 0) {
			System.out.println("------------------------------------------------------");
		}
	}

	private void indent(int indentation) {
		for(int i=0; i<indentation*2;i++) {
			System.out.print(" ");
		}
	}
	
	private void re(int num) {
		for(int i=0; i<num;i++) {
			System.out.print(" Re:");
		}
	}

	// Default function for inheritance
	public boolean isReply(){
		return true;
	}

	// Returns the subject String
	public String getSubject(){
		return subject;
	} 

	// Returns the ID
	public int getId(){
		return id;
	}

	// Adds a child pointer to the parent's childList.
	public void addChild(Message child){
		childList.add(child);
	}

}
