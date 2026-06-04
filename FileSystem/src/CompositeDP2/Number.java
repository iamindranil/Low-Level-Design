package CompositeDP2;

public class Number implements ArithmaticExpression{
	
	int value;
	public Number(int value) {
		this.value=value;
	}

	@Override
	public int evaluate() {
		System.out.println("Number is:"+value);
		return value;
	}

}
