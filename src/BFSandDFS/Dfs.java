package BFSandDFS;

import java.util.Iterator;
import java.util.Stack;

public class Dfs {
    public static void dfs(Node start){
        Stack<Node> stack=new Stack<>();
        stack.push(start);
        System.out.println(start.getId());
        stack.peek().setVisited(true);
        Node temper=null;
        while(stack.size()>0) {
            for (Iterator<Node> iterator = stack.peek().getNeighbor().iterator(); iterator.hasNext(); ) {
                temper = iterator.next();
                if (temper.isVisited() == false) {
                    stack.push(temper);
                    System.out.println(temper.getId());
                    temper.setVisited(true);
                    break;
                }
                if (!iterator.hasNext()) {
                    stack.pop();
                }
            }
        }
    }

    public static void main(String[] args){
        Node A=new Node("A");
        Node B=new Node("B");
        Node C=new Node("C");
        Node D=new Node("D");
        Node E=new Node("E");
        Node F=new Node("F");
        Node G=new Node("G");

        A.getNeighbor().add(C);
        A.getNeighbor().add(D);
        A.getNeighbor().add(F);

        B.getNeighbor().add(C);

        C.getNeighbor().add(B);
        C.getNeighbor().add(D);
        C.getNeighbor().add(A);

        D.getNeighbor().add(A);
        D.getNeighbor().add(C);

        E.getNeighbor().add(G);

        F.getNeighbor().add(G);
        F.getNeighbor().add(A);

        G.getNeighbor().add(F);
        G.getNeighbor().add(E);

        Dfs.dfs(A);
    }
}
