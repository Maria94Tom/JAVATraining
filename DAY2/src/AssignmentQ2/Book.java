package AssignmentQ2;

public class Book {
    private String bookTitle;
    private String Author;
    private String ISBN;
    private int numOfCopies;

    public  Book(String bookTitle, String Author, String ISBN, int numOfCopies){
        this.bookTitle=bookTitle;
        this.Author=Author;
        this.ISBN=ISBN;
        this.numOfCopies=numOfCopies;

    }
    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return Author;
    }

    public String getIsbn() {
        return ISBN;
    }

    public int getNumOfCopies() {
        return numOfCopies;
    }

    public void setNumOfCopies(int numOfCopies) {
        this.numOfCopies = numOfCopies;
    }

    public String displayBookTitle(){
        String bookInfo = bookTitle+"-"+Author+"-"+ISBN+"-"+numOfCopies;

        return bookInfo;
    }

}
