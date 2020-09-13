package tim.d79.word_search;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Solution2 {
    public boolean exist(char[][] board, String word) {
        int[][] pathBoard = new int[board.length][board[0].length];
        for(int i =0;i<board.length; i++){
            for(int j =0;j<board[0].length; j++){
                if(board[i][j] == word.toCharArray()[0]){
                    pathBoard[i][j] =1;
                    if(word.toCharArray().length == 1){
                        return true;
                    }
                    int[] result = findNext(board, pathBoard, new int[]{i,j}, word.toCharArray(), 1);
                    if(result[0] == -1 && result[1] == -1){
                        pathBoard[i][j] = 0;
                    }else{
                        System.out.println(result[0]+" "+result[1]);
                        return true;
                    }
                }
            }
        }
       return false;
    }


    public int[] findNext(char[][] board, int[][] pathBoard, int[] currentLoc, char[] wordC, int wordLoc){
        int x= currentLoc[0];
        int y = currentLoc[1];
        int height = board.length;
        int width = board[0].length;
        char c = wordC[wordLoc];
        List<int[]> nextLocList = new ArrayList<int[]>();
        int targetX = 0;
        int targetY = 0;
        //top
        if (x > 0) {
             targetX = x - 1;
             targetY = y;
            nextLocList.add(new int[]{targetX, targetY});
        }
        //bottom
        if (x < height - 1) {
            targetX = x + 1;
            targetY = y;
            nextLocList.add(new int[]{targetX, targetY});
        }
        //left
        if (y > 0) {
            targetX = x;
            targetY = y - 1;
            nextLocList.add(new int[]{targetX, targetY});
        }
        //right
        if (y < width - 1) {
            targetX = x;
            targetY = y + 1;
            nextLocList.add(new int[]{targetX, targetY});
        }
        for(int[] tarXY : nextLocList){
            targetX = tarXY[0];
            targetY = tarXY[1];
            char nt = board[targetX][targetY];
            if (nt == c && pathBoard[targetX][targetY] != 1) {
                pathBoard[targetX][targetY] = 1;
                if(wordLoc < wordC.length -1){
                    int[] resultTemp = findNext(board, pathBoard, tarXY, wordC, wordLoc + 1);
                    if(resultTemp[0] != -1 && resultTemp[1] != -1){
                        return resultTemp;
                    }else{
                        pathBoard[targetX][targetY] = 0;
                    }
                }else{
                    return tarXY;
                }

            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        char[][] c = new char[][]{
                {'A','B','C','E'},
                {'S','F','E', 'S'},
                {'A','D','E', 'E'}};
        String word = "ABCEEDA";
        Date a = new Date();
        System.out.println(s.exist(c, word));
        Date b = new Date();
        System.out.println("last "+ (b.getTime()-a.getTime()) +"ms");
    }
}
