package dailyinterviewpro;

class Node<T> {
    T value;
    Node<T> left;
    Node<T> right;

    public Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    String preorder(StringBuilder traversal) {
        traversal.append(value).append(" ");
        if (left != null) {
            left.preorder(traversal);
        }
        if (right != null) {
            right.preorder(traversal);
        }
        return traversal.toString();
    }
}

public class InvertBinaryTree {
    public static void main(String[] args) {
        Node<Character> root = new Node<>(
                'a',
                new Node<>(
                        'b',
                        new Node<>('d', null, null),
                        new Node<>('e', null, null)
                ),
                new Node<>(
                        'c',
                        new Node<>('f', null, null),
                        null
                )
        );

        System.out.println(root.preorder(new StringBuilder()));
        invert(root);
        String preorder = root.preorder(new StringBuilder());
        System.out.println(preorder);
        if (!preorder.equals("a c f b e d ")){
            throw new RuntimeException("wrong inversion");
        }
    }

    static <T> void invert(Node<T> root) {
        if (root == null) {
            return;
        }
        Node<T> tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invert(root.left);
        invert(root.right);


    }
}
