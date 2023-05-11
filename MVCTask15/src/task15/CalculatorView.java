package task15;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class CalculatorView extends JFrame {

	private static final long serialVersionUID = 8875094773972826751L;
		
	private JTextField firstNumber = new JTextField(8);
	private JLabel additionLabel = new JLabel(" + ");
	private JTextField secondNumber = new JTextField(8);
	private JButton calculateButton = new JButton("Izračunaj");
	private JTextField calcSolution = new JTextField(8);
	
	private JTextField firstNumberLine2 = new JTextField(8);
	private JLabel subtractionLabel = new JLabel(" - ");
	private JTextField secondNumberLine2 = new JTextField(8);
	private JButton calculateButtonLine2 = new JButton("Izračunaj");
	private JTextField calcSolutionLine2 = new JTextField(8);
	
	private JTextField firstNumberLine3 = new JTextField(8);
	private JLabel multiplicationLabel = new JLabel(" * ");
	private JTextField secondNumberLine3 = new JTextField(8);
	private JButton calculateButtonLine3 = new JButton("Izračunaj");
	private JTextField calcSolutionLine3 = new JTextField(8);
	
	private JTextField firstNumberLine4 = new JTextField(8);
	private JLabel divisonLabel = new JLabel(" / ");
	private JTextField secondNumberLine4 = new JTextField(8);
	private JButton calculateButtonLine4 = new JButton("Izračunaj");
	private JTextField calcSolutionLine4 = new JTextField(8);
	
	CalculatorView(){
		this.setTitle("Digitron");		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,200);
		this.setResizable(false);
		
		JPanel calcPanel = new JPanel();
		Border blackLine, raisedBevel, loweredBevel, empty, matte,matteButton,matteSolution;
		
		
		
		blackLine = BorderFactory.createLineBorder(Color.black);
		raisedBevel = BorderFactory.createRaisedBevelBorder();
		loweredBevel = BorderFactory.createLoweredBevelBorder();
		empty = BorderFactory.createEmptyBorder();
		matte = BorderFactory.createMatteBorder(5, 10, 5, 10, getForeground());
		matteButton = BorderFactory.createMatteBorder(5, 10, 5, 10, getForeground());
		matteSolution = BorderFactory.createMatteBorder(5, 10, 5, 50, getForeground());
		
		
		calcPanel.setBorder(blackLine);
		
		additionLabel.setBorder(empty);
		subtractionLabel.setBorder(empty);
		multiplicationLabel.setBorder(empty);
		divisonLabel.setBorder(empty);
		
		firstNumber.setBorder(matte);
		secondNumber.setBorder(matte);
		calcSolution.setBorder(matteSolution);
		
		firstNumberLine2.setBorder(matte);
		secondNumberLine2.setBorder(matte);
		calcSolutionLine2.setBorder(matteSolution);
		
		firstNumberLine3.setBorder(matte);
		secondNumberLine3.setBorder(matte);
		calcSolutionLine3.setBorder(matteSolution);
		
		firstNumberLine4.setBorder(matte);
		secondNumberLine4.setBorder(matte);
		calcSolutionLine4.setBorder(matteSolution);
	
		calculateButton.setBorder(matteButton);
		calculateButtonLine2.setBorder(matteButton);
		calculateButtonLine3.setBorder(matteButton);
		calculateButtonLine4.setBorder(matteButton);
	
		
		calcPanel.add(firstNumber);
		calcPanel.add(additionLabel);
		calcPanel.add(secondNumber);
		calcPanel.add(calculateButton);
		calcPanel.add(calcSolution);
		
		calcPanel.add(firstNumberLine2);
		calcPanel.add(subtractionLabel);
		calcPanel.add(secondNumberLine2);
		calcPanel.add(calculateButtonLine2);
		calcPanel.add(calcSolutionLine2);
		
		calcPanel.add(firstNumberLine3);
		calcPanel.add(multiplicationLabel);
		calcPanel.add(secondNumberLine3);
		calcPanel.add(calculateButtonLine3);
		calcPanel.add(calcSolutionLine3);
		
		calcPanel.add(firstNumberLine4);
		calcPanel.add(divisonLabel);
		calcPanel.add(secondNumberLine4);
		calcPanel.add(calculateButtonLine4);
		calcPanel.add(calcSolutionLine4);
		
		this.add(calcPanel);
	}
	
	public double getFirstNumber(int line) {
		if(line==1) {
			return Double.parseDouble(firstNumber.getText());
		}
		else if(line==2) {
			return Double.parseDouble(firstNumberLine2.getText());
		}
		else if(line==3) {
			return Double.parseDouble(firstNumberLine3.getText());
		}
		else if(line==4) {
			return Double.parseDouble(firstNumberLine4.getText());
		}
		else {
			return 0;
		}
		
	}
	
	public double getSecondNumber(int line) {
		if(line==1) {
			return Double.parseDouble(secondNumber.getText());
		}
		else if(line==2) {
			return Double.parseDouble(secondNumberLine2.getText());
		}
		else if(line==3) {
			return Double.parseDouble(secondNumberLine3.getText());
		}
		else if(line==4) {
			return Double.parseDouble(secondNumberLine4.getText());
		}
		else {
			return 0;
		}
		
	}
	
	public double getCalcSolution(int line) {
		if(line==1) {
			return Double.parseDouble(calcSolution.getText());
		}
		else if(line==2) {
			return Double.parseDouble(calcSolutionLine2.getText());
		}
		else if(line==3) {
			return Double.parseDouble(calcSolutionLine3.getText());
		}
		else if(line==4) {
			return Double.parseDouble(calcSolutionLine4.getText());
		}
		return 0;
	}
	
	public void setCalcSolution(double solution,int line) {
		DecimalFormat df = new DecimalFormat("#.###");
		if(line==1) {
			calcSolution.setText(df.format(solution));
		}
		else if(line==2) {
			calcSolutionLine2.setText(df.format(solution));
		}
		else if(line==3) {
			calcSolutionLine3.setText(df.format(solution));
		}
		else if(line==4) {
			calcSolutionLine4.setText(df.format(solution));
		}
		
	}
	
	void addCalculationListener(ActionListener listenerForCalcButton) {
		calculateButton.addActionListener(listenerForCalcButton);
	}
	
	void addCalculationListener2(ActionListener listenerForCalcButton) {
		calculateButtonLine2.addActionListener(listenerForCalcButton);
	}
	
	void addCalculationListener3(ActionListener listenerForCalcButton) {
		calculateButtonLine3.addActionListener(listenerForCalcButton);
	}
	
	void addCalculationListener4(ActionListener listenerForCalcButton) {
		calculateButtonLine4.addActionListener(listenerForCalcButton);
	}
	
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
