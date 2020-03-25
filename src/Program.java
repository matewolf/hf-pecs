import java.util.Scanner;

public class Program {
    private Library lib;
    private Scanner scanner;

    public Program() {
        lib = new Library();
        scanner = new Scanner(System.in);
    }

    public void run() {
        String command;
        do {
            System.out.println("(1) List publications");
            System.out.println("(2) Add book");
            System.out.println("(3) Add journal");
            System.out.println("(4) Search in catalog");
            System.out.println("(q) - Quit");

            command = scanner.nextLine();
            switch (command) {
                case "1":
                    listPublications();
                    break;

                case "2":
                    addBook();
                    break;

                case "3":
                    addJournal();
                    break;

                case "4":
                    search();
                    break;

                case "q":
                    break;

                default:
                    System.out.println("Unknown command!");
            }

            if (command.compareTo("q") != 0) {
                System.out.println("Press ENTER to continue...");
                scanner.nextLine();
            }
        }
        while (command.compareTo("q") != 0);
    }

    private void addBook() {
        System.out.println("Add book");
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter page number: ");
        int pageNum = Integer.parseInt(scanner.nextLine());
        lib.addPublication(new Book(title, publisher, author, pageNum));
    }

    private void addJournal() {
        System.out.println("Add journal");
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter number: ");
        int number = Integer.parseInt(scanner.nextLine());
        lib.addPublication(new Journal(title, publisher, year, number));
    }

    private void listPublications() {
        for (Publication pub : lib.getPublications()) {
            System.out.println(pub.toString());
            System.out.println();
        }
    }

    private void search() {
        System.out.println("Search");
        System.out.print("Enter title-part: ");
        String titlePart = scanner.nextLine();
        System.out.print("Enter document-type (Book/Journal/All): ");
        String docType = scanner.nextLine();
        System.out.print("Enter days: ");
        int days = Integer.parseInt(scanner.nextLine());


        Class c;
        switch (docType) {
            case "Book":
                c = Book.class;
                break;

            case "Journal":
                c = Journal.class;
                break;

            case "All":
                c = Publication.class;
                break;

            default:
                System.out.println("Unknown type!");
                return;
        }

        for (Publication pub : lib.getPublications()) {
            if (c.isInstance(pub) && pub.getTitle().contains(titlePart)) {
                System.out.println(pub.getTitle() + "\t" + Integer.toString(pub.getPrice(days)));
            }
        }
    }
}
