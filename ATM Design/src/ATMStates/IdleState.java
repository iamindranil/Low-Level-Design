package ATMStates;

import Def.ATM;
import Def.Card;

public class IdleState extends ATMState{
	
	@Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }

}
