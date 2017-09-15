package football;

public class UsefulMethods {
    
   

    // factorial
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int fact = 1; // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    } // factorial

    // Poisson
    public static double poissonPDF(int x, double l) {
        double prob = ((Math.exp(-l) * Math.pow(l, x)) / factorial(x));
        return prob;
    }

    // Double Sum
    public static double sumOfDoubleSeries(CorrectScore f, int x_start, int x_end, int y_start, int y_end) {

        double sum = 0;
        for (int i = x_start; i <= x_end; i++) {
            for (int j = y_start; j <= y_end; j++) {
                sum = sum + f.getScoreFT(i, j);
            }
        }
        return sum;
    }

    /*
    public static double sumOfDoubleSeries (CorrectScore f, String[] args) {
        
        String [] myArray = new String[args.length];
        String x_start = myArray[0];
        String x_end = myArray[1];
        String y_start = myArray[2];
        String y_end = myArray[3];
       
        
        double sum = 0;
        for (int i = Integer.valueOf(x_start); i <= Integer.valueOf(x_end); i++) {
            for (int j = Integer.valueOf(y_start); j <= Integer.valueOf(y_end); j++) {
                sum = sum + f.getScoreFT(i,j);
            }
        } 
        return sum;
    }
     */
    
    
}
