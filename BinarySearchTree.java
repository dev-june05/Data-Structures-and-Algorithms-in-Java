public class BinarySearchTree {
    private Node root;
    
    private static class Node {
        private int value;
        private Node left;
        private Node right;
        
        public Node(int value) {
            this.value = value;
        }
    }
    
    // Insert a new value into the BST
    public void insert(int value) {
        root = insert(root, value);
    }
    
    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }
        // If value == node.value, we don't insert duplicates
        return node;
    }
    
    // Search for a value in the BST
    public boolean search(int value) {
        return search(root, value);
    }
    
    private boolean search(Node node, int value) {
        if (node == null) {
            return false;
        }
        
        if (value == node.value) {
            return true;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }
    
    // Delete a value from the BST
    public void delete(int value) {
        root = delete(root, value);
    }
    
    private Node delete(Node node, int value) {
        if (node == null) {
            return null;
        }
        
        if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            // Node to be deleted found
            
            // Case 1: Node with no children (leaf node)
            if (node.left == null && node.right == null) {
                return null;
            }
            
            // Case 2: Node with one child
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            
            // Case 3: Node with two children
            // Find the inorder successor (smallest in right subtree)
            Node successor = findMin(node.right);
            node.value = successor.value;
            node.right = delete(node.right, successor.value);
        }
        
        return node;
    }
    
    // Helper method to find minimum value in a subtree
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    // Inorder traversal (Left, Root, Right) - gives sorted order
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }
    
    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }
    
    // Preorder traversal (Root, Left, Right)
    public void preorder() {
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
    }
    
    private void preorder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }
    
    // Postorder traversal (Left, Right, Root)
    public void postorder() {
        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();
    }
    
    private void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " ");
        }
    }
    
    // Check if the BST is empty
    public boolean isEmpty() {
        return root == null;
    }
    
    // Get the height of the BST
    public int height() {
        return height(root);
    }
    
    private int height(Node node) {
        if (node == null) {
            return -1; // Height of empty tree is -1
        }
        
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    // Count the number of nodes in the BST
    public int size() {
        return size(root);
    }
    
    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }
    
    // Find minimum value in the BST
    public Integer findMin() {
        if (root == null) {
            return null;
        }
        return findMin(root).value;
    }
    
    // Find maximum value in the BST
    public Integer findMax() {
        if (root == null) {
            return null;
        }
        return findMax(root).value;
    }
    
    private Node findMax(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        
        // Insert some values
        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45};
        for (int value : values) {
            bst.insert(value);
        }
        
        // Test traversals
        bst.inorder();
        bst.preorder();
        bst.postorder();
        
        // Test search
        System.out.println("Search 40: " + bst.search(40));
        System.out.println("Search 100: " + bst.search(100));
        
        // Test min/max
        System.out.println("Minimum: " + bst.findMin());
        System.out.println("Maximum: " + bst.findMax());
        
        // Test size and height
        System.out.println("Size: " + bst.size());
        System.out.println("Height: " + bst.height());
        
        // Test delete
        System.out.println("\nAfter deleting 30:");
        bst.delete(30);
        bst.inorder();
        
        System.out.println("After deleting 50 (root):");
        bst.delete(50);
        bst.inorder();
    }
}
