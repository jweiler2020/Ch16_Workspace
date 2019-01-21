import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class PizzaGUI extends JFrame
{
	public PizzaGUI()
	{
		JRadioButton small = new JRadioButton("Small");
		JRadioButton med = new JRadioButton("Medium");
		JRadioButton large = new JRadioButton("Large");
		ButtonGroup bg = new ButtonGroup();
		bg.add(small);
		bg.add(med);
		bg.add(large);

		JPanel sizes = new JPanel();
		sizes.setLayout(new GridLayout(3, 1));
		sizes.add(small);
		sizes.add(med);
		sizes.add(large);

		sizes.setBorder(new CompoundBorder(
				new LineBorder(Color.BLACK, 1),
				new EmptyBorder(6, 6, 6, 6)
		));


		JCheckBox cheese = new JCheckBox("Extra cheese");
		JCheckBox mush = new JCheckBox("Mushrooms");
		JCheckBox pepp = new JCheckBox("Pepperoni");

		JPanel toppings = new JPanel();
		toppings.setLayout(new GridLayout(3, 1));
		toppings.add(cheese);
		toppings.add(mush);
		toppings.add(pepp);

		toppings.setBorder(new CompoundBorder(
				new LineBorder(Color.BLACK, 1),
				new EmptyBorder(6, 6, 6, 6)
		));


		JToggleButton toGo = new JToggleButton("To Go", false);


		Box b = Box.createHorizontalBox();
		b.add(Box.createHorizontalStrut(10));
		b.add(sizes);
		b.add(Box.createHorizontalStrut(10));
		b.add(toppings);
		b.add(Box.createHorizontalStrut(10));
		b.add(toGo);
		b.add(Box.createHorizontalStrut(10));


		Container c = getContentPane();
		c.add(b);
	}

	public static void main(String[] args)
	{
		PizzaGUI pizza = new PizzaGUI();
		pizza.setBounds(100, 100, 400, 200);
		pizza.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pizza.setVisible(true);
	}
}
