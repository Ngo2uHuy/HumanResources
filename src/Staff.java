import java.util.ArrayList;
import java.util.Scanner;

public abstract class Staff {
    protected String employCode;
    protected String employName;
    protected int employAge;
    protected double coSalary;
    protected String workingDay;
    protected String workingParts;
    protected int numOfDaysOfLeave;

    public String getEmployCode() {
        return employCode;
    }

    public void setEmployCode(String employCode) {
        this.employCode = employCode;
    }

    public String getEmployName() {
        return employName;
    }

    public void setEmployName(String employName) {
        this.employName = employName;
    }

    public int getEmployAge() {
        return employAge;
    }

    public void setEmployAge(int employAge) {
        this.employAge = employAge;
    }

    public double getCoSalary() {
        return coSalary;
    }

    public void setCoSalary(double coSalary) {
        this.coSalary = coSalary;
    }

    public String getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(String workingDay) {
        this.workingDay = workingDay;
    }

    public String getWorkingParts() {
        return workingParts;
    }

    public void setWorkingParts(String workingParts) {
        this.workingParts = workingParts;
    }

    public int getNumOfDaysOfLeave() {
        return numOfDaysOfLeave;
    }

    public void setNumOfDaysOfLeave(int numOfDaysOfLeave) {
        this.numOfDaysOfLeave = numOfDaysOfLeave;
    }

    public Staff() {
    }

    public Staff(String employCode, String employName, int employAge, double coSalary, String workingDay, String workingParts, int numOfDaysOfLeave) {
        this.employCode = employCode;
        this.employName = employName;
        this.employAge = employAge;
        this.coSalary = coSalary;
        this.workingDay = workingDay;
        this.workingParts = workingParts;
        this.numOfDaysOfLeave = numOfDaysOfLeave;
    }
//nhập thông tin
    public void input(ArrayList<Department> arrayDepart) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập mã nhân viên: ");
        this.employCode = scan.nextLine();
        System.out.print("Nhập tên nhân viên: ");
        this.employName = scan.nextLine();
        System.out.print("Nhập tuổi nhân viên: ");
        this.employAge = Integer.parseInt(scan.nextLine());
        System.out.print("Nhập hệ số lương của nhân viên: ");
        this.coSalary = Double.parseDouble(scan.nextLine());
        System.out.print("Nhập ngày vào làm của nhân viên: ");
        this.workingDay = scan.nextLine();
        System.out.print("Nhập số ngày nghỉ của nhân viên: ");
        this.numOfDaysOfLeave = Integer.parseInt(scan.nextLine());
        this.workingParts = selectPart(arrayDepart);
    }
    //menu hiển thị bộ phận
    private void menuParts(ArrayList<Department> arrayDepart) {
        for (int i = 0; i < arrayDepart.size(); i++) {
            System.out.println((i + 1) + ". " + arrayDepart.get(i).getDepartCode()+" - "+arrayDepart.get(i).getDepartName());
        }
    }
    //chọn bộ phận
    private String selectPart(ArrayList<Department> arrayDepart) {
        Scanner scan = new Scanner(System.in);
        do {
            menuParts(arrayDepart);
            System.out.print("Bạn chọn bộ phận: ");
            int select = -1;
            select = Integer.parseInt(scan.nextLine());
            if (select == 1 || select == 2 || select == 3) {
                arrayDepart.get(select-1).setCurNumOfEmploys(arrayDepart.get(select-1).getCurNumOfEmploys()+1);
                return arrayDepart.get(select-1).getDepartName();
            } else {
                System.out.println("Không hợp lệ. Vui lòng bạn chọn lại!!!");
            }
        } while (true);
    }
    //định dạnh ô số
    protected String formatNumCell(Number num){
        String paddLeft="%7s";
        String paddRight="%-9s";
        return String.format(paddLeft," ")+String.format(paddRight,num);
    }
    //định dạng ô chữ
    protected String formatTextCell(String text){
        String paddLeft="%-20s";
        return String.format(paddLeft," "+text);
    }
    public abstract void displayInfomation();
}
