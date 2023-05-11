package task15;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class CalculatorController {
	
	private CalculatorView theView;
	private CalculatorModel theModel;
	
	public CalculatorController(CalculatorView theView,CalculatorModel theModel) {
		this.theView=theView;
		this.theModel=theModel;
		
		this.theView.addCalculationListener(new CalculateListener());
		this.theView.addCalculationListener2(new CalculateListener2());
		this.theView.addCalculationListener3(new CalculateListener3());
		this.theView.addCalculationListener4(new CalculateListener4());
	}
	
	class CalculateListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			double firstNumber, secondNumber = 0;
			
			try {
				firstNumber = theView.getFirstNumber(1);
				secondNumber = theView.getSecondNumber(1);
								
				theModel.addTwoNumbers(firstNumber, secondNumber);
				
				theView.setCalcSolution(theModel.getCalculationValue(1),1);
				
			}
			catch(NumberFormatException eM) {
				theView.displayErrorMessage("Unesite dva realna broja.");
			}
		}
	}
	
	class CalculateListener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			double firstNumber, secondNumber = 0;
			
			try {
				firstNumber = theView.getFirstNumber(2);
				secondNumber = theView.getSecondNumber(2);
								
				theModel.subTwoNumbers(firstNumber, secondNumber);
				
				theView.setCalcSolution(theModel.getCalculationValue(2),2);
				
			}
			catch(NumberFormatException eM) {
				theView.displayErrorMessage("Unesite dva realna broja.");
			}
		}
	}
	
	class CalculateListener3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			double firstNumber, secondNumber = 0;
			
			try {
				firstNumber = theView.getFirstNumber(3);
				secondNumber = theView.getSecondNumber(3);
								
				theModel.multiplyTwoNumbers(firstNumber, secondNumber);
				
				theView.setCalcSolution(theModel.getCalculationValue(3),3);
				
			}
			catch(NumberFormatException eM) {
				theView.displayErrorMessage("Unesite dva realna broja.");
			}
		}
	}
	
	class CalculateListener4 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			double firstNumber, secondNumber = 0;
			
			try {
				firstNumber = theView.getFirstNumber(4);
				secondNumber = theView.getSecondNumber(4);
				
				if(secondNumber==0) {
					throw new Exception();
				}
				theModel.divideTwoNumbers(firstNumber, secondNumber);
				
				theView.setCalcSolution(theModel.getCalculationValue(4),4);
				
			}
			catch(NumberFormatException eM) {
				theView.displayErrorMessage("Unesite dva realna broja.");
			}
			catch(Exception ex) {
				theView.displayErrorMessage("Deljenje nulom nije moguće.");
			}
		}
	}
	
	

}
