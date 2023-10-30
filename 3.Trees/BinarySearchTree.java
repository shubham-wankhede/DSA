public class BinarySearchTree<E> {

    private Node root;
    public class Node{
        int height;
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(Node left) {
            this.left = left;
        }

        public Node(Node left,Node right) {
            this.left = left;
            this.right = right;
        }

    }

    public boolean insert(int val){
        root = insert(val,root);
        return true;
    }

    public int getHeight(Node node){
        return node==null ? -1 : node.height;
    }

    private Node insert(int val, Node node){
        if(node==null){
            node = new Node(val);
            return node;
        }

        if(val <= node.val){
            node.left = insert(val,node.left);
        }

        if(val>node.val){
            node.right = insert(val,node.right);
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right))+1;

      return node;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        getTreeString(root, 0, result);
        return result.toString();
    }

    private void getTreeString(Node root, int level, StringBuilder result) {
        if (root != null) {
            getTreeString(root.right, level + 1, result);

            for (int i = 0; i < level; i++) {
                result.append("    ");
            }
            if(root==this.root){
                result.append(root.val).append("\n");
            }else {
                result.append("|---->").append(root.val).append("\n");
            }

            getTreeString(root.left, level + 1, result);
        }
    }

}
