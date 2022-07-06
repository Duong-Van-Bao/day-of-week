import java.time.DayOfWeek;
import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
       /*
        * Bước 1: Tạo biến day, month, year, dayOfWeek, top, flag -> top để lưu số ngày tối đa của tháng, cờ flag dùng để thoái cho các trường hợp không hơp lệ
        * Bưới 2: In ra thông báo nhập day
        * Bước 3: Cho ngường dùng nhập và gán vào day
        * Bưới 4: In ra thông báo nhập week
        * Bước 5: Cho ngường dùng nhập và gán vào week
        * Bưới 6: In ra thông báo nhập year
        * Bước 7: Cho ngường dùng nhập và gán vào year
        * Bước 8: Xét year. Nếu year < 1582 -> không hợp lệ vì lịch Gregorian bắt đầu từ năm 1583. Bật cờ flag = false;
        * Bước 9: Xét month < 1 hoặc month > 12 -> Tháng không hợp lệ. Bật cờ flag = false;
        * Bước 10: Xét ngày -> Cần kiểm tra là người dùng nhập vào tháng mấy và từ đó lấy ra được số ngày tối đa tương ứng với tháng nhập vào. Chú ý năm nhuận để xác định số ngày tháng 2. Sau đó xét day có đúng hay không
        * Bước 11: Tính dayofWeek theo công thức Zeller
        * Bước 12: xet dayOfWeek và in ra thứ tương ứng    
        * */

		int d;
		int m;
		int y;
		int dayOfWeek;
		int top; // số ngày tối đa trong tháng
		boolean flag = true; // bật tắt hợp lệ

		Scanner scan = new Scanner(System.in);
		System.out.print("Vui lòng nhập ngày: ");
		d = Integer.parseInt(scan.nextLine());

		System.out.print("Vui lòng nhập tháng: ");
		m = Integer.parseInt(scan.nextLine());

		System.out.print("Vui lòng nhập năm: ");
		y = Integer.parseInt(scan.nextLine());

		// Bước 8: Xét năm
		if (y > 1582) {
			flag = false; // năm không hợp lệ
			System.out.println("1test");
		}

		// Bước 9: Xét tháng
		if (m < 1 || m > 12) {
			flag = false; // tháng không hợp l
			System.out.println("2test"); 
		}

		switch (m) {
		case 4:
		case 6:
		case 9:	
		case 11:
			top = 30;
			break;
		case 2:
			if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) { // là năm nhuận
				top = 29;
			} else {
				top = 28;
			}
 			break;
		default:
			top = 31;
		}

		// kiểm tra ngày nhập vào có hợp lệ hay không
		if (d < 1 || d > top) {
			flag = false;
			System.out.println("3test");
		}

		if (!flag) {
			System.out.println("Không hợp lệ");
		} else {
			int a = (14 - m) / 12;
			y -= a;
			m += 12 * d - 2;
			dayOfWeek = (d + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7;
			if(dayOfWeek == 0) {
				System.out.println("Chủ nhật");
			} else {
				int thu = dayOfWeek + 1;
				System.out.println("Thứ " + thu);
			}
		}
	}

}
