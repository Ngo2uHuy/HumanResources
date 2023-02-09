import java.util.*;

public class Manager extends Staff implements ICalculator {
    final int MANAGER_SALARY=5000000;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Manager() {
    }

    public Manager(String employCode, String employName, int employAge, double coSalary, String workingDay, String workingParts, int numOfDaysOfLeave, String title) {
        super(employCode, employName, employAge, coSalary, workingDay, workingParts, numOfDaysOfLeave);
        this.title = title;
    }

    public void input(ArrayList<Department> arrayDepart) {
        super.input(arrayDepart);
        this.title = selectTitle();
    }
    //list lương theo chức vụ
    private HashMap<String, Integer> listSalary() {
        HashMap<String, Integer> mapSalaries = new HashMap();
        mapSalaries.put("Business Leader", 8000000);
        mapSalaries.put("Project Leader", 5000000);
        mapSalaries.put("Technical Leader", 6000000);
        return mapSalaries;
    }
    //lấy list chức vụ
    private HashMap<Integer, String> listTitles() {
        HashMap<Integer, String> mapTitles = new HashMap();
        HashMap<String, Integer> mapSalaries = listSalary();
        int i=1;
        for (Map.Entry<String, Integer> entry : mapSalaries.entrySet()) {
            mapTitles.put(i, entry.getKey());
            i++;
        }
        return mapTitles;
    }
    //hiển thị những chức vụ
    private void menuTitles(HashMap<Integer, String> mapTitles) {
        Set<Integer> keySet = mapTitles.keySet();
        for (Integer key : keySet) {
            System.out.println(key + ". " + mapTitles.get(key));
        }
    }
    //chọn chức vụ
    private String selectTitle() {
        Scanner scan = new Scanner(System.in);
        HashMap<Integer, String> mapTitles = listTitles();
        do {
            System.out.println("Chức danh: ");
            menuTitles(mapTitles);
            System.out.print("Nhập chức danh: ");
            int select = -1;
            select = Integer.parseInt(scan.nextLine());
            if (select == 1 || select == 2 || select == 3) {
                return mapTitles.get(select);
            } else {
                System.out.println("Không hợp lệ. Vui lòng bạn chọn lại!!!");
            }
        } while (true);
    }
    //tính lương
    public double calculateSalary() {
        HashMap<String, Integer> mapSalaries = listSalary();
        return super.coSalary*MANAGER_SALARY+mapSalaries.get(this.title);
    }
    //hiển thị theo định dạng
    public void displayInfomation() {
        String text;
        text=formatTextCell(this.employCode)+"|";
        text+=formatTextCell(this.employName)+"|";
        text+=formatNumCell(this.employAge)+"|";
        text+=formatNumCell(this.coSalary)+"|";
        text+=formatTextCell(this.workingDay)+"|";
        text+=formatNumCell(this.numOfDaysOfLeave)+"|";
        text+=formatTextCell(this.workingParts)+"|";
        text+="      "+formatTextCell(this.title)+"   |";
        text+=formatNumCell(this.calculateSalary());
        System.out.println(text);
    }
}
