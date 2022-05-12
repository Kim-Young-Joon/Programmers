package codingTest;

import java.util.ArrayList;
import java.util.Arrays;

// 없는 숫자 더하기
public class SumNumber {
    public int solution(int[] numbers) {
        int answer = 0;
        ArrayList<Integer> myData = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            myData.add(i);
        }

        // 파라미터로 전달된 배열을 정렬하고 역순으로(값이 큰 것부터) ArrayList 에서 삭제
        // 정렬한 다음 역순으로 삭제해야 IndexOutOfBoundsException 오류를 방지할 수 있다.
        Arrays.sort(numbers);
        for(int index = numbers.length - 1; index >= 0; index--) {
            myData.remove(numbers[index]);
        }

        for(int i = 0; i < myData.size(); i++) {
            answer += myData.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        SumNumber testData = new SumNumber();
        int[] test1 = {1, 2, 3, 4, 6, 7, 8, 0};
        int[] test2 = {5, 8, 4, 0, 6, 7, 9};

        System.out.println(testData.solution(test1));
        System.out.println(testData.solution(test2));
    }
}
