public class Node {

  private int data;
  private Node nextNode;

  public Node(int data) {
    this.data = data;
  }

  public int getData() {
    return data;
  }

  public Node nextNode() {
    return nextNode;
  }

  public void setData(int data) {
    this.data = data;
  }

  public void setNextNode(Node node) {
    this.nextNode = node;
  }

}