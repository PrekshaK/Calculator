import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Calculator extends JFrame{
	
	private String signentered = "";   							//determine which sign is entered
	private String numentered;									// which number is just entered
	private int total = 0; 										//calculate total after sign is entered
	private int inumentered;									//store the integer value of string number entered
	private static String allnumentered = "";					//store all number entered.(when two digit numbers are entered)
	private int savednum;										// number before sign entered;
	private boolean equalentered = false;
	
	//buttons in JFrame
	private JButton[] numbuttons = {new JButton("0"), new JButton("1"), new JButton("2"), new JButton("3"), new JButton("4"), new JButton("5"), new JButton("6"), new JButton("7"), new JButton("8"), new JButton("9")};
	private JButton[] signbuttons = {new JButton("+"), new JButton("-"), new JButton("*"), new JButton("/")};
	private JButton equaltobutton = new JButton("=");
	
	//Textfield where number and signs appears after clicking buttons
	private JTextField  textfield = new JTextField(15);
	
	
	//construcotor
	public Calculator(){
		
		super("Calculator");							//title of JFrame
		setLayout(new FlowLayout());					//layout of JFrame
		add(textfield);									//adding textfield to JFrame
		
		NumClass numhandler = new NumClass();			//object of class that handles number buttons when clicked
		for (JButton x: numbuttons){					
			add(x);										//adding number buttons to JFrame
			x.addActionListener(numhandler);			//adding actionlistener functionality to the object of the class that handles number buttons
		}
		
		SignClass signhandler = new SignClass();		//object of class that handles sign buttons when clicked
		for (JButton y: signbuttons){
			add(y);										//adding sign buttons to JFrame
			y.addActionListener(signhandler);			// adding actionlistener functionality to the object of the class that handles sign buttons
		}
		
		EqualClass equalhandler = new EqualClass();			//object of class that handles equalto button when clicked
		add(equaltobutton);									//adding equalto button to JFrame
		equaltobutton.addActionListener(equalhandler);		// adding actionlistener functionality to the object of the class that handles sign buttons
	}
	
	
	private class NumClass implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			if (equalentered)
				textfield.setText("");
			
			numentered = event.getActionCommand();
			allnumentered += numentered;
			textfield.setText(textfield.getText() + event.getActionCommand());
			inumentered = Integer.parseInt(allnumentered);
			total = inumentered;
			equalentered = false;
		}
	}
	
	private class SignClass implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			if (signentered == "+")
				total +=  savednum;
			
			else if (signentered == "-")
				total =  savednum - total;
			
			else if (signentered == "*")
				total *=  savednum;
			
			else if (signentered == "/")
				total =  savednum / total;
			
			savednum = total;
			signentered = event.getActionCommand();
			textfield.setText(textfield.getText() + event.getActionCommand());
			allnumentered = "";
			
		}
	}
	
	
	private class EqualClass implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			if (signentered == "+")
				total +=  savednum;
			
			else if (signentered == "-")
				total =  savednum - total;
			
			else if (signentered == "*")
				total *=  savednum;
			
			else if (signentered == "/")
				total =  savednum / total;
			
			

			
			textfield.setText(String.format("%s", total));
			
			equalentered = true;
			total = 0;
			allnumentered = "";
			signentered = "";
		}
	}

}
