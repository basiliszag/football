package football;

public class EventTypes {

    CorrectScore myScore = new CorrectScore();
    int sumLimit = 10;

    // Winner 3 Way
    // Home
    public double winner3WayHome() {
        double probWinner3WayHome = .0;

        for (int i = 0; i <= sumLimit; i++) {
            for (int j = 0; j <= i - 1; j++) {
                probWinner3WayHome = probWinner3WayHome + myScore.getScoreFT(i, j);
                //System.out.printf(" (%s,%s) - %s",i,j,f.getScoreFT(i,j));
            }
        }
        return probWinner3WayHome;
    } //winner3WayHome

    // Away
    public double winner3WayAway() {
        double probWinner3WayAway = .0;

        for (int j = 0; j <= sumLimit; j++) {
            for (int i = 0; i <= j - 1; i++) {
                probWinner3WayAway = probWinner3WayAway + myScore.getScoreFT(i, j);
                //System.out.printf(" (%s,%s) - %s",i,j,f.getScoreFT(i,j));
            }
        }
        return probWinner3WayAway;
    } //winner3WayAway

    // Draw
    public double winner3WayDraw() {
        double probWinner3WayDraw = 1 - winner3WayHome() - winner3WayAway();

        return probWinner3WayDraw;
    } //winner3WayDraw


    // Under/ Over FT
    // Under
    public double underOverFT2WayUnder(double line) {
        double probunderOverFT2WayUnder = .0;
        for (int i = 0; i <= line; i++) {
            for (int j = 0; j <= line - i; j++) {
                probunderOverFT2WayUnder = probunderOverFT2WayUnder + myScore.getScoreFT(i, j);
            }
        }
        return probunderOverFT2WayUnder;
    } // underOverFT2WayUnder

    // Over
    public double underOverFT2WayOver(double line) {
        double probunderOverFT2WayOver = 1 - underOverFT2WayUnder(line);
        return probunderOverFT2WayOver;
    } // underOverFT2WayOver


    // Under/ Over Home FT
    // Under
    public double underOverHomeFT2WayUnder(double line) {
        double probunderOverHomeFT2WayUnder = .0;
        for (int i = 0; i <= line - 0.5; i++) {
            for (int j = 0; j <= sumLimit; j++) {
                probunderOverHomeFT2WayUnder = probunderOverHomeFT2WayUnder + myScore.getScoreFT(i, j);
            }
        }
        return probunderOverHomeFT2WayUnder;
    } // underOverHomeFT2WayUnder

    // Over
    public double underOverHomeFT2WayOver(double line) {
        double probUnderOverHomeFT2WayOver = 1 - underOverHomeFT2WayUnder(line);
        return probUnderOverHomeFT2WayOver;
    } // underOverHomeFT2WayOver


    // Under/ Over Away FT
    // Under
    public double underOverAwayFT2WayUnder(double line) {
        double probunderOverAwayFT2WayUnder = .0;
        for (int j = 0; j <= line - 0.5; j++) {
            for (int i = 0; i <= sumLimit; i++) {
                probunderOverAwayFT2WayUnder = probunderOverAwayFT2WayUnder + myScore.getScoreFT(i, j);
            }
        }
        return probunderOverAwayFT2WayUnder;
    } // underOverAwayFT2WayUnder

    // Over
    public double underOverAwayFT2WayOver(double line) {
        double probunderOverAwayFT2WayOver = 1 - underOverAwayFT2WayUnder(line);
        return probunderOverAwayFT2WayOver;
    } // underOverAwayFT2WayOver


    // Both Teams to Score FT
    // No
    public double bothTeamsToScoreFTNo() {
        double probBothTeamsToScoreFTNo = .0;
        for (int i = 0; i <= sumLimit; i++) {
            probBothTeamsToScoreFTNo = probBothTeamsToScoreFTNo + myScore.getScoreFT(i, 0);
        }
        for (int j = 1; j <= sumLimit; j++) {
            probBothTeamsToScoreFTNo = probBothTeamsToScoreFTNo + myScore.getScoreFT(0, j);
        }
        return probBothTeamsToScoreFTNo;
    } //bothTeamsToScoreFTNo

    // Yes
    public double bothTeamsToScoreFTYes() {
        double probBothTeamsToScoreFTYes = 1 - bothTeamsToScoreFTNo();
        return probBothTeamsToScoreFTYes;
    }


    // 1st Team to Score
    // Home
    public double firstTeamToScoreHome() {
        double probFirstTeamToScoreHome = (myScore.lambda / (myScore.lambda + myScore.mi)) * ( 1. - myScore.getScoreFT(0,0));
        return probFirstTeamToScoreHome;
    }

    // Away
    public double firstTeamToScoreAway() {
        double probFirstTeamToScoreAway = (myScore.mi / (myScore.lambda + myScore.mi)) * ( 1. - myScore.getScoreFT(0,0));
        return probFirstTeamToScoreAway;
    }

    // None
    public double firstTeamToScoreNone() {
        double probFirstTeamToScoreNone = myScore.getScoreFT(0,0);
        return probFirstTeamToScoreNone;
    }


    // Margin of Victory

    // Home
    public double marginOfVictoryFTHome( int margin) {
        double probMarginOfVictoryFTHome = .0;
        for (int i = 0 ; i <= sumLimit; i++) {
            probMarginOfVictoryFTHome = probMarginOfVictoryFTHome + myScore.getScoreFT(i,i - margin);
        }
        return probMarginOfVictoryFTHome;
    } //marginOfVictoryFTHome

    // Away
    public double marginOfVictoryFTAway( int margin) {
        double probMarginOfVictoryFTAway = .0;
        for (int i = 0 ; i <= sumLimit; i++) {
            probMarginOfVictoryFTAway = probMarginOfVictoryFTAway + myScore.getScoreFT(i - margin,i );
        }
        return probMarginOfVictoryFTAway;
    } //marginOfVictoryFTAway



    /* -------------------------------------------------------------------------------------------------------------*/

    // Winner 3 Way HT1
    // Home
    public double winner3WayHomeHT1() {
        double probWinner3WayHomeHT1 = .0;

        for (int i = 0; i <= sumLimit; i++) {
            for (int j = 0; j <= i - 1; j++) {
                probWinner3WayHomeHT1 = probWinner3WayHomeHT1 + myScore.getScoreHT1(i, j);
                //System.out.printf(" (%s,%s) - %s",i,j,f.getScoreFT(i,j));
            }
        }
        return probWinner3WayHomeHT1;
    } //winner3WayHomeHT1

    // Away
    public double winner3WayAwayHT1() {
        double probWinner3WayAwayHT1 = .0;

        for (int j = 0; j <= sumLimit; j++) {
            for (int i = 0; i <= j - 1; i++) {
                probWinner3WayAwayHT1 = probWinner3WayAwayHT1 + myScore.getScoreHT1(i, j);
                //System.out.printf(" (%s,%s) - %s",i,j,f.getScoreFT(i,j));
            }
        }
        return probWinner3WayAwayHT1;
    } //winner3WayAwayHT1

    // Draw
    public double winner3WayDrawHT1() {
        double probWinner3WayDrawHT1 = 1 - winner3WayHomeHT1() - winner3WayAwayHT1();

        return probWinner3WayDrawHT1;
    } //winner3WayDrawHT1


    // Under/ Over HT1
    // Under
    public double underOverHT12WayUnder(double line) {
        double probunderOverHT12WayUnder = .0;
        for (int i = 0; i <= line; i++) {
            for (int j = 0; j <= line - i; j++) {
                probunderOverHT12WayUnder = probunderOverHT12WayUnder + myScore.getScoreHT1(i, j);
            }
        }
        return probunderOverHT12WayUnder;
    } // underOverHT12WayUnder

    // Over
    public double underOverHT12WayOver(double line) {
        double probunderOverHT12WayOver = 1 - underOverHT12WayUnder(line);
        return probunderOverHT12WayOver;
    } // underOverHT12WayOver


    // Under/ Over Home HT1
    // Under
    public double underOverHomeHT12WayUnder(double line) {
        double probunderOverHomeHT12WayUnder = .0;
        for (int i = 0; i <= line - 0.5; i++) {
            for (int j = 0; j <= sumLimit; j++) {
                probunderOverHomeHT12WayUnder = probunderOverHomeHT12WayUnder + myScore.getScoreHT1(i, j);
            }
        }
        return probunderOverHomeHT12WayUnder;
    } // underOverHomeHT12WayUnder

    // Over
    public double underOverHomeHT12WayOver(double line) {
        double probunderOverHomeHT12WayOver = 1 - underOverHomeHT12WayUnder(line);
        return probunderOverHomeHT12WayOver;
    } // underOverHomeHT12WayOver


    // Under/ Over Away HT1
    // Under
    public double underOverAwayHT12WayUnder(double line) {
        double probunderOverAwayHT12WayUnder = .0;
        for (int j = 0; j <= line - 0.5; j++) {
            for (int i = 0; i <= sumLimit; i++) {
                probunderOverAwayHT12WayUnder = probunderOverAwayHT12WayUnder + myScore.getScoreHT1(i, j);
            }
        }
        return probunderOverAwayHT12WayUnder;
    } // underOverAwayHT12WayUnder

    // Over
    public double underOverAwayHT12WayOver(double line) {
        double probunderOverAwayHT12WayOver = 1 - underOverAwayHT12WayUnder(line);
        return probunderOverAwayHT12WayOver;
    } // underOverAwayHT12WayOver


    // Both Teams to Score HT1
    // No
    public double bothTeamsToScoreHT1No() {
        double probBothTeamsToScoreHT1No = .0;
        for (int i = 0; i <= sumLimit; i++) {
            probBothTeamsToScoreHT1No = probBothTeamsToScoreHT1No + myScore.getScoreHT1(i, 0);
        }
        for (int j = 1; j <= sumLimit; j++) {
            probBothTeamsToScoreHT1No = probBothTeamsToScoreHT1No + myScore.getScoreHT1(0, j);
        }
        return probBothTeamsToScoreHT1No;
    } //bothTeamsToScoreHT1No

    // Yes
    public double bothTeamsToScoreHT1Yes() {
        double probBothTeamsToScoreHT1Yes = 1 - bothTeamsToScoreHT1No();
        return probBothTeamsToScoreHT1Yes;
    }

} // EventTypes
