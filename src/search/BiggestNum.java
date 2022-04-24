package search;

import java.util.Arrays;
import java.util.Comparator;

// 코딩 테스트 연습 - 정렬 - 가장 큰 수
public class BiggestNum {
    public String solution(int[] numbers) {

        // 숫자를 문자열로 변환
        String[] result = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }

        // 정렬
        Arrays.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((o2 + o1).compareTo(o1 + o2));
            }
        });

        // 0만 여러개 있는 배열의 경우 하나의 0만 리턴
        if(result[0].equals("0")) {
            return "0";
        }

        String answer = "";

        // 정렬된 문자 하나로 합치기
        for (String a : result) {
            answer += a;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] test1 = {6, 10, 2};
        int[] test2 = {3, 30, 34, 5, 9};

        BiggestNum myTest = new BiggestNum();

        System.out.println(myTest.solution(test1));
        System.out.println(myTest.solution(test2));

    }
}