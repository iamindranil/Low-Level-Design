package Def;

import ATMStates.ATMState;
import ATMStates.IdleState;

public class ATM {
	
	private static ATM atmObject = new ATM();
	
	ATMState currentATMState;
	private int atmBalance;
	int noOfTwoThousandsNotes;
	int noOfFiveHundredNotes;
	int noOfOneHundredNotes;
	
	private ATM() {}
	
	public void setCurrentATMState(ATMState currentATMState) {
		this.currentATMState=currentATMState;
	}
	
	public ATMState getCurrentATMState() {
        return currentATMState;
    }


	
	public static ATM getATMObject() {
		atmObject.setCurrentATMState(new IdleState());
        return atmObject;
	}
	
	public int getAtmBalance() {
		return atmBalance;
	}
	
	public void setAtmBalance(int atmBalance,int noOfTwoThousandsNotes,int noOfFiveHundredNotes,int noOfOneHundredNotes) {
		this.atmBalance=atmBalance;
		this.noOfTwoThousandsNotes=noOfTwoThousandsNotes;
		this.noOfFiveHundredNotes=noOfFiveHundredNotes;
		this.noOfOneHundredNotes=noOfOneHundredNotes;
	}
	
	public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandsNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void deductATMBalance(int amount) {
        atmBalance = atmBalance - amount;
    }

    public void deductTwoThousandNotes(int number) {
        noOfTwoThousandsNotes = noOfTwoThousandsNotes - number;
    }

    public void deductFiveHundredNotes(int number) {
        noOfFiveHundredNotes = noOfFiveHundredNotes - number;
    }

    public void deductOneHundredNotes(int number) {
        noOfOneHundredNotes = noOfOneHundredNotes - number;
    }

    public void printCurrentATMStatus(){
        System.out.println("Balance: " + atmBalance);
        System.out.println("2kNotes: " + noOfTwoThousandsNotes);
        System.out.println("500Notes: " + noOfFiveHundredNotes);
        System.out.println("100Notes: " + noOfOneHundredNotes);

    }

	
}
