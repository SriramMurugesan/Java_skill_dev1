public class StringManipulationDemo {
    public static void main(String[] args) {
        // String name = "sriram";
        // System.out.println(name.charAt(0));
        // System.out.println(name.length());
        // System.out.println(name.substring(0, 3));
        // System.out.println(name.toUpperCase());
        // System.out.println(name.toLowerCase());
        // System.out.println(name.trim());
        // System.out.println(name.replace('r', 'R'));
        // System.out.println(name.replace("sriram", "Sri"));
        // System.out.println(name.startsWith("s"));
        // System.out.println(name.endsWith("m"));
        // System.out.println(name.indexOf("r"));
        // System.out.println(name.lastIndexOf("r"));
        // System.out.println(name.substring(2, 5));
        // System.out.println(name.substring(2));
        // System.out.println(name);
        // name = name.replace("r", "R");
        // System.out.println(name);

        // String text = new String("java");
        // String text1 = new String("java");

        // System.out.println(text == text1);
        // System.out.println(text.equals(text1));

        StringBuilder text = new StringBuilder("hello");

        text.append(" world");
        System.out.println("append "+text);
        text.insert(5, " beautiful");
        System.out.println("insert "+text);
        text.replace(5, 16, "Java");
        System.out.println("replace "+text);
        text.delete(0, 5);
        System.out.println("delete "+text);
        text.reverse();
        System.out.println("reverse "+text);
        

    }
}
