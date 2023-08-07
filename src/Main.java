import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.printf("<<<<<<<<Welcome to Pezesha Loan Repayment Calculator. Press enter to continue>>>>>");
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

        double loanAmount = Double.parseDouble(input[0]);
        int loanTerm = Integer.parseInt(input[1]);
        double interestRate = Double.parseDouble(input[2]);
        int repaymentFrequency = Integer.parseInt(input[3]);
        int compoundInterestInterval = 0;

        LoanRepaymentCalculator loanRepaymentCalculator;


        switch (repaymentFrequency) {
            case 1:
                compoundInterestInterval = 12;
                loanRepaymentCalculator=new LoanRepaymentCalculator();
                loanRepaymentCalculator.loanRepaymentCalculator(loanAmount, loanTerm, interestRate, repaymentFrequency, compoundInterestInterval);
                loanRepaymentCalculator.start();
                break;
            case 2:
                compoundInterestInterval = 26;
                loanRepaymentCalculator=new LoanRepaymentCalculator();
                loanRepaymentCalculator.loanRepaymentCalculator(loanAmount, loanTerm, interestRate, repaymentFrequency, compoundInterestInterval);
                loanRepaymentCalculator.start();
                break;
            case 4:
                compoundInterestInterval = 52;
                loanRepaymentCalculator=new LoanRepaymentCalculator();
                loanRepaymentCalculator.loanRepaymentCalculator(loanAmount, loanTerm, interestRate, repaymentFrequency, compoundInterestInterval);
                loanRepaymentCalculator.start();
                break;
            default:
                System.out.println("Invalid repayment frequency");

        }


    }



}