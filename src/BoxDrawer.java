import javax.swing.*;
import java.awt.*;

public class BoxDrawer extends JPanel
{
	int boxType;
	double size = 1;
	Color color;
	
	public void setBoxType(int boxType) { this.boxType = boxType; }
	
	public void setBoxColor(Color color) { this.color = color; }
	
	public void increaseSize() { size += 0.1; }
	
	public void decreaseSize() { size -= 0.1; }

	public void drawBox(Graphics g)
	{
		int w = (int)(getWidth()/2*size);
		int h = (int)(getHeight()/2*size);
		int x = (getWidth()-w)/2;
		int y = (getHeight()-h)/2;
		g.setColor(color);
		int fontSize = w/15;
		g.setFont(new Font(Font.MONOSPACED, Font.BOLD | Font.ITALIC, fontSize));
		switch(boxType)
		{
			case 0: // 000
				g.drawRect(x, y, w, h);
				break;
			case 1: // 001
				g.fillRect(x, y, w, h);
				break;
			case 2: // 010
				g.drawRoundRect(x, y, w, h, 50, 50);
				break;
			case 3: // 011
				g.fillRoundRect(x, y, w, h, 50, 50);
				break;
			case 4: // 100
				g.draw3DRect(x, y, w, h, true);
				break;
			case 5: // 101
				g.fill3DRect(x, y, w, h, true);
				break;
			default:
				g.drawString("Error: Cannot have both 3D rect and round rect", w/2-24*fontSize/4, h);
				break;
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(color.equals(Color.WHITE))
			setBackground(Color.GRAY);
		else
			setBackground(Color.WHITE);
		drawBox(g);
	}
}
