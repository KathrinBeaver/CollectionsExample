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
//        listExample();
//        customEnumerationExample();
//        sortNumberString();
//        sortWordsList();

//        List<String> words = calculateWordsCount("стол стул стена слово стул и еще один стол");
//        words.stream()
//                .forEach(System.out::println);
//
//        System.out.println("\n\n");
//
//        Set<String> wordsSet = calculateWordsCountSet("стол стул стена слово стул и еще один стол");
//        wordsSet.stream()
//                .forEach(System.out::println);

        List<Word> words = calculateWordsCountWordsList("стол стул стена слово стул и еще один стол");
        words.stream()
                .forEach(System.out::println);

        System.out.println("\n\n");

        Set<Word> wordsSet = calculateWordsCountWordsSet("стол стул стена слово стул и еще один стол");
        wordsSet.stream()
                .forEach(System.out::println);

//        for(String word : words) {
//             System.out.println(word);
//        }

//        for(int i = 0; i < words.size(); i++) {
//            System.out.println(words.get(i));
//        }

         mapExample();
    }

    private static void listExample() {
        List<Integer> list1 = new ArrayList<>();
        ArrayList list2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list1.add(i * i);
            list2.add(String.valueOf(i * i));
        }

        System.out.println(list1);
        System.out.println(list2);

        list1.remove(2);

        System.out.println(list1);
        list1.remove(Integer.valueOf(49));

        for (int i = 0; i < list1.size(); i++) {
//        for(Integer num : list1) {
//            list1.remove(num);
            list1.remove(list1.get(i));
        }

        System.out.println(list1);

        ArrayList<ArrayList<Integer>> matrix =
                new ArrayList<ArrayList<Integer>>();
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

        enumeration.remove();

        while (enumeration.hasNext()) {
            System.out.println(enumeration.next());
        }
    }

    private static void sortNumberString() {
//        ArrayList<char> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 22, -3, 40, 5));

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("111");
        list2.add("222");
        list2.add("333");

        // 1 2 4 5 6 10 11 20 30 50

        // Java 9 and newer
        List<String> strings = new ArrayList<>(List.of("Hello", "world"));

        Collections.binarySearch(list1, 2);

        List<Integer> emptyList = Collections.emptyList();
//        emptyList.add(1);

        Collections.sort(list1);

        List<Integer> sortedList = list1.stream()
                .sorted()
//                .sorted(Comparator.naturalOrder())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        sortedList.forEach(System.out::println);
    }

    private static void sortWordsList() {

        ArrayList<Word> list = new ArrayList<>();

        list.add(new Word("слово1", 1));
        list.add(new Word("слово2", 2));
        list.add(new Word("слово3", 3));
        list.add(new Word("слово4", 2));

        String test = "слово2      ";
//        String test = "слово2 ".trim();
        Word testWord = new Word(test, 1);

        if (list.contains(testWord)) {
            int index = list.indexOf(testWord);
            System.out.println("Слово существует, id = " + index);
            long count = list.get(index).getCount();
            list.get(index).setCount(count + 1);
        } else {
            System.out.println("Слово не существует");
            list.add(testWord);
        }

        System.out.println("1 sort: ");
        Collections.sort(list);
        list.sort(new WordDateComparator());

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

        Collections.sort(list, new Comparator<Word>() {

            @Override
            public int compare(Word o1, Word o2) {
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });

        for (Word list1 : list) {
            System.out.println(list1);
        }

        list.add(new Word("ааааааа", 1));

        System.out.println();
        System.out.println("4 sort: ");
        Collections.sort(list, new WordDictionaryComparator());

        for (Word list1 : list) {
            System.out.println(list1);
        }

        System.out.println();
        System.out.println("5 sort: ");
        List<Word> sortedList = list.stream()
                .sorted(Comparator.comparing(Word::getWord))
                .collect(Collectors.toList());

        sortedList.forEach(System.out::println);
    }

    // стол стул стена слово стул и еще один стол
    /*
     стол 2
     стул 2
     стена 1
     слово 1
     и 1
     еще 1
     один 1

     стол
     стул
     стена
     слово
     и
     еще
     один

     */

    private static List<String> calculateWordsCount(String text) {
        String[] allWords = text.split("\\s");
        List<String> words = new ArrayList();
        for (String word: allWords) {
            if (!words.contains(word)) {
                words.add(word);
            }
        }
        return words;
    }

    private static List<Word> calculateWordsCountWordsList(String text) {
        String[] allWords = text.split("\\s");
        List<Word> words = new ArrayList<Word>();
        for (String word: allWords) {
            Word wrd = new Word(word);
            if (!words.contains(wrd)) {
                words.add(wrd);
            } else {
                words.get(words.indexOf(wrd))
                        .setCount(words.get(words.indexOf(wrd)).getCount() + 1);
            }
        }
        return words;
    }

    private static Set<Word> calculateWordsCountWordsSet(String text) {
        String[] allWords = text.split("\\s");
        Set<Word> words = new HashSet<Word>();
        for (String word: allWords) {
            words.add(new Word(word));
        }
        return words;
    }

    private static Set<String> calculateWordsCountSet(String text) {
        String[] allWords = text.split("\\s");
        Set<String> words = new HashSet<>();
        for (String word: allWords) {
            words.add(word);
        }
        return words;
    }

    private static void mapExample() {
        MapExample mapTest = new MapExample();
        mapTest.fillBooksList();
        mapTest.mapAuthors();
        mapTest.getBooksList();
    }

    /**
     * Арбуз - это .... знач. 1
     *       - это ... знач. 1
     * Абажур - .....
     *
     *
     *
     */
}
