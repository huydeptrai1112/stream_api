package uisingstream;

import java.util.*;
import java.util.stream.Collectors;

public class UsingStream {

    public static void main(String[] args) {
//        usingFilter();
//        usingMap();
//        usingFlatMap();
//        usingSorted();
        usingReduce();
    }

    //Returns a stream consisting of
    //the elements of this stream that match the given predicate
    public static void usingFilter() {
        Customer john = new Customer("John P.", 15);
        Customer sarah = new Customer("Sarah M.", 200);
        Customer charles = new Customer("Charles B.", 150);
        Customer mary = new Customer("Mary T.", 1);
        List<Customer> customersWithMoreThan100Points = Arrays.asList(john, sarah, charles, mary);
        System.out.println(customersWithMoreThan100Points
                .stream()
                .filter(c -> c.getPoints() > 100)
                .collect(Collectors.toList()).toString());
    }

    //    Returns a stream consisting of the results of applying
    //    the given function to the elements of this stream
    public static void usingMap() {
        Map<String, String> books = new HashMap<>();
        books.put(
                "978-0201633610", "Design patterns : elements of reusable object-oriented software");
        books.put(
                "978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
        books.put("978-0134685991", "Effective Java");
        books.put("978-1234", "Effective Java");


        List<String> optionalIsbn = books.entrySet().stream()
                .filter(e -> "Effective Java".equals(e.getValue()))
                .map(Map.Entry::getKey).collect(Collectors.toList());
        optionalIsbn.stream().forEach(System.out::println);

        System.out.println();

        List<String> titles = books.entrySet().stream()
                .filter(e -> e.getKey().startsWith("978-0"))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        titles.forEach(System.out::println);
    }

//    flat + map
    public static void usingFlatMap() {
        List<List<String>> list = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"));
        System.out.println("Using flat map: " + list
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
    }

    public static void usingDistinct() {
        Collection<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");
        List<String> distinctChars = list.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public static void usingSorted() {
        List<Integer> list = Arrays.asList(-9, -18, 0, 25, 4);

        System.out.println("The sorted stream is : ");
        list.stream().sorted().forEach(System.out::println);
//        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    public static void usingReduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int result = numbers
                .stream()
                .reduce(0, (subtotal, element) -> subtotal + element);
        System.out.println(result);
    }
}
