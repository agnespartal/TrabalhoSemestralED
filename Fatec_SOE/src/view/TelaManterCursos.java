package view;

import controller.CursosController;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaManterCursos extends JFrame {
	
	private static final long serialVersionUID = 6909508245638580811L;
	private JPanel contentPane;
	private JTextField txtSistemaDeOrientacao;
	private JTextField labelAmarelaBottomPropriedadeDaFatec;
	private JTextField txtPropriedadeDaFatec_1;
	private JTextField labelAmarelaTOP;
	private JTextField tfNome;	
	private JTextField tfLimiteCiclos;
	private JTextField tfQtdeCiclos;
	private JTextField tfID;
	private JTable table;



//====================================================================================================================================
//============================================================ TELA BASE =============================================================
//====================================================================================================================================
	public TelaManterCursos() {
		setBackground(new Color(214, 220, 228));
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\\\Gabriel Silva\\\\Area de Trabalho\\\\FATEC\\\\OneDrive - Fatec Centro Paula Souza\\\\PROJETOS_GITHUB\\\\ENGENHARIA_SW2\\\\IMG"));
		setTitle("SOE - Sistema de Orientação Estudantil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 1024, 680);// TAMANHO DA TELA
		contentPane = new JPanel();

		contentPane.setBackground(new Color(214, 220, 228));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//----------------------------------------------------------------------------------------------------------------------------
		JLabel LOGO = new JLabel("");
		LOGO.setHorizontalAlignment(SwingConstants.CENTER);
		LOGO.setBackground(new Color(132, 151, 176));
		LOGO.setIcon(new ImageIcon("C:\\TEMP\\logoSOE.png"));
		LOGO.setBounds(0, 0, 207, 93);
		contentPane.add(LOGO);
		
		//----------------------------------------------------------------------------------------------------------------------------
		txtSistemaDeOrientacao = new JTextField();
		txtSistemaDeOrientacao.setEditable(false);
		txtSistemaDeOrientacao.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSistemaDeOrientacao.setForeground(new Color(255, 255, 255));
		txtSistemaDeOrientacao.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtSistemaDeOrientacao.setText("SISTEMA DE ORIENTAÇÃO ESTUDANTIL      ");
		txtSistemaDeOrientacao.setBackground(new Color(132, 151, 176));
		txtSistemaDeOrientacao.setBounds(0, 0, 1008, 93);
		contentPane.add(txtSistemaDeOrientacao);
		txtSistemaDeOrientacao.setColumns(10);
		
		txtPropriedadeDaFatec_1 = new JTextField();
		txtPropriedadeDaFatec_1.setText("Propriedade da FATEC Zona Leste. Todos os direitos reservados ®");
		txtPropriedadeDaFatec_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtPropriedadeDaFatec_1.setForeground(Color.WHITE);
		txtPropriedadeDaFatec_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtPropriedadeDaFatec_1.setEditable(false);
		txtPropriedadeDaFatec_1.setColumns(10);
		txtPropriedadeDaFatec_1.setBackground(new Color(132, 151, 176));
		txtPropriedadeDaFatec_1.setBounds(0, 616, 1008, 25);
		contentPane.add(txtPropriedadeDaFatec_1);
		
		labelAmarelaBottomPropriedadeDaFatec = new JTextField();
		labelAmarelaBottomPropriedadeDaFatec.setHorizontalAlignment(SwingConstants.CENTER);
		labelAmarelaBottomPropriedadeDaFatec.setForeground(Color.WHITE);
		labelAmarelaBottomPropriedadeDaFatec.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelAmarelaBottomPropriedadeDaFatec.setEditable(false);
		labelAmarelaBottomPropriedadeDaFatec.setColumns(10);
		labelAmarelaBottomPropriedadeDaFatec.setBackground(new Color(191, 143, 0));
		labelAmarelaBottomPropriedadeDaFatec.setBounds(0, 612, 1008, 5);
		contentPane.add(labelAmarelaBottomPropriedadeDaFatec);
		
		labelAmarelaTOP = new JTextField();
		labelAmarelaTOP.setHorizontalAlignment(SwingConstants.CENTER);
		labelAmarelaTOP.setForeground(Color.WHITE);
		labelAmarelaTOP.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelAmarelaTOP.setEditable(false);
		labelAmarelaTOP.setColumns(10);
		labelAmarelaTOP.setBackground(new Color(191, 143, 0));
		labelAmarelaTOP.setBounds(0, 92, 1008, 5);
		contentPane.add(labelAmarelaTOP);
		
		tfNome = new JTextField();
		tfNome.setToolTipText("Informe a descrição do curso");
		tfNome.setBounds(211, 160, 398, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Curso");
		lblNome.setBounds(211, 144, 40, 17);
		contentPane.add(lblNome);
		
		JLabel lbQtdeCiclos = new JLabel("Qtde de Ciclos");
		lbQtdeCiclos.setBounds(699, 144, 110, 17);
		contentPane.add(lbQtdeCiclos);
		
		JLabel lblDescrio = new JLabel("Procura");
		lblDescrio.setBounds(68, 201, 110, 17);
		contentPane.add(lblDescrio);
		
		JLabel lblInserindoCursos = new JLabel("Inserindo Cursos");
		lblInserindoCursos.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserindoCursos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInserindoCursos.setBounds(58, 108, 907, 17);
		contentPane.add(lblInserindoCursos);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(615, 469, 110, 32);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(735, 469, 110, 32);
		contentPane.add(btnExcluir);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.setBounds(855, 469, 110, 32);
		contentPane.add(btnGravar);
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon("C:\\TEMP\\lupa.png"));
		btnPesquisar.setActionCommand("pesquisar");
		btnPesquisar.setBounds(619, 148, 32, 32);
		contentPane.add(btnPesquisar);
		
// 		NumberFormat numberformat = NumberFormat.getInstance();
//		NumberFormatter formatter = new NumberFormatter(numberformat);
//		formatter.setValueClass(Integer.class);
//		formatter.setMinimum(1);
//		formatter.setMaximum(10);
//		formatter.setAllowsInvalid(false);
  		
//		JFormattedTextField tfQtdeCiclos = new JFormattedTextField(formatter);
  		tfQtdeCiclos = new JTextField();
		tfQtdeCiclos.setToolTipText("Informe qtde de ciclos do curso");
		tfQtdeCiclos.setColumns(10);
		tfQtdeCiclos.setBounds(699, 160, 110, 20);
		contentPane.add(tfQtdeCiclos);
		
		JLabel lblLimiteCiclos = new JLabel("Limite de Ciclos");
		lblLimiteCiclos.setBounds(855, 144, 110, 17);
		contentPane.add(lblLimiteCiclos);

// 		NumberFormat limiteformat = NumberFormat.getInstance();
//		NumberFormatter formatlimite = new NumberFormatter(limiteformat);
//		formatlimite.setValueClass(Integer.class);
//		formatlimite.setMinimum(1);
//		formatlimite.setMaximum(15);
//		formatlimite.setAllowsInvalid(false);
		
		
//		JFormattedTextField tfLimiteCiclos = new JFormattedTextField(formatlimite);
  		tfLimiteCiclos = new JTextField();
		tfLimiteCiclos.setToolTipText("Informe o limite de ciclos do curso");
		tfLimiteCiclos.setColumns(10);
		tfLimiteCiclos.setBounds(855, 160, 110, 20);
		contentPane.add(tfLimiteCiclos);
		
		tfID = new JTextField();
		tfID.setToolTipText("Informe qtde de ciclos do curso");
		tfID.setColumns(10);
		tfID.setBounds(68, 160, 90, 20);
		contentPane.add(tfID);
		
		JLabel lbID = new JLabel("ID");
		lbID.setBounds(68, 144, 110, 17);
		contentPane.add(lbID);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(68, 216, 725, 196);
		contentPane.add(scrollPane);
		
		JTextArea taLista = new JTextArea();
		scrollPane.setViewportView(taLista);
		
		table = new JTable();
		table.setBounds(104, 493, 74, -23);
		contentPane.add(table);
		
		
		//----------------------------------------------------------------------------------------------------------------------------
		

		CursosController cursoCTR = new CursosController(tfID, tfNome, tfQtdeCiclos, tfLimiteCiclos, taLista);
		
		JButton btnFechar = new JButton("Fechar Janela");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(471, 469, 134, 32);
		contentPane.add(btnFechar);
		
		btnGravar.addActionListener(cursoCTR);
		btnAlterar.addActionListener(cursoCTR);
		btnExcluir.addActionListener(cursoCTR);
		btnPesquisar.addActionListener(cursoCTR);
		
	}
}	

