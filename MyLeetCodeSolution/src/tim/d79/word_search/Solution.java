package tim.d79.word_search;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] c = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word = "ABCB";
        System.out.println(s.exist(c, word));
    }

    public boolean exist(char[][] board, String word) {
        char[] wc = word.toCharArray();
        char fstwc = wc[0];
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                char c = row[j];
                for (int k = 0; k < wc.length; k++) {
                    if (fstwc == board[i][j]){
                        List<int[]> nextLocList = new ArrayList<int[]>();
                        nextLocList.add(new int[]{i,j});
                        for (int m = 1; m < wc.length; m++) {
                            if(nextLocList.size() > 0){
                                List<int[]> nextLocListTmpAll = new ArrayList<int[]>();
                                for (int[] nextLoc : nextLocList) {
                                    List<int[]> nextLocListTmp = getNextLocation(board, nextLoc, wc[m]);
                                    nextLocListTmpAll.addAll(nextLocListTmp);
                                }
                                nextLocList = nextLocListTmpAll;
                            }
                        }
                        if(nextLocList.size() > 0) {
                            result = true;
                        }else{
                            break;
                        }
                    }

                }
            }
        }
        return result;
    }

    public List<int[]> getNextLocation(char[][] board, int[] currentLoc, char c) {
        int x = currentLoc[0];
        int y = currentLoc[1];
        List<int[]> nextLocList = new ArrayList<int[]>();
        int height = board.length;
        int width = board[0].length;
        //top
        if (x > 0) {
            char nt = board[x - 1][y];
            if (nt == c) {
                int[] nextLoc = new int[2];
                nextLoc[0] = x - 1;
                nextLoc[1] = y;
                nextLocList.add(nextLoc);
            }
        }
        //bottom
        if (x < height - 1) {
            char nt = board[x + 1][y];
            if (nt == c) {
                int[] nextLoc = new int[2];
                nextLoc[0] = x + 1;
                nextLoc[1] = y;
                nextLocList.add(nextLoc);
            }
        }
        //left
        if (y > 0) {
            char nt = board[x][y - 1];
            if (nt == c) {
                int[] nextLoc = new int[2];
                nextLoc[0] = x;
                nextLoc[1] = y - 1;
                nextLocList.add(nextLoc);
            }
        }
        //right
        if (y < width - 1) {
            char nt = board[x][y + 1];
            if (nt == c) {
                int[] nextLoc = new int[2];
                nextLoc[0] = x;
                nextLoc[1] = y + 1;
                nextLocList.add(nextLoc);
            }
        }
        return nextLocList;
    }

}