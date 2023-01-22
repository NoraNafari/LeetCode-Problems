package bullsAndCows299;

public class BullsAndCows {

    public static void main(String[] args) {
//        secret = "1807", guess = "7810"
        //should print 1A3B
        System.out.println(getHint("1807", "7810"));
//        secret = "1123", guess = "0111"
        //should print 1A1B
        System.out.println(getHint("1123", "0111"));

    }

    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        //We keep track of all the numbers that are seen in secret and guess in a 10-element array
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            //if two characters are the same the bulls must be increased
            if (s == g) {
                bulls++;
            } else {
                //if the secret's character was in guess before
                if (numbers[s] < 0) {
                    cows++;
                }
                //if the guess's character was in secret before
                if (numbers[g] > 0) {
                    cows++;
                }
                //add one to the visited number in secret
                numbers[s]++;
                //reduce one from the visited number in g
                numbers[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
