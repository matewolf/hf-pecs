public class Journal extends Publication{
    private static int rental = 100;

    private int year;
    private int number;

    public Journal(String title, String publisher, int year, int number) {
        super(title, publisher);
        this.year = year;
        this.number = number;
    }

    @Override
    public String toString() {
        return "### JOURNAL ###\n" +
                "Title: " + getTitle() + "\n" +
                "Publisher: " + getPublisher() + "\n" +
                "Year: " + Integer.toString(getYear()) + "\n" +
                "Number: " + Integer.toString(getNumber());
    }

    @Override
    public int getPrice(int i) {
        return super.getPrice(i) + i * additionalRental;
    }

    public static int getRental() {
        return rental;
    }

    public static void setRental(int rental) {
        Journal.rental = rental;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
