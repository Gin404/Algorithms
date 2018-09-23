package BFSandDFS;

import java.util.*;

public class Bfs {
    public static void bfs(Node start){
        Queue<Node> queue=new LinkedList<Node>();
        Set<Node> set=new HashSet<>();
        set.add(start);
        queue.offer(start);
        while (queue.size()>0){
            Node node=queue.poll();
            System.out.println(node.getId());
            node.setVisited(true);
            Node temper=null;
            for (Iterator<Node> iterator=node.getNeighbor().iterator();iterator.hasNext();){
                temper=iterator.next();
                if (temper.isVisited()==false&&set.add(temper)) {
                    queue.offer(temper);
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

        Bfs.bfs(A);
    }
}
