package AL;

public class IteradorComparavel<T, C extends Comparador<T>> {


    private Unica<T, C> mUnica;

    private boolean mIniciado;
    private boolean mFinalizado;
    private int mIndice;
    private int mQuantidade;

    private int mTipo;


    public IteradorComparavel(Unica<T, C> eLista) {

        mUnica = eLista;

        mIniciado = false;
        mFinalizado = false;
        mIndice = 0;
        mQuantidade = 0;

        mTipo = 2;

    }

    public void iniciar() {

        mIniciado = true;
        mFinalizado = false;

        mIndice = 0;


        mQuantidade = mUnica.getQuantidade();


    }

    public boolean continuar() {
        if (mIniciado) {

            if (mIndice < mQuantidade) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    public void proximo() {

        if (mIniciado) {

            if (mFinalizado == false) {
                mIndice += 1;
            }

            if (mIndice >= mQuantidade) {
                mFinalizado = true;
            }
        }

    }

    public int getIndice() {

        if (mIniciado == false) {
            throw new IllegalArgumentException("Iterador nao iniciado !");
        }

        if (mFinalizado) {
            throw new IllegalArgumentException("Iterador finalizado !");
        }

        return mIndice;

    }

    public T getValor() {

        if (mIniciado == false) {
            throw new IllegalArgumentException("Iterador nao iniciado !");
        }

        if (mFinalizado) {
            throw new IllegalArgumentException("Iterador finalizado !");
        }


        return mUnica.getValor(mIndice);


    }

    public boolean iniciado() {
        return mIniciado;
    }

    public boolean finalizado() {
        return mFinalizado;
    }


    public boolean temAntes() {

        if (mIniciado == false) {
            throw new IllegalArgumentException("Iterador nao iniciado !");
        } else {

            if (mIndice > 0) {
                return true;
            } else {
                return false;
            }

        }

    }

    public boolean temDepois() {

        if (mIniciado == false) {
            throw new IllegalArgumentException("Iterador nao iniciado !");
        } else {


            if ((mIndice + 1) < mQuantidade) {
                return true;
            } else {
                return false;
            }


        }

    }

    public int getAnteriorIndice() {
        if (temAntes()) {

            return mIndice - 1;

        } else {

            throw new IllegalArgumentException("Iterador nao possui anterior !");

        }
    }

    public int getProximoIndice() {
        if (temDepois()) {

            return mIndice + 1;

        } else {

            throw new IllegalArgumentException("Iterador nao possui proximo !");

        }
    }


    public T getAnteriorValor() {
        if (temAntes()) {


            return mUnica.getValor(mIndice - 1);


        } else {

            throw new IllegalArgumentException("Iterador nao possui anterior !");

        }


    }

    public T getProximoValor() {
        if (temDepois()) {


            return mUnica.getValor(mIndice + 1);


        } else {

            throw new IllegalArgumentException("Iterador nao possui proximo !");

        }


    }

    public void sair() {
        mFinalizado = true;
        mIndice = mQuantidade;
    }
}
