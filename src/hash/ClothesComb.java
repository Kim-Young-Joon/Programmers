package hash;

import java.util.HashMap;

// 코딩테스트 연습 - 해시 - 위장
public class ClothesComb {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> myData = new HashMap<>();

        String category = ""; // 의상의 종류를 담을 문자열 변수

        for(int index = 0; index < clothes.length; index++) {
            category = clothes[index][1];
            myData.put(category, myData.containsKey(category) ? myData.get(category) + 1 : 1);
        }

        answer = 1; // 곱해주기 위해 1로 변경
        for(String key : myData.keySet()) {
            answer *= (myData.get(key) + 1);
            // 각 의상의 종류별로 안입는 경우까지 추가하여 +1 을 해준다.
        }
        answer--; // 모든 종류의 의상을 안입는 경우는 제외해야 하므로 -1

        return answer;
    }

    public static void main(String[] args) {
        String[][] test1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] test2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        ClothesComb myTest = new ClothesComb();
        System.out.println("test1 : " + myTest.solution(test1));
        System.out.println("test2 : " + myTest.solution(test2));
    }
}
