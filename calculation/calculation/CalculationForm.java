package calculation;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.*;

public class CalculationForm 
{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	//public static Calculation window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculationForm window = new CalculationForm();
				    window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculationForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 50, 289, 211);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(134, 0, 139, 31);
		textField.setText("1");
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(134, 31, 139, 31);
		textField_1.setText("1");
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("1");
		textField_2.setBounds(134, 59, 139, 31);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("\u0420\u0435\u0448\u0438\u0442\u044C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				
				try
				{
					double suma_credit = Double.parseDouble(textField.getText());
					double stavka_credit = Double.parseDouble(textField_1.getText());
					double srok_credit = Double.parseDouble(textField_2.getText());
					
					if(stavka_credit < 0 || stavka_credit > 1)
					{
						throw new Exception("Ставка кредита должна быть больше нуля и меньше единицы");
					}
					if(srok_credit < 0 )
					{
						throw new Exception("Срок кредита не должна превышать 60 месяцев");
					}
					if(suma_credit < 0 )
					{
						throw new Exception("Сумма кредита не должна быть меньше нуля");
					}
					
					Calculation<Double> calc = new Calculate(suma_credit, stavka_credit, srok_credit);
					calc.execute();		
					double result = calc.getResult();
					
					textField_3.setText(Double.toString(result));
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
		button.setBounds(0, 90, 273, 36);
		frame.getContentPane().add(button);
		
		textField_3 = new JTextField();
		textField_3.setBounds(134, 124, 139, 48);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u0421\u0443\u043C\u043C\u0430 \u043A\u0440\u0435\u0434\u0438\u0442\u0430");
		lblNewLabel.setBounds(0, 0, 139, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u0421\u0442\u0430\u0432\u043A\u0430 \u043A\u0440\u0435\u0434\u0438\u0442\u0430");
		lblNewLabel_1.setBounds(0, 31, 139, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u0421\u0440\u043E\u043A \u043A\u0440\u0435\u0434\u0438\u0442\u0430");
		lblNewLabel_2.setBounds(0, 59, 139, 31);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u041F\u043B\u0430\u0442\u0435\u0436 \u0441\u043E\u0441\u0442\u043E\u0432\u043B\u044F\u0435\u0442");
		lblNewLabel_3.setBounds(0, 124, 139, 48);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
