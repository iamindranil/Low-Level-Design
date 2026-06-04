package CompositeDP2;

public class Expression implements ArithmaticExpression{
	
	ArithmaticExpression leftExpression;
	ArithmaticExpression rightExpression;
	Operation operation;
	
	public Expression(ArithmaticExpression leftExpression,ArithmaticExpression rightExpression,Operation operation) {
		this.leftExpression=leftExpression;
		this.rightExpression=rightExpression;
		this.operation=operation;
	}

	@Override
	public int evaluate() {
		int value=0;
		if(operation.equals("ADD")) {
			value=leftExpression.evaluate()+rightExpression.evaluate();
		}else if(operation.equals("SUBSTRACT")) {
			value=leftExpression.evaluate()-rightExpression.evaluate();
		}else if(operation.equals("DIVIDE")) {
			value=leftExpression.evaluate()/rightExpression.evaluate();
		}else {
			value=leftExpression.evaluate()*rightExpression.evaluate();
		}
		return value;
	}
	
	
}
