package ShortestDistance;

import java.util.*;

public class Dijkstra {
    public static void dijkstra(Node start, List<Node> graph) throws Exception {
        Map<Node, Integer> dis = new HashMap<>();
        Map<Node, Integer> find = new HashMap<>();
        Map<Node, Node> preNode = new HashMap<>();
        if (start == null){
            throw new Exception("Starter is invalid");
        }
        //初始化距离数组
        for (Node node : graph) {
            if (start.getNeighbor().keySet().contains(node)) {
                dis.put(node, start.getNeighbor().get(node));
            } else {
                dis.put(node, 9999);
            }
        }

        find.put(start, 0);
        dis.remove(start);
        int min = 9999;
        Node near = null;
        while (!dis.isEmpty()) {
            //遍历距离数组，找最小值
            min = 9999;
            for (Map.Entry<Node, Integer> entry : dis.entrySet()) {
                if (entry.getValue() < min) {
                    min = entry.getValue();
                    near = entry.getKey();
                }
            }
            if (min == 9999){
                find.putAll(dis);
                break;
            }
            find.put(near, min);

            //根据最小值调整其他距离
            if (!near.getNeighbor().isEmpty()) {
                for (Map.Entry<Node, Integer> entry : near.getNeighbor().entrySet()) {
                    if (dis.keySet().contains(entry.getKey()) && min + entry.getValue() < dis.get(entry.getKey())) {
                        preNode.put(entry.getKey(), near);
                        dis.put(entry.getKey(), min + entry.getValue());
                    }
                }
            }
            dis.remove(near);
        }

        for (Map.Entry<Node, Integer> entry : find.entrySet()){
            System.out.println("Key = "+entry.getKey().getName()+",value="+entry.getValue());
        }
        for (Map.Entry<Node, Node> entry : preNode.entrySet()){
            System.out.println("Key = "+entry.getKey().getName()+",value="+entry.getValue().getName());
        }
    }

    public static void  main(String[] args) throws Exception {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        A.getNeighbor().put(F, 100);
        A.getNeighbor().put(E, 30);
        A.getNeighbor().put(C, 10);
        B.getNeighbor().put(C, 5);
        C.getNeighbor().put(D, 50);
        D.getNeighbor().put(F, 10);
        E.getNeighbor().put(D, 20);
        E.getNeighbor().put(F, 60);
        List<Node> ls = new ArrayList<>();
        ls.add(A);
        ls.add(B);
        ls.add(C);
        ls.add(D);
        ls.add(E);
        ls.add(F);
        dijkstra(A, ls);
    }
}
