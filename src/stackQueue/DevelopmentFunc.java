package stackQueue;

import java.util.*;

// 코딩테스트 연습 - 스택/큐 - 기능개발
public class DevelopmentFunc {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        // 큐 초기화 작업
        for(int num : progresses) {
            queue.add(num);
        }

        int day = 1; // 진행일
        int total = 0; // 연속 진행 작업 수
        int index = 0; // 기능 index

        while(!queue.isEmpty()) {
            if(queue.peek() + (day * speeds[index]) >= 100) {
                queue.poll();
                total++;
                index++;
            } else {
                day++;
                if(total > 0) {
                    answerList.add(total);
                    total = 0;
                }
            }
        }
        answerList.add(total);

        answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i).intValue();
        }

        return answer;
    }

    public static void main(String[] args) {
        DevelopmentFunc myTest = new DevelopmentFunc();
        int[] test1_progresses = {93, 30, 55};
        int[] test1_speeds = {1, 30, 5};
        int[] test2_progresses = {95, 90, 99, 99, 80, 99};
        int[] test2_speeds = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(myTest.solution(test1_progresses, test1_speeds)));
        System.out.println(Arrays.toString(myTest.solution(test2_progresses, test2_speeds)));
    }
}
