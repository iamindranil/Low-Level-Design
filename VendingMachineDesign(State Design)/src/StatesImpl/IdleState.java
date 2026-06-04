package StatesImpl;

import java.util.ArrayList;
import java.util.List;

import Def.Coin;
import Def.Item;
import Def.VendingMachine;
import States.State;

public class IdleState implements State{
	
	public IdleState(){
        System.out.println("Currently Vending machine is in IdleState");
    }

    public IdleState(VendingMachine machine){
        System.out.println("Currently Vending machine is in IdleState");
        machine.setCoinList(new ArrayList<>());
    }


	@Override
	public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
		machine.setVendingMachineState(new HasMoneyState());
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
		machine.getInventory().addItem(item, codeNumber);
		
	}
	
	 

}
