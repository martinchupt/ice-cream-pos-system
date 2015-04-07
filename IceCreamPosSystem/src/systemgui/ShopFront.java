package systemgui;

import icecream.IceCreamDecorator;
import icecream.IceCreamFlavor;
import icecream.IceCreamTransaction;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ShopFront extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 5942918026890601854L;
	JPanel panel_flavor = new JPanel();
	JPanel panel_decorator = new JPanel();
	JPanel panel_sale_admin = new JPanel();
	JPanel panel_display = new JPanel();
	JButton btn_newSale, btn_sysAdmin;
	
	JButton[] btn;
	JRadioButton[] rbtn;
	JLabel display;
	
	private IceCreamTransaction iceCreamTransaction;

	private IceCreamFlavor chocolate;	//
	private IceCreamFlavor vanilla;		//  Define variables of flavors
	private IceCreamFlavor newFlavor;	//
	
	private IceCreamDecorator mm;				//
	private IceCreamDecorator strawberry;		//  Define variables of decorators
	private IceCreamDecorator newDecorator;		//
		
	public ShopFront() {
		
		iceCreamTransaction = new IceCreamTransaction();
		
		chocolate = new IceCreamFlavor("Chocolate", "Chocolate IceCream", 20);		//
		vanilla = new IceCreamFlavor("Vanilla", "Vanilla IceCream", 20);			//  Create flavor objects and give values 
		newFlavor = new IceCreamFlavor();											//
				
		mm = new IceCreamDecorator("M & M", "", 5);									//
		strawberry = new IceCreamDecorator("Strawberry", "", 4);					//  Create decorator objects and give values 
		newDecorator = new IceCreamDecorator();										//
				
		
		// Set Flavor Panel
		panel_flavor.setBounds(20, 20, 500, 50);
		panel_flavor.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Flavor"));
		panel_flavor.setLayout(new GridLayout(1,3));
		
		rbtn = new JRadioButton[3];																//
		rbtn[0] = new JRadioButton(chocolate.getName() + " ($" + chocolate.getCost() + ")");	//
		rbtn[1] = new JRadioButton(vanilla.getName() + " ($" + vanilla.getCost() + ")");		//
		rbtn[2] = new JRadioButton();															//
		rbtn[2].setVisible(false);																//
		ButtonGroup group = new ButtonGroup();													//  "Flavor" RadioButton
	    for(int i = 0; i < rbtn.length; i++) {													//
	      rbtn[i].addActionListener(this);														//
	      group.add(rbtn[i]);																	//
	      panel_flavor.add(rbtn[i]);															//
	    }																						//
		add(panel_flavor);																		//
		
		
		// Set Decorator Panel
		
		panel_decorator.setBounds(20, 70, 500, 50);
		panel_decorator.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Decorator"));
		panel_decorator.setLayout(new GridLayout(1,3));
		
		btn = new JButton[3];																//
		btn[0] = new JButton(mm.getName() + " ($" + mm.getCost() + ")");					//
		btn[1] = new JButton(strawberry.getName() + " ($" + strawberry.getCost() + ")");	//
		btn[2] = new JButton();																//
		btn[2].setVisible(false);															//  "Decorator" Button
		for(int i = 0; i < btn.length; i++) {												//
			btn[i].addActionListener(this);													//
			panel_decorator.add(btn[i]);													//
		}																					//
		add(panel_decorator);																//
		
		// Set Sale & Admin Panel
		
		panel_sale_admin.setBounds(20, 130, 500, 50);
		panel_sale_admin.setLayout(new GridLayout(1,2));
		
		btn_newSale = new JButton("New Ice Cream");			//
		btn_newSale.addActionListener(this);				//  "New Ice Cream" Button
		panel_sale_admin.add(btn_newSale);					//
		
		btn_sysAdmin = new JButton("System Administrator");	//
		btn_sysAdmin.addActionListener(this);				//  "System Administrator" Button
		panel_sale_admin.add(btn_sysAdmin);					//
		
		add(panel_sale_admin);
		
		
		// Set Display Panel
		
		panel_display.setBounds(20, 190, 500, 50);
		panel_display.setBackground(Color.orange);
		panel_display.setVisible(false);
		
		display = new JLabel();								//
		panel_display.add(display);							//  "display" Label
		add(panel_display);									//
		
		
		// Set Main Frame
		
	    setTitle("Ice Cream Shop POS System");
	    setLayout(null);
	    setBounds(50, 50, 560, 300);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent e){
		
		// Set action when flavor radio button is selected
		
		if (rbtn[0].isSelected() || rbtn[1].isSelected() || rbtn[2].isSelected()) {
			
			panel_display.setVisible(true);
			
			if (rbtn[0].isSelected()) {								//
				iceCreamTransaction.setFlavor(chocolate);			//
			}														//
			if (rbtn[1].isSelected()) {								//
				iceCreamTransaction.setFlavor(vanilla);				//  Pass flavor parameter to IceCreamTransaction class
			}														//
			if (rbtn[2].isSelected()) {								//
				iceCreamTransaction.setFlavor(newFlavor);			//
			}														//
			
			display.setText(iceCreamTransaction.getSummary());		//  Get and display the result from IceCreamTransaction class
		
		}
		
		
		// Set action when decorator button is clicked
		
		if (e.getSource() == btn[0] || e.getSource() == btn[1] || e.getSource() == btn[2]) {
			
			panel_display.setVisible(true);
			
			if(e.getSource() == btn[0]) {									//
				iceCreamTransaction.addDecoratorQuantity(mm);				//
			}																//
			if(e.getSource() == btn[1]) {									//
				iceCreamTransaction.addDecoratorQuantity(strawberry);		//  Pass decorator parameter to IceCreamTransaction class
			}																//
			if(e.getSource() == btn[2]) {									//
				iceCreamTransaction.addDecoratorQuantity(newDecorator);		//
			}																//
			
			display.setText(iceCreamTransaction.getSummary());		//  Get and display the result from IceCreamTransaction class
		
		}
		
		
		// Set action when "New Ice Cream" button is clicked
		
		if (e.getSource() == btn_newSale) {
			iceCreamTransaction = new IceCreamTransaction();		//  Restart the program by new object
			display.setText("");									//  Clear the display label 
		}
		
		
		// Set action when "System Administrator" button is clicked
		
		if (e.getSource() == btn_sysAdmin) {
			
			// First input dialog box, ask for the input type of new item
			Object[] choice = {"Flavor", "Decorator"};
			String inputType = (String)JOptionPane.showInputDialog(rootPane, "Decorator or Flavor?", "Choose a type", JOptionPane.QUESTION_MESSAGE, null, choice, "Flavor");
			
			// Second input dialog box, ask for the name of item
			// Third input dialog box, ask for the price of item
			if (inputType == "Flavor") {
				String itemName = (String)JOptionPane.showInputDialog(rootPane, "What is the item's name?", "Enter the name", JOptionPane.QUESTION_MESSAGE);
				String itemPrice = (String)JOptionPane.showInputDialog(rootPane, "What is the price?", "Enter the price", JOptionPane.QUESTION_MESSAGE);
				if (itemName!= null && itemPrice != null) {
					double dprice = Double.parseDouble(itemPrice);	//  Convert the type of price (string --> double)
					newFlavor = new IceCreamFlavor(itemName, itemName + " IceCream", dprice);  //  Pass the input data to the newFlavor object
					rbtn[2].setText(newFlavor.getName() + " ($" + newFlavor.getCost() + ")");  //  Set text for the radio button
					rbtn[2].setVisible(true);
				}			
			}
			
			if (inputType == "Decorator") {
				String itemName = (String)JOptionPane.showInputDialog(rootPane, "What is the item's name?", "Enter the name", JOptionPane.QUESTION_MESSAGE);
				String itemPrice = (String)JOptionPane.showInputDialog(rootPane, "What is the price?", "Enter the price", JOptionPane.QUESTION_MESSAGE);
				if (itemName!= null && itemPrice != null) {
					double dprice = Double.parseDouble(itemPrice);	//  Convert the type of price (string --> double)
					newDecorator = new IceCreamDecorator(itemName, "", dprice);			//  Pass the input data to the newDecorator object
					btn[2].setText(itemName + " ($" + newDecorator.getCost() + ")");	//  Set text for the button
					btn[2].setVisible(true);
				}
				
			}

		
		}
	
	}
	
}
