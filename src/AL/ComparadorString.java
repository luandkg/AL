package AL;

public class ComparadorString  extends  Comparador<String>{

    @Override
    public boolean isIgual(String valor1, String valor2) {
        return valor1.contentEquals(valor2) == true;
    }

    @Override
    public boolean isDiferente(String valor1, String valor2) {
        return valor1.contentEquals(valor2) == false;
    }
}
