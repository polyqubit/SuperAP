import java.util.Scanner;

public class starter {
    public static void main(String args[]) {
        System.out.println("Is "+111111+" a palindrome? " + isPalindromeNoString(111111)+"\n");
        Scanner sc = new Scanner(System.in);
        int store = 0;
        while(true){
            System.out.println("Enter a number to see if it is a palindrome");
            try {
                store = sc.nextInt();
            }
            catch(Exception e) {sc.nextLine(); System.out.println("wrong"); store = 0; continue;}
            sc.nextLine();
            System.out.println("Is "+store+" a palindrome? " + isPalindromeNoString(store)+"\n");
        }
    }
    static boolean isPalindrome(int x) {
        if(x<0) {return false;}
        String s = String.valueOf(x);
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)!=s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
    static boolean isPalindromeNoString(int x) {
        if(x<0) {return false;}
        int length = (int)Math.log10(x);
        System.out.println(length);
        int copy = x;
        for(int i=0;i<(int)(length/2)+1;i++) {
            if((x%10)!=(copy%Math.pow(10,length))) {
                return false;
            }
            x/=10;
            copy%=Math.pow(10,length);
            length--;
            System.out.println(x+" "+copy);
        }
        return true;
    }
}

// 1234
// 234
