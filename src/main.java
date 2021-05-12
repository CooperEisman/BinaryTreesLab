import com.sun.jdi.Value;

import java.security.Key;

public class main {
    public static void main(String[] args) {
        BinarySearchTree<String, String> b = new BinarySearchTree<String, String>();

        System.out.println("IsEmpty: " + b.isEmpty() + " Length: " + b.getLength());
        b.put("Hello", "World");
        System.out.println("IsEmpty: " + b.isEmpty() + " Length: " + b.getLength());
        b.put("Hello", "World");
        System.out.println("IsEmpty: " + b.isEmpty() + " Length: " + b.getLength());
        b.put("Cooper", "Eisman");
        System.out.println("IsEmpty: " + b.isEmpty() + " Length: " + b.getLength());
        System.out.println(b.get("Cooper"));
        System.out.println(b.contains("Coop"));

    }
}
