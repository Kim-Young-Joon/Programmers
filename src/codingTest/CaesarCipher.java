package codingTest;

// 시저 암호
public class CaesarCipher {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder(s);

        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) >= 65 && sb.charAt(i) <= 90) {
                if(sb.charAt(i) + n > 90) {
                    int myNum = (sb.charAt(i) + n) - 90;
                    sb.setCharAt(i, (char)(65 + myNum - 1));
                } else {
                    sb.setCharAt(i, (char)(sb.charAt(i) + n));
                }
            } else if(sb.charAt(i) >= 97 && sb.charAt(i) <= 122) {
                if(sb.charAt(i) + n > 122) {
                    int myNum = (sb.charAt(i) + n) - 122;
                    sb.setCharAt(i, (char)(97 + myNum - 1));
                } else {
                    sb.setCharAt(i, (char)(sb.charAt(i) + n));
                }
            }
        }

        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        CaesarCipher myTest = new CaesarCipher();
        String str = "AB";
        int num = 1;
        System.out.println(myTest.solution(str, num));

        str = "z";
        num = 1;
        System.out.println(myTest.solution(str, num));

        str = "a B z";
        num = 4;
        System.out.println(myTest.solution(str, num));
    }
}
