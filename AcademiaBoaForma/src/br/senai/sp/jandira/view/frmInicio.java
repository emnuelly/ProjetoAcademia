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
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class frmInicio extends JFrame {

	private JPanel contentPane;
	private JTable tableDados;

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
		panelTitulo.setBackground(new Color(255, 255, 204));
		panelTitulo.setBounds(0, 0, 434, 50);
		contentPane.add(panelTitulo);
		panelTitulo.setLayout(null);
		
		JLabel lblTitulo = new JLabel("ACADEMIA");
		lblTitulo.setIcon(new ImageIcon(frmInicio.class.getResource("/br/senai/sp/jandira/imagens/fitness.png")));
		lblTitulo.setForeground(SystemColor.desktop);
		lblTitulo.setFont(new Font("Aharoni", Font.PLAIN, 24));
		lblTitulo.setBounds(78, 4, 174, 39);
		panelTitulo.add(lblTitulo);
		
		JLabel lblBoaForma = new JLabel("Boa Forma");
		lblBoaForma.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoaForma.setForeground(new Color(250, 128, 114));
		lblBoaForma.setFont(new Font("Segoe Script", Font.PLAIN, 23));
		lblBoaForma.setBounds(173, 22, 135, 28);
		panelTitulo.add(lblBoaForma);
		
		JPanel panelDados = new JPanel();
		panelDados.setForeground(SystemColor.menu);
		panelDados.setBackground(new Color(255, 255, 255));
		panelDados.setBounds(0, 50, 434, 341);
		contentPane.add(panelDados);
		panelDados.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 319);
		panelDados.add(scrollPane);
		
		tableDados = new JTable();
		tableDados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "CLIENTES"
			}
		));
		tableDados.getColumnModel().getColumn(0).setPreferredWidth(53);
		tableDados.getColumnModel().getColumn(1).setPreferredWidth(340);
		scrollPane.setViewportView(tableDados);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBackground(new Color(255, 255, 204));
		panelBotoes.setBounds(0, 390, 434, 63);
		contentPane.add(panelBotoes);
		panelBotoes.setLayout(null);
		
		JButton btnAdiciona = new JButton("");
		btnAdiciona.setToolTipText("Editar um cliente!");
		btnAdiciona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAdiciona.setBounds(27, 8, 59, 50);
		btnAdiciona.setIcon(new ImageIcon(frmInicio.class.getResource("/br/senai/sp/jandira/imagens/pencil.png")));
		panelBotoes.add(btnAdiciona);
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(frmInicio.class.getResource("/br/senai/sp/jandira/imagens/exit.png")));
		btnSair.setBounds(348, 8, 59, 50);
		panelBotoes.add(btnSair);
		
		JButton btnEditar = new JButton("");
		btnEditar.setToolTipText("Editar um cliente!");
		btnEditar.setBounds(96, 8, 59, 50);
		panelBotoes.add(btnEditar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setToolTipText("Editar um cliente!");
		btnExcluir.setBounds(165, 8, 59, 50);
		panelBotoes.add(btnExcluir);
	}
}
