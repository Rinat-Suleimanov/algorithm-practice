package trees;

import java.util.*;

class Node {
    Node1 left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Day22BinarySearchTrees {

    public static int getHeight(Node1 root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int childHeight = Math.max(leftHeight, rightHeight);
        return 1 + childHeight;
    }

    public static Node1 insert(Node1 root, int data) {
        if (root == null) {
            return new Node1(data);
        } else {
            Node1 cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node1 root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int height = getHeight(root);
        System.out.println(height);
    }
}

