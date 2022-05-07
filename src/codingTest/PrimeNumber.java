package codingTest;

// 소수 만들기
public class PrimeNumber {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) answer++;
                }
            }
        }

        return answer;
    }

    public boolean isPrime(int n) {
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4};
        int[] test2 = {1, 2, 7, 6, 4};
        PrimeNumber myTest = new PrimeNumber();

        System.out.println(myTest.solution(test1));
        System.out.println(myTest.solution(test2));
    }
}
