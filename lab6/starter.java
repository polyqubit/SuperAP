import java.util.Random;

public class starter {
    static void p(Object o) {System.out.print(o);}
    public static void main(String args[]) {
        SinglyLinkedList sll = new SinglyLinkedList();
        Random rand = new Random();
        for(int i=0;i<20;i++) {
            sll.push(rand.nextInt(100));
        }
        for(int i=0;i<20;i++) {
            sll.insert(rand.nextInt(20), -1);
        }
        sll.printList();
        System.out.println("\n");
        for(int i=0;i<20;i++) {
            sll.swap(i, 39-i);
        }
        sll.printList();
    }
}


// 1,2,3,4,5,6
// 6,5,4,3,2,1