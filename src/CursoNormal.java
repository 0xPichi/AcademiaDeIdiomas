import java.util.Calendar;

public class CursoNormal extends Curso {
	private int nivel;
	private CursoNormal cursoNivelSuperior;
	private CursoNormal cursoNivelInferior;
	
	public CursoNormal(String idioma, int nivel, Calendar fInicio, Calendar fFinal, int horario, int maxAlumnos
			,float precio, CursoNormal cursoNivelSuperior, CursoNormal cursoNivelInferior) {
		super(idioma, fInicio, fFinal, horario, maxAlumnos, precio);
		this.nivel = nivel;
		this.cursoNivelInferior = cursoNivelInferior;
		this.cursoNivelSuperior = cursoNivelSuperior;
	}
	
	/**
	 * Getter del atributo <code>nivel</code>
	 * 
	 * @return nivel int con el nivel de <code>Curso</code>
	 */
	public int getNivel() {
		return nivel;
	}
	
	public CursoNormal getCursoSuperior() {
		return this.cursoNivelSuperior;
	}
	
	public CursoNormal getCursoInferior() {
		return this.cursoNivelInferior;
	}
	
	
	

}
