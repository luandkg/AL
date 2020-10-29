package App;

import AL.Iterador;
import AL.Vetor;

public class AppVetor {

    public void init(){

        System.out.println("#######################################################################################");

        System.out.println("ALGORITMO :  VETOR");

        criarVetor();


        alterarVetor();


        aumentarVetor();

        reduzirVetor();

        System.out.println("#######################################################################################");

    }


    public void criarVetor(){

        System.out.println("\t VETOR :: CRIAR");


        Vetor<Integer> vetorA = new Vetor<Integer>(3, 0);

        System.out.println("\t\t - Vetor A = " + getVetor(vetorA));
        System.out.println("\t\t\t - Capacidade : " + vetorA.getCapacidade());

        Vetor<Integer> vetorB = new Vetor<Integer>(5, 0);

        System.out.println("\t\t - Vetor B = " + getVetor(vetorB));
        System.out.println("\t\t\t - Capacidade : " + vetorB.getCapacidade());

    }

    public void alterarVetor(){

        System.out.println("\t VETOR :: ALTERAR");


        Vetor<Integer> vetorA = new Vetor<Integer>(3, 0);

        System.out.println("\t\t - Vetor A = " + getVetor(vetorA));

        System.out.println("\t\t\t - Alterar Indice 0 --> 10 ");
        vetorA.set(0,10);
        System.out.println("\t\t\t - Vetor A = " + getVetor(vetorA));

        System.out.println("\t\t\t - Alterar Indice 1 --> 20 ");
        vetorA.set(1,20);
        System.out.println("\t\t\t - Vetor A = " + getVetor(vetorA));

        System.out.println("\t\t\t - Alterar Indice 2 --> 30 ");
        vetorA.set(2,30);
        System.out.println("\t\t\t - Vetor A = " + getVetor(vetorA));

        System.out.println("\t\t\t - Capacidade : " + vetorA.getCapacidade());


    }


    public void aumentarVetor(){

        System.out.println("\t VETOR :: AUMENTAR");


        Vetor<Integer> vetorA = new Vetor<Integer>(3, 1);

        System.out.println("\t\t - Vetor A = " + getVetor(vetorA));
        System.out.println("\t\t\t - Capacidade : " + vetorA.getCapacidade());

        System.out.println("\t\t\t - Aumentar : 2 com valor 5");
        vetorA.aumentar(2,5);
        System.out.println("\t\t - Vetor A = " + getVetor(vetorA));
        System.out.println("\t\t\t - Capacidade : " + vetorA.getCapacidade());


        Vetor<Integer> vetorB = new Vetor<Integer>(5, 3);

        System.out.println("\t\t - Vetor B = " + getVetor(vetorB));
        System.out.println("\t\t\t - Capacidade : " + vetorB.getCapacidade());

        System.out.println("\t\t\t - Aumentar : 3 com valor 1");
        vetorB.aumentar(3,1);
        System.out.println("\t\t - Vetor B = " + getVetor(vetorB));
        System.out.println("\t\t\t - Capacidade : " + vetorB.getCapacidade());

        System.out.println("\t\t\t - Aumentar : 1 com valor 7");
        vetorB.aumentar(1,7);
        System.out.println("\t\t - Vetor B = " + getVetor(vetorB));
        System.out.println("\t\t\t - Capacidade : " + vetorB.getCapacidade());

    }

    public void reduzirVetor(){

        System.out.println("\t VETOR :: REDUZIR");


        Vetor<Integer> vetorA = new Vetor<Integer>(3, 1);
        vetorA.setVarios(0,1,2,3);

        System.out.println("\t\t - Vetor A = " + getVetor(vetorA));
        System.out.println("\t\t\t - Capacidade : " + vetorA.getCapacidade());

        System.out.println("\t\t\t - Reduzir : 2");
        vetorA.reduzir(2);
        System.out.println("\t\t - Vetor A = " + getVetor(vetorA));
        System.out.println("\t\t\t - Capacidade : " + vetorA.getCapacidade());


        Vetor<Integer> vetorB = new Vetor<Integer>(5, 3);
        vetorB.setVarios(0,1,2,3,4,5);

        System.out.println("\t\t - Vetor B = " + getVetor(vetorB));
        System.out.println("\t\t\t - Capacidade : " + vetorB.getCapacidade());

        System.out.println("\t\t\t - Reduzir : 3");
        vetorB.reduzir(3);
        System.out.println("\t\t - Vetor B = " + getVetor(vetorB));
        System.out.println("\t\t\t - Capacidade : " + vetorB.getCapacidade());

        System.out.println("\t\t\t - Reduzir : 1");
        vetorB.reduzir(1);
        System.out.println("\t\t - Vetor B = " + getVetor(vetorB));
        System.out.println("\t\t\t - Capacidade : " + vetorB.getCapacidade());

    }


    public String getVetor(Vetor<Integer> mVetor){
        String texto = "";

        Iterador<Integer> mIterador = new Iterador<Integer>(mVetor);

        int mUltimo = mVetor.getCapacidade()-1;
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
