package App;


public class App {

    public static void main(String args[]) {


        System.out.println("\n ALGORITMOS \n");


        AppVetor mAppVetor = new AppVetor();
        mAppVetor.init();


        AppLista mAppLista = new AppLista();
        mAppLista.init();

        AppProtetor mAppProtetor = new AppProtetor();
        mAppProtetor.init();


        AppUnica mAppUnica = new AppUnica();
        mAppUnica.init();


        AppRecursos mRecursos = new AppRecursos();
        mRecursos.init("res/");

    }


}
