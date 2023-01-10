public class starter {
    public static String integerToRomanNumeral(int n) {
        int copy = n;
        int length = Integer.toString(n).length();
        String finish = "";
        while(length>0) {
            int temp = getDigit(copy,length);
            finish += miniToRoman(temp, length);
            length--;
        }
        return finish;
    }
    private static String miniToRoman(int n, int place) {
        switch(place) {
            case 1: {
                if(n<4) {
                    String finish = "";
                    while(n>0) {
                        finish+="I";
                        n--;
                    }
                    return finish;
                }
                else if(n==4) {
                    return "IV";
                }
                else if(n==5) {
                    return "V";
                }
                else if(n<9) {
                    String finish="V";
                    while(n>5) {
                        finish+="I";
                        n--;
                    }
                    return finish;
                }
                else if(n==9) {
                    return "IX";
                }
                break;
            }
            case 2: {
                if(n<4) {
                    String finish = "";
                    while(n>0) {
                        finish+="X";
                        n--;
                    }
                    return finish;
                }
                else if(n==4) {
                    return "XL";
                }
                else if(n==5) {
                    return "L";
                }
                else if(n<9) {
                    String finish="L";
                    while(n>5) {
                        finish+="X";
                        n--;
                    }
                    return finish;
                }
                else if(n==9) {
                    return "XC";
                }
                break;
            }
            case 3: {
                if(n<4) {
                    String finish = "";
                    while(n>0) {
                        finish+="C";
                        n--;
                    }
                    return finish;
                }
                else if(n==4) {
                    return "CD";
                }
                else if(n==5) {
                    return "D";
                }
                else if(n<9) {
                    String finish="D";
                    while(n>5) {
                        finish+="C";
                        n--;
                    }
                    return finish;
                }
                else if(n==9) {
                    return "CM";
                }
                break;
            }
            case 4: {
                if(n<4) {
                    String finish = "";
                    while(n>0) {
                        finish+="M";
                        n--;
                    }
                    return finish;
                }
                else if(n==4) {
                    return "M(V)";
                }
                else if(n==5) {
                    return "(V)";
                }
                else if(n<9) {
                    String finish="(V)";
                    while(n>5) {
                        finish+="M";
                        n--;
                    }
                    return finish;
                }
                else if(n==9) {
                    return "M(X)";
                }
                break;
            }
        }
        return "";
    }
    private static int getDigit(int n, int place) {
        return (n/(int)Math.pow(10,place-1))%10;
    }
    public static void main(String args[]) {
        System.out.println("1 " + integerToRomanNumeral(1));
        System.out.println("19 " + integerToRomanNumeral(19));
        System.out.println("25 " + integerToRomanNumeral(25));
        System.out.println("259 " + integerToRomanNumeral(259));
        System.out.println("1029 " + integerToRomanNumeral(1029));
        System.out.println("4000 " + integerToRomanNumeral(4000));
        System.out.println("4932 " + integerToRomanNumeral(4932));
    }
}

// 1234
// 234
