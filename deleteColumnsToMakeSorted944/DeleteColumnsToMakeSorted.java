package deleteColumnsToMakeSorted944;

public class DeleteColumnsToMakeSorted {

    public static void main(String[] args) {
        //test case
        String[] test = new String[3];
        test[0] = "a";
        test[1] = "b";
        test[2] = "c";
        System.out.println(minDeletionSize(test));
    }

    public static int minDeletionSize(String[] strs) {
        //counter to see how many are not in order, we don't need to
        //check the edge cases. Because they are resolved by counter=0
        int counter = 0;
        //iterate through the characters
        for (int i = 0; i < strs[0].length(); i++) {
            //iterate through the words
            for (int j = 0; j < strs.length -1; j++) {
                //if the characters are not in increasing order, break the loop and increase the counter
                if (strs[j].charAt(i)>strs[j+1].charAt(i)) {
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }
}
