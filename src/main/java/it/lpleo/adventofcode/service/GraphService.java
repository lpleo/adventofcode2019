package it.lpleo.adventofcode.service;

import it.lpleo.adventofcode.domain.Node;
import java.util.ArrayList;
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

  public static Node findNode(Node rootNode, String data) {
    if (rootNode.getData().equals(data)) {
      return rootNode;
    }
    for (Node child : rootNode.getChildren()) {
      Node result = findNode(child, data);
      if (result != null) {
        return result;
      }
    }
    return null;
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

    newNode.setParent(parentNode);
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

  public static int calculateDistance(Node rootNode) {
    return calculateDistance(rootNode, 0);
  }
  
  public static int calculateDistance(Node parent, Node son) {
    int distance = 0;
    Node next = son;
    while(!next.getParent().equals(parent)) {
      next = next.getParent();
      distance++;
    }
    return distance;
  }

  private static int calculateDistance(Node node, int actualStep) {
    int initialStep = actualStep;
    for (Node child : node.getChildren()) {
      actualStep += calculateDistance(child, initialStep + 1);
    }
    return actualStep;
  }

  public static Node findFirstCommonNode(Node root, Node nodeA, Node nodeB) {
    List<String> dataPathA = calculatePath(root, nodeA);
    List<String> dataPathB = calculatePath(root, nodeB);
    String result = findFirstCommonNode(dataPathA, dataPathB);
    return findNode(root, result);
  }

  public static List<String> calculatePath(Node root, Node destination) {
    List<String> path = new ArrayList<>();
    while (!destination.equals(root)) {
      destination = destination.getParent();
      path.add(destination.getData());
    }
    return path;
  }

  private static String findFirstCommonNode(List<String> dataPathA, List<String> dataPathB) {
    for (String stepA : dataPathA) {
      for (String stepB : dataPathB) {
        if (stepA.equals(stepB)) {
          return stepA;
        }
      }
    }
    throw new RuntimeException("No existent common step in path");
  }

  private static boolean notExistNode(List<Node> nodes, String data) {
    return findNode(nodes, data) == null;
  }
}
