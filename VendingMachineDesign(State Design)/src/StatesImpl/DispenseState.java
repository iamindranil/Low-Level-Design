package StatesImpl;

import java.util.List;

import Def.Coin;
import Def.Item;
import Def.VendingMachine;
import States.State;

public class DispenseState implements State{
	
	DispenseState(VendingMachine machine, int codeNumber) throws Exception{

        System.out.println("Currently Vending machine is in DispenseState");
        dispenseProduct(machine, codeNumber);
    }


	@Override
	public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getChange(int returnChangeMoney) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
		System.out.println("Product has been dispensed");
        Item item = machine.getInventory().getItem(codeNumber);
        machine.getInventory().updateSoldOutItem(codeNumber);
        machine.setVendingMachineState(new IdleState(machine));
        return item;

	}

	@Override
	public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	


	

}
