package Store41;

import java.util.Comparator;

public class BookNameComparator implements Comparator<BookStore> {
    @Override
    public int compare(BookStore b1, BookStore b2) {
        return b1.getBookName().compareToIgnoreCase(b2.getBookName());
    }
}
