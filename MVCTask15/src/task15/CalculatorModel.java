package task15;

public class CalculatorModel {

	private double calculationValue;
	private double calcValueLine2;
	private double calcValueLine3;
	private double calcValueLine4;
	
	
	public void addTwoNumbers(double firstNumber, double secondNumber) {
		this.calculationValue = firstNumber + secondNumber;
	}
	
	public  void subTwoNumbers(double firstNumber, double secondNumber) {
		this.calcValueLine2 = firstNumber - secondNumber;
	}
	
	public void multiplyTwoNumbers(double firstNumber, double secondNumber) {
		this.calcValueLine3 = firstNumber * secondNumber;
	}
	
	public void divideTwoNumbers (double firstNumber, double secondNumber) {
		this.calcValueLine4 = firstNumber / secondNumber;
	}
	
	public double getCalculationValue(int line) {
		if(line==1) {
			return this.calculationValue;
		}
		else if(line==2) {
			return this.calcValueLine2;
		}
		else if(line==3) {
			return this.calcValueLine3;
		}
		else if(line==4) {
			return this.calcValueLine4;
		}
		else {
			return 0;
		}
		
	}
}
