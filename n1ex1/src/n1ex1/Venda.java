package n1ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Venda {

    private final List<Producte> productes;
    private double total = 0;

    public Venda(List<Producte> productes) {
        this.productes = productes;
    }

    public void calcularTotal(List<Producte> productes) throws VendaBuidaException{

        if (productes.isEmpty()){
            throw new VendaBuidaException("Per fer una venda primer has d'afegir productes");
        }

        total = productes.stream().mapToDouble(Producte::getPreu).sum();

    }

    @Override
    public String toString(){
        return "El preu total és: " + total + " €";
    }

}
