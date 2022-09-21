class BinaryNode {
  int val;
  BinaryNode left;
  BinaryNode right;
}

class Main {
  public static void main(String[] args) {
    BinarySearchTree BST = new BinarySearchTree();
    BST.insertNode(4);
    BST.insertNode(10);
    BST.insertNode(12);
    BST.insertNode(9);
    BST.insertNode(123);
    BST.insertNode(1);
    BST.insertNode(0);
  }
}

class BinarySearchTree {
  BinaryNode root;

  BinarySearchTree() {
    root = null;
  }

  BinaryNode insertNode(BinaryNode currentNode, int value) {
    BinaryNode newNode = new BinaryNode();
    newNode.val = value;
    if (currentNode == null) {

      System.out.println("The value is successfully inserted.");
      return newNode;
    } else {
      if (value <= currentNode.val) {
        insertNode(currentNode.left, value);
      }
      if (value > currentNode.val) {
        insertNode(currentNode.right, value);
      }
    }
    return newNode;

  }

  void insertNode(int value) {
    insertNode(root, value);
  }
}