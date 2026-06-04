package ATMStates;

import java.security.PublicKey;

import ATMWithdrawl.CashWithdrawProcessor;
import ATMWithdrawl.FiveHundredWithdrawProcessor;
import ATMWithdrawl.OneHundredWithdrawProcessor;
import ATMWithdrawl.TwoThousandWithdrawProcessor;
import Def.ATM;
import Def.Card;

public class CashWithdrawalState extends ATMState{
	
	CashWithdrawalState(){
		//i/o
		System.out.println("Please enter the Withdrawal Amount");
	}
	
	public void cashWithdrawal(ATM atmObject, Card card, int withdrawalAmountRequest) {
		
		if(atmObject.getAtmBalance()<withdrawalAmountRequest) {
			System.out.println("Insufficient fund in the ATM Machine");
            exit(atmObject);
		}else if(card.getBankBalance()<withdrawalAmountRequest) {
			System.out.println("Insufficient fund in the your Bank Account");
            exit(atmObject);
		}else {
			card.deductBankBalance(withdrawalAmountRequest);
			atmObject.deductATMBalance(withdrawalAmountRequest);
			//use Chain of Res for withdrawal
			 CashWithdrawProcessor withdrawProcessor=new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));
			 withdrawProcessor.withdraw(atmObject,withdrawalAmountRequest);
			 exit(atmObject);
		}

	}
	
	@Override
    public void exit(ATM atmObject) {
        returnCard();
        atmObject.setCurrentATMState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }

	
}
