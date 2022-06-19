package n3ex1;

import n3ex1.Excepcions.ExcepcioButacaLliure;
import n3ex1.Excepcions.ExcepcioButacaOcupada;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestioButaques {

    private final List<Butaca> butaques;

    public GestioButaques(){
        butaques = new ArrayList<>();
    }

    public List<Butaca> getButaques(){
        return butaques;
    }

    protected void afegirButaca(Butaca butaca) throws ExcepcioButacaOcupada {

        if (cercarButaca(butaca.getFila(), butaca.getSeient()) != -1) {
            throw new ExcepcioButacaOcupada("Aquesta butaca ja està ocupada");
        }

        butaques.add(butaca);
        System.out.println("Butaca reservada");

    }
    protected void eliminarButaca(int fila, int seient) throws ExcepcioButacaLliure{

        if (cercarButaca(fila, seient) == -1) {
            throw new ExcepcioButacaLliure("Aquesta butaca no està reservada");
        }

        butaques.remove(cercarButaca(fila, seient));
        System.out.println("Butaca eliminada");

    }

    protected int cercarButaca(int fila, int seient){

                return butaques.stream()
                .filter(butaca -> butaca.equals(butaca, fila, seient))
                .findFirst()
                .map(butaques::indexOf).orElse(-1);

    }

}
