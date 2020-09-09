//GUI based Chapter 4 Game Zone exercise 1 (page 227)

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoDiceGUI extends JFrame implements ActionListener 
{

	//graphics for this class
	Font mainFont = new Font("Impact", Font.PLAIN, 28);
	JLabel title = new JLabel("two dice game");
	JLabel dieRoll1 = new JLabel("player's die roll is: ");
	JTextField die1Field = new JTextField(3);
	JLabel dieRoll2 = new JLabel("computer's die roll is: ");
	JTextField die2Field = new JTextField(3);
	JLabel result = new JLabel("");
	JButton button = new JButton("click to play!");

	

	//constr methold for this class
	public TwoDiceGUI()
	{
		super("two dice app");
		setBounds(600, 450, 300, 200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//customize the comps
		title.setFont(mainFont);

		//add graphics to frame
		add(title);
		add(dieRoll1);
		add(die1Field);
		add(dieRoll2);
		add(die2Field);
		add(result);
		add(button);

		//add action listener to button comp
		button.addActionListener(this);

		setVisible(true);
	}

	//event handling method 
	@Override
	public void actionPerformed(ActionEvent event)
	{
		//create two Die obj
		Die playerDie = new Die();
		Die comDie = new Die();

		//output the values of the die obj in the fields of the GUI
		die1Field.setText("" + playerDie.getDieValue());
		die2Field.setText("" + comDie.getDieValue());

		//decide what the outcome of the game should be 
		//set text result label accordingly 
		if(playerDie.getDieValue() > comDie.getDieValue())
		{
			result.setText("you have won the game");
		}
		else
		{
			if(playerDie.getDieValue() < comDie.getDieValue())
			{
				result.setText("sorry, sucka you lose!");
			}
			else
			{
				result.setText("we have a draw");
			}
		} 
	}

	public static void main(String[] args)
	{
		TwoDiceGUI aFrame = new TwoDiceGUI();
	}
}