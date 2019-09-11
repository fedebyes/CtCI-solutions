package Ch3;
import CtCILibrary.CtCILibrary.AssortedMethods;

import java.util.ArrayList;
import java.util.Stack;

class MyStack<Integer> {
    Stack s1;
    Stack s2;
    int active_stack;
    public MyStack(){
        s1=new Stack<Integer>();
        s2=new Stack<Integer>();
        active_stack=1;
    }
    public void push(Integer value){
        System.out.println("Inserting "+value);

        while(true){
            if(s1.isEmpty())break;
            if((int)value > (int) s1.peek())break;
            //System.out.println(value +" is > "+s1.peek());
            s2.push(s1.pop());
        }
        s1.push(value);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }

    }
    public Integer pop(){return (Integer)s1.pop();}
    public Integer peek(){return (Integer)s1.peek();}
    public boolean isEmpty(){return s1.isEmpty();}


}



public class Q3_05 {

    public static void main(String [] args) {
        MyStack<Integer> s = new MyStack<Integer>();

        ArrayList<Integer> arrayList=new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int r = AssortedMethods.randomIntInRange(0,  1000);
            s.push(r);



        }
        while (!s.isEmpty()){
            System.out.print(s.pop()+", ");
        }


    }
}
