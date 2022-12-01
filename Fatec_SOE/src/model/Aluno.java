package model;

public class Aluno {
	
	public String nome;
	public String ra;
	public String telefone;
	public String email;
	public int curso;
	public String periodo;
	public Object semestre;
	public Object ciclo;
	public Object turma;
	public String status;
	
	@Override
	public String toString() {
		return nome+";"+ra+";"+telefone+";"+email+";"+ciclo+";"+curso+";"+turma+";"+semestre+";"+periodo+";"+status;
	}
}