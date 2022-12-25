package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Monkey {
    private int name;
    private int divisibleBy;
    private Monkey tr;
    private Monkey fa;
    private Queue<Integer> queue;
    private String operator;
    private String num;
    private int inpect = 0;

    public Monkey(int name, int divisibleBy, String operator, String num) {
        this.name = name;
        this.divisibleBy = divisibleBy;
        this.operator = operator;
        this.num = num;
        this.queue = new LinkedList<Integer>();
    }

    public String getAllItems(){
        return this.queue.toString();
    }
    public int getInpect() {
        return this.inpect;
    }

    public int getName() {
        return name;
    }

    public void setTr(Monkey tr) {
        this.tr = tr;
    }

    public void setFa(Monkey fa) {
        this.fa = fa;
    }


    private int calcNew (){
        int oldNum = queue.poll();
        int newNum = 0;

        if(this.operator == "+"){
            if(this.num == "old"){
                newNum = oldNum + oldNum;
            }
            else {
                int a = Integer.parseInt(num);
                newNum = oldNum + a;
            }
        }
        else if (this.operator == "*") {
            if(this.num == "old"){
                newNum = oldNum + oldNum;
            }
            else {
                int a = Integer.parseInt(num);
                newNum = oldNum + a;
            }
        }
        return newNum;
    }

    public void throwItem(){
        int newNum = this.calcNew();
        newNum = newNum / 3;

        if(newNum % divisibleBy == 0){
            this.inpect++;
            tr.addItem(newNum);
        }
        else{
            this.inpect++;
            fa.addItem(newNum);
        }

    }

    public void goThrough(){
        while(queue.size() < 0){
            this.throwItem();
        }
    }

    public void addItem(int item){
       this.queue.add(item);
    }

}
