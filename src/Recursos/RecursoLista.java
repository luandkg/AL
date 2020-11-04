package Recursos;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RecursoLista {

    private int mCaixaGrandeAltura;
    private int mCaixaMediaAltura;
    private int mCaixaMediaPequena;

    private int mTamanho_Grande;
    private int mTamanho_Medio;
    private int mTamanho_Pequena;

    private int mAposGrande;
    private int mAposMedio;
    private int mAposPequena;

    private Font eFonte_TituloGrande;
    private Font eFonte_Media;
    private Font eFonte_Pequena;

    private int mIMAGEM_LARGURA;
    private int mIMAGEM_ALTURA;
    private Color eFundo;


    private BufferedImage img;
    private Graphics g;

    private int ALTURANDO;

    private int eInicioX;
    private int eInicioSubX;

    private int eCaixa;
    private int eCaixaPequena;

    private int mY;

    private int mItemX;
    private int mItemY;

    private Ponto mInicio;
    private Ponto mFim;

    public RecursoLista(int eLargura, int eAltura) {


        mTamanho_Grande = 50;
        mTamanho_Medio = 30;
        mTamanho_Pequena = 20;


        eFonte_TituloGrande = new Font("TimesRoman", Font.BOLD, mTamanho_Grande);
        eFonte_Media = new Font("TimesRoman", Font.BOLD, mTamanho_Medio);
        eFonte_Pequena = new Font("TimesRoman", Font.BOLD, mTamanho_Medio);

        mCaixaGrandeAltura = (mTamanho_Grande * 2) + 20;
        mCaixaMediaAltura = (mTamanho_Medio * 2) + 20;
        mCaixaMediaPequena = (mTamanho_Pequena * 2) + 20;

        mAposGrande = mTamanho_Grande + 20;
        mAposMedio = mTamanho_Medio + 20;
        mAposPequena = mTamanho_Pequena + 20;

        eFundo = Color.WHITE;


        mIMAGEM_LARGURA = eLargura;
        mIMAGEM_ALTURA = eAltura;


        img = new BufferedImage(mIMAGEM_LARGURA, mIMAGEM_ALTURA, BufferedImage.TYPE_INT_ARGB);
        g = img.getGraphics();

        g.setColor(eFundo);
        g.fillRect(0, 0, mIMAGEM_LARGURA, mIMAGEM_ALTURA);

        eInicioX = 250;
        eInicioSubX = 450;

        eCaixa = 700;
        eCaixaPequena = 450;


        ALTURANDO = 0;
        mY = 0;
        mItemX = 0;
        mItemY = 0;

    }

    public void criarTitulo(String eNome, Color eCor) {

        criarCaixaTituloGrande(g, 0, ALTURANDO, mIMAGEM_LARGURA, eCor);
        tituloGrande(g, 0, ALTURANDO, mIMAGEM_LARGURA, eNome);


    }

    public void pular(int eY) {

        mY += eY;

    }

    public Ponto criarLista(Color eCorEscura, Color eCorClara, Color eEspecialEscuro, Color eEspecialClaro) {

        int eY = mY;
        int eX = 100;

        int eMargem = 10;

        int eLargura = 1200;
        int eAltura = 600;

        g.setColor(eCorEscura);
        g.fillRect(eX, mY, eLargura, eAltura);

        g.setColor(eCorClara);
        g.fillRect(eX + eMargem, mY + eMargem, eLargura - (2 * eMargem), eAltura - (2 * eMargem));

        g.setColor(eEspecialEscuro);
        g.fillRect(eX + eMargem, eY + eMargem, 150, 150);
        g.setColor(eEspecialClaro);
        g.fillRect(eX + eMargem + eMargem, eY + eMargem + eMargem, 150 - (2 * eMargem), 150 - (2 * eMargem));

        tituloPequeno(g, eX + eMargem, eY + eMargem, 150, 150, "Início");

        mInicio = new Ponto(eX, eY + eMargem);


        int yFim = (eY + eAltura) - 150 - eMargem;

        g.setColor(eEspecialEscuro);
        g.fillRect(eX + eMargem, yFim, 150, 150);
        g.setColor(eEspecialClaro);
        g.fillRect(eX + eMargem + eMargem, yFim + eMargem, 150 - (2 * eMargem), 150 - (2 * eMargem));

        tituloPequeno(g, eX + eMargem, yFim, 150, 150, "Fim");

        mFim = new Ponto(eX, yFim);

        mItemX = 200;
        mItemY = 100;


        return new Ponto(eX, eY);

    }

    public Ponto criarItem(Ponto eLista, String eNome, Color eCorEscura, Color eCorClara, Color eCorEscura2, Color eCorClara2) {


        int eY = eLista.getY() + 150;
        int eX = eLista.getX() + mItemX + 50;

        int eMargem = 10;

        int eLargura = 120;
        int eAltura = 300;

        g.setColor(eCorEscura);
        g.fillRect(eX, eY, eLargura, eAltura);

        g.setColor(eCorClara);
        g.fillRect(eX + eMargem, eY + eMargem, eLargura - (2 * eMargem), eAltura - (2 * eMargem));

        tituloPequeno(g, eX, eY, eLargura, eAltura - 30, eNome);

        int ex2 = eX + eMargem;
        int ey2 = eY + eMargem;

        int eMenorAltura = 50;

        g.setColor(eCorEscura2);
        g.fillRect(ex2, ey2, eLargura - (2 * eMargem), eMenorAltura);
        g.setColor(eCorClara2);
        g.fillRect(ex2 + eMargem, ey2 + eMargem, eLargura - (4 * eMargem), eMenorAltura - (2 * eMargem));

        int ey3 = eY + eMargem + eAltura - eMargem - 50 - eMargem;
        g.setColor(eCorEscura2);
        g.fillRect(ex2, ey3, eLargura - (2 * eMargem), eMenorAltura);
        g.setColor(eCorClara2);
        g.fillRect(ex2 + eMargem, ey3 + eMargem, eLargura - (4 * eMargem), eMenorAltura - (2 * eMargem));


        mItemX += 180;

        return new Ponto(eX, eY + eMargem);

    }

    public void ligarInicio(Ponto eItem, Color eCor) {

        int eLargura = eItem.getX() - mInicio.getX() - 150 + (120 / 2);

        int eAltura = eItem.getY() - mInicio.getY() - (150 / 2);

        g.setColor(eCor);
        g.fillRect(mInicio.getX() + 150 + 10, mInicio.getY() + (150 / 2), eLargura, 10);

        g.fillRect(mInicio.getX() + 150 + 10 + eLargura - 10, mInicio.getY() + (150 / 2), 10, eAltura);


    }

    public void ligarFim(Ponto eItem, Color eCor) {

        int eLargura = eItem.getX() - mFim.getX() - 150 + (120 / 2);

        int eAltura = (mFim.getY() + 150) - (eItem.getY() + 300) - (150 / 2) + 10;

        g.setColor(eCor);
        g.fillRect(mFim.getX() + 150 + 10, mFim.getY() + (150 / 2), eLargura, 10);

        g.fillRect(mFim.getX() + 150 + eLargura, mFim.getY() + 10, 10, eAltura);

        System.out.println("Altura : " + eAltura);
        System.out.println("Y : " + mFim.getY());

    }

    public void ligarProximo(Ponto eInicio, Color eCor) {


        g.setColor(eCor);

        int ex = eInicio.getX() + 120;
        int ey = eInicio.getY()+20;

        g.fillRect(ex, ey, 25, 10);

        // SETA DIREITA

        int seta_x = ex +5 + 25 ;
        int seta_y = ey - 5;
        int seta_largura = 25;
        int seta_altura = 20;


        Polygon triangle = new Polygon();
        triangle.addPoint(seta_x, seta_y);
        triangle.addPoint(seta_x, seta_y + seta_altura);

        triangle.addPoint(seta_x + seta_largura, seta_y + (seta_altura / 2));

        g.fillPolygon(triangle);

    }


    public void ligarAnterior(Ponto eInicio, Color eCor) {


        g.setColor(eCor);

        int ex = eInicio.getX() - 20 ;
        int ey = eInicio.getY() + 300  - 50;

        g.fillRect(ex, ey, 25, 10);

        // SETA ESQUERDA

        int seta_x = ex +5 - 10 ;
        int seta_y = ey - 5;
        int seta_largura = 25;
        int seta_altura = 20;


        Polygon triangle = new Polygon();
        triangle.addPoint(seta_x, seta_y);
        triangle.addPoint(seta_x, seta_y + seta_altura);

        triangle.addPoint(seta_x - seta_largura, seta_y + (seta_altura / 2));

        g.fillPolygon(triangle);

    }

    public void exportar(String eArquivo) {

        try {
            ImageIO.write(img, "png", new File(eArquivo));
        } catch (IOException e) {

        }

    }


    public int criarCaixaTituloGrande(Graphics g, int x, int mais, int iLargura, Color eCor) {

        g.setColor(eCor);
        g.fillRect(x, mais, iLargura, mCaixaGrandeAltura);

        return mais;
    }

    public int criarCaixaMedia(Graphics g, int x, int mais, int iLargura, Color eCor) {

        g.setColor(eCor);
        g.fillRect(x, mais, iLargura, mCaixaMediaAltura);

        return mais;
    }

    public int criarCaixaPequena(Graphics g, int x, int mais, int iLargura, Color eCor) {

        g.setColor(eCor);
        g.fillRect(x, mais, iLargura, mCaixaMediaPequena);

        return mais;
    }

    public void criarFundo(Graphics g, Color eCor, int x, int mais, int iLargura, int iAltura) {

        g.setColor(eCor);
        g.fillRect(x, mais, iLargura, iAltura);

    }


    public void criarConexao(int x, int ey1, int ey2, Color eCor) {


        g.setColor(eCor);
        g.fillRect(x, ey1, 10, ey2 - ey1);

        g.fillRect(x + 10, ey1, 30, 10);
        g.fillRect(x + 10, ey2 - 10, 30, 10);

        // SETA DIREITA

        int seta_x = x + 10 + 30 + 10;
        int seta_y = ey1 - 5;
        int seta_largura = 25;
        int seta_altura = 20;


        Polygon triangle = new Polygon();
        triangle.addPoint(seta_x, seta_y);
        triangle.addPoint(seta_x, seta_y + seta_altura);

        triangle.addPoint(seta_x + seta_largura, seta_y + (seta_altura / 2));

        g.fillPolygon(triangle);

    }

    public void criarDescida(int x, int ey1, int ey2, Color eCor) {


        g.setColor(eCor);
        g.fillRect(x, ey1, 10, ey2 - ey1);


        // SETA ABAIXO

        int seta_x = x - 8;
        int seta_y = ey2 + 5;
        int seta_largura = 25;
        int seta_altura = 20;


        Polygon triangle = new Polygon();
        triangle.addPoint(seta_x, seta_y);
        triangle.addPoint(seta_x + seta_largura, seta_y);

        triangle.addPoint(seta_x + (seta_largura / 2), seta_y + (seta_altura));

        g.fillPolygon(triangle);

    }

    public int tituloGrande(Graphics g, int x, int mais, int iLargura, String eTitulo) {

        Rectangle r = new Rectangle(x, mais, iLargura, mCaixaGrandeAltura);


        FontRenderContext frc =
                new FontRenderContext(null, true, true);

        Rectangle2D r2D = eFonte_TituloGrande.getStringBounds(eTitulo, frc);
        int rWidth = (int) Math.round(r2D.getWidth());
        int rHeight = (int) Math.round(r2D.getHeight());
        int rX = (int) Math.round(r2D.getX());
        int rY = (int) Math.round(r2D.getY());

        int a = (r.width / 2) - (rWidth / 2) - rX;
        int b = (r.height / 2) - (rHeight / 2) - rY;
        g.setColor(Color.BLACK);

        g.setFont(eFonte_TituloGrande);
        g.drawString(eTitulo, r.x + a, r.y + b);

        mais += mAposGrande;
        return mais;

    }

    public int tituloMedio(Graphics g, int x, int mais, int iLargura, String eTitulo) {

        Rectangle r = new Rectangle(x, mais, iLargura, mCaixaMediaAltura);


        FontRenderContext frc =
                new FontRenderContext(null, true, true);

        Rectangle2D r2D = eFonte_Media.getStringBounds(eTitulo, frc);
        int rWidth = (int) Math.round(r2D.getWidth());
        int rHeight = (int) Math.round(r2D.getHeight());
        int rX = (int) Math.round(r2D.getX());
        int rY = (int) Math.round(r2D.getY());

        int a = (r.width / 2) - (rWidth / 2) - rX;
        int b = (r.height / 2) - (rHeight / 2) - rY;
        g.setColor(Color.BLACK);

        g.setFont(eFonte_Media);
        g.drawString(eTitulo, r.x + a, r.y + b);

        mais += mAposMedio;

        return mais;
    }


    public int tituloPequeno(Graphics g, int x, int mais, int iLargura, int iAltura, String eTitulo) {

        Rectangle r = new Rectangle(x, mais, iLargura, iAltura);


        FontRenderContext frc =
                new FontRenderContext(null, true, true);

        Rectangle2D r2D = eFonte_Pequena.getStringBounds(eTitulo, frc);
        int rWidth = (int) Math.round(r2D.getWidth());
        int rHeight = (int) Math.round(r2D.getHeight());
        int rX = (int) Math.round(r2D.getX());
        int rY = (int) Math.round(r2D.getY());

        int a = (r.width / 2) - (rWidth / 2) - rX;
        int b = (r.height / 2) - (rHeight / 2) - rY;
        g.setColor(Color.BLACK);

        g.setFont(eFonte_Pequena);
        g.drawString(eTitulo, r.x + a, r.y + b);

        mais += mAposPequena;
        return mais;

    }
}
