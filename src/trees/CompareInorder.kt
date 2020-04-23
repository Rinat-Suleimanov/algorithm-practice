package trees

import java.util.*

data class TreeNode(
    val value: Int,
    val left: TreeNode? = null,
    val right: TreeNode? = null
)

fun main() {
    val first = TreeNode(
        1,
        TreeNode(2, TreeNode(4), TreeNode(5)),
        TreeNode(3)
    )
    val second = TreeNode(
        2,
        TreeNode(4),
        TreeNode(1, TreeNode(5), TreeNode(3))
    )
    val firstTraversal = LinkedList<Int>()
    inorder(first, firstTraversal)
    val compareInorder = compareInorder(second, firstTraversal)
    val empty = firstTraversal.isEmpty()
    println(compareInorder && empty)
}

fun inorder(root: TreeNode?, traversal: LinkedList<Int>) {
    if (root == null) return
    inorder(root.left, traversal)
    traversal.addLast(root.value)
    inorder(root.right, traversal)
}

fun compareInorder(root: TreeNode?, traversal: LinkedList<Int>): Boolean {
    if (root == null) return true
    if (!compareInorder(root.left, traversal)) {
        return false
    }
    if (traversal.isEmpty() || traversal[0] != root.value) return false
    traversal.removeFirst()
    return compareInorder(root.right, traversal)
}

//            1                     2
//          /   \                 /   \
//         2     3               4     1
//       /   \                       /   \
//      4     5                     5     3