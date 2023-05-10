import java.util.Arrays;

public class Vettore{
    private static int[] v = new int[20];
    public Vettore(){
        for(int i = 0; i < v.length; i++){
            v[i] = RandInt.fromOne(99);
        }
        Arrays.sort(v);
    }
    public static int binarySearch(int n){
        return Arrays.binarySearch(v, n);
    }
}
