package ru.mai.sortworslist.sort;

import ru.mai.sortworslist.data.Word;

import java.util.Comparator;

/**
 * @author Beaver
 */
public class WordDateComparator
        implements Comparator<Word> {

    @Override
    public int compare(Word w1, Word w2) {
        return w1.getDate().compareTo(w2.getDate());
    }
}
