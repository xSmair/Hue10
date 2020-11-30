package net.htlgrieskirchen.pos3.java8.concurrency.bruteforce;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSerial {

    static long t0 = System.currentTimeMillis();

    public static void main(String[] args) {
        String hashedPassword ="";
        try {
            hashedPassword = Files.readAllLines(new File("passwords/password0").toPath()).get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Auf wieviele Stellen sollen gecheckt werden?");
        int k = new Scanner(System.in).nextInt();
        List<Character> characterList = new ArrayList<>();
        char x = '0';
        for (int i = 0; i < 75; i++) {
            characterList.add(x);
            x++;
        }
        Object[] set1 = characterList.toArray();

        checkAllKLength(set1, k, hashedPassword);
    }


    static void checkAllKLength(Object[] set, int k, String hashedPassword) {
        int n = set.length;
        checkAllKLengthRec(set, "", n, k, hashedPassword);
    }


    static void checkAllKLengthRec(Object[] set, String prefix, int n, int k, String hashedPassword) {
        if (k == 0) {
            System.out.println(prefix);
            if(StringUtil.applySha256(prefix).equals(hashedPassword)){
                System.out.println("Password: " + prefix + "(" + hashedPassword + ")");
                System.out.println("Benchmark: " + (System.currentTimeMillis() - t0) + "ms = " + (System.currentTimeMillis() - t0)/1000 + "s");
                System.exit(1);
            }
            return;
        }

        for (int i = 0; i < n; ++i) {
            String newPrefix = prefix + set[i];
            checkAllKLengthRec(set, newPrefix, n, k - 1, hashedPassword);
        }
    }
}