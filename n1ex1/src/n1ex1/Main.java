package n1ex1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

//        Producte p1 = new Producte("Poma", 2.5);
//        Producte p2 = new Producte("Pera", 3);
//        Producte p3 = new Producte("Taronja", 1);
//
//        ArrayList<Producte> productes = new ArrayList<>();
//        productes.add(p1);
//        productes.add(p2);
//        productes.add(p3);

        ArrayList<Producte> productes = new ArrayList<>(); //ArrayList buit

        //Codi necessari per generar i capturar una excepció del tipus IndexOutOfBoundsException
        try {
            System.out.println(productes.get(1000));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        //Excepció personalitzada VendaBuidaException
        Venda venda = new Venda(productes);

        try {
            venda.calcularTotal(productes);
            System.out.println(venda);
        } catch (VendaBuidaException e) {
            System.out.println(e.getMessage());
        }

    }

}
