package football;

/*
 * @author zagklaras
 */
public class Football {

    static boolean convertToOdds = true; // on/odd
    //static String Green = "\u001B[32m"; // Colour for terminal


    public static double probabilityToOdd(double x) {
        double myOdd;
        if (convertToOdds == true) {
            myOdd = 1 / x;
        } else {
            myOdd = x;
        }

        return myOdd;
    } // probabilityToOdd

    public static void main(String[] args) {

        CorrectScore myScore = new CorrectScore();
        EventTypes myMarkets = new EventTypes();
        //UsefulMethods myMethods = new UsefulMethods();

        // ask input
        System.out.println("Enter Initial Parameters...");
        myScore.readData();

        System.out.println("\n1. Winner 3 Way FT");
        System.out.println("-----------------------");
        System.out.printf("     Home: %.2f ", probabilityToOdd(myMarkets.winner3WayHome()));
        System.out.printf("Draw: %.2f ", probabilityToOdd(myMarkets.winner3WayDraw()));
        System.out.printf("Away: %.2f \n\n", probabilityToOdd(myMarkets.winner3WayAway()));


        //System.out.println("     Error Check: " + (myMarkets.winner3WayHome() + myMarkets.winner3WayDraw() + myMarkets.winner3WayAway()));

        System.out.println("2. Under/ Over FT");
        System.out.println("--------------------");
        for (int i = 0; i <= 4; i++) {
            System.out.printf("     Under " + i + ".5 : " + " %.2f ", probabilityToOdd(myMarkets.underOverFT2WayUnder(i + 0.5)));
            System.out.printf(" Over " + i + ".5 : " + " %.2f \n", probabilityToOdd(myMarkets.underOverFT2WayOver(i + 0.5)));
        }
        System.out.println("\n");

        System.out.println("3. Under/ Over FT Home - Away");
        System.out.println("--------------------------------");
        for (int i = 0; i <= 2; i++) {
            System.out.printf("     Under FT || Home " + i + ".5 : " + " Under" + " %.2f " + " Over" + " %.2f " + "||", probabilityToOdd(myMarkets.underOverHomeFT2WayUnder(i + 0.5)), probabilityToOdd(myMarkets.underOverHomeFT2WayOver(i + 0.5)));
            System.out.printf(" Away  " + i + ".5 : " + "Under" + " %.2f" + " Over" + " %.2f \n", probabilityToOdd(myMarkets.underOverAwayFT2WayUnder(i + 0.5)), probabilityToOdd(myMarkets.underOverAwayFT2WayOver(i + 0.5)));
        }
        System.out.println("\n");

        System.out.println("4. Both Teams to Score FT");
        System.out.println("----------------------------");
        System.out.printf("     Yes: " + " %.2f  " + "     No:" + " %.2f \n\n", probabilityToOdd(myMarkets.bothTeamsToScoreFTYes()), probabilityToOdd(myMarkets.bothTeamsToScoreFTNo()));

        System.out.println("5. First Team to Score");
        System.out.println("-------------------------");
        System.out.printf("     Home:" + " %.2f  " + "None:" + " %.2f  " + "Away:" +" %.2f  \n\n", probabilityToOdd(myMarkets.firstTeamToScoreHome()), probabilityToOdd(myMarkets.firstTeamToScoreNone()), probabilityToOdd(myMarkets.firstTeamToScoreAway()));


        System.out.println("6. Margin Of Victory FT");
        System.out.println("---------------------------");
        for (int i = 1; i <= 5; i++) {
            System.out.printf("     Home: +" + i + " " + " %.2f" + " || Away: +" + i + " " + " %.2f ", probabilityToOdd(myMarkets.marginOfVictoryFTHome(i)),probabilityToOdd(myMarkets.marginOfVictoryFTAway(i)));
        }
        System.out.println("\n");




        System.out.println("--------------------------------------------------------------------------------------------------------");
        /* ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */


        System.out.println("7. Winner 3 Way HT1");
        System.out.println("----------------------");
        System.out.printf("     Home: %.2f ", probabilityToOdd(myMarkets.winner3WayHomeHT1()));
        System.out.printf("Draw: %.2f ", probabilityToOdd(myMarkets.winner3WayDrawHT1()));
        System.out.printf("Away: %.2f \n\n", probabilityToOdd(myMarkets.winner3WayAwayHT1()));

        //System.out.println("     Error Check: " + (myMarkets.winner3WayHome() + myMarkets.winner3WayDraw() + myMarkets.winner3WayAway()));

        System.out.println("8. Under/ Over HT1");
        System.out.println("---------------------");
        for (int i = 0; i <= 2; i++) {
            System.out.printf("     Under " + i + ".5 : " + " %.2f ", probabilityToOdd(myMarkets.underOverHT12WayUnder(i + 0.5)));
            System.out.printf(" Over " + i + ".5 : " + " %.2f \n", probabilityToOdd(myMarkets.underOverHT12WayOver(i + 0.5)));
        }
        System.out.println("\n");

        System.out.println("9. Under/ Over HT1 Home - Away");
        System.out.println("---------------------------------");
        for (int i = 0; i <= 1; i++) {
            System.out.printf("     Under HT1 || Home " + i + ".5 : " + " Under" + " %.2f " + " Over" + " %.2f " + "||", probabilityToOdd(myMarkets.underOverHT12WayUnder(i + 0.5)), probabilityToOdd(myMarkets.underOverHomeHT12WayOver(i + 0.5)));
            System.out.printf(" Away  " + i + ".5 : " + "Under" + " %.2f" + " Over" + " %.2f \n", probabilityToOdd(myMarkets.underOverAwayHT12WayUnder(i + 0.5)), probabilityToOdd(myMarkets.underOverAwayHT12WayOver(i + 0.5)));
        }
        System.out.println("\n");

        System.out.println("10. Both Teams to Score HT1");
        System.out.println("------------------------------");
        System.out.printf("     Yes: " + " %.2f  " + "   No:" + " %.2f \n\n", probabilityToOdd(myMarkets.bothTeamsToScoreHT1Yes()), probabilityToOdd(myMarkets.bothTeamsToScoreHT1No()));


    } // main
}
