package greedy;

import java.util.HashSet;

// 코딩테스트 연습 - 그리디 - 체육복
public class GymSuit {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        HashSet<Integer> resList = new HashSet<>();
        HashSet<Integer> losList = new HashSet<>();

        for (int i : reserve)
            resList.add(i);

        for (int i : lost) {
            if(resList.contains(i))
                resList.remove(i);
            else
                losList.add(i);
        }

        for (int i : lost) {
            if(losList.contains(i)) {
                if(resList.contains(i-1))
                    resList.remove(i-1);
                else if(resList.contains(i+1))
                    resList.remove(i+1);
                else
                    answer--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        GymSuit testData = new GymSuit();
        int test1_n = 5;
        int[] test1_lost = {2, 4};
        int[] test1_reserve = {1, 3, 5};

        int test2_n = 5;
        int[] test2_lost = {2, 4};
        int[] test2_reserve = {3};

        int test3_n = 3;
        int[] test3_lost = {3};
        int[] test3_reserve = {1};

        System.out.println(testData.solution(test1_n, test1_lost, test1_reserve));
        System.out.println(testData.solution(test2_n, test2_lost, test2_reserve));
        System.out.println(testData.solution(test3_n, test3_lost, test3_reserve));
    }
}
