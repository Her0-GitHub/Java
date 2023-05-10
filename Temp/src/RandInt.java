import java.util.Random;

public class RandInt {
    private static final Random rand = new Random();
    /**
     * @param min Minimum Value (Included)
     * @param max Maximum Value (Included)
     * @return Random number between min and max
     */
    public static int tra(int min, int max) {
        return (int) Math.round(rand.nextDouble() * (max - min) + min);
    }
    /**
     * @param max Maximum Value (Included)
     * @return Random number between 0 and max
     */
    public static int fromZero(int max) {
        return (int) Math.round(rand.nextDouble() * max);
    }
    /**
     * @param max Maximum Value (Included)
     * @return Random number between 1 and max
     */
    public static int fromOne(int max) {
        return (int) Math.round(rand.nextDouble() * (max - 1) + 1);
    }
}