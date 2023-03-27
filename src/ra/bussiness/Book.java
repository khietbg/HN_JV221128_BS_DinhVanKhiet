package ra.bussiness;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Book implements IBook,Comparable<Book>{
    public static List<Book> listBook = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float importPrice,float interest) {
        this.exportPrice = importPrice*interest;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }
    public void inputData() {
        System.out.println("nhập tên sách:");
        this.bookName = scanner.nextLine();
        System.out.println("nhập tiêu đề sách:");
        this.title = scanner.nextLine();
        System.out.println("nhập số trang");
        this.numberOfPages = Integer.parseInt(scanner.nextLine());
        System.out.println("giá nhập sách là:");
        this.importPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("lợi nhuận là:");
        this.interest=Float.parseFloat(scanner.nextLine());
        this.exportPrice = importPrice*interest;
        System.out.println("trạng thái sách: (true:đang bán), (false: không bán)");
        this.bookStatus = Boolean.parseBoolean(scanner.nextLine());
    }
    public void displayData() {
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("mã sách : %d \n",bookId);
        System.out.printf("tên sách : %s \n",bookName);
        System.out.printf("tiêu đề : %s \n",title);
        System.out.printf("số trang : %d \n",numberOfPages);
        System.out.printf("giá nhập : %.1f \n",importPrice);
        System.out.printf("lợi nhuận  : %.1f \n",interest);
        System.out.printf("giá bán : %.1f \n",exportPrice);
        System.out.printf("trang thai sach la: %s \n",bookStatus?"đang bán":"không bán");
        System.out.println("---------------------------------------------------------------------------");

    }

    @Override
    public void createBook() {
        System.out.println("Nhập số lượng sách muốn thêm: \n");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin sách thứ " + (i+1) + "\n");

            Book book = new Book();
            book.inputData();
            if (listBook.size() == 0) {
                book.setBookId(1);
            } else {
                book.setBookId(listBook.get(listBook.size() - 1).getBookId() + 1);
            }

            listBook.add(book);
        }

    }

    @Override
    public void showBook() {
        for (Book book:listBook) {
            book.displayData();
        }
    }


    @Override
    public void sortWithInterest() {
        Collections.sort(listBook);
    }

    @Override
    public void deleteById() {
        System.out.println("Nhập id muốn xoá");
        int id = Integer.parseInt(scanner.nextLine());
        for (Book book:listBook) {
            if (book.getBookId()==id){
                listBook.remove(book);
                return;
            }
        }
        System.out.println("không có sách muốn xoá");
    }

    @Override
    public void searchByName() {
        System.out.println("Nhập tên sách muốn tìm: ");
        String search = scanner.nextLine();
        for (Book book:listBook) {
            if (book.bookName.equals(search)){
                book.displayData();
                return;
            }
        }
        System.out.println("không có sách cần tìm");
    }

    @Override
    public void changeStatus() {
        System.out.println("Nhập id sách muốn thay dổi");
        int id = Integer.parseInt(scanner.nextLine());
        for (Book book:listBook) {
            if (book.getBookId()==id){
                book.setBookStatus(!book.getBookStatus());
                return;
            }
        }
        System.out.println("id không tồn tại");
    }

    @Override
    public int compareTo(Book o) {
        return (int) (o.getInterest()-this.interest);
    }
}
