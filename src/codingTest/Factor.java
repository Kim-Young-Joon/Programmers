package codingTest;

import java.util.HashSet;

// 약수의 개수와 덧셈
public class Factor {
    public int solution(int left, int right) {
        int answer = 0;
        HashSet<Integer> myData = new HashSet<>();

        for(int num = left; num <= right; num++) { // 수의 범위 지정
            for(int factor = 1; factor <= num; factor++) { // 약수 구하기
                if(num % factor == 0) {
                    myData.add(factor); // 구한 약수를 HashSet 에 저장 (중복된 값이면 저장 X)
                }
            }

            // 약수의 개수가 짝수이면 + / 홀수이면 -
            if(myData.size() % 2 == 0) {
                answer += num;
            } else {
                answer -= num;
            }

            // 다음 수를 위해 HashSet 초기화
            myData.clear();
        }

        return answer;
    }

    public static void main(String[] args) {
        Factor myTest = new Factor();
        int left = 13, right = 17;
        System.out.println(myTest.solution(left, right));

        left = 24;
        right = 27;
        System.out.println(myTest.solution(left, right));
    }
}
