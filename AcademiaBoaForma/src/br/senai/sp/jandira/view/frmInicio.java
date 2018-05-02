package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmInicio extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmInicio frame = new frmInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public frmInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(SystemColor.inactiveCaption);
		panelTitulo.setBounds(0, 0, 434, 50);
		contentPane.add(panelTitulo);
		panelTitulo.setLayout(null);
		
		JLabel lblTitulo = new JLabel("ACADEMIA BOA FORMA");
		lblTitulo.setIcon(new ImageIcon(frmInicio.class.getResource("/br/senai/sp/jandira/imagens/gym-control-of-exercises-with-a-list-on-a-clipboard-and-heart-beats (1).png")));
		lblTitulo.setForeground(SystemColor.desktop);
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 19));
		lblTitulo.setBounds(159, 11, 265, 28);
		panelTitulo.add(lblTitulo);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 50, 434, 341);
		contentPane.add(panel);
		
		table = new JTable();
		table.setBounds(10, 30, 415, 213);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"ID", "CLIENTE"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(295);
		panel.setLayout(null);
		panel.add(table);
	}
}
