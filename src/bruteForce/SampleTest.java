package bruteForce;

import java.util.ArrayList;
import java.util.Arrays;

// 코딩테스트 연습 - 완전탐색 - 모의고사
public class SampleTest {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] p1 = { 1, 2, 3, 4, 5 };
        int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        int[] cnt = new int[3];
        for (int i = 0; i < answers.length; i++) {
            int now = answers[i];
            if (p1[i % p1.length] == now)
                cnt[0]++;
            if (p2[i % p2.length] == now)
                cnt[1]++;
            if (p3[i % p3.length] == now)
                cnt[2]++;
        }
        int max = Math.max(Math.max(cnt[0], cnt[1]), cnt[2]);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == max)
                list.add(i + 1);
        }
        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        SampleTest myTest = new SampleTest();
        System.out.println(Arrays.toString(myTest.solution(new int[] { 1, 2, 3, 4, 5 })));
        System.out.println(Arrays.toString(myTest.solution(new int[] { 1, 3, 2, 4, 2 })));
    }
}

