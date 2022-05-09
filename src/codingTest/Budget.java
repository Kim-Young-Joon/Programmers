package codingTest;

import java.util.ArrayList;
import java.util.Collections;

// 예산
public class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;
        ArrayList<Integer> myData = new ArrayList<>();
        int bSum = 0;

        for(int i = 0; i < d.length; i++) {
            myData.add(d[i]);
        }
        Collections.sort(myData);

        for(int index = 0; index < myData.size(); index++) {
            bSum += myData.get(index);
            if(bSum > budget) {
                break;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 3, 2, 5, 4};
        int[] test2 = {2, 2, 3, 3};
        int budget1 = 9;
        int budget2 = 10;

        Budget myTest = new Budget();

        System.out.println(myTest.solution(test1, budget1));
        System.out.println(myTest.solution(test2, budget2));
    }
}
