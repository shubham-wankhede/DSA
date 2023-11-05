public class SegmentTree {

    private Node root;

    private class Node{
        int val;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    public SegmentTree(int[] arr) {
        this.root = constructTree(arr,0,arr.length-1);
    }

    public Node constructTree(int[] arr, int start, int end){
        Node node = new Node(start,end);
        if(start == end){
            node.val = arr[start];
            return node;
        }

        int mid = (start+end)/2;

        node.left = constructTree(arr,start,mid);
        node.right = constructTree(arr,mid+1,end);


        node.val = node.left.val + node.right.val;

        return node;
    }

    public void update(int index, int val){
        update(root,index,val);
    }

    public Node update(Node node, int index, int val){
        if(index >= node.startInterval && index <= node.endInterval){
            if(node.startInterval==index && node.endInterval==index){
                node.val = val;
                return node;
            }
            Node updatedLeft = update(node.left,index,val);
            Node updatedRight = update(node.right,index,val);
            node.val = updatedLeft.val+updatedRight.val;
        }
        return node;
    }

    public int query(int qsi, int qei){
        return query(this.root, qsi,qei);
    }

    private int query(Node node, int qsi, int qei){
        if(node.startInterval>=qsi && node.endInterval<=qei ){
            return node.val;
        } else if(node.startInterval > qei ||  node.endInterval <qsi){
            return 0;
        } else {
            int left = this.query(node.left,qsi,qei);
            int right = this.query(node.right,qsi,qei);

            return left+right;
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        getTreeString(root, 0, result);
        return result.toString();
    }

    private void getTreeString(Node node, int level, StringBuilder result) {
        if (node != null) {
            getTreeString(node.right, level + 1, result);

            for (int i = 0; i < level; i++) {
                result.append("           ");
            }
            if(node==this.root){
                result.append(node.val).append("("+node.startInterval+","+node.endInterval+")").append("\n");
            }else {
                result.append("|---->").append(node.val).append("("+node.startInterval+","+node.endInterval+")").append("\n");
            }

            getTreeString(node.left, level + 1, result);
        }
    }


}

