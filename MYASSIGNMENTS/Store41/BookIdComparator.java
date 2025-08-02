package Store41;

import java.util.Comparator;

public class BookIdComparator implements Comparator<BookStore> {
    @Override
    public int compare(BookStore b1, BookStore b2) {
        return Integer.compare(b1.getBookId(), b2.getBookId());
    }
}
