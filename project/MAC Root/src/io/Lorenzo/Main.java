package io.Lorenzo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<MAC> macs = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        System.out.print("Lettura da file o da input? [f/i] ");
        switch(in.nextLine().toLowerCase().charAt(0)){
            case 'f' -> {
                try {
                    System.out.println(new File("mac.txt").createNewFile() ? "File mac.txt creato, Inserisci i MAC address" : "Controlla di aver inserito in mac.txt i MAC address");
                } catch (IOException e) {
                    handleException("Si è verificato un errore durante la creazione del file:", e);
                }
                System.out.print("Premi invio per inziare la lettura da file... "); in.nextLine(); in.close();
                try (Scanner fin = new Scanner(new File("mac.txt"))){
                    while (fin.hasNextLine()){
                        String mac = fin.nextLine();
                        try {
                            macs.add(new MAC(mac));
                        } catch (IllegalArgumentException e) {
                            System.err.println("MAC non valido: " + mac);
                        }
                    }
                } catch (IOException e) {
                    handleException("Si è verificato un errore durante l'apertura o la lettura del file:", e);
                }
            }
            case 'i' -> {
                System.out.println("Inserisci i MAC address, uno per riga. Scrivi \"fine\" per terminare l'inserimento.");
                while (true) {
                    String mac = in.nextLine();
                    if (mac.equalsIgnoreCase("fine")) break;
                    try {
                        macs.add(new MAC(mac));
                    } catch (IllegalArgumentException e) {
                        System.err.println("MAC non valido: " + (mac.equals("\n") ? "nessun MAC inserito" : mac));
                    }
                }
            }
            default -> System.out.println("Scelta non valida");
        }
        System.out.println("Totale MAC address inseriti: " + macs.size());
        MAC root = null;
        for (MAC mac : macs) {
            if (root == null || mac.isSmallerThan(root)) root = mac;
        }
        System.out.println("Il MAC address root è: " + root);
    }
    private static void handleException(String message, Exception e) {
        System.err.println(message + " " + e.getMessage());
        System.exit(1);
    }
}
