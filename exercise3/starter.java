import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class starter {
    static void p(Object o) {System.out.print(o);}
    static boolean isCorrect(String s, int pairs) {
        int countL = 0;
        int countR = 0;
        for(char c : s.toCharArray()) {
            if(c==40) {
                countL++;
            }
            else if(c==41) {
                countR++;
            }
            else {
                return false;
            }
        }
        return (countL==countR)&&(countL==pairs);
    }
    static String insertPair(String s, int index) {
        char[] str = s.toCharArray();
        char[] copy = new char[str.length + 2];
        boolean inserted = false;
        for(int i=0;i<copy.length;i++) {
            if(i<index) {
                copy[i] = str[i];
            }
            else if(i==index) {
                copy[i] = 40;
                i++;
                copy[i] = 41;
            }
            else {
                copy[i] = str[i-2];
            }
        }
        return String.valueOf(copy);
    }
    static ArrayList<String> construct(String base, int pairs) {
        ArrayList<String> huh = new ArrayList<>();
        innerConstruct(huh, base, pairs);
        return huh;
    }
    static void innerConstruct(ArrayList<String> a, String s, int pairs) {
        if(isCorrect(s, pairs)) {
            a.add(s);
            return;
        }
        for(int i=0;i<s.length();i++) {
            innerConstruct(a, insertPair(s,i), pairs);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter pairs: ");
        int man = sc.nextInt();
        HashSet<String> hs = new HashSet<>();
        String base = "()";
        ArrayList<String> test = construct(base, man);
        for(String s : test) {
            hs.add(s);
        }
        for(String s : hs) {
            p(s+"  ");
        }
        p(hs.size());
    }
}