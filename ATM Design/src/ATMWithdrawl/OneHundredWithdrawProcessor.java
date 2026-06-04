package ATMWithdrawl;

import Def.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor{
	CashWithdrawProcessor nextCashWithdrawProcessor;
	public OneHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
		super(nextCashWithdrawProcessor);
	}
	@Override
	public void withdraw(ATM atm,int remainingAmount) {
		int req=remainingAmount/100;
		int remAmount=remainingAmount%100;
		if(req<=atm.getNoOfFiveHundredNotes()) {
			atm.deductFiveHundredNotes(remAmount);
		}else{
			atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
			remAmount-=(req-atm.getNoOfFiveHundredNotes())*500;
		}
		if(remAmount!=0) {
			super.withdraw(atm,remAmount);
		}
	}
}
