package com.jbj.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.notDefault.gc.ActionMethod;

public class LibraryGui implements ActionListener{

	private JFrame frame;
	private JTextField nameInput;
	private JTextField searchBox;
	private JTextField textField_2;
	private JButton displayInventory;
	private JTextArea outputText;
	private JButton searchByAuthor;
	private JSpinner bookInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryGui window = new LibraryGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void showGUI(){
		LibraryGui window1 = new LibraryGui();
		window1.frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public LibraryGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(new Color(51, 0, 102));
		frame.setBounds(100, 100, 1119, 666);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {130, 90, 30, 65, 50, 50, 30};
		gridBagLayout.rowHeights = new int[] {95, 0, 95, 95, 95, 48, 48, 48, 30};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Grand Circus Library!");
		lblWelcomeToThe.setPreferredSize(new Dimension(150, 16));
		lblWelcomeToThe.setFont(new Font("Tahoma", Font.PLAIN, 43));
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThe.setOpaque(true);
		lblWelcomeToThe.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblWelcomeToThe.setBackground(new Color(153, 204, 255));
		GridBagConstraints gbc_lblWelcomeToThe = new GridBagConstraints();
		gbc_lblWelcomeToThe.fill = GridBagConstraints.BOTH;
		gbc_lblWelcomeToThe.gridwidth = 11;
		gbc_lblWelcomeToThe.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcomeToThe.gridx = 0;
		gbc_lblWelcomeToThe.gridy = 0;
		frame.getContentPane().add(lblWelcomeToThe, gbc_lblWelcomeToThe);
		
		JButton searchByAuthor = new JButton("Search by author");
		searchByAuthor.setName("searchByAuthor");
		searchByAuthor.setBackground(new Color(153, 255, 51));
		searchByAuthor.setForeground(new Color(0, 0, 0));
		searchByAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				outputText.setText(ActionMethod.researchAuthor(searchBox.getText(), nameInput.getText()));
			}
		});
		
		JLabel lblSearch = new JLabel("Search:");
		GridBagConstraints gbc_lblSearch = new GridBagConstraints();
		gbc_lblSearch.anchor = GridBagConstraints.EAST;
		gbc_lblSearch.insets = new Insets(0, 0, 5, 5);
		gbc_lblSearch.gridx = 0;
		gbc_lblSearch.gridy = 1;
		frame.getContentPane().add(lblSearch, gbc_lblSearch);
		
		searchBox = new JTextField();
		searchBox.setName("searchBox");
		GridBagConstraints gbc_searchBox = new GridBagConstraints();
		gbc_searchBox.insets = new Insets(0, 0, 5, 5);
		gbc_searchBox.fill = GridBagConstraints.BOTH;
		gbc_searchBox.gridx = 1;
		gbc_searchBox.gridy = 1;
		frame.getContentPane().add(searchBox, gbc_searchBox);
		searchBox.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 3;
		gbc_lblName.gridy = 1;
		frame.getContentPane().add(lblName, gbc_lblName);
		
		nameInput = new JTextField();
		nameInput.setName("nameInput");
		GridBagConstraints gbc_nameInput = new GridBagConstraints();
		gbc_nameInput.insets = new Insets(0, 0, 5, 0);
		gbc_nameInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameInput.gridx = 6;
		gbc_nameInput.gridy = 1;
		frame.getContentPane().add(nameInput, gbc_nameInput);
		nameInput.setColumns(10);
		GridBagConstraints gbc_searchByAuthor = new GridBagConstraints();
		gbc_searchByAuthor.fill = GridBagConstraints.BOTH;
		gbc_searchByAuthor.insets = new Insets(0, 0, 5, 5);
		gbc_searchByAuthor.gridx = 0;
		gbc_searchByAuthor.gridy = 2;
		frame.getContentPane().add(searchByAuthor, gbc_searchByAuthor);
		
		JButton searchKeyword = new JButton("Search by keyword");
		searchKeyword.setName("searchKeyword");
		searchKeyword.setBackground(new Color(51, 255, 51));
		GridBagConstraints gbc_searchKeyword = new GridBagConstraints();
		gbc_searchKeyword.fill = GridBagConstraints.BOTH;
		gbc_searchKeyword.insets = new Insets(0, 0, 5, 5);
		gbc_searchKeyword.gridx = 1;
		gbc_searchKeyword.gridy = 2;
		frame.getContentPane().add(searchKeyword, gbc_searchKeyword);
		searchKeyword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				outputText.setText(ActionMethod.researchKeyword(searchBox.getText(), nameInput.getText()));
			}
		});
		
		outputText = new JTextArea();
		outputText.setForeground(new Color(255, 255, 255));
		outputText.setCaretColor(new Color(255, 255, 255));
		outputText.setName("Output Text");
		outputText.setBackground(new Color(0, 51, 102));
		outputText.setDisabledTextColor(new Color(255, 51, 255));
		GridBagConstraints gbc_outputText = new GridBagConstraints();
		gbc_outputText.insets = new Insets(0, 0, 5, 0);
		gbc_outputText.gridwidth = 5;
		gbc_outputText.gridheight = 5;
		gbc_outputText.fill = GridBagConstraints.BOTH;
		gbc_outputText.gridx = 2;
		gbc_outputText.gridy = 2;
		frame.getContentPane().add(outputText, gbc_outputText);
		
		displayInventory = new JButton("Display our inventory");
		displayInventory.setForeground(new Color(255, 255, 255));
		displayInventory.setName("displayInventory");
		displayInventory.setBackground(new Color(0, 51, 153));
		GridBagConstraints gbc_displayInventory = new GridBagConstraints();
		gbc_displayInventory.gridwidth = 2;
		gbc_displayInventory.fill = GridBagConstraints.BOTH;
		gbc_displayInventory.insets = new Insets(0, 0, 5, 5);
		gbc_displayInventory.gridx = 0;
		gbc_displayInventory.gridy = 3;
		frame.getContentPane().add(displayInventory, gbc_displayInventory);
		displayInventory.addActionListener(this);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBackground(new Color(255, 102, 0));
		GridBagConstraints gbc_btnReturn = new GridBagConstraints();
		gbc_btnReturn.gridwidth = 2;
		gbc_btnReturn.fill = GridBagConstraints.BOTH;
		gbc_btnReturn.insets = new Insets(0, 0, 5, 5);
		gbc_btnReturn.gridx = 0;
		gbc_btnReturn.gridy = 4;
		frame.getContentPane().add(btnReturn, gbc_btnReturn);
		btnReturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				outputText.setText(ActionMethod.returnMethod(nameInput.getName(), bookInput.getValue()));
			}
		});
		
		
		
		JButton donateBook = new JButton("Donate Book");
		donateBook.setName("donateBook");
		donateBook.setBackground(new Color(153, 204, 204));
		GridBagConstraints gbc_donateBook = new GridBagConstraints();
		gbc_donateBook.gridwidth = 2;
		gbc_donateBook.fill = GridBagConstraints.BOTH;
		gbc_donateBook.insets = new Insets(0, 0, 5, 5);
		gbc_donateBook.gridx = 0;
		gbc_donateBook.gridy = 5;
		frame.getContentPane().add(donateBook, gbc_donateBook);
		
		
		JLabel lblBookTitle = new JLabel("Book , Author");
		GridBagConstraints gbc_lblBookTitle = new GridBagConstraints();
		gbc_lblBookTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblBookTitle.gridx = 0;
		gbc_lblBookTitle.gridy = 6;
		frame.getContentPane().add(lblBookTitle, gbc_lblBookTitle);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 6;
		frame.getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setName("quit");
		btnQuit.setForeground(new Color(0, 0, 0));
		btnQuit.setBackground(new Color(255, 0, 0));
		GridBagConstraints gbc_btnQuit = new GridBagConstraints();
		gbc_btnQuit.gridheight = 2;
		gbc_btnQuit.gridwidth = 2;
		gbc_btnQuit.fill = GridBagConstraints.BOTH;
		gbc_btnQuit.insets = new Insets(0, 0, 0, 5);
		gbc_btnQuit.gridx = 0;
		gbc_btnQuit.gridy = 7;
		frame.getContentPane().add(btnQuit, gbc_btnQuit);

		
		
		JLabel lblBookid = new JLabel("BookID:");
		GridBagConstraints gbc_lblBookid = new GridBagConstraints();
		gbc_lblBookid.gridheight = 3;
		gbc_lblBookid.insets = new Insets(0, 0, 5, 5);
		gbc_lblBookid.gridx = 3;
		gbc_lblBookid.gridy = 7;
		frame.getContentPane().add(lblBookid, gbc_lblBookid);
		
		bookInput = new JSpinner();
		bookInput.setName("bookInput");
		GridBagConstraints gbc_bookInput = new GridBagConstraints();
		gbc_bookInput.gridheight = 3;
		gbc_bookInput.gridwidth = 4;
		gbc_bookInput.insets = new Insets(0, 0, 5, 5);
		gbc_bookInput.fill = GridBagConstraints.BOTH;
		gbc_bookInput.gridx = 4;
		gbc_bookInput.gridy = 7;
		frame.getContentPane().add(bookInput, gbc_bookInput);
		ArrayList model1 = new ArrayList();
		model1.add("100");
		model1.add("101");
		model1.add("102");
		model1.add("103");
		model1.add("104");
		model1.add("105");
		model1.add("106");
		model1.add("107");
		model1.add("108");
		model1.add("109");
		model1.add("110");
		model1.add("111");
		model1.add("112");
		model1.add("113");
		model1.add("114");
		SpinnerModel model = new SpinnerListModel(model1);
		bookInput.setModel(model);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton firstB = ((JButton)e.getSource());
		System.out.println(((JButton)e.getSource()).getName());
		System.out.println(displayInventory.getName());
		if (firstB.getName().equals(displayInventory.getName())) {
			ActionMethod.readFromBookList();
			outputText.setText(ActionMethod.readFromBookList());
		}
		
	}

}
