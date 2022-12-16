import java.util.Scanner;

public class starter {
    static void p(Object o) {
        System.out.print(o);
    }

    static String toPostfix(String s) {
        Stack sym = new Stack();
        String build = "";
        while (!s.equals("")) {
            char t = s.charAt(0);
            switch (t) {
                case '+':
                case '-':
                case '*':
                case '/':
                case '%':
                case '(': {
                    sym.push(t);
                    s = s.substring(1);
                    continue;
                }
                case ')': {
                    while (sym.peek() != '(') {
                        build += (char)sym.pop();
                    }
                    sym.pop();
                    s = s.substring(1);
                    continue;
                }
            }
            build += t; // if no symbols
            s = s.substring(1);
        }
        while(!sym.isEmpty()) {
            build += (char)sym.pop();
        }
        return build;
    }

    public static void main(String args[]) {
        // String test = "(A+B*(C-D))/E";
        Scanner sc = new Scanner(System.in);
        p("Enter infix string: ");
        String test = sc.nextLine();
        String result = toPostfix(test);
        p(test + " -> " + result + "\n");
    }
}