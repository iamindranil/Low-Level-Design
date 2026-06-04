package CompositeDP2;

public class Main {
	
	public static void main(String[] args) {
		ArithmaticExpression two=new Number(2);
		ArithmaticExpression one=new Number(1);
		ArithmaticExpression seven=new Number(7);
		
		ArithmaticExpression addExpression=new Expression(one,seven, Operation.ADD);
		ArithmaticExpression parentExpression = new Expression(two,addExpression, Operation.MULTIPLY);
		
		System.out.println(parentExpression.evaluate()); 
		
		
	}
	
}
