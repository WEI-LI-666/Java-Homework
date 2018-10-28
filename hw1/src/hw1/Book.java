/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1;

/**
 *
 * @author B10409009
 */
public class Book {

    /**
     * @param bookName name of the book
     * @param bookCode Serial number of the book
     * @param bookPrice book price
     */
    private String bookName;
    private String bookCode;
    private double bookPrice;

    public Book(String bookName, String bookCode, double bookPrice) {
        setBookName(bookName);
        setBookCode(bookCode);
        setBookPrice(bookPrice);
    }

    // show the book information
    public void getBookInfo() {
        System.out.printf("Book{bookPrice=%.1f, bookName=%s, bookCode=%s}\n", bookPrice, bookName, bookCode);
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    // check the value to make sure input correctly
    public void setBookPrice(double bookPrice) {
        if (bookPrice > 0.0) {
            this.bookPrice = bookPrice;
        } else {
            System.out.println("Price must be a positive numbers!");
        }
    }

}
