public class Node {
    int value;
    Node left;
    Node right;
    Node parent;
    int key;
 
    Node(int value, int key) {
        this.value = value;
        parent = null;
        right = null;
        left = null;
        this.key = key;
    }
}
