package ShortestDistance;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private String name;

    private Map<Node, Integer> neighbor;

    public Node(String name){
        this.name = name;
        this.neighbor = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Node, Integer> getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(Map<Node, Integer> neighbor) {
        this.neighbor = neighbor;
    }
}
