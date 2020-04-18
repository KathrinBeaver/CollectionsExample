package ru.mai.filecollectiontest;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Beaver
 */
public class MapExample {

    private HashMap<String, String> hashMap = new HashMap();
    private ArrayList<String> books = new ArrayList<>();

    public void fillBooksList() {
        books.add("Война и мир");
        books.add("Отцы и дети");
        books.add("Обломов");
        books.add("Мы");
        books.add("Книга 1");
    }

    public void mapAuthors() {
        hashMap.put("Война и мир", "Толстой");
        hashMap.put("Отцы и дети", "Тургенев");
        hashMap.put("Обломов", "Гончаров");
        hashMap.put("Мы", null);
        hashMap.put("Мы", "Замятин");
    }

    public void getBooksList() {
        for (int i = 0; i < books.size(); i++) {

            if (hashMap.containsKey(books.get(i))) {
                System.out.println("Автор" + (i + 1) + ":\t"
                        + hashMap.get(books.get(i)) +
                        "\t" + books.get(i));
            } else {
                System.out.println("\nThe Imformation about the"
                        + " author of the book\t"
                        + books.get(i) + "\tis not available\n");
            }
        }
    }
}


