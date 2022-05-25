package codingTest;

// 문자열 다루기 기본
public class StrBasic {
    public boolean solution(String s) {
        boolean answer = true;
        StringBuilder sb = new StringBuilder(s);
        int index = 0;

        // 문자열 길이 확인
        if(sb.length() == 4 || sb.length() == 6) {
            answer = true;
        } else {
            return false;
        }

        // ASCII code 를 활용한 숫자 판단
        for(index = 0; index < sb.length(); index++) {
            if(sb.charAt(index) < 48 || sb.charAt(index) > 57) {
                answer = false;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        StrBasic myTest = new StrBasic();
        String test1 = "a234";
        String test2 = "1234";

        System.out.println(myTest.solution(test1));
        System.out.println(myTest.solution(test2));
    }
}
