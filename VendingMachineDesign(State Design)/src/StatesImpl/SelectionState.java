package StatesImpl;

import Def.*;
import States.State;

public class SelectionState implements State{
	
	public SelectionState(){
        System.out.println("Currently Vending machine is in SelectionState");
    }


	@Override
	public void clickOnInsertCoinButton(Def.VendingMachine machine) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickOnStartProductSelectionButton(Def.VendingMachine machine) throws Exception {
		return;
		
	}

	@Override
	public void insertCoin(Def.VendingMachine machine, Def.Coin coin) throws Exception {
		 throw new Exception("you can not insert Coin in selection state");
		
	}

	@Override
	public void chooseProduct(Def.VendingMachine machine, int codeNumber) throws Exception {
		 //1. get item of this codeNumber
        Item item = machine.getInventory().getItem(codeNumber);

        //2. total amount paid by User
        int paidByUser = 0;
        for(Coin coin : machine.getCoinList()){
            paidByUser = paidByUser + coin.value;
        }

        //3. compare product price and amount paid by user
        if(paidByUser < item.getPrice()) {
            System.out.println("Insufficient Amount, Product you selected is for price: " + item.getPrice() + " and you paid: " + paidByUser);
            refundFullMoney(machine);
            throw new Exception("insufficient amount");
        }
        else if(paidByUser >= item.getPrice()) {

            if(paidByUser > item.getPrice()) {
                getChange(paidByUser-item.getPrice());
            }
            machine.setVendingMachineState(new DispenseState(machine, codeNumber));
        }

		
	}

	@Override
	public int getChange(int returnChangeMoney) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Def.Item dispenseProduct(Def.VendingMachine machine, int codeNumber) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<Def.Coin> refundFullMoney(Def.VendingMachine machine) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInventory(Def.VendingMachine machine, Def.Item item, int codeNumber) throws Exception {
		// TODO Auto-generated method stub
		
	}

	


}
