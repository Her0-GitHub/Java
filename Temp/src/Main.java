import java.util.Arrays;
//  Dato un vettore di 20 numeri interi compresi fra 1 e 99 generato casualmente (privo di
//  elementi che si ripetono) lo passi ad un metodo assieme ad un intero che deve essere
//  cercato nel vettore usando l'algoritmo della ricerca binaria.

public class Main {
    public static void main(String[] args) {
        Vettore v = new Vettore();
        for (int i = 0; i < 10; i++) {
            System.out.printf("Ricerca Binaria: %d\n", v.binarySearch(i));
        }
    }
}