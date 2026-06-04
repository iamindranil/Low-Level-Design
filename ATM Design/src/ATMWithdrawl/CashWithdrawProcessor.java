package ATMWithdrawl;

import Def.ATM;

public class CashWithdrawProcessor {
	CashWithdrawProcessor nextCashWithdrawProcessor;
	
	CashWithdrawProcessor (CashWithdrawProcessor nextCashWithdrawProcessor){
		this.nextCashWithdrawProcessor=nextCashWithdrawProcessor;
	}
	
	public void withdraw(ATM atm,int remainingAmount) {
		if(nextCashWithdrawProcessor!=null) {
			nextCashWithdrawProcessor.withdraw(atm, remainingAmount);
		}
	}
}
