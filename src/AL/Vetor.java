package AL;

public class Vetor<T> {

    private T mDados[];
    private int mCapacidade;

    public Vetor(int eCapacidade, T eInicial) {

        mDados = (T[]) new Object[eCapacidade];
        mCapacidade = eCapacidade;

        if (mCapacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que 0 ");
        }

        for (int i = 0; i < mCapacidade; i++) {
            mDados[i] = eInicial;
        }

    }

    public int getCapacidade() {
        return mCapacidade;
    }


    public T get(int eIndice) {
        if (eIndice < 0) {
            throw new IllegalArgumentException("Indice nao existente : " + eIndice);
        } else if (eIndice > mCapacidade - 1) {
            throw new IllegalArgumentException("Indice nao existente : " + eIndice);
        }
        return mDados[eIndice];
    }

    public void set(int eIndice, T eValor) {
        if (eIndice < 0) {
            throw new IllegalArgumentException("Indice nao existente : " + eIndice);
        } else if (eIndice > mCapacidade - 1) {
            throw new IllegalArgumentException("Indice nao existente : " + eIndice);
        }
        mDados[eIndice] = eValor;
    }


    public void setVarios(int eIndice, T eValor1, T eValor2) {

        set(eIndice, eValor1);
        set(eIndice + 1, eValor2);

    }

    public void setVarios(int eIndice, T eValor1, T eValor2, T eValor3) {

        set(eIndice, eValor1);
        set(eIndice + 1, eValor2);
        set(eIndice + 2, eValor3);

    }

    public void setVarios(int eIndice, T eValor1, T eValor2, T eValor3, T eValor4) {

        set(eIndice, eValor1);
        set(eIndice + 1, eValor2);
        set(eIndice + 2, eValor3);
        set(eIndice + 3, eValor4);

    }

    public void setVarios(int eIndice, T eValor1, T eValor2, T eValor3, T eValor4, T eValor5) {

        set(eIndice, eValor1);
        set(eIndice + 1, eValor2);
        set(eIndice + 2, eValor3);
        set(eIndice + 3, eValor4);
        set(eIndice + 4, eValor5);

    }

    public void aumentar(int eMais, T eInicial) {

        if (eMais <= 0) {
            throw new IllegalArgumentException("O aumento precisa ser um numero maior que 0 : " + eMais);
        }

        int eNovaCapacidade = mCapacidade + eMais;
        T mDadosMais[] = (T[]) new Object[eNovaCapacidade];

        for (int i = 0; i < mCapacidade; i++) {
            mDadosMais[i] = mDados[i];
        }

        for (int i = mCapacidade; i < eNovaCapacidade; i++) {
            mDadosMais[i] = eInicial;
        }

        mDados = mDadosMais;
        mCapacidade = eNovaCapacidade;

    }

    public void reduzir(int eMenos) {

        if (eMenos <= 0) {
            throw new IllegalArgumentException("A reducao precisa ser um numero maior que 0 : " + eMenos);
        }

        int eNovaCapacidade = mCapacidade - eMenos;
        if (eNovaCapacidade <= 0) {
            throw new IllegalArgumentException("Essa reducao nao pode acontecer que o tamanho ficara ficara : " + eNovaCapacidade);
        }

        T mDadosMenos[] = (T[]) new Object[eNovaCapacidade];

        for (int i = 0; i < eNovaCapacidade; i++) {
            mDadosMenos[i] = mDados[i];
        }

        mDados = mDadosMenos;
        mCapacidade = eNovaCapacidade;

    }


    public void trocar(int i1, int i2) {

        T auxiliar = mDados[i1];

        mDados[i1] = mDados[i2];
        mDados[i2] = auxiliar;

    }


    public void ordenarCrescente(Ordenador<T> mOrdenador) {

        int tam = mCapacidade;

        for(int i = 0; i<tam; i++){
            for(int j = 0; j<tam-1; j++){
                if (mOrdenador.isMaior(get(j),get(j+1))){

                    trocar(j,j+1);
                }
            }
        }


    }

    public void ordenarDecrescente(Ordenador<T> mOrdenador) {

        int tam = mCapacidade;

        for(int i = 0; i<tam; i++){
            for(int j = 0; j<tam-1; j++){
                if (mOrdenador.isMenor(get(j),get(j+1))){

                    trocar(j,j+1);
                }
            }
        }


    }

}
