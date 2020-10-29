package App;

import AL.Iterador;
import AL.Lista;
import AL.Vetor;

public class App {

    public static void main(String args[]) {


        System.out.println("\n ALGORITMOS \n");


        System.out.println("\t LISTA");

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



        System.out.println("\n\t VETOR");



        Vetor<Integer> vetor_Inteiros = new Vetor<Integer>(5, 0);

        Iterador<Integer> mIteradorVetor = new Iterador<Integer>(vetor_Inteiros);

        System.out.println("\t\t Itens");
        for(mIteradorVetor.iniciar();mIteradorVetor.continuar();mIteradorVetor.proximo()){
            System.out.println("\t\t\t - " + mIteradorVetor.getIndice() + " : " + mIteradorVetor.getValor());
        }

        System.out.println("\t\t Vetor - Capacidade : " + vetor_Inteiros.getCapacidade());


    }


}
