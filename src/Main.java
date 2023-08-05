public class Main {
    public static void main(String[] args) {

        double loanAmount=200.0;
        int loanTerm=0;
        double interestRate=10.5;
        int repaymentFrequency=0;
        loanRepaymentCalculator(loanAmount,loanTerm,interestRate,repaymentFrequency);

    }
    static void loanRepaymentCalculator(double loanAmount, int loanTerm, double interestRate, int repaymentFrequency){

          double totalInterest=loanAmount*interestRate/100;
          System.out.println(totalInterest);
    }
}