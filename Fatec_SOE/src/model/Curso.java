package model;

public class Curso {

	public int CursoID;
	public String CursoNome;
	public int CursoCiclos;
	public int CursoLimite;

	@Override
	public String toString() {
		return CursoID+";"+CursoNome+";"+CursoCiclos+";"+CursoLimite;
		
	}
}
