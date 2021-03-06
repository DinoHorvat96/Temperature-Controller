package hr.veleri.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hr.veleri.controller.TemperaturaController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UnosView {

	private JFrame frame;
	private JTextField textFieldNazivMjeseca;
	private JTextField textFieldDanUMjesecu;
	private JTextField textFieldJutarnjaTemp;
	private JTextField textFieldPopodnevnaTemp;
	private JTextField textFieldVecernjaTemp;
	private JTextField textFieldProsjecnaTemp;
	
	private TemperaturaController korisnickaTemperaturaController = new TemperaturaController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnosView window = new UnosView();
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
	public UnosView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNazivMjeseca = new JLabel("Naziv mjeseca:");
		lblNazivMjeseca.setBounds(10, 26, 89, 14);
		frame.getContentPane().add(lblNazivMjeseca);
		
		JLabel lblDanUMjesecu = new JLabel("Dan u mjesecu:");
		lblDanUMjesecu.setBounds(10, 51, 89, 14);
		frame.getContentPane().add(lblDanUMjesecu);
		
		JLabel lblJutarnjaTemp = new JLabel("Jutarnja temp.:");
		lblJutarnjaTemp.setBounds(10, 76, 89, 14);
		frame.getContentPane().add(lblJutarnjaTemp);
		
		JLabel lblPopodnevnaTemp = new JLabel("Popodnevna temp.:");
		lblPopodnevnaTemp.setBounds(10, 101, 123, 14);
		frame.getContentPane().add(lblPopodnevnaTemp);
		
		JLabel lblVecernjaTemp = new JLabel("Vecernja temp.:");
		lblVecernjaTemp.setBounds(10, 126, 89, 14);
		frame.getContentPane().add(lblVecernjaTemp);
		
		textFieldNazivMjeseca = new JTextField();
		textFieldNazivMjeseca.setBounds(156, 23, 86, 20);
		frame.getContentPane().add(textFieldNazivMjeseca);
		textFieldNazivMjeseca.setColumns(10);
		
		textFieldDanUMjesecu = new JTextField();
		textFieldDanUMjesecu.setBounds(156, 48, 86, 20);
		frame.getContentPane().add(textFieldDanUMjesecu);
		textFieldDanUMjesecu.setColumns(10);
		
		textFieldJutarnjaTemp = new JTextField();
		textFieldJutarnjaTemp.setBounds(156, 73, 86, 20);
		frame.getContentPane().add(textFieldJutarnjaTemp);
		textFieldJutarnjaTemp.setColumns(10);
		
		textFieldPopodnevnaTemp = new JTextField();
		textFieldPopodnevnaTemp.setBounds(156, 98, 86, 20);
		frame.getContentPane().add(textFieldPopodnevnaTemp);
		textFieldPopodnevnaTemp.setColumns(10);
		
		textFieldVecernjaTemp = new JTextField();
		textFieldVecernjaTemp.setBounds(156, 123, 86, 20);
		frame.getContentPane().add(textFieldVecernjaTemp);
		textFieldVecernjaTemp.setColumns(10);
		
		JButton btnPotvrda = new JButton("Potvrdi unos dnevne temperature");
		btnPotvrda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nazivMjeseca;
				int danUMjesecu;
				float jutarnjaTemp;
				float popodnevnaTemp;
				float vecernjaTemp;
				float prosjecnaJutarnjaTemp;
				
				nazivMjeseca = textFieldNazivMjeseca.getText();
				danUMjesecu = Integer.parseInt(textFieldDanUMjesecu.getText());
				jutarnjaTemp = Integer.parseInt(textFieldJutarnjaTemp.getText());
				popodnevnaTemp = Integer.parseInt(textFieldPopodnevnaTemp.getText());
				vecernjaTemp = Integer.parseInt(textFieldVecernjaTemp.getText());
				
				korisnickaTemperaturaController.kreirajDnevnuTemperaturu(nazivMjeseca, danUMjesecu, jutarnjaTemp, popodnevnaTemp, vecernjaTemp);
				
				prosjecnaJutarnjaTemp = korisnickaTemperaturaController.izracunProsjecnihJutarnjih();
				
				textFieldProsjecnaTemp.setText(String.valueOf(prosjecnaJutarnjaTemp));
			}
		});
		btnPotvrda.setBounds(10, 166, 232, 23);
		frame.getContentPane().add(btnPotvrda);
		
		JLabel lblProsjecnaJutarnjaTemp = new JLabel("Prosjecna jutarnja temp.:");
		lblProsjecnaJutarnjaTemp.setBounds(10, 217, 152, 14);
		frame.getContentPane().add(lblProsjecnaJutarnjaTemp);
		
		textFieldProsjecnaTemp = new JTextField();
		textFieldProsjecnaTemp.setBounds(187, 214, 86, 20);
		frame.getContentPane().add(textFieldProsjecnaTemp);
		textFieldProsjecnaTemp.setColumns(10);
	}
}
