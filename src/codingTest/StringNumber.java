package codingTest;

// 문자열 내 p와 y의 개수
public class StringNumber {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s);
        int pcnt = 0, ycnt = 0;

        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == 'p') {
                pcnt++;
            } else if(sb.charAt(i) == 'y') {
                ycnt++;
            }
        }

        if(pcnt != ycnt) {
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        StringNumber myTest = new StringNumber();
        String str1 = "pPoooyY";
        String str2 = "Pyy";

        System.out.println(myTest.solution(str1));
        System.out.println(myTest.solution(str2));
    }
}
