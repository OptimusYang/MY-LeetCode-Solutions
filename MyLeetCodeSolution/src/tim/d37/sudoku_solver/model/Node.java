package tim.d37.sudoku_solver.model;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private int value = 0;

    List<Container> containerList = new ArrayList<Container>();

    public void setContainer(Container c){
        containerList.add(c);
    }

    public void setValue(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }

    public int[] getValueOccupyArr(){
        int[] valueOccupyArr = new int[9];
        for(Container c : containerList){
            int[] av = c.getAvailableValues();
            for( int i=0;i<av.length;i++){
                if(av[i] == 1){
                    valueOccupyArr[i] = 1;
                }
            }
        }
        return valueOccupyArr;
    }
}
