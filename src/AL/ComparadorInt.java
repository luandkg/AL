package AL;

public class ComparadorInt  extends  Comparador<Integer>{

    @Override
    public boolean isIgual(Integer valor1, Integer valor2) {
        return valor1 == valor2;
    }

    @Override
    public boolean isDiferente(Integer valor1, Integer valor2) {
        return valor1 != valor2;
    }
}
