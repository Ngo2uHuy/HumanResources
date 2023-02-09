import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HumanResources {
    private ArrayList<Department> arrayDepart;
    private ArrayList<Staff> arrayStaff;

    public ArrayList<Department> getArrayDepart() {
        return arrayDepart;
    }

    public void setArrayDepart(ArrayList<Department> arrayDepart) {
        this.arrayDepart = arrayDepart;
    }

    public ArrayList<Staff> getArrayStaff() {
        return arrayStaff;
    }

    public void setArrayStaff(ArrayList<Staff> arrayStaff) {
        this.arrayStaff = arrayStaff;
    }

    public HumanResources() {
        this.arrayDepart = new ArrayList<Department>();
        this.arrayStaff = new ArrayList<Staff>();
    }

    //thêm bộ phận
    private void inputDePart() {
        Department dp = new Department("HC", "Hành chính nhân sự");
        arrayDepart.add(dp);
        dp = new Department("IT", "Công nghệ thông tin");
        arrayDepart.add(dp);
        dp = new Department("MKT", "Marketing");
        arrayDepart.add(dp);
    }
    //xuất thông tin nhân viên
    public void listStaff() {
        if (this.arrayStaff.size() > 0) {
            xuatRowHeaderStaff();
            xuatLine();
            for (Staff s : this.arrayStaff) {
                s.displayInfomation();
            }
        } else {
            System.out.println("Không có nhân viên nào trong các bộ phận");
        }
    }
    //xuát thông tin bộ phận
    public void listDePart() {
        xuatRowHeaderDepart();
        for (Department d : this.arrayDepart) {
            System.out.println(d.toString());
        }
    }
    //xuất thông tin nhân viên theo bộ phận
    public void listEmByDe() {
        if (this.arrayStaff.size() > 0) {
            for (int i = 0; i < this.arrayDepart.size(); i++) {
                System.out.println(this.arrayDepart.get(i).getDepartName());
                System.out.println("--------------------------------------------");
                xuatRowHeaderStaff();
                for (int j = 0; j < this.arrayStaff.size(); j++) {
                    if (this.arrayDepart.get(i).getDepartName().equalsIgnoreCase(this.arrayStaff.get(j).getWorkingParts())) {
                        this.arrayStaff.get(j).displayInfomation();
                    }
                }
                System.out.println("");
            }
        } else {
            System.out.println("Không có nhân viên nào trong công ty");
        }
    }
        //menu chương trình
    private static void Menu() {
        System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty.");
        System.out.println("2. Hiển thị các bộ phận trong công ty.");
        System.out.println("3. Hiển thị các nhân viên theo từng bộ phận.");
        System.out.println("4. Thêm nhân viên mới vào công ty.");
        System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên.");
        System.out.println("6. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần.");
        System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.");
        System.out.println("0. Thoát chương trình.");
    }

    private void xuatLine() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    //định dạng khoảng cách
    private String formatCell(String paddLeft, String title, String paddRight) {
        return String.format(paddLeft, " ") + title + String.format(paddRight, " ");
    }
    //xuất tiêu đề nhân viên theo định dạng
    private void xuatRowHeaderStaff() {
        String paddString0 = "%1s";
        String paddString1 = "%3s";
        String paddString2 = "%4s";
        String paddString3 = "%5s";
        String paddString4 = "%6s";
        String paddString5 = "%7s";
        String paddString6 = "%8s";
        String text;
        text = formatCell(paddString2, "Mã nhân viên", paddString2) + "|";
        text += formatCell(paddString1, "Tên nhân viên", paddString2) + "|";
        text += formatCell(paddString4, "Tuổi", paddString4) + "|";
        text += formatCell(paddString2, "HS lương", paddString2) + "|";
        text += formatCell(paddString2, "Ngày vào làm", paddString2) + "|";
        text += formatCell(paddString0, "Ngày nghỉ phép", paddString0) + "|";
        text += formatCell(paddString4, "Bộ phận", paddString5) + "|";
        text += formatCell(paddString1, "Số giờ làm thêm/Chức vụ", paddString1) + "|";
        text += formatCell(paddString6, "Lương", paddString1);
        System.out.println(text);
    }
    //xuất tiêu đề bộ phận theo định dạng
    private void xuatRowHeaderDepart() {
        String paddString0 = "%1s";
        String paddString1 = "%3s";
        String paddString2 = "%4s";
        String paddString3 = "%5s";
        String paddString4 = "%6s";
        String paddString5 = "%7s";
        String paddString6 = "%8s";
        String text;
        text = formatCell(paddString1, "Mã bộ phận", paddString5) + "|";
        text += formatCell(paddString1, "Tên bộ phận", paddString4) + "|";
        text += formatCell(paddString4, "Số lượng nhân viên hiện tại", paddString4);
        System.out.println(text);
    }
    //menu thêm nhân viên
    private static void menuInSert() {
        System.out.println("1. Thêm nhân viên thông thường");
        System.out.println("2. Thêm nhân viên là cấp quản lý (có thêm chức vụ)");
    }
    //thêm nhân viên
    private void insertStaff() {
        Scanner s = new Scanner(System.in);
        boolean flag = false;
        Staff st;
        do {
            menuInSert();
            System.out.print("Bạn chọn: ");
            switch (Integer.parseInt(s.nextLine())) {
                case 1:
                    st = new Employee();
                    st.input(this.arrayDepart);
                    this.arrayStaff.add(st);
                    break;
                case 2:
                    st = new Manager();
                    st.input(this.arrayDepart);
                    this.arrayStaff.add(st);
                    break;
                default:
                    System.out.println("Không hợp lệ. Vui lòng bạn nhập lại!!!");
                    flag = true;
            }
        } while (flag);
    }
    //tìm thông tin nhân viên theo tên
    private void searchByName(String str) {
        boolean check = true;
        for (Staff s : this.arrayStaff) {
            if (s.getEmployName().equalsIgnoreCase(str) && check) {
                xuatRowHeaderStaff();
                check = false;
            }
            if (s.getEmployName().equalsIgnoreCase(str)) {
                s.displayInfomation();
            }
        }
        if (check == true) {
            System.out.println("Không có nhân viên nào có tên: " + str);
        }
        System.out.println("");
        xuatLine();
    }
    //tìm tìm thông tin nhân viên theo mã
    private void searchByCode(String str) {
        ;
        boolean check = true;
        for (Staff s : this.arrayStaff) {
            if (s.getEmployCode().equalsIgnoreCase(str) && check) {
                xuatRowHeaderStaff();
                check = false;
            }
            if (s.getEmployCode().equalsIgnoreCase(str)) {
                s.displayInfomation();
            }
        }
        if (check == true) {
            System.out.println("Khoong có nhân viên nào có mã: " + str);
        }
        System.out.println("");
        xuatLine();
    }
    //menu tìm kiếm
    private static void menuSearch() {
        System.out.println("1. Tìm nhân viên bằng tên");
        System.out.println("2. Tìm nhân viên bằng mã nhân viên");
    }
    //tìm nhân viên
    private void searchStaff() {
        Scanner s = new Scanner(System.in);
        boolean flag = false;
        String str;
        do {
            menuSearch();
            System.out.print("Bạn chọn: ");
            switch (Integer.parseInt(s.nextLine())) {
                case 1:
                    System.out.print("Nhập tên nhân viên cần tìm: ");
                    str = s.nextLine();
                    searchByName(str);
                    break;
                case 2:
                    System.out.print("Nhập mã nhân viên cần tìm: ");
                    str = s.nextLine();
                    searchByCode(str);
                    break;
                default:
                    System.out.println("Không hợp lệ. Vui lòng bạn nhập lại!!!");
                    flag = true;
            }
        } while (flag);
    }
    //sắp xếp theo lương tăng dần
    private void sortBySalaryAsc() {
        if (this.arrayStaff.size() > 0) {
            HumanResources hm = new HumanResources();
            hm.setArrayStaff(this.arrayStaff);
            double s1 = 0, s2 = 0;
            for (int i = 0; i < hm.getArrayStaff().size() - 1; i++) {
                for (int j = i + 1; j < hm.getArrayStaff().size(); j++) {
                    if (hm.getArrayStaff().get(i) instanceof Employee) {
                        s1 = ((Employee) hm.getArrayStaff().get(i)).calculateSalary();
                    }
                    if (hm.getArrayStaff().get(i) instanceof Manager) {
                        s2 = ((Manager) hm.getArrayStaff().get(i)).calculateSalary();
                    }
                    if (s1 > s2) {
                        Collections.swap(hm.getArrayStaff(), i, j);
                    }
                }
            }
            hm.listStaff();
        } else {
            System.out.println("Không có nhân viên nào trong công ty");
        }
    }
    //sắp xếp theo lương giảm dần
    private void sortBySalaryDes() {
        if (this.arrayStaff.size() > 0) {
            HumanResources hm = new HumanResources();
            hm.setArrayStaff(this.arrayStaff);
            double s1 = 0, s2 = 0;
            for (int i = 0; i < hm.getArrayStaff().size() - 1; i++) {
                for (int j = i + 1; j < hm.getArrayStaff().size(); j++) {
                    if (hm.getArrayStaff().get(i) instanceof Employee) {
                        s1 = ((Employee) hm.getArrayStaff().get(i)).calculateSalary();
                    }
                    if (hm.getArrayStaff().get(i) instanceof Manager) {
                        s2 = ((Manager) hm.getArrayStaff().get(i)).calculateSalary();
                    }
                    if (s1 < s2) {
                        Collections.swap(hm.getArrayStaff(), i, j);
                    }
                }
            }
            hm.listStaff();
        } else {
            System.out.println("Không có nhân viên nào trong công ty");
        }
    }
    //chương trình xử lý
    private static void process(HumanResources hr) {
        Scanner scan = new Scanner(System.in);
        hr.inputDePart();
        boolean flag = true;
        do {
            Menu();
            System.out.println("Lựa chọn của bạn: ");
            switch (Integer.parseInt(scan.nextLine())) {
                case 1:
                    hr.listStaff();
                    break;
                case 2:
                    hr.listDePart();
                    break;
                case 3:
                    hr.listEmByDe();
                    break;
                case 4:
                    hr.insertStaff();
                    break;
                case 5:
                    hr.searchStaff();
                    break;
                case 6:
                    hr.sortBySalaryDes();
                    break;
                case 7:
                    hr.sortBySalaryAsc();
                    break;
                case 0:
                    System.out.println("Tạm Biệt");
                    flag = false;
                    break;
                default:
                    System.out.println("Không hợp lệ. Vui lòng bạn nhập lại!!!");
            }
        } while (flag);
    }

    public static void main(String[] args) {
        HumanResources hr = new HumanResources();
        process(hr);

    }
}
