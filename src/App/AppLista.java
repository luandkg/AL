package App;

import AL.Iterador;
import AL.Lista;

public class AppLista {


    public void init(){

        System.out.println("#######################################################################################");

        System.out.println("ALGORITMO :  LISTA");

        criarLista();

        criarListaLimitada();

        listarLista();


        System.out.println("#######################################################################################");

    }


    public void criarLista(){

        System.out.println("\t LISTA :: CRIAR");

        Lista<Integer> lista_vazia = new Lista<Integer>();

        System.out.println("\t\t - Lista A = " + getLista(lista_vazia));
        System.out.println("\t\t\t - Vazia : " + lista_vazia.estaVazia());
        System.out.println("\t\t\t - Quantidade : " + lista_vazia.getQuantidade());

        Lista<Integer> lista_naovazia = new Lista<Integer>();

        lista_naovazia.adicionar(10);
        lista_naovazia.adicionar(15);
        lista_naovazia.adicionar(20);

        System.out.println("\t\t - Lista B = " + getLista(lista_naovazia));
        System.out.println("\t\t\t - Vazia : " + lista_naovazia.estaVazia());
        System.out.println("\t\t\t - Quantidade : " + lista_naovazia.getQuantidade());

    }


    public void criarListaLimitada(){

        System.out.println("\t LISTA :: LIMITAR");

        Lista<Integer> lista_vazia = new Lista<Integer>();

        System.out.println("\t\t - Lista A = " + getLista(lista_vazia));
        System.out.println("\t\t\t - Esta Limitiada : " + lista_vazia.estaLimitada());
        System.out.println("\t\t\t - Limite : " + lista_vazia.getLimite());
        System.out.println("\t\t\t - Esta Cheia : " + lista_vazia.estaCheia());

        Lista<Integer> lista_naovazia = new Lista<Integer>();

        lista_naovazia.limitar(5);

        lista_naovazia.adicionar(10);
        lista_naovazia.adicionar(15);
        lista_naovazia.adicionar(20);

        System.out.println("\t\t - Lista B = " + getLista(lista_naovazia));
        System.out.println("\t\t\t - Esta Limitiada : " + lista_naovazia.estaLimitada());
        System.out.println("\t\t\t - Limite : " + lista_naovazia.getLimite());
        System.out.println("\t\t\t - Esta Cheia : " + lista_naovazia.estaCheia());
        System.out.println("\t\t\t - Para Encher : " + lista_naovazia.completar());


        Lista<Integer> lista_cheia = new Lista<Integer>();

        lista_cheia.limitar(5);

        lista_cheia.adicionar(10);
        lista_cheia.adicionar(15);
        lista_cheia.adicionar(20);
        lista_cheia.adicionar(25);
        lista_cheia.adicionar(30);

        System.out.println("\t\t - Lista C = " + getLista(lista_cheia));
        System.out.println("\t\t\t - Esta Limitiada : " + lista_cheia.estaLimitada());
        System.out.println("\t\t\t - Limite : " + lista_cheia.getLimite());
        System.out.println("\t\t\t - Esta Cheia : " + lista_cheia.estaCheia());
        System.out.println("\t\t\t - Para Encher : " + lista_cheia.completar());


    }


    public void listarLista(){


        System.out.println("\t LISTA :: LISTAR ITENS");

        Lista<Integer> lista_Inteiros = new Lista<Integer>();

        lista_Inteiros.adicionar(10);
        lista_Inteiros.adicionar(15);
        lista_Inteiros.adicionar(20);

        Iterador<Integer> mIteradorLista = new Iterador<Integer>(lista_Inteiros);

        System.out.println("\t\t Itens");

        for(mIteradorLista.iniciar();mIteradorLista.continuar();mIteradorLista.proximo()){
            System.out.println("\t\t\t - " + mIteradorLista.getIndice() + " : " + mIteradorLista.getValor());
        }

        System.out.println("\t\t Lista - Quantidade : " + lista_Inteiros.getQuantidade());

    }


    public String getLista(Lista<Integer> mLista){
        String texto = "";

        Iterador<Integer> mIterador = new Iterador<Integer>(mLista);

        int mUltimo = mLista.getQuantidade()-1;
        int mCorrente = 0;

        for(mIterador.iniciar();mIterador.continuar();mIterador.proximo()){

            if (mCorrente==mUltimo){
                texto += " " +  mIterador.getValor();
            }else{
                texto += " " +  mIterador.getValor() + " , ";
            }

            mCorrente+=1;
        }

        return " { " + texto + " } ";
    }


}
