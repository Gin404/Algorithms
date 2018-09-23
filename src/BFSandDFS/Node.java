package BFSandDFS;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String id;
    private List<Node> neighbor;
    private boolean visited=false;

    public Node(String id){
        this.id=id;
        neighbor=new ArrayList<Node>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Node> getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(List<Node> neighbor) {
        this.neighbor = neighbor;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }




}
