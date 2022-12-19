package org.example;

public class Tree {
    private Node root;

    public Tree(String name){
        this.root = new Node(name);
    }

    public Node getRoot() {
        return root;
    }

    public Node getNodeByName(Node node, String name){
        if(node == null){
            return null;
        }
        if(node.getName() == name){
            return node;
        }
        for(Node child : node.getChildren()){
            Node result = getNodeByName(child, name);
            if(result != null){
                return result;
            }
        }
        return null;
    }
}
