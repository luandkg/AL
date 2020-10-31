package App;

import AL.Chaveador;
import AL.Protetor;

public class AppProtetor {



    public Chaveador getChave_Codigo() {

        Chaveador mChave = new Chaveador(10);

        mChave.setVarios(0, 5, 200, 62, 85, 23, 6, 50, 2, 19, 70);


        return mChave;
    }

    public void init() {

        System.out.println("#######################################################################################");

        System.out.println("ALGORITMO :  PROTETOR");


        Protetor mDesSegurador_Codigo = new Protetor(getChave_Codigo());

        int[] mDados = new int[256];

        for (int i = 0; i < 256; i++) {
            mDados[i] = i;
        }

        byte[] bDados = mDesSegurador_Codigo.guardar(mDados).getData();
        byte[] rDados = mDesSegurador_Codigo.revelar(bDados).getData();

        for (int i = 0; i < 256; i++) {

            System.out.println("\t " + textoInt(mDados[i],3) + " -->> " + textoInt(organizarByteInt(bDados[i]),3) + " :: " + textoInt(organizarByteInt(rDados[i]),3));

            int esperava = organizarByteInt(rDados[i]);

            if (i == esperava) {

            } else {
                System.out.println("EITA PORRA");
            }
        }

        System.out.println("#######################################################################################");

    }

    public String textoInt(int b, int casas) {

        String m = String.valueOf(b);

        while (m.length() < casas) {
            m = "0" + m;
        }


        return m;
    }


    public int organizarByteInt(byte b) {

        if (b >= 0) {
            return (int) b;
        } else {
            return 256 + (int) b;
        }

    }

}
