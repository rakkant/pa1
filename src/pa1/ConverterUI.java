package pa1;

/** @author Rakkan Tiasakul 5810546013
 * This class is UI for Converter program.
 */

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JMenuItem;


public class ConverterUI extends JFrame {
	/**
	 * Constructer as global variables
	 */
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField2;
	private JButton convertButton;
	private JButton clearButton;
	private UnitConverter unitconverter;
	private JComboBox<Unit> comboBox ;
	private JComboBox<Unit> comboBox_2;
	private JRadioButton leftToRight;
	private JRadioButton rightToLeft;
	private JMenuBar menuBar;
	private JMenu mnUnitType;
	private JMenuItem mnLength;
	private JMenuItem mnWeight;
	private JMenuItem mnArea;
	private JMenuItem mnCurrency;
	private JSeparator separator;
	private JMenuItem mnExit;
	private Unit u;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		UnitConverter uc = new UnitConverter();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterUI frame = new ConverterUI(uc);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public  ConverterUI(UnitConverter uc){
		this.unitconverter = uc;
		this.setTitle ("Converter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
	}


	private void initComponents(){

		setBounds(100, 100, 600, 100);
		ActionListener convert = new ConvertButtonListener();
		ActionListener clear = new ClearButtonListener();
		ActionListener Left = new ChooseLeftToRight();
		ActionListener Right = new ChooseRightToLeft();
		KeyListener convertEnter = new ConvertButtonListener();
		ActionListener menuSelect1 = new ConvertChoiceCurrency();
		ActionListener menuSelect2 = new ConvertChoiceWeight();
		ActionListener menuSelect3 = new ConvertChoiceArea();
		ActionListener menuSelect4 = new ConvertChoiceLength();

		menuBar = new JMenuBar();

		setJMenuBar(menuBar);

		mnUnitType = new JMenu("Unit Type");
		menuBar.add(mnUnitType);

		mnLength = new JMenuItem("Length");
		mnUnitType.add(mnLength);
		mnLength.addActionListener(menuSelect4);

		mnWeight = new JMenuItem("Weight");
		mnUnitType.add(mnWeight);
		mnWeight.addActionListener(menuSelect2);

		mnArea = new JMenuItem("Area");
		mnUnitType.add(mnArea);
		mnArea.addActionListener(menuSelect3);

		mnCurrency = new JMenuItem("Currency");
		mnUnitType.add(mnCurrency);
		mnCurrency.addActionListener(menuSelect1);

		separator = new JSeparator();
		mnUnitType.add(separator);

		mnExit = new JMenuItem("Exit");
		mnExit.addActionListener(new ExitMenu());
		mnUnitType.add(mnExit);


		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));

		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(convert);

		comboBox = new JComboBox<Unit>();
		UnitType utype = UnitType.Length;
		Unit[] units = unitconverter.getUnits(utype);
		for(Unit u : units) comboBox.addItem(u);


		comboBox.addKeyListener(convertEnter);
		contentPane.add(comboBox);


		JLabel label = new JLabel("=");
		contentPane.add(label);

		textField2 = new JTextField();
		contentPane.add(textField2);
		textField2.setColumns(10);
		textField2.addActionListener(convert);

		comboBox_2 = new JComboBox<Unit>();
		UnitType utype2 = UnitType.Length;
		Unit[] units2 = unitconverter.getUnits(utype2);
		for(Unit u : units2)
		comboBox_2.addItem(u);
		comboBox_2.addKeyListener(convertEnter);
		contentPane.add(comboBox_2);

		convertButton = new JButton("Convert!");
		convertButton.addActionListener(convert);
		contentPane.add(convertButton);

		clearButton = new JButton("Clear");
		clearButton.addActionListener(clear);
		contentPane.add(clearButton);

		leftToRight = new JRadioButton("Left -> Right");
		leftToRight.addActionListener(Left);
		leftToRight.setSelected(true);
		contentPane.add(leftToRight);

		rightToLeft = new JRadioButton("Right -> Left");
		rightToLeft.addActionListener(Right);
		contentPane.add(rightToLeft);

	}
	/**
	 * 
	 * This class is for using to exit the UI window by clicking on "exit" in menuItem.
	 *
	 */
	class ExitMenu extends AbstractAction{
		public ExitMenu(){
			super("Exit");
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);		
		}
	}

	/**
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * @version This method implements ActionListener. Using for clicking on Left to Right button
	 * after clicking on that button textField would be editable while textField2 would not. 
	 * But the value after converting will be showed in textField2 instead.
	 */

	class ChooseLeftToRight implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			textField.setEditable(true);
			textField2.setEditable(false);	
			leftToRight.setSelected(true);
			rightToLeft.setSelected(false);
		}
	}

	/** 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 *  @version This method implements ActionListener. Using for clicking on Right to Left button
	 * after clicking on that button textField2 would be editable while textField would not. 
	 * But the value after converting will be showed in textField instead.
	 */

	class ChooseRightToLeft implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			textField2.setEditable(true);
			textField.setEditable(false);	
			rightToLeft.setSelected(true);
			leftToRight.setSelected(false);
		}
	}

	/**
	 * @version  This method implements ActionListener, use for set textField to be ""
	 * after clicking on clear button.
	 */
	class ClearButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent evt){
			textField.setText("");
			textField2.setText("");
		}
	}

	class ConvertChoiceCurrency implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			mnCurrency.isSelected();
			comboBox.removeAllItems();
			comboBox_2.removeAllItems();
			UnitType utype = UnitType.Currency;
			Unit[] units = unitconverter.getUnits(utype);
			for(Unit u : units) comboBox.addItem(u);
			UnitType utype2 = UnitType.Currency;
			Unit[] units2 = unitconverter.getUnits(utype2);
			for(Unit u : units2)
			comboBox_2.addItem(u);

		}
	}

	class ConvertChoiceWeight implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mnWeight.isSelected();
			comboBox.removeAllItems();
			comboBox_2.removeAllItems();
			UnitType utype = UnitType.Weight;
			Unit[] units = unitconverter.getUnits(utype);
			for(Unit u : units) comboBox.addItem(u);
			UnitType utype2 = UnitType.Weight;
			Unit[] units2 = unitconverter.getUnits(utype2);
			for(Unit u : units2)
			comboBox_2.addItem(u);

		}
	}

	class ConvertChoiceArea implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mnArea.isSelected();
			comboBox.removeAllItems();
			comboBox_2.removeAllItems();
			UnitType utype = UnitType.Area;
			Unit[] units = unitconverter.getUnits(utype);
			for(Unit u : units) comboBox.addItem(u);
			UnitType utype2 = UnitType.Area;
			Unit[] units2 = unitconverter.getUnits(utype2);
			for(Unit u : units2)
			comboBox_2.addItem(u);
		}
	}

	class ConvertChoiceLength implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			mnCurrency.isSelected();
			comboBox.removeAllItems();
			comboBox_2.removeAllItems();
			UnitType utype = UnitType.Length;
			Unit[] units = unitconverter.getUnits(utype);
			for(Unit u : units) comboBox.addItem(u);
			UnitType utype2 = UnitType.Length;
			Unit[] units2 = unitconverter.getUnits(utype2);
			for(Unit u : units2)
			comboBox_2.addItem(u);
		} 

	}
	class ConvertButtonListener implements ActionListener, KeyListener{
		/**
		 * This is a method for converting the unit.
		 * @exception to throw the exception if the input is not a number.
		 */
		public void convert(){
			String s = textField.getText().trim();
			String u = textField2.getText().trim();
			System.out.println("actionPerformed : input = " +s);
			System.out.println("actionPerformed : input = " +u);
			if (s.length() > 0 || u.length() > 0){
				try{
					Unit temp1 =  (Unit)comboBox.getSelectedItem();
					Unit temp2 = (Unit)comboBox_2.getSelectedItem();
					if(leftToRight.isSelected()){
						double value = Double.valueOf(s);
						textField2.setText(Double.toString(unitconverter.convert(value, temp1, temp2)));
					}
					else{
						double value = Double.valueOf(u);
						textField.setText(Double.toString(unitconverter.convert(value, temp2, temp1)));
					}
				}catch (NumberFormatException e){
					e.printStackTrace();
				}
			}
		}
		public void actionPerformed (ActionEvent evt){
			this.convert();
		}
		/**
		 * (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 * These three interface belong to KeyListener.
		 * In this case, we only need to press the Enter button on a keyboard for converting instead of clicking Convert button on UI
		 * So we write the condition in KeyPressed only and at the value of Enter button in KeyCode, then we call the method convert();
		 * 
		 */
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER){
				this.convert();
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
		}
	}

}
