public class Queue {
    /* FIRST IN FIRST OUT */
    Node head;
    int length;

    /*
     * Postcondition: The top will be null.
     */
    public Queue() {
        head = null;
        length = 0;
    }

    /*
     * Adds a node to the end of the queue
     */
    public void enqueue(int data) {
        length++;
        if (null == head) {
            head = new Node(data);
            return;
        }
        Node t = head;
        while(null != t.getNext()) {
            t = t.getNext();
        }
        t.setNext(new Node(data));
    }

    /*
     * Removes a node from the front of the queue
     */
    public int dequeue() {
        if (null == head) {
            return -1;
        }
        int t = head.getData();
        head = head.getNext();
        length--;
        return t;
    }

    /*
     * Checks if the queue is empty.
     */
    public boolean isEmpty() {
        return (null == head);
    }

    /*
     * Returns the value of the frontmost element
     */
    public int front() {
        return (null == head) ? -1 : head.getData();
    }

    /*
     * Returns the value at the end of the queue
     */
    public int back() {
        if (null == head) {
            return -1;
        }
        Node n = head;
        while (null != n.getNext()) {
            n = n.getNext();
        }
        return n.getData();
    }

    /*
     * Returns the size of the queue
     */
    public int getSize() {
        return length;
    }
}