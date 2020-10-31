package AL;

public abstract class Comparador<T> {

    public abstract boolean isIgual(T valor1, T valor2);

    public abstract boolean isDiferente(T valor1, T valor2);

}
