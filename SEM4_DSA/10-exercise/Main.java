import java.util.Scanner;

class Node {
    String str;
    Node left;
    Node right;

    Node(String str) {
        this.str = str;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    Node root;

    Node insert(Node root, String str) {
        if (root == null) {
            return new Node(str);
        }
        if (str.compareTo(root.str) < 0) {
            root.left = insert(root.left, str);
        } else {
            root.right = insert(root.right, str);
        }
        return root;
    }

    boolean search(Node root, String str) {
        if (root == null) return false;
        if (root.str.equals(str)) return true;
        if (str.compareTo(root.str) < 0) return search(root.left, str);
        return search(root.right, str);
    }

    Node delete(Node root, String str) {
        if (root == null) return null;

        if (str.compareTo(root.str) < 0) {
            root.left = delete(root.left, str);
        } else if (str.compareTo(root.str) > 0) {
            root.right = delete(root.right, str);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            Node temp = findMax(root.left);
            root.str = temp.str;
            root.left = delete(root.left, temp.str);
        }
        return root;
    }

    Node findMax(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.str + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.str + " ");
            inorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.str + " ");
        }
    }

    String findSmallest(Node root) {
        if (root == null) return "Tree is empty";
        Node curr = root;
        while (curr.left != null) curr = curr.left;
        return curr.str;
    }

    String findLargest(Node root) {
        if (root == null) return "Tree is empty";
        Node curr = root;
        while (curr.right != null) curr = curr.right;
        return curr.str;
    }

    int getHeight(Node root) {
        if (root == null) return -1;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        Main bst = new Main();
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nBST Operations");
            System.out.println("==========");
            System.out.println("1.Insert Node\t2.Search\t3.Delete node");
            System.out.println("4.Pre-order Traversal\t5.In-order Traversal\t6.Post-order Traversal");
            System.out.println("7.Smallest & Largest\t8.Height & Total Nodes\t0.Exit");
            System.out.print("\nEnter your choice : ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter the string to insert: ");
                    String s1 = sc.nextLine();
                    bst.root = bst.insert(bst.root, s1);
                    break;
                case 2:
                    System.out.print("Enter data to search: ");
                    String s2 = sc.nextLine();
                    if (bst.search(bst.root, s2)) System.out.println("Element found:" + s2);
                    else System.out.println("Element not found!");
                    break;
                case 3:
                    System.out.print("Enter the string to delete : ");
                    String s3 = sc.nextLine();
                    if (bst.search(bst.root, s3)) {
                        bst.root = bst.delete(bst.root, s3);
                    } else {
                        System.out.println("data not found in tree!");
                    }
                    break;
                case 4:
                    System.out.print("PREORDER: ");
                    bst.preorder(bst.root);
                    System.out.println();
                    break;
                case 5:
                    System.out.print("INORDER: ");
                    bst.inorder(bst.root);
                    System.out.println();
                    break;
                case 6:
                    System.out.print("POSTORDER: ");
                    bst.postorder(bst.root);
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Smallest string: " + bst.findSmallest(bst.root));
                    System.out.println("Largest string: " + bst.findLargest(bst.root));
                    break;
                case 8:
                    System.out.println("Height of BST: " + bst.getHeight(bst.root));
                    System.out.println("Total Nodes: " + bst.countNodes(bst.root));
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
