package n3ex1;

public class Butaca {

    private int fila;
    private int seient;
    private String nomReserva;

    public Butaca(int fila, int seient, String nomReserva) {
        this.fila = fila;
        this.seient = seient;
        this.nomReserva = nomReserva;
    }

    public int getFila() {
        return fila;
    }

    public int getSeient() {
        return seient;
    }

    public String getNomReserva() {
        return nomReserva;
    }

    public boolean equals(Butaca butaca1, Butaca butaca2){

        boolean iguals = false;
        if (butaca1.fila == butaca2.fila){
            if (butaca1.seient == butaca2.seient) {
                iguals = true;
            }
        }
        return iguals;
    }

    @Override
    public String toString(){
        return "Fila: " + this.fila + "Seient: " + this.seient + "Persona: " + this.nomReserva;
    }

}
