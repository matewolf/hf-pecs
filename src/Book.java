public class Book extends Publication{
    private static int additionalRental = 110;

    private String author;
    private int pageNum;

    public Book(String title, String publisher, String author, int pageNum) {
        super(title, publisher);
        this.author = author;
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "### BOOK ###\n" +
                "Title: " + getTitle() + "\n" +
                "Publisher: " + getPublisher() + "\n" +
                "Author: " + getAuthor() + "\n" +
                "Page number: " + Integer.toString(getPageNum());
    }

    public int getPrice(int i) {
        return super.getPrice(i) + i * additionalRental;
    }

    public static int getAdditionalRental() {
        return additionalRental;
    }

    public static void setAdditionalRental(int additionalRental) {
        Book.additionalRental = additionalRental;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
