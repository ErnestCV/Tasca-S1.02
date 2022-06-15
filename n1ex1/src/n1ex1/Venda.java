package n1ex1;

import java.util.ArrayList;
import java.util.Arrays;

public class Venda {

    private ArrayList<Producte> productes;
    protected static double total = 0;

    public Venda(ArrayList<Producte> productes, double total) {
        this.productes = productes;
        this.total = total;
    }

    //Codi necessari per generar i capturar una excepció del tipus IndexOutOfBoundsException
    public static void calcularTotal(ArrayList<Producte> productes) throws VendaBuidaException{

        //Codi necessari per generar i capturar una excepció del tipus IndexOutOfBoundsException
//        try {
//            productes.get(productes.size());
//
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("Exception: " + e.getMessage());
//        }

        if (productes.isEmpty()){
            throw new VendaBuidaException("");
        }

    }


}
