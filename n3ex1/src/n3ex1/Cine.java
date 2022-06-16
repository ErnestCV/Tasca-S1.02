package n3ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class Cine {

    private int nombreFiles;
    private int nombreSeientsPerFila;
    private GestioButaques gestioButaques;

    public Cine() {

        gestioButaques = new GestioButaques();
        demanarDadesInicials();

    }
    public void demanarDadesInicials(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introudeix el nombre de files del cinema: ");
        nombreFiles = scanner.nextInt();
        System.out.println("Introudeix el nombre de seients per fila: ");
        nombreSeientsPerFila = scanner.nextInt();

    }
    public void iniciar(){
        int selector = menu();
        switch (selector){
            case 1: {

            }
        }
    }
    public int menu(){
        System.out.println("Opcions");
        System.out.println("Intro: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public void mostrarButaques(){
        for (Butaca butaca : gestioButaques.getButaques()){
            System.out.println(butaca);
        }
    }

}
