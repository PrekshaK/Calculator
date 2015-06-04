import javax.swing.JFrame;
public class main extends JFrame {
	
	public static void main(String[] args){
		
		Calculator calc = new Calculator();
		calc.setDefaultCloseOperation(EXIT_ON_CLOSE);
		calc.setSize(200, 200);
		calc.setVisible(true);
	}

}
