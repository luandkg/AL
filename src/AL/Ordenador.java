package AL;

public abstract class Ordenador<T> {

    public abstract boolean isIgual(T valor1, T valor2);

    public abstract boolean isDiferente(T valor1, T valor2);

    public abstract boolean isMenor(T valor1, T valor2);

    public abstract boolean isMaior(T valor1, T valor2);

}