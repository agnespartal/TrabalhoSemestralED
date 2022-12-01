//together
package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Aluno;
import view.TelaManterCursos;
import br.com.leandrocolevati.Lista.*;

public class AlunoController implements ActionListener {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_6;
	private JComboBox comboBox;
	private JComboBox comboBox_2;
	private JComboBox comboBox_1;
	private JComboBox comboBox_1_1;
	private JComboBox comboBox_1_1_1;
	private JButton btnRegras_1_2_1;
	private JButton btnRegras_1_2;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxDesistente;

	public AlunoController(JTextField textField, JTextField textField_1, JTextField textField_2, JTextField textField_6,
			JComboBox comboBox, JComboBox comboBox_2, JComboBox comboBox_1, JComboBox comboBox_1_1,
			JComboBox comboBox_1_1_1, JButton btnRegras_1_2_1, JButton btnRegras_1_2, 
			JCheckBox chckbxNewCheckBox,JCheckBox chckbxDesistente) {
		super();
		this.textField = textField;
		this.textField_1 = textField_1;
		this.textField_2 = textField_2;
		this.textField_6 = textField_6;
		this.comboBox = comboBox;
		this.comboBox_2 = comboBox_2;
		this.comboBox_1 = comboBox_1;
		this.comboBox_1_1 = comboBox_1_1;
		this.comboBox_1_1_1 = comboBox_1_1_1;
		this.btnRegras_1_2_1 = btnRegras_1_2_1;
		this.btnRegras_1_2 = btnRegras_1_2;
		this.chckbxDesistente = chckbxDesistente;
		this.chckbxNewCheckBox = chckbxNewCheckBox;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Lista lista = new Lista();
		try {
			lista = gerarLista(lista);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		String cmd = e.getActionCommand();
		if (cmd.equals("Inserir")) {
			try {
				inserir(lista);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Alterar")) {
			try {
				alterar(lista);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Excluir")) {
			try {
				excluir(lista);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Importar Lista")) {
			importarLista();
		}
		if (cmd.equals("buscaNome")) {
			try {
				buscaNome();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("buscaRA")) {
			try {
				buscaRA();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Cursos")) {
			try {
				TelaManterCursos frame2 = new TelaManterCursos();
				frame2.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	private Lista gerarLista(Lista lista) throws Exception {
		String path = System.getProperty("user.home") + File.separator + "BDAlunos";
		File arq = new File(path, "aluno.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leFluxo = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leFluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				Aluno aluno = new Aluno();
				aluno.nome = vetLinha[0];
				aluno.ra = vetLinha[1];
				aluno.email = vetLinha[3];
				aluno.telefone = vetLinha[2];
				aluno.ciclo = vetLinha[4];
				aluno.curso = Integer.parseInt(vetLinha[5]);
				aluno.turma = vetLinha[6];
				aluno.semestre = vetLinha[7];
				aluno.periodo = vetLinha[8];
				lista.addFirst(aluno);
				linha = buffer.readLine();
			}
			buffer.close();
			leFluxo.close();
			fluxo.close();
		}
		
		return lista;
	}

	
	private void importarLista() {
		Object [] options = {"Aceitar", "Aceitar"};
		JOptionPane.showOptionDialog(null, "Sem ação\nMotivo: Programador com preguiça!", "Em construção", 
				JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE, null, options, options[0] );
	}
	
	private void buscaRA() throws Exception {
		Aluno aluno = new Aluno();
		aluno.ra = textField_1.getText();
		buscaAlunoRA(aluno);
	}
	
	private void buscaAlunoRA (Aluno aluno) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "BDAlunos";
		File arq = new File(path, "aluno.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leFluxo = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leFluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (vetLinha[1].equals(aluno.ra)) {
					textField.setText(vetLinha[0]);
					textField_2.setText(vetLinha[3]);
					textField_6.setText(vetLinha[2]);
					comboBox_2.setSelectedItem(vetLinha[4]);
					CursosController curso = new CursosController(textField, textField, textField, textField, null);
					String linha2 = curso.readID(Integer.parseInt(vetLinha[5]));
					String[] vetLinha2 = linha2.split(";");
					comboBox.setSelectedItem(vetLinha2[1]+";"+vetLinha2[0]);
					comboBox_1.setSelectedItem(vetLinha[6]);
					comboBox_1_1.setSelectedItem(vetLinha[7]);
					comboBox_1_1_1.setSelectedItem(vetLinha[8]);
					if (vetLinha[9].equals("Desistente")) {
						chckbxDesistente.setSelected(true);
					}else if (vetLinha[9].equals("Trancado")) {
						chckbxNewCheckBox.setSelected(true);
					}
					break;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leFluxo.close();
			fluxo.close();
		}
	}

	private void buscaNome() throws IOException {
		Aluno aluno = new Aluno();
		aluno.nome = textField.getText();
		buscaAlunoNome(aluno);
		
	}

	private void buscaAlunoNome(Aluno aluno) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "BDAlunos";
		File arq = new File(path, "aluno.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leFluxo = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leFluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (vetLinha[0].equals(aluno.nome)) {
					textField_1.setText(vetLinha[1]);
					textField_2.setText(vetLinha[3]);
					textField_6.setText(vetLinha[2]);
					comboBox_2.setSelectedItem(vetLinha[4]);
					CursosController curso = new CursosController(textField, textField, textField, textField, null);
					String linha2 = curso.readID(Integer.parseInt(vetLinha[5]));
					String[] vetLinha2 = linha2.split(";");
					comboBox.setSelectedItem(vetLinha2[1]+";"+vetLinha2[0]);
					comboBox_1.setSelectedItem(vetLinha[6]);
					comboBox_1_1.setSelectedItem(vetLinha[7]);
					comboBox_1_1_1.setSelectedItem(vetLinha[8]);
					if (vetLinha[9].equals("Desistente")) {
						chckbxDesistente.setSelected(true);
					}else if (vetLinha[9].equals("Trancado")) {
						chckbxNewCheckBox.setSelected(true);
					}
					break;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leFluxo.close();
			fluxo.close();
		}
	}



	private void excluir(Lista lista) throws Exception {
		Aluno aluno = new Aluno();
		aluno.nome = textField.getText();

		boolean existe = excluirAluno(aluno.nome, lista);
		if (existe == true) {
			JOptionPane.showMessageDialog(null, "Aluno excluido!");
		} else {
			JOptionPane.showMessageDialog(null, "Aluno não existe!");
		}
		limpaConteudo();

	}

	private boolean excluirAluno(String nome, Lista lista) throws Exception {
		int tamanho = lista.size();
		boolean existe = false;
		Aluno aux = new Aluno();
		for (int i = 0; i < tamanho; i++) {
			aux = (Aluno)lista.get(i);
			if (aux.nome.equals(nome)) {
				lista.removePosition(i);
				excluirArquivo();
				cadastraAluno(lista);
				existe = true;
				break;
			}
		}
		return existe;
	}

	private void alterar(Lista lista) throws Exception {
		Aluno aluno = new Aluno();
		aluno.nome = textField.getText();
		boolean existe = alteraAlunoNome(aluno.nome,lista);
		if (existe == true) {
			JOptionPane.showMessageDialog(null, "Aluno alterado!");
		} else {
			JOptionPane.showMessageDialog(null, "Aluno não cadastrado!");
		}
	}

	private boolean alteraAlunoNome(String nome, Lista lista) throws Exception {
		int tamanho = lista.size();
		boolean existe = false;
		Aluno aux = new Aluno();
		for (int i = 0; i < tamanho; i++) {
			aux = (Aluno)lista.get(i);
			if (aux.nome.equals(nome)) {
				lista.removePosition(i);
				existe = true;
				inserir(lista);
				break;
			}
		}
		return existe;
	}

	private void inserir(Lista lista) throws Exception {
		Aluno aluno = new Aluno();
		aluno.nome = textField.getText();
		aluno.ra = textField_1.getText();
		aluno.email = textField_2.getText();
		aluno.telefone = textField_6.getText();
		aluno.ciclo = comboBox_2.getSelectedItem();
		if (comboBox.getSelectedItem() != null) {
			String cursosel = (String) comboBox.getSelectedItem();
			String[] vetLinha2 = cursosel.split(";");
			aluno.curso = Integer.parseInt(vetLinha2[1]);
		} else {
			aluno.curso = 0;
		}
		String cursosel = (String) comboBox.getSelectedItem();
		String[] vetLinha2 = cursosel.split(";");
		aluno.curso = Integer.parseInt(vetLinha2[1]);
		aluno.turma = comboBox_1.getSelectedItem();
		aluno.semestre = comboBox_1_1.getSelectedItem();
		aluno.periodo = (String) comboBox_1_1_1.getSelectedItem();
		
		if (chckbxNewCheckBox.isSelected()) {
			aluno.status = "Trancado";
		}else if(chckbxDesistente.isSelected()) {
			aluno.status = "Desistente";
		}else {
			aluno.status = "Cursando";
		}
		
		
		lista.addFirst(aluno);
		
		excluirArquivo();
		cadastraAluno(lista);
		limpaConteudo();
		
	}

	private void limpaConteudo() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_6.setText("");
		comboBox_2.setSelectedIndex(0);
		comboBox_1.setSelectedIndex(0);
		comboBox_1_1.setSelectedIndex(0);
		comboBox_1_1_1.setSelectedIndex(0);
		chckbxDesistente.setSelected(false);
		chckbxNewCheckBox.setSelected(false);
	}
	
	private void excluirArquivo() {
		String path = System.getProperty("user.home") + File.separator + "BDAlunos";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "aluno.csv");
		if (arq.exists()) {
		arq.delete();
		}
	}

	private void cadastraAluno(Lista lista) throws Exception {
		String path = System.getProperty("user.home") + File.separator + "BDAlunos";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "aluno.csv");
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		
		StringBuffer buffer = new StringBuffer();
		int tamanho = lista.size();
		String linha = "";
		for (int i = 0; i < tamanho; i++) {
			linha = lista.get(i).toString();
			buffer.append(linha + "\r\n");
		}
		
		FileWriter fWriter = new FileWriter(arq, existe);
		PrintWriter pWriter = new PrintWriter(fWriter);
		pWriter.write(buffer.toString());
		pWriter.flush();
		pWriter.close();
	}



	public Boolean verificaCurso(int CursoID) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "BDAlunos";
		File arq = new File(path, "aluno.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leFluxo = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leFluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (Integer.parseInt(vetLinha[5])==CursoID) {
					buffer.close();
					leFluxo.close();
					fluxo.close();
					return true;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leFluxo.close();
			fluxo.close();
			return false;
		}
		return false;
	}

}
