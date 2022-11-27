import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int key) {
        data = key;
        this.left = null;
        this.right = null;
    }
}

public class Binary_Tree_Traversals {
    static Scanner sc = new Scanner(System.in);

    static Node createTree() {
        Node root = null;
        System.out.println("Enter data: ");
        int key = sc.nextInt();
        if (key == -1) {
            return null;
        }
        root = new Node(key);
        System.out.println("Enter left for " + key);
        root.left = createTree();
        System.out.println("Enter right for " + key);
        root.right = createTree();
        return root;

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

    static void preorder(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

    }

    static void postorder(Node root) {
        if (root == null) {
            return;
        } else {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

    }

    static void levelorder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur == null) {
                if (q.isEmpty()) {
                    return;
                }
                q.add(null);
                System.out.println();
            } else {
                System.out.print(cur.data + " ");
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }

        }

    }

    public static void main(String[] args) {
        System.out.println("Creating a tree if there is no node (or null) enter -1");
        Node root = createTree();
        System.out.print("\nInorder is:\n");
        inorder(root);
        System.out.print("\nPreorder is:\n");
        preorder(root);
        System.out.print("\nPostorder is:\n");
        postorder(root);
        System.out.print("\nLevel order is:\n");
        levelorder(root);
    }
}
