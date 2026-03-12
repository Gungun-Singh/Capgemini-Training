import java.util.*;

public class BankSystem {

	interface Bank{
		void assignLoans(int[] loans);
		void averageLoan();
		void maxLoan();
		void minLoan();
	}
	
	class PersonalLoanDept implements Bank{
		int[] loanAmounts;
		
		PersonalLoanDept(int clients){
			loanAmounts = new int[clients];
		}
		
		
		@Override
		public void assignLoans(int[] loans) {
		int n= loanAmounts.length;
		
		for(int i=0;i<n;i++) {
			loanAmounts[i] = loans[i];
		}
		//sout loans processed
		
		}
		
		@Override
		public void averageLoan() {
			double sum=0;
			int n= loanAmounts.length;
			
			for(int i=0;i<n;i++) {
				sum += loanAmounts[i];
			}
			double avg = sum/n;
		}
		
		@Override
		public void maxLoan() {
			int n = loanAmounts.length;
			int max =0;
			
			for(int i=0;i<n;i++) {
			max = Math.max(max, loanAmounts[i]);	
			}
		}
		
		@Override
		public void minLoan() {
			int n = loanAmounts.length;
			int min =0;
			
			for(int i=0;i<n;i++) {
			min = Math.min(min, loanAmounts[i]);	
			}
		}
		
	}
	
	class BusinessLoanDept implements Bank {
int[] loanAmounts;

	BusinessLoanDept(int clients){
		loanAmounts = new int[clients];
	}
		
	@Override
	public void assignLoans(int[] loans) {
	int n= loanAmounts.length;
	
	for(int i=0;i<n;i++) {
		loanAmounts[i] = loans[i];
	}
	}
	
		@Override
		public void averageLoan() {
			double sum=0;
			int n= loanAmounts.length;
			
			for(int i=0;i<n;i++) {
				sum += loanAmounts[i];
			}
			double avg = sum/n;
			//sout String.format("%.2f", avg);
			

	}
		
		@Override
		public void maxLoan() {
			int n = loanAmounts.length;
			int max =0;
			
			for(int i=0;i<n;i++) {
			max = Math.max(max, loanAmounts[i]);	
			}
		}
		
		@Override
		public void minLoan() {
			int n = loanAmounts.length;
			int min =loanAmounts[0];
			
			for(int i=0;i<n;i++) {
			min = Math.min(min, loanAmounts[i]);	
			}
		}
	}}
	

