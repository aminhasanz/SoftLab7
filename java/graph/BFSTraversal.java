package graph;

class BFSTraversal implements GraphTraversalStrategy {
    @Override
    public void traverse(Graph graph, Node start) {
        graph.resetVisits();
        Queue<Pair<Node, Integer>> nodes = new LinkedList<>();
        nodes.add(new Pair<>(start, 0));
        while (!nodes.isEmpty()) {
            Pair<Node, Integer> front = nodes.poll();
            Node frontNode = front.getValue0();
            if (!frontNode.isVisited()) {
                frontNode.setVisited(true);
                int distance = front.getValue1();
                frontNode.setDistance(distance);
                nodes.addAll(
                        frontNode.getAvailableNeighbors()
                                .stream()
                                .map(neighbor -> new Pair<>(neighbor, distance + 1))
                                .collect(Collectors.toList()));
            }
        }
    }
}