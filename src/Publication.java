abstract public class Publication {
    public static int additionalRental = 23;

    private String title;
    private String publisher;

    public Publication(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }

    public abstract String toString();
    public int getPrice(int i) {
        return i * additionalRental;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public static int getAdditionalRental() {
        return additionalRental;
    }

    public static void setAdditionalRental(int additionalRental) {
        Publication.additionalRental = additionalRental;
    }
}
