package ru.netology;

public class MoviesManager {
    int numberFilms;
    private PosterItem[] items = new PosterItem[0];

    public MoviesManager(int numberFilms) {
        if (numberFilms != 0) {
            this.numberFilms = numberFilms;
        } else {
            this.numberFilms = 5;
        }
    }

    public MoviesManager() {
        this.numberFilms = 5;
    }


    public void save(PosterItem item) {
        PosterItem[] tmp = new PosterItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public PosterItem[] findAll() {

        return items;
    }

    public PosterItem[] findLast() {
        PosterItem[] result = new PosterItem[numberFilms];
        int resultlenght;
        if (items.length < numberFilms) {
            resultlenght = items.length;
        } else {
            resultlenght = numberFilms;
        }
        for (int i = 0; i < resultlenght; i++) {
            result[i] = items[items.length - 1 - i];
        }
        return result;
    }
}
