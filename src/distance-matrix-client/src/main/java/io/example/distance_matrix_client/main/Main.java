package io.example.distance_matrix_client.main;

import io.example.distance_matrix_client.commons.Commons;
import io.example.distance_matrix_library.Client;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String apiKey = args.length < 1 ? "" : args[0];

        if (apiKey.length() == 0) {
            System.out.println("To use this example you must provide valid API key.");
            System.out.println("Obtain free trail at https://distancematrix.ai/.");
            System.out.println();
            System.out.print("Enter your API key: ");
            String line = null;
            try (Scanner scanner = new Scanner(System.in)) {
                line = scanner.nextLine();
            }
            if (line == null || line.trim().length() == 0) {
                return;
            }
            apiKey = line;
        }

        new Client()
                .withApiKey(apiKey)
                .makeExampleRequest()
        ;

        System.out.println("End");
    }

}
