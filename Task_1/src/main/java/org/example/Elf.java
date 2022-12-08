package org.example;

public class Elf {
    private String name;
    private int calories;

    public Elf(int numer, int calories){
        this.calories = calories;
        this.name = "Elf " + numer;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }
    public String getName() {
        return name;
    }
    public int getCalories() {
        return calories;
    }

    public String toString(){
        return "Name: " + this.name +"| Calories: " + this.calories;
    }

}
