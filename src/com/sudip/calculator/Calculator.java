package com.sudip.calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	String curr, prev;
	private boolean on;
	String buffer;
	int res;

	/**
	 * Create the frame.
	 */
	public Calculator() {
		res = 0;
		on = false;
		curr = prev = "";

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.disable();
		textField.setBounds(84, 30, 159, 33);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton button = new JButton("1");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				display("1");
			}
		});
		button.setBounds(84, 123, 44, 40);
		contentPane.add(button);

		JButton button_1 = new JButton("2");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				display("2");
			}
		});
		button_1.setBounds(138, 123, 44, 40);
		contentPane.add(button_1);

		JButton button_2 = new JButton("3");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				display("3");
			}
		});
		button_2.setBounds(188, 123, 44, 40);
		contentPane.add(button_2);

		JButton button_3 = new JButton("+");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				display("+");
			}
		});
		button_3.setBounds(242, 123, 66, 40);
		contentPane.add(button_3);

		JButton button_4 = new JButton("4");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				display("4");
			}
		});
		button_4.setBounds(84, 174, 44, 40);
		contentPane.add(button_4);

		JButton button_5 = new JButton("5");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				display("5");
			}
		});
		button_5.setBounds(138, 174, 44, 40);
		contentPane.add(button_5);

		JButton button_6 = new JButton("6");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				display("6");
			}
		});
		button_6.setBounds(192, 174, 44, 40);
		contentPane.add(button_6);

		JButton button_7 = new JButton("-");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				display("-");
			}
		});

		button_7.setBounds(242, 174, 66, 40);
		contentPane.add(button_7);

		JButton button_8 = new JButton("7");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				display("7");
			}
		});
		button_8.setBounds(84, 225, 44, 40);
		contentPane.add(button_8);

		JButton button_9 = new JButton("8");
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				display("8");
			}
		});
		button_9.setBounds(138, 225, 44, 40);
		contentPane.add(button_9);

		JButton button_10 = new JButton("9");
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				display("9");
			}
		});
		button_10.setBounds(192, 225, 44, 40);
		contentPane.add(button_10);

		JButton btnX = new JButton("X");
		btnX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				display("X");
			}
		});
		btnX.setBounds(242, 225, 66, 40);
		contentPane.add(btnX);

		JButton button_12 = new JButton(".");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_12.setBounds(84, 270, 44, 40);
		contentPane.add(button_12);

		JButton button_13 = new JButton("0");
		button_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				display("0");
			}
		});
		button_13.setBounds(138, 270, 44, 40);
		contentPane.add(button_13);

		JButton button_14 = new JButton("/");
		button_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				display("/");
			}
		});
		button_14.setBounds(192, 270, 44, 40);
		contentPane.add(button_14);

		JButton button_15 = new JButton("=");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display("=");
			}
		});
		button_15.setBounds(242, 270, 66, 40);
		contentPane.add(button_15);

		JButton btnOn = new JButton("ON");
		btnOn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField.setEnabled(true);
				textField.requestFocus();
				on = true;

			}
		});
		btnOn.setBounds(84, 74, 65, 40);
		contentPane.add(btnOn);

		JButton btnOff = new JButton("OFF");
		btnOff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(" ");
				curr = "";
				on = false;
				textField.setEnabled(false);

			}
		});
		btnOff.setBounds(237, 72, 71, 40);
		contentPane.add(btnOff);

		JButton btnAc = new JButton("AC");
		btnAc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				curr = "";
			}
		});
		btnAc.setBounds(159, 74, 73, 40);
		contentPane.add(btnAc);

		JButton btnDel = new JButton("X");
		btnDel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(buffer);
			}
		});
		btnDel.setBackground(Color.RED);
		btnDel.setForeground(Color.DARK_GRAY);
		btnDel.setBounds(253, 37, 55, 33);
		contentPane.add(btnDel);
	}

	public void display(String str) {
		if (on == true) {
			if (str.equals("=")) {
				calculate(curr);
			} else {
				buffer = curr;
				curr = curr + str;
				textField.setText(curr);
			}
		} else {
			textField.disable();
		}
	}

	public void calculate(String num) {

		if (num.contains("+")) {
			String[] str = num.split("\\+");
			res = (Integer.parseInt(str[0])) + (Integer.parseInt(str[1]));
		}
		if (num.contains("X")) {
			String[] str = num.split("X");
			res = Integer.parseInt(str[0]) * Integer.parseInt(str[1]);
		}
		if (num.contains("-")) {
			String[] str = num.split("-");
			res = Integer.parseInt(str[0]) - Integer.parseInt(str[1]);
		}
		if (num.contains("/")) {
			String[] str = num.split("/");
			res = Integer.parseInt(str[0]) / Integer.parseInt(str[1]);
		}
		textField.setText(Integer.toString(res));

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
