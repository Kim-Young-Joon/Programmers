package bruteForce;

import java.util.HashSet;

// 코딩테스트 연습 - 완전탐색 - 소수 찾기
public class FindPrime {
    public int solution(String numbers) {
        int answer = 0;

        // 모든 수의 조합을 담아 둘 HashSet
        HashSet<Integer> myData = new HashSet<>();
        combination(numbers, "", myData);

        // 소수 판별
        for(int num : myData) {
            boolean judge = isPrime(num);
            if(judge) {
                answer++;
            }
        }

        return answer;
    }

    // 모든 수의 조합을 저장하는 함수
    public void combination(String numbers, String arr, HashSet<Integer> set) {
        int len = numbers.length();
        if(!"".equals(arr)){
            set.add(Integer.valueOf(arr));
        }
        for(int i = 0; i < len; i++) {
            combination(numbers.substring(0, i) + numbers.substring(i + 1, len), arr + numbers.charAt(i), set);
        }
    }

    // 소수인지를 판단하는 함수
    public boolean isPrime(int num) {
        if(num <= 1)
            return false;
        for(int i = 2; i <= num/2; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        FindPrime myTest = new FindPrime();
        String numbers1 = "17";
        String numbers2 = "011";

        System.out.println(myTest.solution(numbers1));
        System.out.println(myTest.solution(numbers2));
    }
}
