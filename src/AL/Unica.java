package AL;

public class Unica<T, C extends Comparador<T>> {

    private class Item {

        private T mValor;
        private Item mProximo;

        public Item(T eValor) {
            mValor = eValor;
            mProximo = null;
        }

        public void setValor(T eValor) {
            this.mValor = eValor;
        }

        public T getValor() {
            return this.mValor;
        }

        public void setProximo(Item eProximo) {
            this.mProximo = eProximo;
        }

        public Item getProximo() {
            return this.mProximo;
        }

    }

    private Item mPrimeiro;
    private Item mUltimo;
    private int mQuantidade;

    private C mComparador;

    public Unica(C eComparador) {

        mPrimeiro = null;
        mUltimo = null;
        mQuantidade = 0;

        mComparador = eComparador;

        //System.out.println("Construindo Lista");
    }

    public void adicionar(T eValor) {

        boolean adicionando = false;


        adicionando = true;


        if (adicionando) {


            Item mCorrente = mPrimeiro;

            boolean existe = false;

            while (mCorrente != null) {
                if (mComparador.isIgual(mCorrente.getValor(), eValor)) {
                    existe = true;
                }
                mCorrente = mCorrente.getProximo();
            }

            if (!existe){


                Item mAdicionar = new Item(eValor);

                if (mPrimeiro == null) {

                    mPrimeiro = mAdicionar;

                } else {

                    mUltimo.setProximo(mAdicionar);
                }

                mUltimo = mAdicionar;

                //System.out.println("Adicionando " + eValor);
                mQuantidade += 1;

            }



        }


    }

    public int getQuantidade() {
        return mQuantidade;
    }

    public void remover(T eValor) {

        if (mPrimeiro != null) {

            Item mAnterior = null;
            Item mCorrente = mPrimeiro;

            while (mCorrente != null) {

                if (mCorrente.getValor() == eValor) {

                    mQuantidade -= 1;
                    //	System.out.println("Removendo " + eValor);

                    if (mAnterior == null) {

                        if (mPrimeiro.getProximo() != null) {
                            mPrimeiro = mPrimeiro.getProximo();
                        } else {
                            mPrimeiro = null;
                            mUltimo = null;
                        }

                    } else {

                        if (mCorrente.getProximo() == null) {
                            mUltimo = mAnterior;
                            mAnterior.setProximo(null);
                            mCorrente = null;
                        } else {

                            mAnterior.setProximo(mCorrente.getProximo());
                            mCorrente = null;
                        }

                    }

                    break;
                }

                mAnterior = mCorrente;
                mCorrente = mCorrente.getProximo();
            }

        }

    }

    public void removerIndex(int eIndex) {

        int mIndex = 0;
        boolean mRemovido = false;

        if (mPrimeiro != null) {

            Item mAnterior = null;
            Item mCorrente = mPrimeiro;

            while (mCorrente != null) {

                if (eIndex == mIndex) {

                    if (mAnterior == null) {

                        if (mPrimeiro.getProximo() != null) {
                            mPrimeiro = mPrimeiro.getProximo();
                        } else {
                            mPrimeiro = null;
                            mUltimo = null;
                        }

                    } else {

                        if (mCorrente.getProximo() == null) {
                            mUltimo = mAnterior;
                            mAnterior.setProximo(null);
                            mCorrente = null;
                        } else {

                            mAnterior.setProximo(mCorrente.getProximo());
                            mCorrente = null;
                        }

                    }
                    mRemovido = true;
                    mQuantidade -= 1;

                    break;
                }

                mAnterior = mCorrente;
                mCorrente = mCorrente.getProximo();
                mIndex += 1;
            }

        }

        if (!mRemovido) {
            throw new IllegalArgumentException("Indice invalido : " + mIndex);
        }

    }


    public void listarSemIndice() {

        Item mCorrente = mPrimeiro;

        while (mCorrente != null) {
            System.out.println(" ->> " + mCorrente.getValor());
            mCorrente = mCorrente.getProximo();
        }

    }

    public void listarComIndice() {

        int indice = 0;

        Item mCorrente = mPrimeiro;
        while (mCorrente != null) {

            System.out.println(" " + indice + " ->> " + mCorrente.getValor());

            mCorrente = mCorrente.getProximo();
            indice += 1;
        }
    }

    public T getValor(int indice) {

        if (indice >= 0) {

            int indicecontagem = 0;
            Item mCorrente = mPrimeiro;
            while (mCorrente != null) {

                if (indice == indicecontagem) {
                    return mCorrente.getValor();
                }

                indicecontagem += 1;
                mCorrente = mCorrente.getProximo();
            }

            throw new IllegalArgumentException("Indice invalido : " + indice);

        } else {

            throw new IllegalArgumentException("Indice invalido : " + indice);
        }

    }

    public void setValor(int indice, T eValor) {

        if (indice >= 0) {

            int indicecontagem = 0;
            Item mCorrente = mPrimeiro;
            boolean trocou = false;

            while (mCorrente != null) {

                if (indice == indicecontagem) {
                    mCorrente.setValor(eValor);
                    trocou = true;
                    break;
                }

                indicecontagem += 1;
                mCorrente = mCorrente.getProximo();

            }

            if (!trocou) {
                throw new IllegalArgumentException("Indice invalido : " + indice);
            }

        } else {

            throw new IllegalArgumentException("Indice invalido : " + indice);

        }

    }


    public boolean estaVazia() {

        return mQuantidade == 0;

    }

    public boolean possuiObjetos() {

        return mQuantidade > 0;
    }

    public void limpar() {
        mQuantidade = 0;
        mPrimeiro = null;
        mUltimo = null;
    }


    public int getIndexOf(T eValor) {


        boolean encontrou = false;

        Item mCorrente = mPrimeiro;

        int mIndice = 0;

        while (mCorrente != null) {

            if (mCorrente.getValor() == eValor) {
                encontrou = true;
                break;
            }


            mIndice += 1;
            mCorrente = mCorrente.getProximo();
        }

        if (encontrou == false) {
            throw new IllegalArgumentException("Valor nao encontrado : " + eValor);
        }

        return mIndice;
    }

    public boolean existe(T eValor) {

        boolean retorno = false;

        Item mCorrente = mPrimeiro;
        while (mCorrente != null) {
            if (mCorrente.getValor() == eValor) {
                retorno = true;
                break;
            }
            mCorrente = mCorrente.getProximo();
        }

        return retorno;

    }

    public int contar(T eValor) {

        int retorno = 0;


        Item mCorrente = mPrimeiro;

        while (mCorrente != null) {
            if (mCorrente.getValor() == eValor) {
                retorno += 1;
            }
            mCorrente = mCorrente.getProximo();
        }

        return retorno;
    }


}
