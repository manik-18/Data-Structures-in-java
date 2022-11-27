import java.util.Scanner;

class Node {
  int data;
  Node left, right;

  public Node(int key) {
    this.data = key;
    this.left = null;
    this.right = null;
  }
}

public class Binary_Search_Tree {
  static Scanner sc = new Scanner(System.in);

  static Node insert(Node root, int key) {
    Node newnode = new Node(key);
    if (root == null) {
      root = newnode;
      return root;
    }
    Node cur = root;
    Node parent = null;
    while (cur != null) {
      parent = cur;
      if (cur.data > key) {
        cur = cur.left;
      } else {
        cur = cur.right;
      }
    }
    if (parent == null) {
      parent = newnode;
    } else if (parent.data > key) {
      parent.left = newnode;
    } else {
      parent.right = newnode;
    }
    return root;

  }

  static int minValue(Node root) {
    int minv = root.data;
    while (root.left != null) {
      minv = root.left.data;
      root = root.left;
    }
    return minv;
  }

  static Node delete(Node root, int key) {
    if (root == null) {
      return root;
    }
    if (key < root.data) {
      root.left = delete(root.left, key);
    } else if (key > root.data) {
      root.right = delete(root.right, key);
    } else {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }
      root.data = minValue(root.right);
      root.right = delete(root.right, root.data);
    }
    return root;

  }

  static boolean search(Node root, int key) {
    if (root == null) {
      return false;
    }
    if (root.data == key) {
      return true;
    }
    if (root.data > key) {
      return search(root.left, key);
    }
    return search(root.right, key);
  }

  static void inorder(Node root) {
    if (root == null) {
      return;
    } else {
      inorder(root.left);
      System.out.print(root.data + " ");
      inorder(root.right);
    }

  }

  public static void main(String[] args) {
    Node root = null;
    boolean c = true;
    while (c) {
      System.out.println("\n1.Display tree");
      System.out.println("2.Insert a node");
      System.out.println("3.Delete a node");
      System.out.println("4.Search a node");
      System.out.println("5.Exit");
      System.out.print("\nEnter your choice: ");
      int choice = sc.nextInt();
      switch (choice) {
        case 1:
          inorder(root);
          System.out.println();
          break;
        case 2:
          System.out.print("\nEnter node value: ");
          int v = sc.nextInt();
          root = insert(root, v);
          break;
        case 3:
          System.out.print("\nEnter node value: ");
          int w = sc.nextInt();
          root = delete(root, w);
          break;
        case 4:
          System.out.print("\nEnter node value: ");
          int x = sc.nextInt();
          System.out.println("\n" + search(root, x));
          break;
        case 5:
          c = false;
          break;

        default:
          System.out.println("Wrong input");
          break;
      }
    }
  }
}