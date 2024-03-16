package codegenerator;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentCodeGenerator {

    public static void main(String[] args) {
        // the total number of codes to generate
        final int totalCodes = 100;

        ExecutorService executor = Executors.newFixedThreadPool(5);

        // marks the start time
        long startTime = System.nanoTime();

        // for loop to call generateCode() totalCodes amount of times
        for (int i = 0; i < totalCodes; i++) {
            executor.submit(ConcurrentCodeGenerator::generateRandomCode);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {}

        // marks the end time
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;
        System.out.println("Multi-threaded duration: " + duration + " ms");
    }

    private static void generateRandomCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder singleCode = new StringBuilder(8);
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            singleCode.append(characters.charAt(random.nextInt(characters.length())));
        }
        System.out.println(singleCode);
    }
}
