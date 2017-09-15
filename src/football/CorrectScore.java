package football;

import java.util.*;

public class CorrectScore {

    double probabilityCSFT;
    double probabilityCSHT1;
    double probabilityCSHT2;

    static double lambda; // an den tis kanw static den tis blepei to eventtypes, kai etsi se ola ta sum gia correct score epistrefei miden
    static double mi;
    double percentageHT1 = 0.45;

    Scanner in = new Scanner(System.in);
    
    
    UsefulMethods importMethods = new UsefulMethods();

    public void readData() {
        //Locale.setDefault(Locale.US);
        

        System.out.print("1. Home Exp: ");
        lambda = in.useLocale(Locale.US).nextDouble();

        System.out.print("2. Away Exp: ");
        mi = in.useLocale(Locale.US).nextDouble();
    }

    public double getScoreFT(int x, int y) {

        probabilityCSFT = importMethods.poissonPDF(x, lambda) * importMethods.poissonPDF(y, mi);

        return probabilityCSFT;

    }// getScoreFT

    public double getScoreHT1(int x, int y) {

        probabilityCSHT1 = importMethods.poissonPDF(x, lambda * percentageHT1) * importMethods.poissonPDF(y, mi * percentageHT1);

        return probabilityCSHT1;

    }// getScoreFT
}
