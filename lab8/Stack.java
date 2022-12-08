public class Stack {
	/*  LAST IN FIRST OUT  */
	Node top;

	/* 
		Postcondition: The top will be null.
	*/
	public Stack() {
        top = null;
	}

	/*
		Insert a new Node on top of the stack
	*/
	public void push(int data){
        Node t = new Node(data);
        t.setNext(top);
        top = t;
	}

	/*
		Removes the top node of the stack
	*/
	public int pop(){
        Node t = top;
        top = top.getNext();
        return t.getData();
	}

	/*
		Returns the top value of the stack. Doesn't pop. 
	*/
	public int peek(){
        return top.getData();
	}

	/*
		Checks if the stack is empty. 
	*/
	public boolean isEmpty(){
        return top == null;
	}
}