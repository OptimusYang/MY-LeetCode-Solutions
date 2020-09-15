package tim.d37.sudoku_solver.model;

import java.util.ArrayList;
import java.util.List;

public class Container {


    private List<Node> nodeList = new ArrayList<Node>();

    public void addNode(Node n){
        nodeList.add(n);
        n.setContainer(this);
    }

    public int[] getAvailableValues(){
        int[] values = new int[9];
        for(Node n : nodeList){
            if(n.getValue() != 0){
                values[n.getValue() - 1] = 1;
            }
        }
        return values;
    }
}
