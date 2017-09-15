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

        System.out.println("1. Winner 3 Way FT");
        System.out.printf("     Home: %.2f ", probabilityToOdd(myMarkets.winner3WayHome()));
        System.out.printf("Draw: %.2f ", probabilityToOdd(myMarkets.winner3WayDraw()));
        System.out.printf("Away: %.2f \n", probabilityToOdd(myMarkets.winner3WayAway()));

        //System.out.println("     Error Check: " + (myMarkets.winner3WayHome() + myMarkets.winner3WayDraw() + myMarkets.winner3WayAway()));

        System.out.println("2. Under/ Over FT");
        for (int i = 0; i <= 4; i++) {
            System.out.printf("     Under " + i + ".5 : " + " %.2f ", probabilityToOdd(myMarkets.underOverFT2WayUnder(i + 0.5)));
            System.out.printf(" Over " + i + ".5 : " + " %.2f \n", probabilityToOdd(myMarkets.underOverFT2WayOver(i + 0.5)));
        }

        System.out.println("3. Both Teams to Score FT");
        System.out.printf("     No: " + " %.2f  " +  "        Yes:" + " %.2f \n",probabilityToOdd(myMarkets.bothTeamsToScoreFTNo()),probabilityToOdd(myMarkets.bothTeamsToScoreFTYes()) );


        /* ---------------------------------------------------------------------- */
        System.out.println("--------------------------------------------");
        /* ---------------------------------------------------------------------- */


        System.out.println("4. Winner 3 Way HT1");
        System.out.printf("     Home: %.2f ", probabilityToOdd(myMarkets.winner3WayHomeHT1()));
        System.out.printf("Draw: %.2f ", probabilityToOdd(myMarkets.winner3WayDrawHT1()));
        System.out.printf("Away: %.2f \n", probabilityToOdd(myMarkets.winner3WayAwayHT1()));

        //System.out.println("     Error Check: " + (myMarkets.winner3WayHome() + myMarkets.winner3WayDraw() + myMarkets.winner3WayAway()));

        System.out.println("5. Under/ Over HT1");
        for (int i = 0; i <= 2; i++) {
            System.out.printf("     Under " + i + ".5 : " + " %.2f ", probabilityToOdd(myMarkets.underOverHT12WayUnder(i + 0.5)));
            System.out.printf(" Over " + i + ".5 : " + " %.2f \n", probabilityToOdd(myMarkets.underOverHT12WayOver(i + 0.5)));
        }

        System.out.println("6. Both Teams to Score HT1");
        System.out.printf("     No: " + " %.2f  " +  "        Yes:" + " %.2f \n",probabilityToOdd(myMarkets.bothTeamsToScoreHT1No()),probabilityToOdd(myMarkets.bothTeamsToScoreHT1Yes()) );


    } // main
}
