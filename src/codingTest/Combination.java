package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

// 두 개 뽑아서 더하기
public class Combination {
    public int[] solution(int[] numbers) {
        HashSet<Integer> myData = new HashSet<>();

        for(int index = 0; index < numbers.length - 1; index++) {
            int num = numbers[index];
            for(int i = index+1; i < numbers.length; i++) {
                myData.add(num + numbers[i]);
            }
        }

        // HashSet 에 있는 데이터를 ArrayLis 로 옯기고 정렬
        ArrayList<Integer> arr = new ArrayList<>(myData);
        Collections.sort(arr);

        // int[] 타입으로 ArrayList 변환
        int[] answer = new int[arr.size()];
        int i = 0;
        for(int n : arr) {
            answer[i] = n;
            i++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Combination myTest = new Combination();
        int[] numbers1 = {2, 1, 3, 4, 1};
        int[] numbers2 = {5, 0, 2, 7};

        System.out.println(Arrays.toString(myTest.solution(numbers1)));
        System.out.println(Arrays.toString(myTest.solution(numbers2)));
    }
}
