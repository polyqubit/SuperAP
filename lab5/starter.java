import java.util.*;

class Node {
	Node next;
	int data;

	public Node(int data) {
		next = null;
		this.data = data;
	}
	public void setNext(Node next){
		this.next = next;
	}
	public int getData(){
		return data;
	}	
	public Node getNext(){
		return next;
	}
}

public class starter {
    static void p(Object o) {System.out.print(o);}
    public static void main(String args[]) {
        ArrayList<Node> nList = new ArrayList<>();
        Random rand = new Random();
        for(int i=0;i<100;i++) {
            nList.add(new Node(rand.nextInt(100)));
            p("Node " + i + " = " + nList.get(i).getData() + "\n");
        }
    }
}