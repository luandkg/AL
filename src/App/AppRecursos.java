package App;

import Recursos.Recursos;

public class AppRecursos {

    public void init(String eLocal) {

        System.out.println("");
        System.out.println("################ RECURSOS ################");
        System.out.println("");
        System.out.println("\t - Local : " + eLocal);
        System.out.println("");

        Recursos mRecursos = new Recursos();


        mRecursos.lista_criar(eLocal + "lista.png");
        System.out.println("\t" + getEspacado(" - LISTA", 30, " : OK"));

    }


    public String getEspacado(String eAntes, int tamanho, String eDepois) {

        String eFrase = eAntes;

        while (eFrase.length() < tamanho) {
            eFrase += " ";
        }

        eFrase +=eDepois;

        return eFrase;
    }


}
