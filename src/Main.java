import java.lang.Math;

public class Main {
    public static void main(String[] args) {

        double loanAmount = 10000.0;
        int loanTerm = 12;
        double interestRate = 5;
        int repaymentFrequency = 1;
        int compoundInterestInterval = 0;

        switch (repaymentFrequency) {
            case 1:
                compoundInterestInterval = 12;
                loanRepaymentCalculator(loanAmount, loanTerm, interestRate, repaymentFrequency, compoundInterestInterval);
                break;
            case 2:
                compoundInterestInterval = 26;
                loanRepaymentCalculator(loanAmount, loanTerm, interestRate, repaymentFrequency, compoundInterestInterval);
                break;
            case 4:
                compoundInterestInterval = 52;
                loanRepaymentCalculator(loanAmount, loanTerm, interestRate, repaymentFrequency, compoundInterestInterval);
                break;
            default:
                System.out.println("Invalid repayment frequency");

        }


    }

    static void loanRepaymentCalculator(double loanAmount, int loanTerm, double interestRate, int repaymentFrequency, int compoundInterestInterval) {

        double totalPayments = 0.0;
        int count = 0;
        double principleAmount=loanAmount;
        int repaymentTimes = repaymentFrequency * loanTerm;
        double totalInterest = loanAmount * interestRate / 100;
        double monthlyRepayment = (totalInterest + loanAmount) / repaymentTimes;
        System.out.println();
        System.out.println("                  REPAYMENT TABLE                          ");
        System.out.println(" __________________________________________________________");
        System.out.printf("%5s %10s %10s %8s", "PRINCIPAL AMOUNT", "INTEREST", "REPAYMENT", " OUTSTANDING AMOUNT");

        while (totalInterest + loanAmount > 0) {
            System.out.println();
            System.out.println(" __________________________________________________________");
            System.out.format("%7s %18s %7s %14s", Math.floor(loanAmount * 100) / 100, Math.floor(totalInterest * 100) / 100, Math.floor(monthlyRepayment * 100) / 100, Math.floor((loanAmount + totalInterest) * 100) / 100);
            totalPayments += monthlyRepayment;

            if (totalInterest > 0) {
                totalInterest -= monthlyRepayment;
                if (totalInterest < 0) {
                    loanAmount += totalInterest;
                    totalInterest = 0;
                    if (loanAmount < 0) {
                        totalPayments += loanAmount;
                        break;
                    }
                }
                continue;
            }
            loanAmount -= monthlyRepayment;
            if (loanAmount < 0 && totalInterest == 0) {
                totalPayments += loanAmount;
                 break;
            }

            if (count == compoundInterestInterval) {
                count = 0;
                totalInterest = (totalInterest + loanAmount) * interestRate / 100;
            }
            count++;

        }
        System.out.println("");
        System.out.println("");
        System.out.println("                  REPAYMENT SUMMARY TABLE                          ");
        System.out.println(" __________________________________________________________");
        System.out.printf("%5s %20s", "TOTAL AMOUNT REPAID", "TOTAL INTEREST");
        System.out.println();
        System.out.println(" __________________________________________________________");
        System.out.format("%7s %25s", Math.floor(totalPayments * 100) / 100, Math.floor((totalPayments-principleAmount) * 100) / 100);

    }

}