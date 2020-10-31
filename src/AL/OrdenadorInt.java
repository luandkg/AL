package AL;

public class OrdenadorInt  extends  Ordenador<Integer>{

    @Override
    public boolean isIgual(Integer valor1, Integer valor2) {
        return valor1 == valor2;
    }

    @Override
    public boolean isDiferente(Integer valor1, Integer valor2) {
        return valor1 != valor2;
    }

    @Override
    public boolean isMenor(Integer valor1, Integer valor2) {
        return valor1 < valor2;
    }

    @Override
    public boolean isMaior(Integer valor1, Integer valor2) {
        return valor1 > valor2;
    }
}
