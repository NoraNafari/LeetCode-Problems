package pascalsTriangle118;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {

        //test case
        List<List<Integer>> generated = generate(5);
        for (List<Integer> integers : generated) {
            System.out.println("");
            for (Integer integer : integers) {
                System.out.print(integer + ",");
            }
        }
    }

    //You basically have to add the previous list's upstream numbers iteratively
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= numRows; i++) {
            List<Integer> newList = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j==0 || j==i) {
                    newList.add(1);
                }
                else {
                    newList.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }
            }
            result.add(newList);
        }
        return result;
    }

}
