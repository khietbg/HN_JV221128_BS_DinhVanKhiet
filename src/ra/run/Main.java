package ra.run;

import ra.bussiness.Book;

import java.util.List;
import java.util.Scanner;

public class Main {
        public static Book book = new Book();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
        System.out.println("**************JAVA-HACKATHON-05-BASIC-MENU***************\n"+
                "1. Nhập số sách và thông tin sách \n"+
                "2. Hiển thị thông tin sách \n"+
                "3. Sắp xếp theo lợi nhuận giảm dần \n"+
                "4. Xoá sách theo mã sách \n"+
                "5. Tìm kiếm theo tên sách \n"+
                "6. Thay đổi trạng thái theo mã sách \n"+
                "7. Thoát");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
            book.createBook();
            break;
            case 2:
                book.showBook();
                break;
            case 3:
                book.sortWithInterest();
                break;
            case 4:
                book.deleteById();
                break;
            case 5:
                book.searchByName();
                break;
            case 6:
                book.changeStatus();
                break;
            case 7:
                System.exit(0);
            default:
                break;
        }
        }
    }
}