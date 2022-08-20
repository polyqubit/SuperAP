package pkg;

public class Reply extends Message {
	// Default Constructor
	public Reply() {
		this("", "", 0);
		subject = "";
	}

	// Parameterized constructor
	public Reply(String auth, String bod, int i) {
		author = auth;
		body = bod;
		id = i;
	}
	// Returns if this is a reply (true)
	public boolean isReply(){
		return true;
	}
}
