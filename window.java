import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class window 
{
	private String contents;
	private String userName;
	private static int LENGTH_OF_BOX = 8;
	private static int HOW_MANY_ENTRIES = 0;
	public window()
	{
		/**
		 * USERNAME
		 */
		userName name = new userName();
		userName = name.getUserName();
		/**
		 * new window, layout
		 */
		JFrame frame = new JFrame("Social Media");
		frame.setLayout(new BorderLayout());
		frame.setSize(650,300);
		/**
		 * make all the panels
		 */
		JPanel panelTop = new JPanel();
		JPanel panelBot = new JPanel();
		JPanel panelCenter = new JPanel();
		JPanel panelLeft = new JPanel();
		/**
		 * set all the properties to the correct panels
		 */
		panelTop.setLayout(new FlowLayout());
		panelTop.add(new JLabel("CHAT ROOM"));
		
		JTextArea messageToSend = new JTextArea(1,10);
		JButton send = new JButton("Send");
		panelBot.setLayout(new FlowLayout());
		panelBot.add(messageToSend);
		panelBot.add(send);
		
		JTextArea allMessages = new JTextArea(10,40);
		allMessages.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		panelCenter.setLayout(new FlowLayout());
		panelCenter.add(allMessages);
		allMessages.setEditable(false);
		
		JTextArea allNames = new JTextArea(5,10);
		allNames.append(userName);
		allNames.setEditable(false);
		panelLeft.setLayout(new FlowLayout());
		panelLeft.add(allNames);
		
		/**
		 * add all panels to the frame
		 */
		frame.add(panelTop, BorderLayout.NORTH);
		frame.add(panelBot, BorderLayout.SOUTH);
		frame.add(panelCenter, BorderLayout.CENTER);
		frame.add(panelLeft, BorderLayout.WEST);
		
		/**
		 * set visibility of them and close function
		 */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		/**
		 * sends the message to the chatBox
		 */
		
		class sendIt implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				if(HOW_MANY_ENTRIES < LENGTH_OF_BOX)
				{	
					contents= messageToSend.getText();
					allMessages.append(userName + "> " + contents + "\n");
					messageToSend.setText("");
					HOW_MANY_ENTRIES++;
				}
				else
				{
					contents= messageToSend.getText();
					allMessages.setText("");
					allMessages.append(userName + "> " + contents + "\n");
					messageToSend.setText("");
					HOW_MANY_ENTRIES = 0;
				}
			}
		}
		/**
		 * Make the button listen
		 */
		ActionListener l = new sendIt();
		send.addActionListener(l);
	
	}
}