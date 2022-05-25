package bruteForce;

import java.util.Arrays;

// 코딩테스트 연습 - 완전탐색 - 카펫
public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int maxLen = (int)Math.sqrt(yellow);
        int col;

        for(int row = 1;row <= maxLen;row++){
            if(yellow % row != 0)
                continue;
            col = yellow/row;
            if(((row + col)*2 + 4) == brown)
            {
                answer[0] = Math.max(col, row)+2;
                answer[1] = Math.min(col, row)+2;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Carpet myTest = new Carpet();
        int[] brown = new int[] {10, 8, 24};
        int[] yellow = new int[] {2, 1, 24};

        for(int testIndex = 0; testIndex < brown.length; testIndex++) {
            System.out.println("test" + (testIndex+1) + Arrays.toString(myTest.solution(brown[testIndex], yellow[testIndex])));
        }
    }
}
