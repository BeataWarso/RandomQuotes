import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RandomQuotesFromFile extends JFrame implements ActionListener
{
	JButton bQuotes, bExit;
	JLabel jQuotes;
	
	public RandomQuotesFromFile () {
		setSize(600,400);
		setTitle("Random Quotes");
		setLayout(null);
		bQuotes = new JButton ("Generete quotes");
		bQuotes.setBounds(40, 50, 200, 40);
		add(bQuotes);
		bQuotes.addActionListener(this);
		
		bExit = new JButton("Exit");
		bExit.setBounds(270, 50, 200, 40);
		add(bExit);
		bExit.addActionListener(this);
		
		jQuotes = new JLabel("Your Random Quote: ");
		jQuotes.setBounds(50, 50, 500, 200);
		jQuotes.setForeground(Color.red);
		add(jQuotes);
		
	}
	
	
	public static void main(String[] args) {

		RandomQuotesFromFile quotes = new RandomQuotesFromFile();
		quotes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quotes.setVisible(true);
		

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		if (source==bQuotes) {
	
		
		String fileName = "txt.txt";
		List<String> list = new ArrayList<>();

		try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
			list = reader.lines().collect(Collectors.toList());

		} catch (IOException s) {
			s.printStackTrace();
		}
		
		
		Random random = new Random();
		String randomQuote = list.get(random.nextInt(list.size()));
		
		
		jQuotes.setText("<html>"+randomQuote+ "</html>");
		}
		else if (source==bExit) {
			dispose();
		}
		
		
		
	}
	
	
	
	

}
