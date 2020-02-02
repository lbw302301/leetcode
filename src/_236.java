/**
 * 类别：二叉树 迭代
 *
 * 要点：对每个点设置三个值left，right，mid，分别代表左子树、右子树、本节点是否为p或q
 * 跟使用dfs计算树的深度一样，对每个节点计算left、right、mid的和，如果和>=2则此节点为结果
 * 而如何给left，则需要判断左子树是否含有p或q，如果遍历过程遇到p或q，则返回true，则left为1，否则为0；right同理
 * 如果本身为p或q，则mid =1
 *
 * 这里遍历的时候，采用后（根）序！！！
 * */
public class _236 {
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p , q);
        return ans;
    }

    private boolean traverse(TreeNode node, TreeNode p, TreeNode q){
        if(node == null)
            return false;
        int left = traverse(node.left, p, q) ? 1 : 0;
        int right = traverse(node.right, p,q) ? 1: 0;
        int mid = (node == p || node == q)?1:0;
        if(left + right + mid >= 2)
            this.ans = node;
        return (left + right + mid > 0);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
