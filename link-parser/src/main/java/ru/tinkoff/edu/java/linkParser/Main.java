package ru.tinkoff.edu.java.linkParser;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MalformedURLException {


        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String url = in.nextLine();

        LinkParser githubParser = new GithubParser();
        LinkParser stackOverflowParser = new StackOverflowParser();
        githubParser.setNextParser(stackOverflowParser);

        String[] result = githubParser.parse(url);
        System.out.println(Arrays.toString(result));
    }
}