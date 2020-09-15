package tim.d37.sudoku_solver;

import tim.d37.sudoku_solver.model.Container;
import tim.d37.sudoku_solver.model.Node;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void solveSudoku(char[][] board) {
        Container[] columnCList = new Container[9];
        Container[] blockCList = new Container[9];
        List<Node> nodeList = new ArrayList<Node>();
        for(int i=0;i< board.length;i++){
            char[] row = board[i];
            Container rowC = new Container();
            for(int j=0;j< row.length;j++){
                Container columnC = columnCList[j];
                Container blockC = null;
                if(i>=0&&i<=2&&j>=0&&j<=2){
                    blockC=blockCList[0];
                    if(blockC==null){
                        blockC=new Container();
                    }
                    blockCList[0] = blockC;
                }
                if(i>=0&&i<=2&&j>=3&&j<=5){
                    blockC=blockCList[1];
                    if(blockC==null){
                        blockC=new Container();
                    }
                    blockCList[1] = blockC;
                }
                if(i>=0&&i<=2&&j>=6&&j<=8){
                    blockC=blockCList[2];
                    if(blockC==null){
                        blockC=new Container();
                    }
                    blockCList[2] = blockC;
                }
                if(i>=3&&i<=5&&j>=0&&j<=2){
                    blockC=blockCList[3];
                    if(blockC==null){
                        blockC=new Container();
                    }
                    blockCList[3] = blockC;
                }
                if(i>=3&&i<=5&&j>=3&&j<=5){
                    blockC=blockCList[4];
                    if(blockC==null){
                        blockC=new Container();
                    }
                    blockCList[4] = blockC;
                }
                if(i>=3&&i<=5&&j>=6&&j<=8){
                    blockC=blockCList[5];
                    if(blockC==null){
                        blockC=new Container();
                    }
                    blockCList[5] = blockC;
                }
                if(i>=6&&i<=8&&j>=0&&j<=2){
                    blockC=blockCList[6];
                    if(blockC==null){
                        blockC=new Container();
                    }
                    blockCList[6] = blockC;
                }
                if(i>=6&&i<=8&&j>=3&&j<=5){
                    blockC=blockCList[7];
                    if(blockC==null){
                        blockC=new Container();
                    }
                    blockCList[7] = blockC;
                }
                if(i>=6&&i<=8&&j>=6&&j<=8){
                    blockC=blockCList[8];
                    if(blockC==null){
                        blockC=new Container();
                    }
                    blockCList[8] = blockC;
                }

                if(columnC == null){
                    columnC = new Container();
                    columnCList[j] = columnC;
                }
                int cn = (int) row[j];
                Node n = new Node();
                if(cn != 0){
                    n.setValue(cn);
                }
                rowC.addNode(n);
                columnC.addNode(n);
                blockC.addNode(n);
                nodeList.add(n);
            }
        }
        System.out.println("data process done");
        calcNodeList(nodeList, 0);
        System.out.println("Calculate process done");
        for(int i=0;i<nodeList.size();i++){
//            System.out.print(nodeList.get(i).getValue()+" ");
            board[i/9][i%9] = (char)nodeList.get(i).getValue();
//            if((i+1)%9 == 0){
//                System.out.println();
//            }
        }
    }

    public boolean calcNodeList(List<Node> nodeList, int startLoc){
            Node n = nodeList.get(startLoc);
            if(startLoc ==(nodeList.size() - 1)){
                return true;
            }
            if(n.getValue() != 0){
                boolean res = calcNodeList(nodeList,startLoc+1);
                if(res){
                    return true;
                }else{
                    return false;
                }
            }
            int[] valueOccupyArr = n.getValueOccupyArr();
            List<Integer> availableValue = new ArrayList<Integer>();
            for(int j =0;j< valueOccupyArr.length;j++){
                if(valueOccupyArr[j] == 0){
                    availableValue.add(j+1);
                }
            }
            if(availableValue.size() == 0){
                return false;
            }
            if(startLoc ==(nodeList.size() - 1)){
                n.setValue(availableValue.get(0));
                return true;
            }
            if(availableValue.size() == 1){
                n.setValue(availableValue.get(0));
                boolean res = calcNodeList(nodeList,startLoc+1);
                if(res){
                    return true;
                }else{
                    n.setValue(0);
                    return false;
                }
            }else{
                for(int v : availableValue){
                    n.setValue(v);
                    boolean res = calcNodeList(nodeList,startLoc+1);
                    if(res){
                        return true;
                    }else{
                        n.setValue(0);
//                        return false;
                    }
                }
            }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[9][9];
        board[0][0] = 5;
        board[0][1] = 3;
        board[0][4] = 7;
        board[1][0] = 6;
        board[1][3] = 1;
        board[1][4] = 9;
        board[1][5] = 5;
        board[2][1] = 9;
        board[2][2] = 8;
        board[2][7] = 6;
        board[3][0] = 8;
        board[3][4] = 6;
        board[3][8] = 3;
        board[4][0] = 4;
        board[4][3] = 8;
        board[4][5] = 3;
        board[4][8] = 1;
        board[5][0] = 7;
        board[5][4] = 2;
        board[5][8] = 6;
        board[6][1] = 6;
        board[6][6] = 2;
        board[6][7] = 8;
        board[7][3] = 4;
        board[7][4] = 1;
        board[7][5] = 9;
        board[7][8] = 5;
        board[8][4] = 8;
        board[8][7] = 7;
        board[8][8] = 9;
        for(char[] row : board ){
            for(char x : row){
                System.out.print((int)x);
                System.out.print(" ");
            }
            System.out.println();
        }
        Solution s = new Solution();
        s.solveSudoku(board);
        System.out.println("=========after solve=======");
        for(char[] row : board ){
            for(char x : row){
                System.out.print((int)x);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}