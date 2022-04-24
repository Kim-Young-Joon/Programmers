package search;

import java.util.Arrays;

// 코딩 테스트 연습 - 정렬 - K번째 수
public class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++) {
            int[] subArr = new int[commands[i][1]-commands[i][0]+1];
            int myIndex = 0;

            for(int j = commands[i][0]-1; j < commands[i][1]; j++) {
                subArr[myIndex] = array[j];
                myIndex++;
            }
            Arrays.sort(subArr);

            answer[i] = subArr[(commands[i][2]-1)];
        }

        return answer;
    }

    public static void main(String[] args) {
        KthNumber myNum = new KthNumber();

        int[] array= {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(myNum.solution(array, commands)));
    }
}
