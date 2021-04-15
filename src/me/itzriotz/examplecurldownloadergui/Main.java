package me.itzriotz.examplecurldownloadergui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {
	JPanel panel = new JPanel();
	static JTextField input = new JTextField();
	
	Main(){
		this.setTitle("Example GUI Downloader");
		this.setSize(600,350);
		this.getContentPane().setBackground(Color.getHSBColor(0, 0, 0.1f));
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		JButton button = new JButton("Download!");
		button.setBounds(90, 60, 400, 100);
		button.setLocation(getWidth()/6, 200);
		button.addActionListener(this);
		button.setFocusable(false);
		button.setBackground(Color.getHSBColor(0, 0, 0.15f));
		button.setForeground(Color.WHITE);
		button.setBorder(null);
		button.setFont(getFont());
		this.add(button);
		
		input.setBackground(Color.getHSBColor(0, 0, 0.15f));
		input.setForeground(Color.WHITE);
		input.setSize(500,140);
		input.setLocation(50, 20);
		input.setHorizontalAlignment((int) JTextArea.CENTER_ALIGNMENT);
		this.add(input);
		
	}
	
	
	public static void main(String[] args) {
		new Main();
		System.out.println("Did you know you can use \"curl -X DELETE [webhook]\" to delete Discord webhooks?");
	}

	public void actionPerformed(ActionEvent e) {
		Thread downloaderThread = new Thread(() -> {
		if(input.getText().contains("://")) /*This here is set so it still is able to check if it's a valid URL, because cURL supports hella ton of protocols*/ 
		{
				JOptionPane.showMessageDialog(this, "Started downloading file from "+input.getText()+"\nPlease be patient!");
				Downloader.download(input.getText());
				if(Downloader.exitVal == 0) {
					JOptionPane.showMessageDialog(this, "Done downloading file! \nIt's in your Downloads folder");
				}
			}else {
				JOptionPane.showMessageDialog(this, "That isn't a valid URL", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		});
		downloaderThread.start();
		
	}
}
