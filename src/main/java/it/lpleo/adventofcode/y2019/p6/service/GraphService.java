package it.lpleo.adventofcode.y2019.p6.service;

import it.lpleo.adventofcode.y2019.p6.domain.Node;
import java.util.List;

public class GraphService {

  public static Node findNode(List<Node> nodes, String data) {
    for (Node node : nodes) {
      if (node.getData().equals(data)) {
        return node;
      }
    }
    return null;
  }

  public static boolean notExistNode(List<Node> nodes, String data) {
    return findNode(nodes, data) == null;
  }

  public static void addNode(List<Node> nodes, String data, String parentData) {
    Node newNode = new Node(data);

    if (notExistNode(nodes, data)) {
      nodes.add(newNode);
    } else {
      newNode = findNode(nodes, data);
    }

    Node parentNode;
    if (notExistNode(nodes, parentData)) {
      parentNode = new Node(parentData);
      nodes.add(parentNode);
    } else {
      parentNode = findNode(nodes, parentData);
    }

    parentNode.addChildren(newNode);
  }

  public static Node findRoot(List<Node> nodes) {
    for (Node nodeToVerify : nodes) {
      boolean isChild = false;
      for (Node node : nodes) {
        if (node.getChildren().contains(nodeToVerify)) {
          isChild = true;
          break;
        }
      }
      if (!isChild) {
        return nodeToVerify;
      }
    }
    throw new RuntimeException("Could not find Root");
  }

  private static int calculateDistance(Node node, int actualStep) {
    int initialStep = actualStep;
    for (Node child : node.getChildren()) {
      actualStep += calculateDistance(child, initialStep + 1);
    }
    return actualStep;
  }

  public static int calculateDistance(Node rootNode) {
    return calculateDistance(rootNode, 0);
  }
}
