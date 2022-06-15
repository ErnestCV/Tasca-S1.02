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

        ArrayList<Producte> productes = new ArrayList<>();

        try {
            Venda.calcularTotal(productes);
        } catch (VendaBuidaException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Venda.total);

    }

}
