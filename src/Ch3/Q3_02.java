package Ch3;
import CtCILibrary.CtCILibrary.*;
import CtCILibrary.CtCILibrary.AssortedMethods;

import java.util.Stack;

class NodeWithMin{
    int data;

    int min;
    public NodeWithMin(int data,int min){
        this.data=data;

        this.min=min;
    }

}
class StackWithMin extends Stack<NodeWithMin>{
    public void push(int value){
        int newMin=Math.min(value,min());
        super.push(new NodeWithMin(value,newMin));
    }
    public int min(){
        if (this.isEmpty()){
            return Integer.MAX_VALUE;
        }else return peek().min;
    }
}
public class Q3_02 {



    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        //StackWithMin2 stack2 = new StackWithMin2();
        int[] array = {2, 1, 3, 1};
        for (int value : array) {
            stack.push(value);
            //stack2.push(value);
            System.out.print(value + ", ");
        }
        System.out.println('\n');
        for (int i = 0; i < array.length; i++) {
            System.out.println("Popped " + stack.pop().data + ", " );
            System.out.println("New min is " + stack.min() + ", " );
        }
    }
}
