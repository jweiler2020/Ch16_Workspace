import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Translator extends JFrame
		implements ActionListener
{
	private static final String translated = "Eu não falo português.";
	
	private JButton translate;
	
	public Translator()
	{
		super("Translator");
		
		JLabel engl = new JLabel("English:", SwingConstants.RIGHT);
		JLabel port = new JLabel("Portuguese:", SwingConstants.RIGHT);
		JPanel labels = new JPanel();
		labels.setLayout(new GridLayout(2, 1));
		labels.add(engl);
		labels.add(port);
		JTextField englIn = new JTextField();
		JTextField portIn = new JTextField();
		JPanel inputs = new JPanel();
		inputs.setLayout(new GridLayout(2, 1));
		inputs.add(englIn);
		inputs.add(portIn);
		
		Box inputLabels = Box.createHorizontalBox();
		inputLabels.add(labels);
		inputLabels.add(Box.createHorizontalStrut(10));
		inputLabels.add(inputs);
		
		translate = new JButton("Translate");
		
		Box everything = Box.createVerticalBox();
		everything.add(inputLabels);
		everything.add(Box.createVerticalStrut(10));
		everything.add(translate);
		
		Container c = getContentPane();
		c.add(everything);
	}
	
	public void actionPerformed(ActionEvent e)
	{
	}
	
	public static void main(String[] args)
	{
		Translator window = new Translator();
		window.setBounds(100, 100, 400, 200);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
