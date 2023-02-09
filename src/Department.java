public class Department {
    private String departCode;
    private String departName;
    private int curNumOfEmploys;

    public String getDepartCode() {
        return departCode;
    }

    public void setDepartCode(String departCode) {
        this.departCode = departCode;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public int getCurNumOfEmploys() {
        return curNumOfEmploys;
    }

    public void setCurNumOfEmploys(int curNumOfEmploys) {
        this.curNumOfEmploys = curNumOfEmploys;
    }

    public Department(String departCode, String departName) {
        this.departCode = departCode;
        this.departName = departName;
        this.curNumOfEmploys=0;
    }

    public Department(String departCode, String departName, int curNumOfEmploys) {
        this.departCode = departCode;
        this.departName = departName;
        this.curNumOfEmploys = curNumOfEmploys;
    }
    //định dạng ô số
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
    //xuất thông tin bộ phận
    public String toString(){
        String text;
        text=formatTextCell(this.departCode)+"|";
        text+=formatTextCell(this.departName)+"|";
        text+=formatNumCell(this.curNumOfEmploys);
        return text;
    }
}
