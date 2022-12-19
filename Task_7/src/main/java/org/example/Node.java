package org.example;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private int size;
    private List<Node> children;

    public Node(String name) {
        this.name = name;
        this.size = 0;
        this.children = new ArrayList<>();
    }
    public Node(String name, int size) {
        this.name = name;
        this.size = size;
        this.children = new ArrayList<>();
    }

    public List<Node> getChildren() {
        return children;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public String getName() {
        return name;
    }

    public void addChild( Node node) {
        this.children.add(node);
    }
}
