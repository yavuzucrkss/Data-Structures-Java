package Tree;

import static java.nio.file.Files.size;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    Node newNode(int x){
        root = new Node(x);
        System.out.println(x + " added");
        return root;
    }

    Node insert(Node root, int x){
        if(root != null){
            if(x < root.num){
                root.left = insert(root.left, x);
            }
            else{
                root.right = insert(root.right,x);
            }
        }
        else{
            root = newNode(x);

        }
        return  root;
    }

    Node delete(Node root, int x){
        Node t1, t2;
        if(root == null){
            return null;
        }
        if(root.num == x){
            if(root.left == root.right){
                root = null;
                return null;
            }
            else if(root.left == null){
                t1 = root.right;
                return t1;
            }
            else if(root.right == null){
                t1 = root.left;
                return t1;
            }
            else{
                t1 = t2 = root.right;
                while (t1.left != null){
                    t1 = t1.left;
                }
                t1.left = root.left;

                return t2;
            }
        }
        else {
            if(x < root.num){
                root.left =delete(root.left, x);
            }
            else root.right = delete(root.right,x);
        }
        return root;
    }

    void preOrder(Node root){
        if(root != null){
            System.out.println(root.num + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.println(root.num + " ");
            inOrder(root.right);
        }
    }

    void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.num + " ");
        }
    }

    int height(Node root){
        if(root == null){
            return -1;
        }
        else {
            int left = 0, right = 0;
            left = height(root.left);
            right = height(root.right);
            if(left > right){
                return left + 1;
            }
            else return  right + 1;
        }
    }

    int totalNode(Node root){
        if(root == null){
            return 0;
        }
        else{
            return  totalNode(root.left) + 1 + totalNode(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.root = binaryTree.insert(binaryTree.root,10);
        binaryTree.root = binaryTree.insert(binaryTree.root,8);
        binaryTree.root = binaryTree.insert(binaryTree.root,15);
        binaryTree.root = binaryTree.insert(binaryTree.root,5);
        binaryTree.root = binaryTree.insert(binaryTree.root,12);
        binaryTree.root = binaryTree.insert(binaryTree.root,20);
        binaryTree.root = binaryTree.insert(binaryTree.root,9);
        binaryTree.root = binaryTree.insert(binaryTree.root,25);

        System.out.println(binaryTree.root.num);
        System.out.println(binaryTree.root.right.num);
        System.out.println(binaryTree.root.left.num);
        System.out.println(binaryTree.root.left.left.num);
        System.out.println("------PreOrder-----------");
        binaryTree.preOrder(binaryTree.root);
        System.out.println("------InOrder-----------");
        binaryTree.inOrder(binaryTree.root);
        System.out.println("------PostOrder-----------");
        binaryTree.postOrder(binaryTree.root);

        System.out.println("Depth:" + binaryTree.height(binaryTree.root));
        System.out.println("Total Node" + binaryTree.totalNode(binaryTree.root));

        binaryTree.root = binaryTree.delete(binaryTree.root,5);
        binaryTree.root = binaryTree.delete(binaryTree.root,10);
        binaryTree.root = binaryTree.delete(binaryTree.root,25);

        binaryTree.postOrder(binaryTree.root);

    }

}
