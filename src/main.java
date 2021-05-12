public class main {
    public static void main(String[] args) {
        BinarySearchTree<String, String> b = new BinarySearchTree<String, String>();

        System.out.println("Size: " + b.size() + " IsEmpty: " + b.isEmpty());
        b.put("Hello","World");
        System.out.println("Size: " + b.size() + " IsEmpty: " + b.isEmpty());
        b.put("Mario","Cart");
        System.out.println("Size: " + b.size() + " IsEmpty: " + b.isEmpty());
    }
}
