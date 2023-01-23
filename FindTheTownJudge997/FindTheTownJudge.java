package FindTheTownJudge997;

public class FindTheTownJudge {

    public static void main(String[] args) {
        //test case
        int[][] trust01 = new int[][]{new int[]{1,2}};
        System.out.println(findJudge(2, trust01));

        //test case
        int[][] trust02 = new int[][]{new int[]{1,3}, new int[]{2,3}};
        System.out.println(findJudge(3, trust02));

        int[][] trust03 = new int[][]{new int[] {1,3}, new int[]{2,3}, new int[]{3,1}};
        System.out.println(findJudge(3, trust03));
    }

    public static int findJudge(int n, int[][] trust) {
        //first checking the edge cases of trust array, if there is only one person and nobody
        //is in town! then that is the judge. Otherwise no one is the judge
        if (trust.length==0) {
            if (n==1) {
                return 1;
            }
            else {
                return -1;
            }
        }
        //The idea is to add a vote to a person when somebody votes for it
        //and remove the vote when that person votes for someone else
        //in this way, the person whi has n-1 votes at the end is the judge.
        int[] people = new int[n+1];

        for (int[] ints : trust) {
            people[ints[0]]--;
            people[ints[1]]++;
        }
        for (int i = 0; i < people.length; i++) {
            if (people[i]==n-1) {
                return i;
            }
        }
        return -1;
    }
}
