import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Boxes extends JFrame
		implements ActionListener
{
	private BoxDrawer canvas;
	private JComboBox colorList;
	private JCheckBox filled;
	private JRadioButton rounded, threeD, none;
	private ButtonGroup edgeType;
	private JMenuBar menuBar;
	private JMenu incDec;
	private JMenuItem increase, decrease;
	
	private static String colorNames[] =
			{" red", " orange", " yellow",
					" green", " blue", " cyan", " magenta",
					" gray", " light gray", " dark gray", " pink", " black", " white"};
	
	private static Color colorValues[] =
			{Color.RED, Color.ORANGE, Color.YELLOW,
					Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA,
					Color.GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY, Color.PINK, Color.BLACK, Color.WHITE};
	
	public Boxes()
	{
		super("Boxes");
		
		increase = new JMenuItem("Increase size");
		increase.addActionListener(this);
		decrease = new JMenuItem("Decrease size");
		decrease.addActionListener(this);
		incDec = new JMenu("Change Size");
		incDec.add(increase);
		incDec.add(decrease);
		menuBar = new JMenuBar();
		menuBar.add(incDec);
		this.setJMenuBar(menuBar);
		
		colorList = new JComboBox(colorNames);
		colorList.addActionListener(this);
		
		filled = new JCheckBox("Filled");
		filled.addActionListener(this);
		rounded = new JRadioButton("Rounded");
		rounded.addActionListener(this);
		threeD = new JRadioButton("3D");
		threeD.addActionListener(this);
		none = new JRadioButton("None");
		none.addActionListener(this);
		
		edgeType = new ButtonGroup();
		edgeType.add(rounded);
		edgeType.add(threeD);
		edgeType.add(none);
		
		JPanel controls = new JPanel();
		controls.add(colorList);
		controls.add(filled);
		controls.add(rounded);
		controls.add(threeD);
		controls.add(none);
		
		canvas = new BoxDrawer();
		
		Container c = getContentPane();
		c.add(controls, BorderLayout.SOUTH);
		c.add(canvas, BorderLayout.CENTER);
		
		Color color = colorValues[colorList.getSelectedIndex()];
		canvas.setBoxColor(color);
		
		canvas.setBoxType(0);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Color color = colorValues[colorList.getSelectedIndex()];
		canvas.setBoxColor(color);
		
		if(e.getActionCommand().equals("Increase size"))
			canvas.increaseSize();
		else if(e.getActionCommand().equals("Decrease size"))
			canvas.decreaseSize();
		
		int type = 0;
		if (filled.isSelected())
			type += 1;
		if (rounded.isSelected())
			type += 2;
		if (threeD.isSelected())
			type += 4;
		canvas.setBoxType(type);
		
		canvas.repaint();
	}
	
	public static void main(String[] args)
	{
		Boxes window = new Boxes();
		window.setBounds(100, 100, 400, 240);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}

