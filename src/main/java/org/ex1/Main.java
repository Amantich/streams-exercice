package org.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> noms=new ArrayList<>();

        noms.add("enset");
        noms.add("javascript");
        noms.add("java");
        noms.add("php");

        noms.stream().filter(elem->elem.contains("a"))
                .forEach(elem->System.out.println(elem));

        noms.stream().filter(elem->elem.length()>3)
                .map(elem->new StringBuilder(elem).reverse().toString())
                .forEach(elem->System.out.println(elem));

        noms.stream().filter(elem->elem.contains("e"))
                .flatMap(elem-> Stream.of(elem.toCharArray()))
                .forEach(elem->System.out.println(elem));

        noms.stream().map(elem->elem.toUpperCase())
                .forEach(elem->System.out.println(elem));

        noms.stream().map(elem->elem.length())
                 .forEach(elem->System.out.println(elem));

        noms.stream().flatMap(elem->elem.chars().mapToObj(c->(char) c));


    }
}