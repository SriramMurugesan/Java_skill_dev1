import java.util.*;
public class CollectionsDemo {
    //ArrayList
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("java");
        list.add("python");
        list.add("c++");
        list.add("java");
        System.out.println(list);
        list.remove("java");
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.add("C");
        System.out.println(list);
        System.out.println("get(0)"+list.get(0));
        System.out.println("size()"+list.size());
        System.out.println("contains(\"java\")"+list.contains("java"));
        System.out.println("indexOf(\"java\")"+list.indexOf("java"));
        System.out.println("lastIndexOf(\"java\")"+list.lastIndexOf("java"));
        System.out.println("isEmpty()"+list.isEmpty());
        System.out.println("toArray()"+list.toArray());
        //toArray(new String[0]) creates a new array of size 0 and returns it to the toArray method.
        //toArray(new String[0]) is used to convert the list to an array of strings.
        System.out.println("toArray(new String[0])"+Arrays.toString(list.toArray(new String[0])));
        System.out.println("subList(0, 2)"+list.subList(0, 2));
        


        //HashSet
        HashSet<String> set = new HashSet<>();
        set.add("java");
        set.add("python");
        set.add("c++");
        set.add("java");
        System.out.println(set);
        set.remove("java");
        System.out.println(set);
        set.add("C");
        System.out.println(set);

        //HashMap
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "sriram");
        map.put("age", "20");
        map.put("city", "delhi");
        System.out.println(map);
        map.remove("name");
        System.out.println(map);
        map.put("country", "india");
        System.out.println(map);
        System.out.println(map.get("name"));
        System.out.println(map.size());
        System.out.println(map.containsKey("name"));
        System.out.println(map.containsValue("sriram"));
        System.out.println(map.isEmpty());
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.entrySet());
        

        


        
    }
    
}
