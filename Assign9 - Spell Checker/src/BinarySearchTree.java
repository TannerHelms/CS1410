public class BinarySearchTree<E extends Comparable> {
    private TreeNode<E> root;

    private class TreeNode<E> {
        public E data;
        public TreeNode<E> left;
        public TreeNode<E> right;

        public TreeNode(E data) {
            this.data = data;
        }
    }
    boolean insert(E value) {
            TreeNode<E> node = new TreeNode<>(value);

            if (root == null) {
                root = node;
                return true;
            }

            TreeNode<E> parent = null;
            TreeNode<E> current = root;

            while (current != null) {
                if (value == current.data) {
                    return false;
                }
                parent = current;
                if (value.compareTo(current.data) < 0) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }

            if (value.compareTo(parent.data) < 0) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            return true;

        }

    boolean remove(E value) {
        TreeNode<E> parent = null;
        TreeNode<E> node = root;

        boolean done = false;
        while (!done) {
            if (node == null) {
                return false;
            }
            else if (value.compareTo(node.data) < 0) {
                parent = node;
                node = node.left;
            }
            else if (value.compareTo(node.data) > 0) {
                parent = node;
                node = node.right;
            }
            else {
                done = true;
            }
        }

        // Case for no left child
        if (node.left == null) {
            // Special case for root node
            if (parent == null) {
                root = node.right;
            }
            else { // General case for no left child
                if (value.compareTo(parent.data) < 0) {
                    parent.left = node.right;
                }
                else {
                    parent.right = node.right;
                }
            }
        }
        else { // Case for there IS a left child
            TreeNode<E> parentOfRightMost = node;
            TreeNode<E> rightMost = node.left;
            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }
            node.data = rightMost.data;
            if (parentOfRightMost.right == rightMost) {
                parentOfRightMost.right = rightMost.left;
            }
            else {
                parentOfRightMost.left = rightMost.left;
            }
        }

        return true;
    }
    boolean search(E value) {
        TreeNode<E> current = root;
        while (current != null) {
            if (value.compareTo(current.data) == 0) {
                return true;
            } else if (value.compareTo(current.data) < 0) {
                current = current.left;
            } else if (value.compareTo(current.data) > 0) {
                current = current.right;
            }
        }
        return false;
    }
    int numberNodes() {
        return numberNodes(root);

    }
    private int numberNodes(TreeNode<E> current) {
        if (current == null) {
            return 0;
        }
        int temp = 1;
        if (current.left != null) {
            temp += numberNodes(current.left);
        }
        if (current.right != null) {
            temp += numberNodes(current.right);
        }
        return temp;

    }
    int numberLeafNodes() {
        return numberLeafNodes(root);

    }
    private int numberLeafNodes(TreeNode<E> current) {
        if (current == null) {
            return 0;
        }
        int temp = 0;
        if (current.left == null && current.right == null) {
            temp = 1;
        }
        if (current.left != null) {
            temp += numberLeafNodes(current.left);
        }
        if (current.right != null) {
            temp += numberLeafNodes(current.right);
        }
        return temp;

    }
    void display(String message) {
        System.out.println(message);
        inOrderTraversal(root);

    }
    void inOrderTraversal(TreeNode<E> current) {
        if (current == null) {
            return;
        }
        inOrderTraversal(current.left);
        System.out.println(current.data);
        inOrderTraversal(current.right);
    }
    int height() {
        return height(root) - 1;
    }
    int height(TreeNode<E> current) {
        if (current == null) {
            return 0;
        }
        int leftHeight = height(current.left);
        int rightHeight = height(current.right);
        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }










}
