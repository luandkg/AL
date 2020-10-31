package App;

import AL.ComparadorInt;
import AL.ComparadorString;
import AL.IteradorComparavel;
import AL.Unica;

public class AppUnica {

    public void init(){

        System.out.println("#######################################################################################");

        System.out.println("ALGORITMO :  UNICA");

        criarUnica();

        System.out.println("#######################################################################################");

    }

    public void criarUnica(){

        System.out.println("\t UNICA :: CRIAR");

        Unica<Integer, ComparadorInt> lista_vazia = new Unica<Integer, ComparadorInt>( new ComparadorInt());

        System.out.println("\t\t - Unica A = Tentando { } ");
        System.out.println("\t\t\t - Conteudo : " + getUnica(lista_vazia));
        System.out.println("\t\t\t - Vazia : " + lista_vazia.estaVazia());
        System.out.println("\t\t\t - Quantidade : " + lista_vazia.getQuantidade());

        Unica<Integer,ComparadorInt> lista_naovazia = new Unica<Integer,ComparadorInt>(new ComparadorInt());

        lista_naovazia.adicionar(10);
        lista_naovazia.adicionar(10);
        lista_naovazia.adicionar(20);

        System.out.println("\t\t - Unica B = Tentando { 10 , 10 , 20 } ");
        System.out.println("\t\t\t - Conteudo : " + getUnica(lista_naovazia));
        System.out.println("\t\t\t - Vazia : " + lista_naovazia.estaVazia());
        System.out.println("\t\t\t - Quantidade : " + lista_naovazia.getQuantidade());


        Unica<Integer,ComparadorInt> unica_3 = new Unica<Integer,ComparadorInt>(new ComparadorInt());

        unica_3.adicionar(10);
        unica_3.adicionar(20);
        unica_3.adicionar(20);
        unica_3.adicionar(30);
        unica_3.adicionar(40);
        unica_3.adicionar(20);

        System.out.println("\t\t - Unica C = Tentando { 10 , 20 , 20 , 30 , 40 , 20 } ");
        System.out.println("\t\t\t - Conteudo : " + getUnica(unica_3));
        System.out.println("\t\t\t - Vazia : " + unica_3.estaVazia());
        System.out.println("\t\t\t - Quantidade : " + unica_3.getQuantidade());

        Unica<String,ComparadorString> unica_4 = new Unica<String,ComparadorString>(new ComparadorString());

        unica_4.adicionar("A");
        unica_4.adicionar("B");
        unica_4.adicionar("A");
        unica_4.adicionar("B");
        unica_4.adicionar("A");
        unica_4.adicionar("C");

        System.out.println("\t\t - Unica D = Tentando { A , B , A , B , A , C } ");
        System.out.println("\t\t\t - Conteudo : " + getUnicaString(unica_4));
        System.out.println("\t\t\t - Vazia : " + unica_4.estaVazia());
        System.out.println("\t\t\t - Quantidade : " + unica_4.getQuantidade());



    }


    public String getUnica(Unica<Integer,ComparadorInt> mUnica){
        String texto = "";

        IteradorComparavel<Integer,ComparadorInt> mIterador = new IteradorComparavel<Integer,ComparadorInt>(mUnica);

        int mUltimo = mUnica.getQuantidade()-1;
        int mCorrente = 0;

        for(mIterador.iniciar();mIterador.continuar();mIterador.proximo()){

            if (mCorrente==mUltimo){
                texto += " " +  mIterador.getValor();
            }else{
                texto += " " +  mIterador.getValor() + " , ";
            }

            mCorrente+=1;
        }

        return " {" + texto + " } ";
    }

    public String getUnicaString(Unica<String, ComparadorString> mUnica){
        String texto = "";

        IteradorComparavel<String,ComparadorString> mIterador = new IteradorComparavel<String,ComparadorString>(mUnica);

        int mUltimo = mUnica.getQuantidade()-1;
        int mCorrente = 0;

        for(mIterador.iniciar();mIterador.continuar();mIterador.proximo()){

            if (mCorrente==mUltimo){
                texto += " " +  mIterador.getValor();
            }else{
                texto += " " +  mIterador.getValor() + " , ";
            }

            mCorrente+=1;
        }

        return " {" + texto + " } ";
    }

}
