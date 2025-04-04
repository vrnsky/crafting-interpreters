package dev.vrnsky.lox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Lox {

    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Usage: jlox [script]");
            System.exit(64);
        } else if (args.length == 1) {
            runFile(args[0]);
        } else {
            runPrompt();
        }
    }

    private static void runFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        run(new String(bytes, Charset.defaultCharset()));
    }


    private static void runPrompt() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (;;) {
            System.out.print(">");
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            run(line);
        }
    }

    public static void run(String script) {
        Scanner scanner = new Scanner(script);
        List<Token> tokens = new ArrayList<>();

        for (Token token : tokens) {
            System.out.println(token);
        }
    }

}
