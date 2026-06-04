package StatesImpl;

import java.util.List;

import Def.Coin;
import Def.Item;
import Def.VendingMachine;
import States.State;

public class HasMoneyState implements State{
	
	public HasMoneyState(){
        System.out.println("Currently Vending machine is in HasMoneyState");
    }



	@Override
	public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
		return;
		
	}

	@Override
	public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
		machine.setVendingMachineState(new SelectionState());

		
	}

	@Override
	public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
		System.out.println("Accepted the coin");
        machine.getCoinList().add(coin);

		
	}

	@Override
	public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
		throw new Exception("you need to click on start product selection button first");
		
	}

	@Override
	public int getChange(int returnChangeMoney) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
		System.out.println("Returned the full amount back in the Coin Dispense Tray");
        machine.setVendingMachineState(new IdleState(machine));
        return machine.getCoinList();

	}

	@Override
	public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
		// TODO Auto-generated method stub
		
	}
	

}
