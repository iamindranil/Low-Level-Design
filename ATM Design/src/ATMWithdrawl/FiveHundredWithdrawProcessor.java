package ATMWithdrawl;

import Def.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor{
	
	public FiveHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor){
		super(nextCashWithdrawProcessor);
	}
	
	@Override
	public void withdraw(ATM atm,int remainingAmount) {
		int req=remainingAmount/500;
		int remAmount=remainingAmount%500;
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
