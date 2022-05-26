package codingTest;

import java.util.ArrayList;
import java.util.Stack;

// 크레인 인형뽑기 게임
public class ClawCraneGame {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack[] game = new Stack[board[0].length];
        Stack<Integer> bag = new Stack<Integer>();
        for(int i = 0; i<board[0].length; i++)
            game[i] = new Stack<Integer>();

        for(int i = board.length-1; i>=0;i--){
            for(int j = 0; j<board[0].length; j++)
                if(board[i][j] != 0)
                    game[j].push(board[i][j]);
        }

        for(int i = 0; i<moves.length; i++)
        {
            if(game[moves[i]-1].empty())
                continue;
            int number = (int)game[moves[i]-1].pop();

            if(bag.size() == 0) {
                bag.push(number);
            }
            else{
                if(number == bag.peek()){
                    answer+=2;
                    bag.pop();
                }
                else
                    bag.push(number);
            }
        }
        return answer;
    }

    public int solution2(int[][] board, int[] moves) {
        int answer = 0; // 터뜨려 사라진 인형의 수
        ArrayList<Integer>[] myData = new ArrayList[board.length];
        int[] index = new int[board.length]; // 각 위치별 뽑아야 하는 index
        ArrayList<Integer> basket = new ArrayList<>(); // 뽑는 인형이 보관될 바구니
        // int[][] -> ArrayList
        for(int i = 0; i < board.length; i++) {
            myData[i] = new ArrayList<>();
            for(int j = 0; j < board[i].length; j++) {
                int num = board[i][j];
                if(num != 0) {
                    myData[i].add(num);
                }
            }
            index[i] = myData[i].size() - 1; // 음수면, 뽑을 인형이 없다는 의미 / 0, 양수이면 해당 myData 에서 가져와야할 차례인 인형을 의미
        }
        // 인형뽑기 시작
        for(int i = 0; i < moves.length; i++) {
            int location = moves[i] - 1; // 뽑아올 위치
            int num = 0; // 뽑아오는 인형
            int endIndex = basket.size() - 1;
            if(index[location] >= 0) {
                num = myData[location].remove(index[location]);
                index[location]--;
                if(basket.size() > 0 && num == basket.get(endIndex)) {
                    basket.remove(endIndex);
                    endIndex = basket.size() - 1;
                    answer += 2;
                } else {
                    basket.add(num);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        ClawCraneGame myTest = new ClawCraneGame();
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(myTest.solution(board, moves));
    }
}