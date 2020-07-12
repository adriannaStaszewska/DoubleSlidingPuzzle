package project.boundry;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.controller.QuitController;
import project.controller.ResetController;
import project.model.Model;
import project.view.TangramApplication;
import quiz3.controller.ComputeController;
import quiz3.view.App;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AppView extends JFrame {

	private JPanel contentPane;
	Board panel;
	Model model;
	JLabel moveCounter;

	/**
	 * Create the frame.
	 */
	public AppView(Model model) {
		this.model = model;  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new Board(model, this);
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))))
					.addGap(164))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(174))
		);
		
		JButton btnReset = new JButton("Reset");
		panel_2.add(btnReset);
		btnReset.addActionListener(new ActionListener() { //idea taken from implementation of SampleQuiz3
			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetController(model, AppView.this).reset();
			}	
		});
		
		JButton btnQuit = new JButton("Quit");
		panel_2.add(btnQuit);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		btnQuit.addActionListener(new ActionListener() { //idea taken from implementation of Tangram Application
			public void actionPerformed(ActionEvent e) {
				if (new QuitController().confirm(AppView.this)) {
					AppView.this.dispose();
				}
			}
		});
		
		JLabel lblMoves = new JLabel("Number of moves: ");
		lblMoves.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoves.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblMoves);
		
		moveCounter = new JLabel("0");
		moveCounter.setHorizontalAlignment(SwingConstants.CENTER);
		moveCounter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(moveCounter);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		contentPane.setLayout(gl_contentPane);
	}
	
	public JLabel getMoveCounter() {
		return moveCounter;
	}
}
