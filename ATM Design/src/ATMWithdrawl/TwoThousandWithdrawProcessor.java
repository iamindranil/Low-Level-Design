package ATMWithdrawl;

import Def.ATM;

public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor{
	CashWithdrawProcessor nextCashWithdrawProcessor;
	public TwoThousandWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor){
		super(nextCashWithdrawProcessor);
	}
	
	@Override
	public void withdraw(ATM atm,int remainingAmount) {
		int req=remainingAmount/2000;
		int remAmount=remainingAmount%2000;
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
