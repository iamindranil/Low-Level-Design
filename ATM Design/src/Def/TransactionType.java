package Def;

public enum TransactionType {
	CASH_WITHDRAWAL,
	BALANCE_CHECK;
	

	public static void showAllTransactions() {
		for(TransactionType tType:TransactionType.values()) {
			System.out.println(tType.name());
		}
	}
	
}
