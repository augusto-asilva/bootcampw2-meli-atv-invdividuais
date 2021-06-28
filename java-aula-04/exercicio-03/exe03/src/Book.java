public class Book {
    private String title;
    private int isbn;
    private String author;
    private static int availableToBorrow = 10;

    public Book() {
    }

    public Book(String title, int isbn, String author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return title + ',' + isbn + "," + author + ", availables: " + availableToBorrow;
    }

    public void toBorrow() {
        if (this.availableToBorrow > 0) {
            availableToBorrow--;
            System.out.println("Book borrowed!");
        }
    }

    public void toReturn() {
        if (this.availableToBorrow > 0) {
            availableToBorrow++;
            System.out.println("Book returned!");
        }
    }
}
