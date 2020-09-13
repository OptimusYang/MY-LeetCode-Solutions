package tim.d79.word_search;

import java.util.Date;

public class BestSolution {
    public boolean exist(char[][] board, String word) {
        char[] wordC = word.toCharArray();
        for (int i =0; i< board.length; i++){
            for(int j=0; j<board[0].length;j++){
                if(dfs(board,i,j,wordC,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board,int i, int j, char[] wordc, int wordLoc){
        if(wordc.length == wordLoc){
            return true;
        }
        if(i<0 || j<0|| i>= board.length || j>= board[0].length ||board[i][j]!=wordc[wordLoc]){
            return false;
        }
        board[i][j] +=256;
        boolean result = dfs(board, i+1,j,wordc,wordLoc+1) || dfs(board, i-1,j,wordc,wordLoc+1)||dfs(board, i,j+1,wordc,wordLoc+1)||dfs(board, i,j-1,wordc,wordLoc+1);
        board[i][j] -= 256;
        return result;
    }

    public static void main(String[] args) {
        BestSolution s = new BestSolution();
        char[][] c = new char[][]{
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}};
        String word = "AAB";
        Date a = new Date();
        System.out.println(s.exist(c, word));
        Date b = new Date();
        System.out.println("last "+ (b.getTime()-a.getTime()) +"ms");
    }
}
