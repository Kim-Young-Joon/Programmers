package codingTest;

import java.util.*;

// 로또의 최고 순위와 최저 순위
public class Lotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int cnt = 0; // 일치된 번호의 개수
        int gap = 0; // 최고 순위와 최저 순위 사이의 차이값
        ArrayList<Integer> myLotto = new ArrayList<>();
        ArrayList<Integer> myNum = new ArrayList<>();

        // ArrayList 에 lotto 번호와 당첨번호를 넣고, 정렬
        for(int lotto : lottos) {
            myLotto.add(lotto);
        }
        for(int num : win_nums) {
            myNum.add(num);
        }
        Collections.sort(myLotto);
        Collections.sort(myNum);

        // 당첨번호 개수 찾기
        for(int index = 0; index < myLotto.size(); index++) {
            int num = myLotto.get(index);
            if(num == 0) { // 알아볼 수 없는 번호라면, gap 을 1 증가시키고 다음 번호로 넘어간다.
                gap++;
                continue;
            }

            // 당첨 여부 확인 -> 당첨 번호와 같다면 cnt 를 1 증가시키고, 이후의 번호는 확인하지 않아도 되므로 break
            for(int i = 0; i < myNum.size(); i++) {
                if(num == myNum.get(i)) {
                    cnt++;
                    break;
                }
            }
        }

        // 최저 등수 구하기
        int minRank = 0, maxRank = 0;
        switch(cnt) {
            case 6: minRank = 1; break;
            case 5: minRank = 2; break;
            case 4: minRank = 3; break;
            case 3: minRank = 4; break;
            case 2: minRank = 5; break;
            default: minRank = 6;
        }

        // cnt = 0 , gap = 0 , 1
        answer = new int[2];
        if(cnt == 0) {
            if(gap == 0) {
                answer[0] = minRank-gap;
            } else if(gap == 1) {
                answer[0] = minRank-gap;
            } else {
                answer[0] = minRank-gap+1;
            }
        } else {
            answer[0] = minRank-gap;
        }
        answer[1] = minRank;

        return answer;
    }

    // HashMap 이용한 풀이
    public int[] solution2(int[] lottos, int[] win_nums) {
        int[] answer ={};
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int zeroCount = 0;

        for(int lotto : lottos) {
            if(lotto == 0) {
                zeroCount++;
                continue;
            }
            map.put(lotto, true);
        }

        int sameCount = 0;
        for(int winNum : win_nums) {
            if(map.containsKey(winNum)) sameCount++;
        }

        int maxRank = 7 - (sameCount + zeroCount);
        int minRank = 7 - sameCount;
        if(maxRank > 6) maxRank = 6;
        if(minRank > 6) minRank = 6;

        answer = new int[] {maxRank, minRank};
        return answer;
    }

    public static void main(String[] args) {
        Lotto myTest = new Lotto();
        int[] lottos1 = {44, 1, 0, 0, 31, 25};
        int[] win_nums1 = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(myTest.solution(lottos1, win_nums1)));

        int[] lottos2 = {0, 0, 0, 0, 0, 0};
        int[] win_nums2 = {38, 19, 20, 40, 15, 25};
        System.out.println(Arrays.toString(myTest.solution(lottos2, win_nums2)));

        int[] lottos3 = {45, 4, 35, 20, 3, 9};
        int[] win_nums3 = {20, 9, 3, 45, 4, 35};
        System.out.println(Arrays.toString(myTest.solution(lottos3, win_nums3)));
    }
}
