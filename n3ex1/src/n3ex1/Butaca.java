package n3ex1;

public class Butaca {

    private final int fila;
    private final int seient;
    private final String nomReserva;

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

    public boolean equals(Butaca butaca, int fila, int seient){

        return (butaca.getFila() == fila & butaca.getSeient() == seient);

    }

    @Override
    public String toString(){
        return "Fila: " + this.fila + " Seient: " + this.seient + " Persona: " + this.nomReserva;
    }

}
