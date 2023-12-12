package src.main.environment;

import src.main.app.common.CommonPanelFunction;
import src.main.character.Monster;

import java.util.ArrayList;
import java.util.List;

public class RegionMap {
    public static class Node {
        String value;
        List<Node> neighbors;
        Monster monster;

        public Node(String value) {
            this.value = value;
            this.neighbors = new ArrayList<>();
            this.monster = new Monster(CommonPanelFunction.getRandomInt(0, 100), value + "의 왕");
            this.monster.setImgLink("src/resources/images/monsters/" + value + ".png");
        }

        public String getValue() {
            return value;
        }

        public List<Node> getNeighbors() {
            return neighbors;
        }

        public Monster getMonster() {
            return monster;
        }
    }

    private List<Node> nodes;

    public RegionMap() {
        this.nodes = new ArrayList<>();
        addNode("서울"); // 서울
        addNode("경기도"); // 경기도
        addNode("충주"); // 충주
        addNode("강원도"); // 강원도
        addNode("보령"); // 보령
        addNode("대구"); // 대구
        addNode("대전"); // 대전
        addNode("경주"); // 경주
        addNode("전주"); // 전주
        addNode("부산"); // 부산
        addNode("제주도");
        
        addEdge("서울", "경기도");
        addEdge("경기도", "충주");
        addEdge("경기도", "강원도");
        addEdge("경기도", "보령");
        addEdge("충주", "대구");
        addEdge("강원도", "대구");
        addEdge("강원도", "대전");
        addEdge("보령", "대전");
        addEdge("대구", "경주");
        addEdge("대전", "경주");
        addEdge("대전", "전주");
        addEdge("경주", "부산");
        addEdge("부산", "제주도");
        addEdge("전주", "제주도");
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
