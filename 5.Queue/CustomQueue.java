public class CustomQueue<E> {

    private Node head;
    private Node tail;
    public class Node{
        private E val;
        private Node next;

        public Node(E data) {
            this.val = data;
        }

        public Node(E data, Node next) {
            this.val = data;
            this.next = next;
        }
    }

    public void add(E e){
        Node node = new Node(e);
        if(head==null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public E remove(){
        if(head==null){
            throw new RuntimeException("Queue is Empty.");
        }
        Node node = head;
        head = head.next;
        return node.val;
    }

    public E peek(){
        if(head==null){
            throw new RuntimeException("Queue is Empty.");
        }
        return head.val;
    }

    public void printQueue(){
        Node node = head;
        while(node!=null){
            System.out.print(node.val+", ");
            node = node.next;
        }
    }
}

