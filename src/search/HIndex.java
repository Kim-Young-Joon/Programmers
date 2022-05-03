package search;

import java.util.Arrays;

// 코딩 테스트 연습 - 정렬 - H 인덱스
public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        int indexH; // 남은 배열의 원소개수에 따라 가질 수 있는 최대값(논문 편수)
        for(int i = 0; i < citations.length; i++) {

            // i일때 가장 큰 h값(논문 편수)
            indexH = citations.length-i;

            // 논문 인용 횟수가 indexH 이상인지 확인해서 결정
            if(citations[i] >= indexH) {
                answer = indexH;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        HIndex myTest = new HIndex();

        int[] testData = {3, 0, 6, 1, 5};
        System.out.println(myTest.solution(testData));
    }
}
