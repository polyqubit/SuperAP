import java.util.Random;

public class starter {
    public static void pArr(int[] a) {
        System.out.print("{ ");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("}");
    }

    public static void radix(int[] a) {
        Queue[] qa = new Queue[10];
        for (int i = 0; i < 10; i++) {
            qa[i] = new Queue();
        }
        int[] tq = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            tq[i] = a[i];
        }
        int maxDigit = 0;
        for (int i : a) {
            maxDigit = (Integer.toString(i).length() > maxDigit) ? Integer.toString(i).length() : maxDigit;
        }
        int place = 0;
        while (place < maxDigit) {
            divideTen(qa, tq, place);
            int c = 0;
            for (Queue q : qa) {
                // System.out.print(q.getSize() + ":[ ");
                while (!q.isEmpty()) {
                    tq[c] = q.dequeue();
                    // System.out.print(tq[c] + " ");
                    c++;
                }
                // System.out.print("]  ");
            }
            // System.out.println("end: " + place + " - " + c);
            place++;
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = tq[i];
        }
    }

    private static void divideTen(Queue[] qa, int[] data, int digit) {
        for (int i : data) {
            qa[(i / (int) Math.pow(10, digit)) % 10].enqueue(i);
        }
    }

    public static void main(String args[]) {
        // int[] t = { 999112, 321, 4343, 23994, 1, 231, 101 };
        int[] t = new int[100000];
        Random rand = new Random();
        for(int i = 0; i < t.length; i++) {
            t[i] = rand.nextInt(100000);
        }
        long startTime = System.nanoTime();
        // pArr(t);
        radix(t);
        // pArr(t);
        long endTime = System.nanoTime();
        System.out.println("Time for radix on 100,000 6-length integers: " + ((endTime-startTime)/1000000) + " ms");
        // Roughly 15,900 ms when running in VSCode(yikes!)
    }
}

// 65432