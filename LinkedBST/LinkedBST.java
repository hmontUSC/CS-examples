public class LinkedBST<T extends Comparable<T>>
{
    private class Node
    {
        private T data;
        private Node left;
        private Node right;
        
        public Node(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node root;

    public LinkedBST()
    {
        root = null;
    }

    public void add(T data)
    {
        if (root == null) 
        {
            root = new Node(data);
        }
        else
        {
            add(root, data);
        }
    }

    private Node add(Node node, T data)
    {
        if (node == null)
            return new Node(data);

        if (data.compareTo(node.data) < 0) // Must go to the left
        {
            node.left = add(node.left, data);
        }
        else // Must go to the right
        {
            node.right = add(node.right, data);
        }

        return node;
    }

    public void remove(T data)
    {
        root = remove(root, data);
    }

    private Node remove(Node node, T data)
    {
        if (node == null) 
        {
            return null;
        }

        if (data.compareTo(node.data) < 0) // We must go to the left
        {
            node.left = remove(node.left, data);
        }
        else if (data.compareTo(node.data) > 0) // We must go to the right
        {
            node.right = remove(node.right, data);
        }
        else // We found it!
        {
            if (node.left == null)
            {
                return node.right;
            } 
            else if (node.right == null)
            {   
                return node.left;
            }
            else
            {
                node.data = findMin(node.right);
                node.right = remove(node.right, node.data);
            }
        }

        return node;
    }

    private T findMin(Node node)
    {
        if (node.left == null)
        {
            return node.data;
        }
        else
        {
            return findMin(node.left);
        }
    }

    public boolean search(T data)
    {
        return search(root, data);
    }

    private boolean search(Node node, T data)
    {
        if (node == null)
        {
            return false;
        }

        if (data.compareTo(node.data) < 0) // We must go to the left
        {
            return search(node.left, data);
        }
        else if (data.compareTo(node.data) > 0) // We must go to the right
        {
            return search(node.right, data);
        }
        else // Found it!
        {
            return true;
        }
    }
    
    public void printPreOrder()
    {
        printPreOrder(root);
    }
    
    private void printPreOrder(Node node)
    {
        if (node == null)
        {
            return;
        }
        
        System.out.println(node.data);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public void printInOrder()
    {
        printInOrder(root);
    }

    private void printInOrder(Node node)
    {
        if (node == null)
        {
            return;
        }

        printInOrder(node.left);
        System.out.println(node.data);
        printInOrder(node.right);
    }

    public void printPostOrder()
    {
        printPostOrder(root);
    }

    private void printPostOrder(Node node)
    {
        if (node == null)
        {
            return;
        }

        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.data);
    }
}