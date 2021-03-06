package hanjoondev.leetcode;

import java.util.*;

public class L00079 {
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length, len = word.length();
        HashMap<Character, Integer> bCount = new HashMap<>();
        HashMap<Character, Integer> wCount = new HashMap<>();
        ArrayList<List<Integer>> startingPoints = new ArrayList<>();
        for (int r = 0; r < h; r++)
            for (int c = 0; c < w; c++) {
                bCount.put(board[r][c], bCount.getOrDefault(board[r][c], 0) + 1);
                if (board[r][c] == word.charAt(0))
                    startingPoints.add(Arrays.asList(r, c));
            }
        for (int i = 0; i < len; i++)
            wCount.put(word.charAt(i), wCount.getOrDefault(word.charAt(i), 0) + 1);
        for (char c : wCount.keySet())
            if (!bCount.containsKey(c) || bCount.get(c) < wCount.get(c))
                return false;
        boolean[][] visited = new boolean[h][w];
        for (List<Integer> sp : startingPoints)
            if (dfs(board, word, 0, sp.get(0), sp.get(1), visited))
                return true;
        return false;
    }
    public static boolean dfs(char[][] b, String w, int idx, int r, int c, boolean[][] visited) {
        if (idx == w.length())
            return true;
        if (r < 0 || r >= b.length ||
            c < 0 || c >= b[0].length || visited[r][c] || b[r][c] != w.charAt(idx))
            return false;
        visited[r][c] = true;
        if (dfs(b, w, idx + 1, r + 1, c, visited) || dfs(b, w, idx + 1, r - 1, c, visited) ||
            dfs(b, w, idx + 1, r, c + 1, visited) || dfs(b, w, idx + 1, r, c - 1, visited))
            return true;
        visited[r][c] = false;
        return false;
    }
}
