package practice.Online;

import java.io.*;
import java.util.*;

class SquareBoat {

    static class Node {

        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }

    static class SalesPath {

        static int getCheapestCost(Node rootNode) {
            if(rootNode == null) return 0;
            return dfs(rootNode);
        }

        static int dfs(Node rootNode){
            Node[] childrens = rootNode.children;
            if(childrens == null || childrens.length == 0) return rootNode.cost;

            int minChild = Integer.MAX_VALUE;
            for(Node child : childrens){
                int min = dfs(child);
                minChild = Math.min(min, minChild);
            }

            return minChild + rootNode.cost;
        }
    }


    /*********************************************
     * Driver program to test above method     *
     *********************************************/

    public static void main(String[] args) {
        Node root = new Node(0);
        Node l1 = new Node(5);
        Node l2 = new Node(3);
        Node l3 = new Node(6);

        Node t1 = new Node(4);
        Node t2 = new Node(2);
        Node t3 = new Node(0);
        Node t4 = new Node(1);
        Node t5 = new Node(5);

        Node y1 = new Node(1);
        Node y2 = new Node(10);

        Node u1 = new Node(1);

        root.children = new Node[]{l1, l2, l3};
        l1.children = new Node[]{t1};
        l2.children = new Node[]{t2, t3};
        l3.children = new Node[]{t4, t5};

        t2.children = new Node[]{y1};
        t3.children = new Node[]{y2};
        y1.children = new Node[]{u1};

        // SalesPath p = new SalesPath();
        System.out.println(SalesPath.getCheapestCost(root));
    }
}