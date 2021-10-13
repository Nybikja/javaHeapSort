package com.company;


import java.util.Stack;


public class Tree {

    Node root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }


    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }


    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }

    public void peek(int value) {
        if (containsNode(value)) {
            System.out.println(value);
        } else {
            System.out.println("there is no element with value " + value);
        }
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }


    public void print() {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            Node top = stack.pop();
            System.out.print(top.value + " ");
            current = top.right;
        }
        System.out.println("");
    }


    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(55);
        tree.add(12);
        tree.add(22);
        tree.add(1);
        tree.add(3);
        tree.add(4);
        tree.add(-12);
        tree.print();

        tree.delete(12);

        tree.print();

        System.out.println(tree.containsNode(22));
        tree.peek(3);
    }
}