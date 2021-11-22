/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.addFirst(root);
        while(! deque.isEmpty()){
            int size = deque.size();
            Node curr = deque.removeLast();
            if(curr.left != null){
                deque.addFirst(curr.left);
            }
            if(curr.right != null){
                deque.addFirst(curr.right);
            }
            while(size > 1){
                Node pre = curr;
                curr = deque.removeLast();
                pre.next = curr;
                if(curr.left != null){
                    deque.addFirst(curr.left);
                }
                if(curr.right != null){
                    deque.addFirst(curr.right);
                }
                size --;
            }
        }
        return root;
    }
}
