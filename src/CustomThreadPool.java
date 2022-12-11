import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadFactory;
import java.util.stream.IntStream;

public class CustomThreadPool {

    private static Random random = new Random();

    private static void processLargeDataSet() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<String> largeDataset = getLargeDataset();
        executorService.submit(() -> largeDataset.parallelStream().
                forEach(number -> {
                    int rd = random.nextInt(5000);
                    System.out.println(number + " " + Thread.currentThread().getName() + " " + "Id:" +Thread.currentThread().getId());
                }));


        executorService.shutdown();
    }

    private static void cachingThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<String> largeDataset = getLargeDataset();
        executorService.submit(() -> largeDataset.parallelStream().
                forEach(number -> {
                    int rd = random.nextInt(5000);
                    System.out.println("Cache ---> " + number + " " + Thread.currentThread().getName() + " " + "Id:" +Thread.currentThread().getId());
                }));

        executorService.shutdown();
    }

    private static void usingForkJoin() {
        List<String> largeDataset = getLargeDataset();
        ForkJoinPool customThreadPool = new ForkJoinPool(5);
        customThreadPool.submit(() -> largeDataset.parallelStream().
                forEach(number -> {
                    int rd = random.nextInt(5000);
                    System.out.println("forkJoin  --> " + number + " " + Thread.currentThread().getName() + " " + "Id:" + Thread.currentThread().getId());
//                    try {
//                        Thread.sleep(rd);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }));


        customThreadPool.shutdown();
    }

    private static void usingForkJoin2() {
        List<String> largeDataset = getLargeDataset();
        ForkJoinPool customThreadPool = new ForkJoinPool(5);
        customThreadPool.submit(() -> largeDataset.parallelStream().
                forEach(number -> {
                    int rd = random.nextInt(5000);
                    System.out.println("forkJoin2  ----------------> " + number + " " + Thread.currentThread().getName() + " " + "Id:" + Thread.currentThread().getId());
//                    try {
//                        Thread.sleep(rd);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }));
        customThreadPool.shutdown();
    }

    private static void usingForkJoin3() {
        List<String> largeDataset = getLargeDataset();
        ForkJoinPool customThreadPool = new ForkJoinPool(5);
        customThreadPool.submit(() -> largeDataset.parallelStream().
                forEach(number -> {
                    int rd = random.nextInt(5000);
                    System.out.println("forkJoin3  ----------> " + number + " " + Thread.currentThread().getName() + " " + "Id:" + Thread.currentThread().getId());
//                    try {
//                        Thread.sleep(rd);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }));
        customThreadPool.shutdown();
    }


    private static void processLargeDataSequential() {
        List<String> largeDataset = getLargeDataset();
        largeDataset.stream().forEach(System.out::println);
    }

    private static List<String> getLargeDataset() {
        List<String> largeDataset = new ArrayList<>();
        IntStream.range(0, 1000).forEach(i -> {
            largeDataset.add(UUID.randomUUID().toString());
        });
        return largeDataset;
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        processLargeDataSet();
        System.out.println("--------------------------------------------");
        usingForkJoin();
        cachingThreadPool();
        usingForkJoin2();
        usingForkJoin3();
        long end = System.currentTimeMillis();
        System.out.println((end - begin));

    }
}
