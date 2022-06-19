package n1ex1;

public class Producte {

    private final String nom;
    protected double preu;

    public Producte(String nom, double preu) {
        this.nom = nom;
        this.preu = preu;
    }

    public double getPreu() {
        return preu;
    }
}
