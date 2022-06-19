package n2ex1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

    //private static Scanner scanner;
    private static Scanner scanner = new Scanner(System.in);

//    public Entrada(Scanner scanner) {
//        this.scanner = scanner;
//    }

    public static byte llegirByte(String missatge){

        System.out.println(missatge);
        byte b = 0;
        boolean end = false;

        do {
            try {
                b = scanner.nextByte();
                System.out.println("El teu byte és: " + b);
                end = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de format. El valor no és un byte, torna a provar: ");
            }
            scanner.nextLine();
        } while (!end);

        return b;

    }

    public static int llegirInt(String missatge){

        System.out.println(missatge);
        int b = 0;
        boolean end = false;

        do {
            try {
                b = scanner.nextInt();
                System.out.println("El teu enter és : " + b);
                end = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de format. El valor no és un int, torna a provar: ");
            }
            scanner.nextLine();
        } while (!end);

        return b;

    }



    public static float llegirFloat(String missatge){

        System.out.println(missatge);
        float b = 0;
        boolean end = false;

        do {
            try {
                b = scanner.nextFloat();
                System.out.println("El teu float és : " + b);
                end = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de format. El valor no és un float, torna a provar: ");
            }
            scanner.nextLine();
        } while (!end);

        return b;

    }


    public static double llegirDouble(String missatge){

        System.out.println(missatge);
        double b = 0;
        boolean end = false;

        do {
            try {
                b = scanner.nextDouble();
                System.out.println("El teu double és : " + b);
                end = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de format. El valor no és un double, torna a provar: ");
            }
            scanner.nextLine();
        } while (!end);

        return b;

    }

    public static char llegirChar(String missatge){

        System.out.println(missatge);
        char b = ' ';
        boolean end = false;

        do {
            try {
                b = scanner.next().charAt(0); //Millor scanner.findInLine(".").charAt(0); ??
                System.out.println("El teu char és : " + b);
                end = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de format. El valor no és un char, torna a provar: ");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            scanner.nextLine();
        } while (!end);

        return b;

    }

    public static String llegirString(String missatge){

        System.out.println(missatge);
        String b = "";
        boolean end = false;

        do {
            try {
                b = scanner.next();
                System.out.println("La teva String és : " + b);
                end = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de format. El valor no és un String, torna a provar: ");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            scanner.nextLine();
        } while (!end);

        return b;

    }

    public static boolean llegirSiNo(String missatge){

        System.out.println(missatge);
        boolean b = false;
        boolean end = false;

        do {
            try {
                char c = scanner.next().charAt(0);
                if (c == 's'){
                    b = true;
                    System.out.println("true");
                    end = true;
                } else if (c == 'n') {
                    b = true;
                    System.out.println("false");
                    end = true;
                } else {
                    throw new SiNoException("Valor incorrecte. Introdueix s per indicar \"Sí\" i n per indicar \"No\":");
                }
            } catch (SiNoException err) {
                System.out.println(err.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Error de format. El valor no és un caràcter vàlid, torna a provar: ");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            scanner.nextLine();
        } while (!end);

        return b;

    }

}