package ru.mai.sortworslist.data;

import java.util.Date;
import java.util.Objects;

// стол стул стена слово стул и еще один стол
/*
 стол 2
 стул 2
 стена 1
 слово 1
 и 1
 еще 1
 один 1

 */

/**
 * @author Beaver
 */
public class Word implements Comparable<Word> {

    private String word = "";
    private long count = 0;
    private Date date;

    public Word(String word, long count) {
        this.word = word;
        this.count = count;
        date = new Date();
    }

    public Word(String word) {
        this.word = word;
        this.count = 1;
        date = new Date();
    }

    public Date getDate() {
        return this.date;
    }

    public String getWord() {
        return this.word;
    }

    public long getCount() {
        return this.count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        return ((Word) o).getWord().equals(this.word);
    }

    @Override
    public int hashCode() {
//        return this.word.hashCode();
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.word);
        return hash;
    }

    @Override
    public String toString() {
        return this.word + "\t" + this.count + "\t" + this.date;
    }

    @Override
    public int compareTo(Word w2) {
        int res = 0;

        if (this.count < w2.getCount()) {
            res = 1;
        } else if (this.count == w2.getCount()) {
            res = 0;
        } else {
            res = -1;
        }

        return res;
    }
}
