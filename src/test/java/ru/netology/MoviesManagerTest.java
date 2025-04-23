package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoviesManagerTest {
    PosterItem item1 = new PosterItem(1, "Бладшоп", "Боевик");
    PosterItem item2 = new PosterItem(2, "Вперёд", "Мультфильм");
    PosterItem item3 = new PosterItem(3, "Отель Белград", "Комедия");
    PosterItem item4 = new PosterItem(4, "Джентльмены", "Боевик");
    PosterItem item5 = new PosterItem(5, "Человек-невидимка", "Ужасы");
    PosterItem item6 = new PosterItem(6, "Тролли.Мировой тур", "Мультфильм");
    PosterItem item7 = new PosterItem(7, "Номер один", "Комедия");

    @Test
    void addingNewMovieAll() {

        MoviesManager poster = new MoviesManager();
        poster.save(item1);
        poster.save(item2);
        poster.save(item3);
        poster.save(item4);
        poster.save(item5);
        poster.save(item6);
        poster.save(item7);


        PosterItem[] expected = {item1, item2, item3, item4, item5, item6, item7};
        PosterItem[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void addingNewMovieEmpty() {

        MoviesManager poster = new MoviesManager();

        PosterItem[] expected = {};
        PosterItem[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void findLastMovieWithNumberFilms() {

        MoviesManager poster = new MoviesManager(5);
        poster.save(item1);
        poster.save(item2);
        poster.save(item3);
        poster.save(item4);
        poster.save(item5);
        poster.save(item6);
        poster.save(item7);

        PosterItem[] expected = {item7, item6, item5, item4, item3};
        PosterItem[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void findLastMovieNoNumberFilms() {

        MoviesManager poster = new MoviesManager();

        poster.save(item1);
        poster.save(item2);
        poster.save(item3);
        poster.save(item4);
        poster.save(item5);

        PosterItem[] expected = {item5, item4, item3, item2, item1};
        PosterItem[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void findLastMovieLessNumberFilms() {

        MoviesManager poster = new MoviesManager(3);

        poster.save(item1);
        poster.save(item2);
        poster.save(item3);


        PosterItem[] expected = {item3, item2, item1};
        PosterItem[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void findLastMovieEmpty() {

        MoviesManager poster = new MoviesManager(0);

        poster.save(item1);
        poster.save(item2);
        poster.save(item3);
        poster.save(item4);
        poster.save(item5);

        PosterItem[] expected = {item5, item4, item3, item2, item1};

        PosterItem[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }
}
