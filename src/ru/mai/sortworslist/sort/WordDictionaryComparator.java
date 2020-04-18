package ru.mai.sortworslist.sort;

import ru.mai.sortworslist.data.Word;

import java.util.Comparator;

/**
 * @author Beaver
 */
public class WordDictionaryComparator implements Comparator<Word> {

    @Override
    public int compare(Word o1, Word o2) {
        return o1.getWord().compareTo(o2.getWord());
    }
}
