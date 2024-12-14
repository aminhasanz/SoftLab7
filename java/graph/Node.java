package graph;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.javatuples.Pair;

import lombok.Data;
import lombok.Setter;

@Data
public class Node implements Comparable<Node> {
    private final ArrayList<Edge> edges;
    @Setter
    private boolean visited;
    @Setter
    private int distance;

    public Node() {
        edges = new ArrayList<>();
    }
    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public ArrayList<Pair<Node, Integer>> getAvailableWeightedNeighbors() {
        return edges.stream()
                .filter(edge -> !edge.isDirected() || edge.getNodes().getValue0() == this)
                .map(edge -> new Pair<>(
                        edge.getNodes().getValue0().equals(this) ? edge.getNodes().getValue1() : edge.getNodes().getValue0(),
                        edge.getWeight()))
                .filter(pair -> !pair.getValue0().isVisited())
                .collect(Collectors.toList());
    }

    public ArrayList<Node> getAvailableNeighbors() {
        return getAvailableWeightedNeighbors().stream()
                .map(Pair::getValue0)
                .collect(Collectors.toList());
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.distance, o.distance);
    }


}
