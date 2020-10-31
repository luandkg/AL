package AL;

import java.nio.charset.StandardCharsets;


public class Protetor {

    Chaveador mChaveador;

    public Protetor(Chaveador eChave) {

        mChaveador = eChave;

    }

    public R5Resposta guardar(String eDocumento) {

        R5Resposta mR5Resposta = new R5Resposta();

        byte[] mGuardado = eDocumento.getBytes(StandardCharsets.UTF_8);

        int mIndex = 0;
        int mTamanho = mGuardado.length;

        int mChave_Index = 0;
        int mChave_Tamanho = mChaveador.getChaveTamanho();

        int[] mChaves = new int[mChave_Tamanho];

        while (mChave_Index < mChave_Tamanho) {
            mChaves[mChave_Index] = mChaveador.getChave()[mChave_Index];
            mChave_Index += 1;
        }

        mChave_Index = 0;


        while (mIndex < mTamanho) {

            int novo = organizarByteInt(mGuardado[mIndex]) + mChaves[mChave_Index];


            mChave_Index += 1;
            if (mChave_Index == mChave_Tamanho) {
                mChave_Index = 0;
            }

            while (novo > 255) {
                novo -= 256;
            }
            while (novo < 0) {
                novo += 256;
            }

            mGuardado[mIndex] = (byte) novo;
            mIndex += 1;
        }


        mR5Resposta.validarComData(mGuardado);


        return mR5Resposta;
    }

    public R5Resposta guardar(int[] eOrigemData) {

        R5Resposta mR5Resposta = new R5Resposta();


        int mIndex = 0;
        int mTamanho = eOrigemData.length;

        int mChave_Index = 0;
        int mChave_Tamanho = mChaveador.getChaveTamanho();


        byte[] mGuardado = new byte[mTamanho];

        while (mIndex < mTamanho) {

            int novo = eOrigemData[mIndex] + mChaveador.getChave()[mChave_Index];


            mChave_Index += 1;
            if (mChave_Index == mChave_Tamanho) {
                mChave_Index = 0;
            }

            while (novo > 255) {
                novo -= 256;
            }
            while (novo < 0) {
                novo += 256;
            }

            mGuardado[mIndex] = (byte) novo;
            mIndex += 1;
        }


        mR5Resposta.validarComData(mGuardado);


        return mR5Resposta;
    }


    public R5Resposta revelar(byte[] eDados) {

        String mDecifrando = "";

        R5Resposta mR5Resposta = new R5Resposta();

        int mIndex = 0;
        int mTamanho = eDados.length;

        int mChave_Index = 0;
        int mChave_Tamanho = mChaveador.getChaveTamanho();


        byte[] dDados = new byte[mTamanho];

        while (mIndex < mTamanho) {

            if (mChave_Index == mChave_Tamanho) {
                mChave_Index = 0;
            }

            int novo = organizarByteInt(eDados[mIndex]) - mChaveador.getChave()[mChave_Index];


            mChave_Index += 1;


            while (novo < 0) {
                novo += 256;
            }
            while (novo > 255) {
                novo -= 256;
            }

            dDados[mIndex] = (byte) novo;
            mIndex += 1;
        }


        mDecifrando = new String(dDados, StandardCharsets.UTF_8);

        // System.out.println("Decifrado : " + saida);

        mR5Resposta.validarComConteudoEData(mDecifrando, dDados);


        return mR5Resposta;
    }

    public int enquadraro(int a) {

        while (a < 0) {
            a += 256;
        }

        while (a > 255) {
            a -= 255;
        }

        return a;
    }

    public int organizarByteInt(byte b) {

        if (b >= 0) {
            return (int) b;
        } else {
            return 256 + (int) b;
        }

    }
}
