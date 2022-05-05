package hash;

import java.util.HashMap;

// 코딩테스트 연습 - 해시 - 전화번호 목록
public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, String> myHash = new HashMap<>();

        for(String input : phone_book ) {
            myHash.put(input, input);
        }

        for (String target : phone_book) {
            for( int i=0; i< target.length(); i++) {
                if(myHash.containsKey(target.substring(0,i)) ) {
                    return false;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] testData1 = {"119", "97674223", "1195524421"};
        String[] testData2 = {"123", "456", "789"};
        String[] testData3 = {"12", "123", "1235", "567", "88"};

        PhoneNumberList myTest = new PhoneNumberList();

        System.out.println(myTest.solution(testData1));
        System.out.println(myTest.solution(testData2));
        System.out.println(myTest.solution(testData3));
    }
}
