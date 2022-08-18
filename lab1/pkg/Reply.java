package pkg;

public class Reply extends Message {
	// Default Constructor
	public Reply() {
		this("", "", "", 0);
	}

	// Parameterized constructor
	public Reply(String auth, String subj, String bod, int i) {
		author = auth;
		subject = subj;
		body = bod;
		id = i;
	}
	// Returns if this is a reply (true)
	public boolean isReply(){
		return true;
	}
}
