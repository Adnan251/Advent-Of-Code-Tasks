package org.example;

import java.util.List;
import java.util.Stack;

public class Group {
    private Stack<Character> st = new Stack<Character>();

    public Group(List<Character> li){
        for(int i = 0; i < li.size(); i++){
            this.st.push(li.get(i));
        }
    }

    public Character getBox() {
        return this.st.pop();
    }
    public void setBox(Character box) {
        this.st.push(box);
    }


    public Stack<Character> toStringy() {
        return this.st;
    }

    public int size(){
        return this.st.size();
    }
}
