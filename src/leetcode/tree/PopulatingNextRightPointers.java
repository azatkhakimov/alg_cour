package leetcode.tree;

/*117. Populating Next Right Pointers in Each Node II*/
public class PopulatingNextRightPointers {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Node dummyHead = new Node(0);
        Node pre = dummyHead;
        Node realRoot = root;
        while (root != null){
            if(root.left != null){
                pre.next = root.left;
                pre = pre.next;
            }
            if(root.right != null){
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if(root == null){
                pre = dummyHead;
                root = dummyHead.next;
                dummyHead.next = null;
            }
        }
        return realRoot;
    }

    public static void main(String[] args) {
        PopulatingNextRightPointers test = new PopulatingNextRightPointers();
        Node tree = new Node(1, new Node(2, new Node(4), new Node(5), null), new Node(3, null, new Node(7), null), null);
        System.out.println(test.connect(tree));
    }
}
