public class Semplifica {
    public static void frazione(int numeratore, int denominatore){
        if (denominatore == 0) {
            System.out.println("Errore: denominatore nullo");
            return;
        }
        if(numeratore == 0){
            PrintFrazione(0);
            return;
        }
        if(denominatore == 1){
            PrintFrazione(numeratore);
            return;
        }
        if(denominatore == -1){
            PrintFrazione(numeratore * -1);
            return;
        }
        if(denominatore < 0){
            numeratore *= -1;
            denominatore *= -1;
            PrintFrazione(numeratore, denominatore);
            return;
        }
        int mcd = MCD(numeratore, denominatore);
        PrintFrazione(numeratore / mcd, denominatore / mcd);
    }
    private static void PrintFrazione(int n, int d) {
        System.out.println("Frazione: " + n + "/" + d);
    }
    private static void PrintFrazione(int n){
        System.out.println("Frazione: " + n);
    }
}
