package n3ex1;

import n3ex1.Excepcions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cine {

    private int nombreFiles;
    private int nombreSeientsPerFila;
    private static GestioButaques gestioButaques;
    private final Scanner scanner = new Scanner(System.in);

    public Cine() {

        gestioButaques = new GestioButaques();
        demanarDadesInicials();

    }

    public void demanarDadesInicials() {

        System.out.println("Introudeix el nombre de files del cinema: ");
        nombreFiles = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introudeix el nombre de seients per fila: ");
        nombreSeientsPerFila = scanner.nextInt();
        scanner.nextLine();

    }

    public void iniciar() {

        boolean exit = false;

        do {
            switch (menu()) {
                //Mostrar totes les butaques reservades
                case 1 -> mostrarButaques();

                //Mostrar les butaques reservades per una persona
                case 2 -> mostrarButaquesPersona();

                //Reservar una butaca
                case 3 -> reservarButaca();

                //Anul·lar la reserva d'una butaca
                case 4 -> anularReserva();

                //Anul·lar totes les reserves d'una persona
                case 5 -> anularReservaPersona();

                //Sortir del programa
                case 0 -> {
                    System.out.println("Sortint de l'aplicació");
                    exit = true;
                }
            }

        } while (!exit);
    }

    private byte menu() {
        byte select;
        final byte MIN = 0;
        final byte MAX = 5;

        do {
            System.out.println("""
                        -------------------
                    Escolliu una opció:
                    1: Mostrar totes les butaques reservades
                    2: Mostrar les butaques reservades per una persona
                    3: Reservar una butaca
                    4: Anul·lar la reserva d'una butaca
                    5: Anul·lar totes les reserves d'una persona
                    0: Sortir
                    ------------------
                        """);

            select = scanner.nextByte();
            scanner.nextLine();

            if (select < MIN | select > MAX) {
                System.out.println("Introdueix una opció vàlida.");
            }
        } while (select < MIN | select > MAX);

        return select;
    }

    private int introduirFila() throws ExcepcioFilaIncorrecta {

        System.out.println("Introdueix el nombre de la fila:");
        int fila = scanner.nextInt();
        scanner.nextLine();
        if (fila >= 1 & fila <= nombreFiles) {
            return fila;
        } else {
            throw new ExcepcioFilaIncorrecta("El nombre de la fila no és correcte.");
        }

    }

    private int introduirSeient() throws ExcepcioSeientIncorrecte {

        System.out.println("Introdueix el nombre del seient:");
        int seient = scanner.nextInt();
        scanner.nextLine();
        if (seient >= 1 & seient <= nombreSeientsPerFila) {
            return seient;
        } else {
            throw new ExcepcioSeientIncorrecte("El nombre del seient no és correcte.");
        }

    }

    private String introduirPersona() throws ExcepcioNomPersonaIncorrecte {

        System.out.println("Introdueix el nom de la persona que fa la reserva:");
        String nom = scanner.next();

        if (!nom.matches(".*\\d.*")) {
            return nom;
        } else {
            throw new ExcepcioNomPersonaIncorrecte("El nom de la persona no pot contenir caràcters numèrics.");
        }

    }

    private void reservarButaca() {

        boolean invalidInput;

        int fila = -1;
        do {
            invalidInput = false;
            try {
                fila = introduirFila();
            } catch (ExcepcioFilaIncorrecta e) {
                System.out.println(e.getMessage());
                invalidInput = true;
            }

        } while (invalidInput);

        int seient = -1;
        do {
            invalidInput = false;
            try {
                seient = introduirSeient();
            } catch (ExcepcioSeientIncorrecte e) {
                System.out.println(e.getMessage());
                invalidInput = true;
            }

        } while (invalidInput);

        String nom = null;
        do {
            invalidInput = false;
            try {
                nom = introduirPersona();
            } catch (ExcepcioNomPersonaIncorrecte e) {
                System.out.println(e.getMessage());
                invalidInput = true;
            }

        } while (invalidInput);

        Butaca butaca = new Butaca(fila, seient, nom);

        try {
            gestioButaques.afegirButaca(butaca);
        } catch (ExcepcioButacaOcupada e) {
            System.out.println(e.getMessage());
        }

    }

    private void anularReserva() {

        int fila = -1;
        try {
            fila = introduirFila();
        } catch (ExcepcioFilaIncorrecta e) {
            System.out.println(e.getMessage());
        }

        int seient = -1;
        try {
            seient = introduirSeient();
        } catch (ExcepcioSeientIncorrecte e) {
            System.out.println(e.getMessage());
        }

        try {
            gestioButaques.eliminarButaca(fila, seient);
        } catch (ExcepcioButacaLliure e) {
            System.out.println(e.getMessage());
        }

    }

    private void anularReservaPersona() {

        List<String> nom = new ArrayList<>();

        try {
            nom.add(introduirPersona());
        } catch (ExcepcioNomPersonaIncorrecte e) {
            System.out.println(e.getMessage());
        }

        List<Butaca> trobades = gestioButaques.getButaques().stream()
                .filter(butaca -> butaca.getNomReserva().equals(nom.get(0)))
                .toList();

        trobades.forEach(butaca -> {
            try {
                gestioButaques.eliminarButaca(butaca.getFila(), butaca.getSeient());
            } catch (ExcepcioButacaLliure e) {
                System.out.println(e.getMessage());
            }
        });

    }

    private void mostrarButaques() {
        for (Butaca butaca : gestioButaques.getButaques()) {
            System.out.println(butaca);
        }
    }

    private void mostrarButaquesPersona() {

        List<String> nom = new ArrayList<>();

        try {
            nom.add(introduirPersona());
        } catch (ExcepcioNomPersonaIncorrecte e) {
            System.out.println(e.getMessage());
        }

        List<Butaca> trobades = gestioButaques.getButaques().stream()
                .filter(butaca -> butaca.getNomReserva().equals(nom.get(0)))
                .toList();

        trobades.forEach(System.out::println);

    }

}
