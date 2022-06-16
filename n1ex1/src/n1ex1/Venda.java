package n1ex1;

import java.util.ArrayList;
import java.util.Arrays;

public class Venda {

    private ArrayList<Producte> productes;
    private double total = 0;

    public Venda(ArrayList<Producte> productes) {
        this.productes = productes;
    }

    //Codi necessari per generar i capturar una excepció del tipus IndexOutOfBoundsException
    public double calcularTotal(ArrayList<Producte> productes) throws VendaBuidaException{

        if (productes.isEmpty()){
            throw new VendaBuidaException("Per fer una venda primer has d'afegir productes");
        }

        total = productes.stream().mapToDouble(Producte::getPreu).sum();

        return total;

    }

    @Override
    public String toString(){
        return "El preu total és: " + total + " €";
    }

}
