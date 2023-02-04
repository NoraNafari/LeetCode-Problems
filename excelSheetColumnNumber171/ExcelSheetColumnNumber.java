package excelSheetColumnNumber171;

public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        //test case
        String column01 = "A";
        System.out.println(titleToNumber(column01));
        String column02 = "AB";
        System.out.println(titleToNumber(column02));
        String column03 = "ZY";
        System.out.println(titleToNumber(column03));
    }

    //this is the formula that we have to implement: num = num*26 + numerical value of char
    public static int titleToNumber(String columnTitle) {
        if (columnTitle==null || columnTitle.isEmpty()){
            return 0;
        }
        int sum = 0;
        //numerical value of the letter = char - Upper case A + 1
        for (int i = 0; i < columnTitle.length(); i++) {
            sum*=26;
            sum += columnTitle.charAt(i) - 'A' + 1;
        }
        return sum;
    }
}
