package n1ex1;

public class VendaBuidaException extends Exception{

    public VendaBuidaException(String errorMessage){

        super(errorMessage);
        System.out.println("Per fer una venda primer has d'afegir productes");

    }

}
