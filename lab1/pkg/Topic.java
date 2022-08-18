package pkg;

public class Topic extends Message {
	// Default Constructor
	public Topic() {
		this("", "", "", 0);
	}

	// Parameterized constructor
	public Topic(String auth, String subj, String bod, int i) {
		author = auth;
		subject = subj;
		body = bod;
		id = i;
	}

	// Returns if it's a reply (false)
	public boolean isReply(){
		return false;
	}
}
