import java.util.LinkedList;
import java.util.Queue;

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
    BST.insertNode(11);
    System.out.println(BST.root.val);
    BST.preorderTraversal(BST.root);
    System.out.println();
    BST.inorderTraversal(BST.root);
    System.out.println();
    BST.postorderTraversal(BST.root);
    System.out.println();
    BST.levelorderTraversal(BST.root);
    System.out.println();
    BST.search(0);
    BST.search(2);
    BST.search(123);
    BST.search(9);
    BST.search(10);
    BST.search(122);
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
      currentNode=newNode;
      //System.out.println("The value is successfully inserted.");
      return newNode;
    } 
    else if (value <= currentNode.val) {
      currentNode.left= insertNode(currentNode.left, value);
      return currentNode;
    }
    else{ 
      currentNode.right=insertNode(currentNode.right, value);
      return currentNode;
    }
  }
  void insertNode(int value) {
    root=insertNode(root, value);
  }

  void preorderTraversal(BinaryNode root){
    if(root==null){
      System.out.print("");
    }
    else{
      System.out.print(root.val+" ");
      preorderTraversal(root.left);
      preorderTraversal(root.right);
    }
  }

  void inorderTraversal(BinaryNode root){
    if(root==null){
      System.out.print("");
    }
    else{
      inorderTraversal(root.left);
      System.out.print(root.val+" ");
      inorderTraversal(root.right);
    }
  }

  void postorderTraversal(BinaryNode root){
    if(root==null){
      System.out.print("");
    }
    else{
      postorderTraversal(root.left);
      postorderTraversal(root.right);
      System.out.print(root.val+" ");
    }
  }

  void levelorderTraversal(BinaryNode root){
    Queue<BinaryNode> queue=new LinkedList<BinaryNode>();
    queue.add(root);
    while(!queue.isEmpty()){
      BinaryNode presentNode=queue.remove();
      System.out.print(presentNode.val+" ");
      if(presentNode.left!=null){
        queue.add(presentNode.left);
      }
      if(presentNode.right!=null){
        queue.add(presentNode.right);
      }
    }
  }

  void search(BinaryNode node,int value){
    if(node==null){
      System.out.println(value+ " not in BST. :(");
      return;
    }
    if(node.val==value){
      System.out.println(+value+" found in BST. :)");
      return;
    }
    if(node.val>value){
      search(node.left,value);
    }
    if(node.val<value){
      search(node.right,value);
    }
    
    
    
  }

  void search(int value){
    search(root,value);
  }
}