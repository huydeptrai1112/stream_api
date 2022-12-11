import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamInitialization {

    public static void main(String[] args) {
        streamUsingIterate();
    }

    public static void objectStream() {
        IntStream.range(1, 4).forEach(System.out::println); // 1 2 3

        IntStream.of(1, 2, 3).forEach(System.out::println); // 1 2 3

        DoubleStream.of(1, 2, 3).forEach(System.out::println); // 1.0 2.0 3.0

        LongStream.range(1, 4).forEach(System.out::println); // 1 2 3

        LongStream.of(1, 2, 3).forEach(System.out::println); // 1 2 3
    }

    // Generate Streams from Arrays using .stream or Stream.of
    public static void streamFromArray() {
        String[] languages = {"Java", "C#", "C++", "PHP", "Javascript"};

        Stream<String> testStream1 = Arrays.stream(languages);
        testStream1.forEach(x -> System.out.println(x));

        Stream<String> testStream2 = Stream.of(languages);
        testStream2.forEach(x -> System.out.println(x));
    }

    // Generate Streams from Collections
    public static void streamFromCollection() {
        List<String> items = new ArrayList<>();
        items.add("Java");
        items.add("C#");
        items.add("C++");
        items.add("PHP");
        items.add("Javascript");

        items.stream().forEach(item -> System.out.println(item));
    }

    // Generate Streams using Stream.generate()
    public static void streamUsingGenerate() {
        Stream<String> stream = Stream.generate(() -> "gpcoder").limit(3);
        String[] testStrArr = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(testStrArr)); // [gpcoder, gpcoder, gpcoder]
    }

    // Generate Streams using Stream.iterate()
    public static void streamUsingIterate() {
        Stream<Integer> iterateNumbers = Stream.iterate(1, n -> n + 1).limit(5);
        iterateNumbers.forEach(System.out::print); // 12345
    }

    // Generate Streams from APIs like Regex
    public static void streamUsingRegex() {
        String str = "Welcome,to,gpcoder";
        Pattern.compile(",").splitAsStream(str).forEach(System.out::print);// Welcometogpcoder
    }
}
