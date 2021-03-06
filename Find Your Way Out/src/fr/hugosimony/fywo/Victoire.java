package fr.hugosimony.fywo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Victoire extends JFrame{

	private static final long serialVersionUID = 1L;
	private static Color fond = new Color(255,150,150);
	private static Color rouge = new Color(255,0,0);
	private static Color vert = new Color(0,255,0);
	Font font = new Font("Arial", Font.BOLD, 20);
	Victoire victoire = this;

	public Victoire(int score, boolean win){
		
		this.setTitle("Find Your Way Out [Fin]");
		this.setSize(600, 250);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.addWindowListener(new WindowAdapter() {
			   @Override
			   public void windowClosed(WindowEvent e) {
			      System.exit(0);
			   }
			});
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3,1));
		
		JLabel message_score = new JLabel();
		if(win) {
			message_score.setText("Vous avez gagné ! Félicitations !");
		}else {
			message_score.setText("Vous avez perdu ! Votre score est de " + score + ".");
		}
		
		message_score.setFont(font);
		message_score.setHorizontalAlignment(JLabel.CENTER);
		
		panel1.add(message_score);
		
		JLabel question = new JLabel();
		question.setText("Voulez vous rejouer ?");
		question.setFont(font);
		question.setHorizontalAlignment(JLabel.CENTER);
		
		panel1.add(question);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,2));
		
		JButton oui = new JButton("Oui");
		JButton non = new JButton("Non");
		oui.setFont(font);
		non.setFont(font);
		oui.setBackground(vert);
		non.setBackground(rouge);
		oui.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				victoire.setVisible(false);
				Menu menu = new Menu();
				menu.setVisible(true);
			}
		});
		non.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				victoire.dispose();
			}
		});
		panel2.add(oui);
		panel2.add(non);
		panel2.setBackground(fond);
		panel1.add(panel2);
		
		panel1.setBackground(fond);
		this.add(panel1);
	}
}
