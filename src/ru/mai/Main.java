package ru.mai;

import ru.mai.filecollectiontest.CustomEnumeration;
import ru.mai.filecollectiontest.MapExample;
import ru.mai.sortworslist.data.Word;
import ru.mai.sortworslist.sort.WordComparator;
import ru.mai.sortworslist.sort.WordDateComparator;
import ru.mai.sortworslist.sort.WordDictionaryComparator;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        listExample();
//        customEnumerationExample();
//        sortNumberString();
//        sortWordsList();
//        mapExample();
    }

    private static void listExample() {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i * i));
        }

        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.remove("49");
        System.out.println(list);
    }

    private static void customEnumerationExample() {

        int[] values = new int[5];
        for (int i = 0; i < 5; i++) {
            values[i] = 10 + i;
            System.out.println(values[i]);
        }

        System.out.println("Enumerator: ");

        CustomEnumeration enumeration = new CustomEnumeration(values);

        if (enumeration.hasNext()) {
            enumeration.remove();
        }

        while (enumeration.hasNext()) {
            System.out.println(enumeration.next());
        }
    }

    private static void sortNumberString() {
        //ArrayList<int> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 22, -3, 40, 5));

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("111");
        list2.add("222");
        list2.add("333");

        // Java 9 and newer
        List<String> strings = new ArrayList<>(List.of("Hello", "world"));

        Collections.binarySearch(list1, 2);

        List<Integer> emptyList = Collections.emptyList();
        //emptyList.add(1);

        List<Integer> sortedList = list1.stream()
                .sorted()
//                .sorted(Comparator.naturalOrder())
//                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        sortedList.forEach(System.out::println);
    }

    private static void sortWordsList() {

        ArrayList<Word> list = new ArrayList<>();

        list.add(new Word("слово1", 1));
        list.add(new Word("слово2", 2));
        list.add(new Word("слово3", 3));
        list.add(new Word("слово4", 2));

        String test = "слово2 ";
        //String test = "слово2 ".trim();
        Word testWord = new Word(test, 1);

        if (list.contains(testWord)) {
            int index = list.indexOf(testWord);
            System.out.println("слово существует, id = " + index);
            long count = list.get(index).getCount();
            list.get(index).setCount(count + 1);
        } else {
            System.out.println("слово не существует");
            list.add(testWord);
        }

        System.out.println("1 sort: ");
        Collections.sort(list);
        //list.sort();

        for (Word list1 : list) {
            System.out.println(list1);
        }

        System.out.println();
        System.out.println("2 sort: ");
        Collections.sort(list, new WordComparator());

        for (Word list1 : list) {
            System.out.println(list1);
        }

        System.out.println();
        System.out.println("3 sort: ");
        Collections.sort(list, new WordDateComparator());

        for (Word list1 : list) {
            System.out.println(list1);
        }

        System.out.println();
        System.out.println("4 sort: ");
        Collections.sort(list, new WordDictionaryComparator());

        for (Word list1 : list) {
            System.out.println(list1);
        }

        List<Word> sortedList = list.stream()
                .sorted(Comparator.comparing(Word::getWord))
                .collect(Collectors.toList());

        sortedList.forEach(System.out::println);
    }

    private static void mapExample() {
        MapExample mapTest = new MapExample();
        mapTest.fillBooksList();
        mapTest.mapAuthors();
        mapTest.getBooksList();
    }
}
