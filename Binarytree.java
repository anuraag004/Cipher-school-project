public class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BST {
    Node root;

    // Constructor
    BST() {
        root = null;
    }

    void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    boolean search(int data) {
        return searchRec(root, data);
    }

    boolean searchRec(Node root, int data) {
        if (root == null || root.data == data)
            return root != null;

        if (root.data < data)
            return searchRec(root.right, data);

        return searchRec(root.left, data);
    }

    void inOrder() {
        inOrderRec(root);
    }

    void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();

        // Inserting values
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print in-order traversal
        System.out.println("In-order traversal:");
        tree.inOrder();
        
        // Search for values
        int value = 40;
        if (tree.search(value)) {
            System.out.println("\n" + value + " is found in the BST.");
        } else {
            System.out.println("\n" + value + " is not found in the BST.");
        }

        value = 90;
        if (tree.search(value)) {
            System.out.println(value + " is found in the BST.");
        } else {
            System.out.println(value + " is not found in the BST.");
        }
    }
}
