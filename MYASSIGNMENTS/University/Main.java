package University;
public class Main {
    public static void main(String[] args) {
        Library<Book> bookLibrary = new Library<>();
        bookLibrary.addItem(new Book("The Great Gatsby"));

        Library<Video> videoLibrary = new Library<>();
        videoLibrary.addItem(new Video("Interstellar"));

        Library<Newspaper> newspaperLibrary = new Library<>();
        newspaperLibrary.addItem(new Newspaper("The Times"));

        System.out.println(bookLibrary.getItem(0));
        System.out.println(videoLibrary.getItem(0));
        System.out.println(newspaperLibrary.getItem(0));
    }
}
