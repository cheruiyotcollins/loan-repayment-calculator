import java.lang.Math;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.printf("<<<<<<<<Welcome to Pezesha Loan Repayment Calculator. Press enter to continue>>>>");
        String[] input = new String[4];
        in.nextLine(); //consuming the <enter> from input above



        System.out.println("Please enter loan amount");
        input[0] = in.nextLine();
        System.out.println("Please enter loan term(in months)");
        input[1] = in.nextLine();
        System.out.println("Please enter Interest rate (per year)");
        input[2] = in.nextLine();
        System.out.println("Please enter Repayment frequency: For monthly enter 1, for bi-monthly enter 2 for  weekly enter 4)");
        input[3] = in.nextLine();


        System.out.printf("\n.......Please wait while we calculate your repayments......\n");

        //end collo

        double loanAmount = Double.parseDouble(input[0]);
        int loanTerm = Integer.parseInt(input[1]);
        double interestRate = Double.parseDouble(input[2]);
        int repaymentFrequency = Integer.parseInt(input[3]);;
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
          int count1=0;
        while (totalInterest + loanAmount > 0) {
            count1++;

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
        System.out.println(count1);
        System.out.println("");
        System.out.println("                  REPAYMENT SUMMARY TABLE                          ");
        System.out.println(" __________________________________________________________");
        System.out.printf("%5s %22s %20s", "PRINCIPAL_AMOUNT","TOTAL_AMOUNT_REPAID", "TOTAL_INTEREST");
        System.out.println();
        System.out.println(" __________________________________________________________");
        System.out.format("%7s %20s %25s ", Math.floor(principleAmount * 100) / 100,Math.floor(totalPayments * 100) / 100, Math.floor((totalPayments-principleAmount) * 100) / 100);

    }

}