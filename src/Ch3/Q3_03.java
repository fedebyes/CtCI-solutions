package Ch3;
import CtCILibrary.CtCILibrary.*;
import CtCILibrary.CtCILibrary.AssortedMethods;

import java.util.ArrayList;
import java.util.Stack;


class SetOfStacks {
    int thresold;
    ArrayList<Stack> l=new ArrayList<>();
    Stack latest=null;
    int count;
    int latest_position;
    public SetOfStacks(int thresold){
        this.thresold=thresold;
    }

    public void push(int v){
        if(l.isEmpty()){latest=new Stack();l.add(latest);latest_position=0;count=0;}
        if(count<thresold){
            latest.push(v);count++;}
        else{latest=new Stack();l.add(latest);latest.push(v);count=1;latest_position++;}
    }
    public int pop() {
        if(count==0){
            latest_position--;
            if(latest_position<0){return -1;}
            count=thresold-1;
            latest=l.get(latest_position);}
        else{count--;}

        return (int) latest.pop();
    }
    public int popAt(int v){
        int result= (int) l.get(v).pop();
        if(l.size()>v+1)latest_position=v;
        int index= v;
        SetOfStacks s=new SetOfStacks(thresold);
        while(index<l.size()-1){
            index++;
            s.push(this.pop());



        }
        count=thresold-1;
        while(s.l.size()>0){
            this.push(s.pop());
        }
        return result;
    }


}


public class Q3_03 {
    public static void main(String[] args) {
        int capacity_per_substack = 5;
        SetOfStacks set = new SetOfStacks(capacity_per_substack);
        for (int i = 0; i < 34; i++) {
            set.push(i);
        }
        for (int i = 0; i < 35; i++) {
            System.out.println("Popped " + set.pop());
        }
    }
}
