public class LoanRepaymentCalculator extends Thread{
    double loanAmount = 0.0;
    int loanTerm = 0;
    double interestRate =0.0;
    int repaymentFrequency =0;
    int compoundInterestInterval = 0;
    LoanRepaymentCalculator(){
    }
    LoanRepaymentCalculator(double loanAmount, int loanTerm, double interestRate, int repaymentFrequency, int compoundInterestInterval){
        this.loanAmount=loanAmount;
        this.loanTerm=loanTerm;
        this.interestRate=interestRate;
        this.repaymentFrequency=repaymentFrequency;
        this.compoundInterestInterval=compoundInterestInterval;
    }


    public void loanRepaymentCalculator(double loanAmount, int loanTerm, double interestRate, int repaymentFrequency, int compoundInterestInterval) {
        try {
            double totalPayments = 0.0;
            int count = 0;
            double principleAmount = loanAmount;
            int repaymentTimes=0;
            //calculating total repayments for weekly payments
            if(repaymentFrequency==4){
                if(loanTerm>12){
                    if(loanTerm%12==0){
                        int temp=loanTerm/12;
                        repaymentTimes=temp*52;
                    }else if(loanTerm%12!=0){
                        int temp= loanTerm/12;
                        repaymentTimes=temp*52;
                        temp=loanTerm%12;
                        repaymentTimes+=temp*repaymentFrequency;
                    }
                } else{
                    repaymentTimes = repaymentFrequency * loanTerm;
                }

            } //calculating total repayment  for Bi weekly payments
            else if (repaymentFrequency==2) {
                if(loanTerm>12){
                    if(loanTerm%12==0){
                        int temp=loanTerm/12;
                        repaymentTimes=temp*26;
                    }else if(loanTerm%12!=0){
                        int temp= loanTerm/12;
                        repaymentTimes=temp*26;
                        temp=loanTerm%12;
                        repaymentTimes+=temp*repaymentFrequency;
                    }
                } else{
                    repaymentTimes = repaymentFrequency * loanTerm;
                }
            }
            //calculating total repayments for monthly repayments
            else{
                repaymentTimes = repaymentFrequency * loanTerm;
            }
            System.out.println(repaymentTimes);


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
            System.out.printf("%5s %22s %20s", "PRINCIPAL_AMOUNT", "TOTAL_AMOUNT_REPAID", "TOTAL_INTEREST");
            System.out.println();
            System.out.println(" __________________________________________________________");
            System.out.format("%7s %20s %25s ", Math.floor(principleAmount * 100) / 100, Math.floor(totalPayments * 100) / 100, Math.floor((totalPayments - principleAmount) * 100) / 100);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
