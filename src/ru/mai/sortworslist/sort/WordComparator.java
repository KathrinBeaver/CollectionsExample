package ru.mai.sortworslist.sort;

import ru.mai.sortworslist.data.Word;

import java.util.Comparator;

/**
 * @author Beaver
 */
public class WordComparator implements Comparator<Word> {

    @Override
    public int compare(Word w1, Word w2) {

        int res = 0;

        if (w1.getCount() < w2.getCount()) {
            res = -1;
        } else if (w1.getCount() == w2.getCount()) {
            res = 0;
        } else {
            res = 1;
        }

        return res;
    }
}
