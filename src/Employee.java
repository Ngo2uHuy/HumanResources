import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends Staff implements ICalculator {
    final int EMPLOYEE_SALARY=3000000;
    final int EMPLOYEE_SALARY_OVERTIME=200000;
    int overtimeHours;

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public Employee() {
        overtimeHours=0;
    }

    public Employee(String employCode, String employName, int employAge, double coSalary, String workingDay, String workingParts, int numOfDaysOfLeave, int overtimeHours) {
        super(employCode, employName, employAge, coSalary, workingDay, workingParts, numOfDaysOfLeave);
        this.overtimeHours = overtimeHours;
    }

    public void input(ArrayList<Department> arrayDepart) {
        Scanner scan = new Scanner(System.in);
        super.input(arrayDepart);
        System.out.print("Nhập số giờ làm thêm: ");
        this.overtimeHours = Integer.parseInt(scan.nextLine());
    }
    //tính lương
    public double calculateSalary() {
        return super.coSalary * EMPLOYEE_SALARY + this.overtimeHours * EMPLOYEE_SALARY_OVERTIME;
    }
    //hiển thị thông tin theo định dạng
    public void displayInfomation() {
        String text;
        text=formatTextCell(this.employCode)+"|";
        text+=formatTextCell(this.employName)+"|";
        text+=formatNumCell(this.employAge)+"|";
        text+=formatNumCell(this.coSalary)+"|";
        text+=formatTextCell(this.workingDay)+"|";
        text+=formatNumCell(this.numOfDaysOfLeave)+"|";
        text+=formatTextCell(this.workingParts)+"|";
        text+="      "+formatNumCell(this.overtimeHours)+"       |";
        text+=formatNumCell(this.calculateSalary());
        System.out.println(text);
    }
}
