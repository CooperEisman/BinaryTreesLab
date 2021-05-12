public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    public Node<Key, Value> root;

    public BinarySearchTree() {
        root = null;
    }

    public int size() {
        if(root==null) {
            return 0;
        }
        return size(root);
    }

    //use Node's recursive size
    private int size(Node x) {
        int out = x.getSize();
        if(x.getLeft() !=null) {
            out += size(x.getLeft());
        }
        if(x.getRight() !=null) {
            out += size(x.getRight());
        }
        return out;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    //recursive put wrapper
    public void put(Key key, Value value) {
        if(isEmpty()) {
            root = new Node<Key, Value>(key,value,0);
        }
        put(root, key, value);
    }

    //recursive put
    //sets left/right or creates a new node appropriately, returns the
    //modified node n
    private Node<Key, Value> put(Node<Key, Value> n, Key key, Value val) {
        if(n.getKey().compareTo(key) > 0) {
            if (n.getRight()!=null) {
                put(n.getRight(),key,val);
            } else {
                n.setRight(new Node<Key,Value>(key,val,0));
                n.setSize(n.getSize()+1);
                return n.getRight();
            }
        } else if (n.getKey().compareTo(key) < 0) {
            if (n.getLeft()!=null) {
                put(n.getLeft(),key,val);
            } else {
                n.setLeft(new Node<Key,Value>(key,val,0));
                n.setSize(n.getSize()+1);
                return n.getLeft();
            }
        } else {
            n.setValue(val);
            return n;
        }
        return root;
    }

    //recursive get wrapper
    public Value get(Key key) {

        return get(root, key);
    }

    //recursive get
    //returns null if the key does not exist
    private Value get(Node<Key, Value> n, Key key) {
        return n.getValue();
    }

    public boolean contains(Key key) {
        return true;
    }

    public Value remove(Key key) {
        Value v = get(key);
        root = remove(root, key);
        return v;
    }

    private Node remove(Node<Key, Value> n, Key key) {
        if (n == null) return null;
        int i = key.compareTo(n.getKey());
        if (i < 0) {
            n.setLeft(remove(n.getLeft(), key));
        } else if (i > 0) {
            n.setRight(remove(n.getRight(), key));
        } else {
            if (n.getRight() == null) return n.getLeft();
            if (n.getLeft() == null) return n.getRight();
            Node min = min(n.getRight());
            min.setLeft(n.getLeft());
            n = n.getRight();
        }
        n.setSize(size(n.getRight()) + size(n.getLeft()) + 1);
        return n;
    }

    public Key min() {
        return min(root).getKey();
    }

    //returns the node at the left most left branch of n
    private Node<Key, Value> min(Node<Key, Value> n) {
        return n;
    }

    public Key max() {
        return max(root).getKey();
    }

    //returns the node at the right most right branch of n
    private Node<Key, Value> max(Node<Key, Value> n) {
        return n;
    }

    public String toString() {
        String temp = toString(root);
        temp = temp.substring(0, temp.length() - 2);
        return "{" + temp + "}";
    }

    private String toString(Node<Key, Value> n) {
        if (n == null) return "";
        return toString(n.getLeft()) +
                n.getKey() + "=" + n.getValue() + ", " +
                toString(n.getRight());

    }
}