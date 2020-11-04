package Recursos;

import java.awt.*;

public class Recursos {

    private Color eCorTituloCaixa;

    private Color eAmareloEscuro;
    private Color eAmareloClaro;

    private Color eVerdeEscuro;
    private Color eVerdeClaro;

    private Color eVermelhoEscuro;
    private Color eVermelhoClaro;
    private Color eCinza;

    public Color getColorHexa(String colorStr) {
        return new Color(
                Integer.valueOf(colorStr.substring(1, 3), 16),
                Integer.valueOf(colorStr.substring(3, 5), 16),
                Integer.valueOf(colorStr.substring(5, 7), 16));
    }

    public void lista_criar(String eLocal) {


        RecursoLista mRecursoLista = new RecursoLista(1500, 5000);

        Color eCorTituloCaixa = getColorHexa("#FFC600");

         eAmareloEscuro = getColorHexa("#c8b900");
         eAmareloClaro = getColorHexa("#ffff72");

         eVerdeEscuro = getColorHexa("#387002");
         eVerdeClaro = getColorHexa("#99d066");

         eVermelhoEscuro = getColorHexa("#ac0800");
         eVermelhoClaro = getColorHexa("#ff7d47");
         eCinza = getColorHexa("#4b636e");


        mRecursoLista.criarTitulo("LISTA", eCorTituloCaixa);

        mRecursoLista.pular(300);

        lista_vazia(mRecursoLista);

        lista_um(mRecursoLista);

        lista_dois(mRecursoLista);

        lista_tres(mRecursoLista);

        lista_quatro(mRecursoLista);

        lista_completa(mRecursoLista);

        mRecursoLista.exportar(eLocal);

    }

    public void lista_vazia(RecursoLista mRecursoLista) {

        Ponto eLista = mRecursoLista.criarLista(eAmareloEscuro, eAmareloClaro, eVermelhoEscuro, eVermelhoClaro);

        mRecursoLista.pular(700);

    }

    public void lista_um(RecursoLista mRecursoLista) {

        Ponto eLista = mRecursoLista.criarLista(eAmareloEscuro, eAmareloClaro, eVermelhoEscuro, eVermelhoClaro);

        Ponto e0 = mRecursoLista.criarItem(eLista, "10", eVerdeEscuro, eVerdeClaro, eVermelhoEscuro, eVermelhoClaro);


        mRecursoLista.ligarInicio(e0, eCinza);
        mRecursoLista.ligarFim(e0, eCinza);

        mRecursoLista.pular(700);

    }

    public void lista_dois(RecursoLista mRecursoLista) {

        Ponto eLista = mRecursoLista.criarLista(eAmareloEscuro, eAmareloClaro, eVermelhoEscuro, eVermelhoClaro);

        Ponto e0 = mRecursoLista.criarItem(eLista, "10", eVerdeEscuro, eVerdeClaro, eVermelhoEscuro, eVermelhoClaro);
        Ponto e1 = mRecursoLista.criarItem(eLista, "20", eVerdeEscuro, eVerdeClaro, eVermelhoEscuro, eVermelhoClaro);


        mRecursoLista.ligarProximo(e0, eCinza);

        mRecursoLista.ligarAnterior(e1, eCinza);

        mRecursoLista.ligarInicio(e0, eCinza);
        mRecursoLista.ligarFim(e1, eCinza);

        mRecursoLista.pular(700);

    }

    public void lista_tres(RecursoLista mRecursoLista) {

        Ponto eLista = mRecursoLista.criarLista(eAmareloEscuro, eAmareloClaro, eVermelhoEscuro, eVermelhoClaro);

        Ponto e0 = mRecursoLista.criarItem(eLista, "10", eVerdeEscuro, eVerdeClaro, eVermelhoEscuro, eVermelhoClaro);
        Ponto e1 = mRecursoLista.criarItem(eLista, "20", eVerdeEscuro, eVerdeClaro, eVermelhoEscuro, eVermelhoClaro);
        Ponto e2 = mRecursoLista.criarItem(eLista, "30", eVerdeEscuro, eVerdeClaro, eVermelhoEscuro, eVermelhoClaro);


        mRecursoLista.ligarProximo(e0, eCinza);
        mRecursoLista.ligarProximo(e1, eCinza);

        mRecursoLista.ligarAnterior(e1, eCinza);
        mRecursoLista.ligarAnterior(e2, eCinza);

        mRecursoLista.ligarInicio(e0, eCinza);
        mRecursoLista.ligarFim(e2, eCinza);

        mRecursoLista.pular(700);

    }

    public void lista_quatro(RecursoLista mRecursoLista) {

        Ponto eLista = mRecursoLista.criarLista(eAmareloEscuro, eAmareloClaro, eVermelhoEscuro, eVermelhoClaro);

        Ponto e0 = mRecursoLista.criarItem(eLista, "10", eVerdeEscuro, eVerdeClaro, eVermelhoEscuro, eVermelhoClaro);
        Ponto e1 = mRecursoLista.criarItem(eLista, "20", eVerdeEscuro, eVerdeClaro, eVermelhoEscuro, eVermelhoClaro);
        Ponto e2 = mRecursoLista.criarItem(eLista, "30", eVerdeEscuro, eVerdeClaro, eVermelhoEscuro, eVermelhoClaro);
        Ponto e3 = mRecursoLista.criarItem(eLista, "40", eVerdeEscuro, eVerdeClaro, eVermelhoEscuro, eVermelhoClaro);


        mRecursoLista.ligarProximo(e0, eCinza);
        mRecursoLista.ligarProximo(e1, eCinza);
        mRecursoLista.ligarProximo(e2, eCinza);

        mRecursoLista.ligarAnterior(e1, eCinza);
        mRecursoLista.ligarAnterior(e2, eCinza);
        mRecursoLista.ligarAnterior(e3, eCinza);

        mRecursoLista.ligarInicio(e0, eCinza);
        mRecursoLista.ligarFim(e3, eCinza);

        mRecursoLista.pular(700);

    }


    public void lista_completa(RecursoLista mRecursoLista) {

        Ponto eLista = mRecursoLista.criarLista(eAmareloEscuro, eAmareloClaro, eVermelhoEscuro, eVermelhoClaro);

        Ponto e0 = mRecursoLista.criarItem(eLista, "10", eVerdeEscuro, eVerdeClaro, eVermelhoEscuro, eVermelhoClaro);
        Ponto e1 = mRecursoLista.criarItem(eLista, "20", eVerdeEscuro, eVerdeClaro, eVermelhoEscuro, eVermelhoClaro);
        Ponto e2 = mRecursoLista.criarItem(eLista, "30", eVerdeEscuro, eVerdeClaro, eVermelhoEscuro, eVermelhoClaro);
        Ponto e3 = mRecursoLista.criarItem(eLista, "40", eVerdeEscuro, eVerdeClaro, eVermelhoEscuro, eVermelhoClaro);
        Ponto e4 = mRecursoLista.criarItem(eLista, "50", eVerdeEscuro, eVerdeClaro, eVermelhoEscuro, eVermelhoClaro);


        mRecursoLista.ligarProximo(e0, eCinza);
        mRecursoLista.ligarProximo(e1, eCinza);
        mRecursoLista.ligarProximo(e2, eCinza);
        mRecursoLista.ligarProximo(e3, eCinza);

        mRecursoLista.ligarAnterior(e1, eCinza);
        mRecursoLista.ligarAnterior(e2, eCinza);
        mRecursoLista.ligarAnterior(e3, eCinza);
        mRecursoLista.ligarAnterior(e4, eCinza);

        mRecursoLista.ligarInicio(e0, eCinza);
        mRecursoLista.ligarFim(e4, eCinza);

        mRecursoLista.pular(700);

    }

}
