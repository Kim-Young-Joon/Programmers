package codingTest;

// 신규 아이디 추천
public class NewID {
    /*
        아이디 규칙
        1. 길이는 3자 이상 15자 이하
        2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용 가능
        3. 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 연속으로 사용 불가
    */
    public String solution(String new_id) {
        String answer = "";

        // 1단계 : new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        StringBuilder sb = new StringBuilder(new_id.toLowerCase());

        // 2단계 : new_id 에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '-' || sb.charAt(i) == '_' || sb.charAt(i) == '.') {
                // -, _, . 의 문자일 경우 삭제하지 않음
            } else if(sb.charAt(i) >= 97 && sb.charAt(i) <= 122) {
                // 알파벳 소문자일 경우 삭제하지 않음
            } else if(sb.charAt(i) >= 48 && sb.charAt(i) <= 57) {
                // 숫자일 경우 삭제하지 않음
            } else { // 그 외의 경우는 제거
                sb = sb.deleteCharAt(i);
                i--; // 제거 했을 경우 index 조정을 통해 검사를 건너 뛰는 index 가 없도록 한다.
            }
        }

        // 3단계 : new_id 에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        for(int i = sb.length()-1; i > 0; i--) {
            if(sb.charAt(i) == '.' && sb.charAt(i-1) == '.') {
                sb = sb.deleteCharAt(i);
            }
        }

        // 4단계 : new_id 에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(sb.charAt(0) == '.') {
            sb = sb.deleteCharAt(0);
        }
        if(sb.length() != 0 && sb.charAt(sb.length()-1) == '.') {
            sb = sb.deleteCharAt(sb.length() - 1);
        }

        // 5단계 : new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(sb.length() == 0) {
            sb.append("a");
        }

        // 6단계 : new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //        만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        while(sb.length() > 15) {
            sb.deleteCharAt(15);
        }
        if(sb.length() == 15 && sb.charAt(14) == '.') {
            sb = sb.deleteCharAt(14);
        }

        // 7단계 : new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        while(sb.length() <= 2) {
            char c = sb.charAt(sb.length()-1);
            sb.append(c);
        }
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        NewID myTest = new NewID();
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(myTest.solution(new_id));

        new_id = "z-+.^.";
        System.out.println(myTest.solution(new_id));

        new_id = "=.=";
        System.out.println(myTest.solution(new_id));

        new_id = "123_.def";
        System.out.println(myTest.solution(new_id));

        new_id = "abcdefghijklmn.p";
        System.out.println(myTest.solution(new_id));
    }
}
