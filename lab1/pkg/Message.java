package pkg;
import java.util.*;
import java.io.*;

public class Message {
	ArrayList<Message> childList;
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
	public void print(int indentation){
		System.out.print("------------------------------------------------------"); 
		indent(indentation); System.out.println("Message #"+id+": \""+subject+"\"");
		indent(indentation); System.out.println("From "+author+": \""+body+"\"");
		for(Message m : childList) {
			m.print(indentation+1);
		}
		if(indentation == 0) {
			System.out.print("------------------------------------------------------");
		}
	}

	private void indent(int indentation) {
		for(int i=0; i<indentation*2;i++) {
			System.out.print(" ");
		}
	}
	
	private void re(int num) {
		for(int i=0; i<num*2;i++) {
			System.out.print("Re: ");
		}
	}

	// Default function for inheritance
	public boolean isReply(){
		return false;
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
