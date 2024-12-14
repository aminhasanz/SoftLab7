package graph;

class DijkstraTraversal implements GraphTraversalStrategy {
    @Override
    public void traverse(Graph graph, Node start) {
        graph.resetVisits();
        PriorityQueue<Pair<Integer, Node>> nodes = new PriorityQueue<>();
        nodes.add(new Pair<>(0, start));
        while (!nodes.isEmpty()) {
            Pair<Integer, Node> front = nodes.poll();
            Node frontNode = front.getValue1();
            if (!frontNode.isVisited()) {
                frontNode.setVisited(true);
                int distance = front.getValue0();
                frontNode.setDistance(distance);
                nodes.addAll(
                        frontNode.getAvailableWeightedNeighbors()
                                .stream()
                                .map(neighbor -> new Pair<>(neighbor.getValue1() + distance, neighbor.getValue0()))
                                .collect(Collectors.toList()));
            }
        }
    }
}
