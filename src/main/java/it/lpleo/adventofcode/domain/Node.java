package it.lpleo.adventofcode.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Node {

  private String data;
  private List<Node> children;
  private Node parent;

  public Node(String data) {
    this.data = data;
    this.children = new ArrayList<>();
  }
  
  public void addChildren(Node node) {
    this.children.add(node);
  }
  
  @Override
  public boolean equals(Object node) {
    if(node instanceof Node) {
      return data.equals(((Node) node).getData());
    }
    return false;
  }
}
