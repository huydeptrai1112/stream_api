import java.util.Arrays;
import java.util.List;

public class SequentialAndParallelStream {

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
//        sequentialStream();
        parallelStream();
        long end = System.currentTimeMillis();
        System.out.println("executed time:" + (end - begin));
    }

    public static void sequentialStream() {
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        listOfNumbers.stream().forEach(number ->
                System.out.println(number + " " + Thread.currentThread().getName())
        );
    }

    public static void parallelStream() {
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        listOfNumbers.parallelStream().forEach(number ->
                System.out.println(number + " " + Thread.currentThread().getName())
        );
    }
}
