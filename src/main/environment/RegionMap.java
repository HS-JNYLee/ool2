package src.main.environment;

import java.util.ArrayList;
import java.util.List;

public class RegionMap {
    public static class Node {
        String value;
        List<Node> neighbors;

        public Node(String value) {
            this.value = value;
            this.neighbors = new ArrayList<>();
        }

        public String getValue() {
            return value;
        }

        public List<Node> getNeighbors() {
            return neighbors;
        }
    }

    private List<Node> nodes;

    public RegionMap() {
        this.nodes = new ArrayList<>();
        addNode("서울");
        addNode("경기");
        addNode("충북");
        addNode("강원");
        addNode("충남");
        addNode("경북");
        addNode("전북");
        addNode("경남");
        addNode("전남");
        addNode("부산");
        addNode("제주도");
        
        addEdge("서울", "경기");
        addEdge("경기", "충북");
        addEdge("경기", "강원");
        addEdge("경기", "충남");
        addEdge("충북", "경북");
        addEdge("강원", "경북");
        addEdge("강원", "전북");
        addEdge("충남", "전북");
        addEdge("경북", "경남");
        addEdge("전북", "경남");
        addEdge("전북", "전남");
        addEdge("경남", "부산");
        addEdge("부산", "제주도");
        addEdge("전남", "제주도");
    }

    public void addNode(String value) {
        nodes.add(new Node(value));
    }

    public void addEdge(String from, String to) {
        Node fromNode = getNode(from);
        Node toNode = getNode(to);

        if (fromNode != null && toNode != null) {
            fromNode.neighbors.add(toNode);
        }
    }

    public Node getNode(String value) {
        for (Node node : nodes) {
            if (node.value.equals(value)) {
                return node;
            }
        }
        return null;
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
