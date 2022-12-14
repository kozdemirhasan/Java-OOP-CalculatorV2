package calculator_V2;


public class T1Calculator implements ICalculator {

	private int functionCount;
	private int currentCount = 0;
	
	private IMathFunction[] functions;
	

	public T1Calculator(int functionCount) {
		this.functionCount = functionCount;
		functions = new IMathFunction[functionCount];
	}
	
	

	@Override
	public void addFunction(IMathFunction function) {
		functions[currentCount] = function;
		currentCount++;

	}

	@Override
	public void listMathFunction() {
		System.out.println("Available Functions:");
		for (IMathFunction function : functions)
			System.out.println(function.getName());

	}


	@Override
	public double doCalculation(String functionName, double arg) {
		double result = 0.0;
		boolean isFunctionFound = false;
		for (IMathFunction function : functions) {
			if (functionName.equalsIgnoreCase(function.getName())) {
				result = ((ISingleArgMathFunction)function).calculate(arg);
				isFunctionFound = true;
			}
		}
		if(!isFunctionFound)
			System.out.println("No such function found!");

		return result;
	}



	@Override
	public double doCalculation(String functionName, double arg1, double arg2) {
		double result = 0.0;
		boolean isFunctionFound = false;
		for (IMathFunction function : functions) {
			if (functionName.equalsIgnoreCase(function.getName())) {
				result = ((IDoubleArgMathFunction)function).calculate(arg1, arg2);
				isFunctionFound = true;
			}
		}
		if(!isFunctionFound)
			System.out.println("No such function found!");

		return result;
	}



	@Override
	public String toString() {
		String functionNames="";
		for(IMathFunction matFunction : functions) {
			functionNames += matFunction.getName() +" ";
			
		}
		
		return "T1Calculator [functionCount=" + functionCount + ", currentCount=" + currentCount + ", functions="
				+ functionNames +"]";
	}



}
