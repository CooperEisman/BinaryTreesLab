public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node<Key, Value> root;
    private int length;

    public BinarySearchTree() {
        root = new Node<Key, Value>(null,null);
        length = 0;
    }

    //Test if the Tree is Empty
    public boolean isEmpty() {
        return length <= 0;
    }

    //Returns True if the Key is contained in the Array
    public boolean contains(Key key) {
        return (get(key) != null);
    }

    //Returns Length
    public int getLength() {
        return length;
    }

    //Wrapper for Recursive Put
    public void put(Key key, Value value) {
        if(isEmpty()) {
            root = new Node<Key, Value>(key, value);
            length++;
        } else {
            if(put(root,key,value)) {
                length++;
            }
        }
    }

    //Puts a value into an Array. If it is a new value, return true. If Key exists, return false;
    private boolean put(Node node,Key key, Value value) {
        if(node.getKey().compareTo(key) > 0) {
            if(node.hasRight()) {
                return put(node.getRight(),key,value);
            } else {
                node.setRight(new Node(key,value));
                return true;
            }
        } else if(node.getKey().compareTo(key) < 0) {
            if(node.hasLeft()) {
                return put(node.getLeft(),key,value);
            } else {
                node.setLeft(new Node(key,value));
                return true;
            }
        } else {
            node.setValue(value);
            return false;
        }
    }

    //Wrapper for Recursive get
    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        return get(root, key);
    }

    //Recursive Get. Returns null without value
    private Value get(Node<Key,Value> node,Key key) {
        if(node.getKey().compareTo(key) > 0) {
            if(node.hasRight()) {
                return get(node.getRight(),key);
            } else {
                return null;
            }
        } else if(node.getKey().compareTo(key) < 0) {
            if(node.hasLeft()) {
                return get(node.getLeft(),key);
            } else {
                return null;
            }
        } else {
            return node.getValue();
        }
    }


}