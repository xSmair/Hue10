package net.htlgrieskirchen.pos3.java8.concurrency.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Stream;

public class Main {

    boolean lowerChars;
    boolean higherChars;
    boolean numberChars;

    ArrayList<String> charList = new ArrayList<>();

    public static void main(String[] args) {


    }

    public Main(boolean lowerChars, boolean higherChars, boolean numberChars) {
        this.lowerChars = lowerChars;
        this.higherChars = higherChars;
        this.numberChars = numberChars;

        String charCharListString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbersCharListString = "1234567890";

        if (lowerChars) {
            charList.addAll(Arrays.asList(charCharListString.split("")));
        }
        if (higherChars) {
            charList.addAll(Arrays.asList(charCharListString.toLowerCase().split("")));
        }
        if (numberChars) {
            charList.addAll(Arrays.asList(numbersCharListString.split("")));
        }
    }
}

class BruteForceWorker implements Runnable{

    ArrayList<String> charList;

    public BruteForceWorker(ArrayList<String> charList) {
        this.charList = charList;
    }

    @Override
    public void run() {
        ThreadPoolExecutor threadPoolExecutor
    }
}
