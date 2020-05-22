package practice;

import practice.lib.Injector;
import practice.model.Author;
import practice.model.Book;
import practice.model.Genre;
import practice.service.AuthorService;
import practice.service.BookService;
import practice.service.GenreService;

public class Main {
    private static Injector injector = Injector.getInstance("practice");

    public static void main(String[] args) {
        Author author = new Author();
        author.setName("John Ronald Reuel Tolkien");
        AuthorService authorService = (AuthorService) injector.getInstance(AuthorService.class);
        authorService.add(author);

        Genre genre = new Genre();
        genre.setName("Fantasy");
        GenreService genreService = (GenreService) injector.getInstance(GenreService.class);
        genreService.add(genre);

        Book book = new Book();
        book.setTitle("The Lord of the Rings");
        book.setAuthor(author);
        book.setGenre(genre);
        BookService bookService = (BookService) injector.getInstance(BookService.class);
        bookService.add(book);

        System.out.println(bookService.getBookByTitle("The Lord of the Rings"));
        bookService.getBooksByAuthor(author).forEach(System.out::println);
        bookService.getBooksByGenre(genre).forEach(System.out::println);
    }
}
