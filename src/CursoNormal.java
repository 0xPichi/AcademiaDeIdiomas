import java.util.Calendar;

public class CursoNormal extends Curso {
	private int nivel;
	private CursoNormal cursoNivelSuperior;
	private CursoNormal cursoNivelInferior;

	/**
	 * Constructor de la clase <code>CursoNormal</code>
	 * 
	 * @param idioma
	 *            String asociado a la clase <code>CursoNormal</code>
	 * @param nivel
	 *            int asociado a la clase <code>CursoNormal</code>
	 * @param fInicio
	 *            Calendar asociado a la clase <code>CursoNormal</code>
	 * @param fFinal
	 *            Calendar asociado a la clase <code>CursoNormal</code>
	 * @param horario
	 *            int asociado a la clase <code>CursoNormal</code>
	 * @param maxAlumnos
	 *            int asociado a la clase <code>CursoNormal</code>
	 * @param precio
	 *            float asociado a la clase <code>CursoNormal</code>
	 * @param cursoNivelSuperior
	 *            Curso asociado a la clase <code>CursoNormal</code>
	 * @param cursoNivelInferior
	 *            Curso asociado a la clase <code>CursoNormal</code>
	 */
	public CursoNormal(String idioma, int nivel, Calendar fInicio, Calendar fFinal, int horario, int maxAlumnos,
			float precio, CursoNormal cursoNivelSuperior, CursoNormal cursoNivelInferior) {
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

	/**
	 * Getter del atributo <code>CursoNivelSuperior</code>
	 * 
	 * @return cursoNivelSuperior Curso con el curso superior a
	 *         <code>CursoNormal</code>
	 */
	public CursoNormal getCursoSuperior() {
		return this.cursoNivelSuperior;
	}

	/**
	 * Getter del atributo <code>CursoNivelInferior</code>
	 * 
	 * @return cursoNivelInferior Curso con el curso inferior a
	 *         <code>CursoNormal</code>
	 */
	public CursoNormal getCursoInferior() {
		return this.cursoNivelInferior;
	}

	/**
	 * Setter del atributo <code>nivel</code>
	 * 
	 * @param nivel
	 *            int asociado a <code>CursoNormal</code>
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/**
	 * Setter del atributo <code>cursoNivelSuperior</code>
	 * 
	 * @param cursoSuperior
	 *            Curso asociado a <code>CursoNormal</code>
	 */
	public void setCursoSuperior(CursoNormal cursoSuperior) {
		cursoNivelSuperior = cursoSuperior;
	}

	/**
	 * Setter del atributo <code>cursoNivelInferior</code>
	 * 
	 * @param cursoInferior
	 *            Curso asociado a <code>CursoNormal</code>
	 */
	public void setCursoInferior(CursoNormal cursoInferior) {
		cursoNivelInferior = cursoInferior;
	}

	/**
	 * Sobreescribe el metodo toString() de la clase <code>Object</code>
	 * 
	 * Devuelve una cadena de caracteres con el formato Curso: xxxx; Idioma:
	 * xxxx; Nivel: xxxx;
	 * 
	 * @return Cadena de caracteres que representa el estado del objeto
	 *         <code>Curso</code>
	 */

	@Override
	public String toString() {
		return "Curso: " + super.getCodigo() + "; Idioma: " + super.getIdioma() + "; Nivel:" + this.nivel;

	}
}
