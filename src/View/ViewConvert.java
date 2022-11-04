package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControllerButton;
import Controller.ControllerKey;
import Model.Model;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ViewConvert extends JFrame {

	private JPanel contentPane;
	private JTextField inputP;
	private JTextField inputW;
	private JTextField inputA;
	private JTextField output;
	
	public Model model = new Model();

	/**
	 * Create the frame.
	 */
	public ViewConvert() {
		setTitle("Chuyển số nguyên sang mảng");
		ControllerButton controller = new ControllerButton(this);
		ControllerKey key = new ControllerKey(this);
		this.addKeyListener(key);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("p =");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(40, 28, 53, 24);
		contentPane.add(lblNewLabel);
		
		inputP = new JTextField();
		inputP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		inputP.setBounds(75, 21, 156, 34);
		contentPane.add(inputP);
		inputP.setColumns(10);
		inputP.addKeyListener(key);
		
		JLabel lblW = new JLabel("w =");
		lblW.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblW.setBounds(350, 28, 53, 24);
		contentPane.add(lblW);
		
		inputW = new JTextField();
		inputW.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		inputW.setColumns(10);
		inputW.setBounds(385, 21, 156, 34);
		contentPane.add(inputW);
		inputW.addKeyListener(key);
		
		inputA = new JTextField();
		inputA.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		inputA.setColumns(10);
		inputA.setBounds(231, 80, 156, 34);
		contentPane.add(inputA);
		inputA.addKeyListener(key);
		
		JLabel lblA = new JLabel("a =");
		lblA.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblA.setBounds(196, 87, 53, 24);
		contentPane.add(lblA);
		
		
		JButton btnNewButton = new JButton("Tính");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		btnNewButton.setBounds(451, 170, 141, 68);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(controller);
		
		JButton btnNewButton_1 = new JButton("Format");
		btnNewButton_1.setBounds(527, 314, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(controller);
		
		output = new JTextField();
		output.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (output.getText().trim().equalsIgnoreCase("Kết quả")) {
					output.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (output.getText().trim().equalsIgnoreCase("Kết quả") || output.getText().trim().equals("")) {
					output.setText("Kết quả");
				}
			}
		});
		output.setHorizontalAlignment(SwingConstants.CENTER);
		output.setText("Kết quả");
		output.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		output.setBounds(40, 174, 369, 68);
		contentPane.add(output);
		output.setColumns(10);
		
	}
	
	public void format() {
		inputA.setText("");
		inputP.setText("");
		inputW.setText("");
		output.setText("Kết quả");
	}
	
	public boolean checkInput() {
		boolean checkA = inputA.getText().trim().equalsIgnoreCase("");
		boolean checkP = inputP.getText().trim().equalsIgnoreCase("");
		boolean checkW = inputW.getText().trim().equalsIgnoreCase("");
		
		if (checkA && checkP && checkW) {
			JOptionPane.showMessageDialog(this, "Hãy nhập các giá trị", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (checkA) {
			JOptionPane.showMessageDialog(this, "Nhập giá trị a", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}else if (checkP) {
			JOptionPane.showMessageDialog(this, "Nhập giá trị p", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}else if (checkW) {
			JOptionPane.showMessageDialog(this, "Nhập giá trị w", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public void setOutput() {
		if (checkInput()) {
			try {
				model.setP(Double.parseDouble(inputP.getText().trim()));
				model.setA(Long.parseLong(inputA.getText().trim()));
				model.setW(Integer.parseInt(inputW.getText().trim()));
				
				output.setText(model.getResultString());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Lỗi tính toán", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
}
