package codegenerator;
import java.util.Random;

public class CodeGenerator {

    public static void main(String[] args) {
        // the total number of codes to generate
        final int totalCodes = 100;

        // marks the start time
        long startTime = System.nanoTime();

        // for loop to call generateCode() totalCodes amount of times
        for (int i = 0; i < totalCodes; i++) {
            generateCode();
        }

        // marks the end time
        long endTime = System.nanoTime();
        // duration of single threaded run, converts to milliseconds
        long duration = (endTime - startTime) / 1_000_000;

        System.out.println("Single-threaded duration: " + duration + " ms");

    }

    private static void generateCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder singleCode = new StringBuilder(10);
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            singleCode.append(characters.charAt(random.nextInt(characters.length())));
        }
        System.out.println(singleCode);
    }
}