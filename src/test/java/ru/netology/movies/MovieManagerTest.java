package ru.netology.movies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    public void addMovie() {
        MovieManager manager = new MovieManager();
        Movie movie = new Movie("Бладшот");
        manager.addMovie(movie);
        int expected = 1;
        int actual = manager.findAll().length;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findAll() {
        MovieManager manager = new MovieManager();
        Movie movie1 = new Movie("Бладшот");
        Movie movie2 = new Movie("Вперед");
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        Movie[] movies = manager.findAll();
        int expected = 2;
        int actual = movies.length;
        Assertions.assertEquals(expected, actual);
        Assertions.assertArrayEquals(new Movie[]{movie1, movie2}, movies);
    }

    @Test
    public void findLast_OutLimit() {
        MovieManager manager = new MovieManager(3);
        Movie movie1 = new Movie("Бладшот");
        Movie movie2 = new Movie("Вперед");
        Movie movie3 = new Movie("Отель Белград");
        Movie movie4 = new Movie("Джентльмены");
        Movie movie5 = new Movie("Человек-невидимка");
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);
        Movie[] lastMovies = manager.findLast();
        int expected = 3;
        int actual = lastMovies.length;
        Assertions.assertEquals(expected, actual);
        Assertions.assertArrayEquals(new Movie[]{movie5, movie4, movie3}, lastMovies);
    }

    @Test
    public void findLast_InLimit() {
        MovieManager manager = new MovieManager(5);
        Movie movie1 = new Movie("Бладшот");
        Movie movie2 = new Movie("Вперед");
        Movie movie3 = new Movie("Отель Белград");
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        Movie[] lastMovies = manager.findLast();
        int expected = 3;
        int actual = lastMovies.length;
        Assertions.assertEquals(expected, actual);
        Assertions.assertArrayEquals(new Movie[]{movie3, movie2, movie1}, lastMovies);
    }

    @Test
    public void findLast_DefaultLimit() {
        MovieManager manager = new MovieManager();
        Movie movie1 = new Movie("Бладшот");
        Movie movie2 = new Movie("Вперед");
        Movie movie3 = new Movie("Отель Белград");
        Movie movie4 = new Movie("Джентльмены");
        Movie movie5 = new Movie("Человек-невидимка");
        Movie movie6 = new Movie("Тролли. Мировой тур");
        Movie movie7 = new Movie("Номер один");
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);
        manager.addMovie(movie6);
        manager.addMovie(movie7);
        Movie[] lastMovies = manager.findLast();
        int expected = 5;
        int actual = lastMovies.length;
        Assertions.assertEquals(expected, actual);
        Assertions.assertArrayEquals(new Movie[]{movie7, movie6, movie5, movie4, movie3}, lastMovies);
    }
}
