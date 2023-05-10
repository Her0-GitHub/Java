import java.util.Random;

public class RandInt {
    private static Random rand = new Random();
    public static int tra(int min, int max){
        return (int) Math.round(rand.nextDouble() * (max - min) + min);
    }
    public static int fromZero(int max) {
        return (int) Math.round(rand.nextDouble() * max);
    }
    public static int fromOne(int max) {
        return (int) Math.round(rand.nextDouble() * (max - 1) + 1);
    }
}
