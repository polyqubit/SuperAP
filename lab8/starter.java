public class starter {
    public static void pArr(int[] a) {
        System.out.print("{ ");
        for(int i : a) {
            System.out.print(i+" ");
        }
        System.out.println("}");
    }
    public static void radix(int[] a) {
        Queue[] qa = new Queue[10];
        for(int i = 0; i < 10; i++) {
            qa[i] = new Queue();
        }
        int[] tq = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            tq[i] = a[i];
        }
        int maxDigit = 0;
        for(int i : a) {
            maxDigit = (Integer.toString(i).length()>maxDigit) ? Integer.toString(i).length() : maxDigit;
        }
        while(maxDigit > 0) {
            divideTen(qa, tq, maxDigit);
            int c = 0;
            for(Queue q : qa) {
                System.out.println(c);
                for(int i = 0; i < q.getSize(); i++) {
                    tq[c] = q.dequeue();
                    c++;
                }
            }
            System.out.println("end: " + maxDigit);
            maxDigit--;
        }
        for(int i = 0; i < a.length; i++) {
            a[i] = tq[i];
        }
    }
    private static void divideTen(Queue[] qa, int[] data, int digit) {
        for(int i : data) {
            qa[(i/(int)Math.pow(10,digit))%10].enqueue(i);
        }
    }

    public static void main(String args[]) {
        int[] t = {112,321,4343,23994};
        radix(t);
        pArr(t);
    }
}

// 65432 