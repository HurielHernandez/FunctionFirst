package music;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel
{
	private final String [] function = { "I", "i", "ii", "iio", "iii", "bIII", "IV", "iv", "V", "rV","V/V", "vi", "bVI", "viio","rviio", "bVII"};
	private JComboBox functionComboBox  = new JComboBox(function);
	private final String [] quality = {"M", "m", "d", "a"};
	private JComboBox qualityComboBox = new JComboBox(quality);
	private final String[] category = {"D", "T", "R", "Te"};
	private JComboBox categoryComboBox = new JComboBox(category);

	
	public JComboBox getFunctionComboBox()
	{
		return functionComboBox;
	}

	public void setFunctionComboBox(JComboBox functionComboBox)
	{
		this.functionComboBox = functionComboBox;
	}
	
	public void setColor(boolean correct)
	{
		if(correct)
			setBackground(Color.GREEN);
		else
			setBackground(Color.RED);
	}

	public GamePanel()
	{
		JPanel panel = new JPanel(new GridLayout(3,1));
		
		panel.add(qualityComboBox);
		panel.add(categoryComboBox);
		panel.add(getFunctionComboBox());
		
		panel.setBorder(BorderFactory.createBevelBorder(0));
		
		panel.setBackground(Color.BLUE);
		
		add(panel);
	
	}
	
	public GamePanel(char s) // button Panel
	{	
			JPanel buttonPanel = new JPanel(new GridLayout(2,1));
	
			add(buttonPanel);
			

	}
	
	
	public static void main(String[] args)
	{
		
		JFrame frame = new JFrame("Game");
		frame.setLayout(new FlowLayout());
	
		
		GamePanel[] gamePanel = new GamePanel[6];
	
		for(int i = 0; i < gamePanel.length; i++)
		{
			gamePanel[i] = new GamePanel();
			frame.add(gamePanel[i]);
		}	
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	

}

