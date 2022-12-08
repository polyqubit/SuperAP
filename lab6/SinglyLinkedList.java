public class SinglyLinkedList {
	Node head;

	/* 
		Postcondition: The head will be null 
	*/
	public SinglyLinkedList() {
        head = null;
	}

	/* 
		Receives an integer position, searches through the SinglyLinkedList for the position and returns the data at that positon
	   	If the position doesn't exist, it returns -1
	*/ 
	public int get(int pos) throws Error {
        Node current = head;
        int counter = 0;
        while(current.getNext()!=null) {
            if(counter==pos) {
                return current.getData();
            }
            current = current.getNext();
            counter++;
        }
        throw new Error("@SinglyLinkedList::get: Node position not found!");
	}

	/*
		Insert a new Node at the given position with the data given
	*/
	public void insert(int pos, int data) throws Error {
        if(pos==0) {
            Node n = new Node(data);
            n.setNext(head);
            head = n;
            return;
        }
        Node current = head;
        int counter = 0;
        while(current.getNext()!=null) {
            if((counter+1)==pos) {
                Node n = new Node(data);
                n.setNext(current.getNext());
                current.setNext(n);
                return;
            }
            current = current.getNext();
            counter++;
        }
        throw new Error("@SinglyLinkedList::insert: Node position not found! index: "+pos);
	}

    public void push(int data) {
        if(head==null) {head = new Node(data);}
        Node current = head;
        while(current.getNext()!=null) {
            current = current.getNext();
        }
        current.setNext(new Node(data));
    }

	/*
		Remove the node at the given position
		If no position exists, don't change the list
	*/
	public void remove(int pos){
        if(pos==0) {
            head = head.getNext();
            return;
        }
        Node current = head;
        int counter = 0;
        while(current.getNext()!=null) {
            if((counter+1)==pos) {
                current.setNext(current.getNext().getNext());
            }
            current = current.getNext();
            counter++;
        }
	}

	/*
		Swap two Nodes with the two positions given
	*/
	public void swap(int pos1, int pos2){
        Node index1 = null;
        Node index2 = null;
        boolean check1 = false;
        boolean check2 = false;
        int idx1 = -1;
        int idx2 = -1;
        Node current = head;
        int counter = 0;
        while(current.getNext()!=null) {
            if(counter==pos1) {
                index1 = current;
                idx1 = counter;
                check1 = true;
                break;
            }
            current = current.getNext();
            counter++;
        }
        if(!check1) {throw new Error("@SinglyLinkedList::swap: Node position 1 not found!");}
        current = head;
        counter = 0;
        while(current.getNext()!=null) {
            if(counter==pos2) {
                index2 = current;
                idx2 = counter;
                check2 = true;
            }
            current = current.getNext();
            counter++;
        }
        if(!check2) {throw new Error("@SinglyLinkedList::swap: Node position 2 not found!");}
        // setting first node
        insert(idx1, index2.getData());
        remove(idx1+1);
        insert(idx2, index1.getData());
        remove(idx2+1);
    }
	/*
		Print all data values in the LinkedList 
	*/
	public void printList(){
        Node current = head;
        int counter = 0;
        while(current.getNext()!=null) {
            System.out.println("Node "+counter+": "+current.getData());
            current = current.getNext();
            counter++;
        }
	}
}





// 0,1,2,3,4
// 2,4
// 0,1,4,3,2