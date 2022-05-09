package hanjoondev.programmers;

import java.util.Stack;

public class P64061 {
    public int solution(int[][] board, int[] moves) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            int picked = -1;
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    picked = board[i][move - 1];
                    board[i][move - 1] = 0;
                    break;
                }
            }
            if (picked != -1) {
                if (!stack.isEmpty() && stack.peek() == picked) {
                    stack.pop();
                    ans += 2;
                } else {
                    stack.push(picked);
                }
            }
        }
        return ans;
    }
}
