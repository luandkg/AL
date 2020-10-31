package App;

import AL.Iterador;
import AL.Lista;
import AL.OrdenadorInt;
import AL.Vetor;

public class AppLista {


    public void init(){

        System.out.println("#######################################################################################");

        System.out.println("ALGORITMO :  LISTA");

        criarLista();

        criarListaLimitada();

        listarLista();

        trocarLista();

        ordenarLista();


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


    public void trocarLista() {

        System.out.println("\t LISTA :: TROCAR");


        Lista<Integer> lista_A = new Lista<Integer>();

        lista_A.adicionar(10);
        lista_A.adicionar(20);
        lista_A.adicionar(30);
        lista_A.adicionar(40);
        lista_A.adicionar(50);

        System.out.println("\t\t - Lista A = " + getLista(lista_A));

        System.out.println("\t\t\t - Trocar 0 e 1");
        lista_A.trocar(0, 1);
        System.out.println("\t\t\t - Lista A = " + getLista(lista_A));

        System.out.println("\t\t\t - Trocar 4 e 3");
        lista_A.trocar(4, 3);
        System.out.println("\t\t\t - Lista A = " + getLista(lista_A));



        System.out.println("\t\t\t - Quantidade : " + lista_A.getQuantidade());


    }


    public void ordenarLista() {

        System.out.println("\t LISTA :: ORDENAR");


        Lista<Integer> lista_A = new Lista<Integer>();

        lista_A.adicionar(40);
        lista_A.adicionar(20);
        lista_A.adicionar(50);
        lista_A.adicionar(10);
        lista_A.adicionar(30);

        System.out.println("\t\t - Lista A = " + getLista(lista_A));

        System.out.println("\t\t\t - Ordenar Crescente");

        lista_A.ordenarCrescente(new OrdenadorInt());

        System.out.println("\t\t\t - Lista A = " + getLista(lista_A));

        System.out.println("\t\t\t - Embaralhar");
        lista_A.embaralhar();

        System.out.println("\t\t\t - Lista A = " + getLista(lista_A));


        System.out.println("\t\t\t - Ordenar Decrescente");

        lista_A.ordenarDecrescente(new OrdenadorInt());

        System.out.println("\t\t\t - Lista A = " + getLista(lista_A));


        System.out.println("\t\t\t - Quantidade : " + lista_A.getQuantidade());


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
