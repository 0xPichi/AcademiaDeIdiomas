import java.util.ArrayList;
import java.util.Calendar;

/**
 * 
 * Clase <code>Curso</code>
 * 
 * @author Sergio Delgado Álvarez
 * @author Miguel Bayón Sanz
 * @author Daniel Paredes Santamaría
 *
 */
public class Curso {

	private String codigo;
	private String idioma;
	private Calendar fInicio;
	private Calendar fFinal;
	private int horario;
	private final int maxAlumnos;
	private final float precio;
	private ArrayList<Alumno> inscritos;
	private ArrayList<Matricula> matriculasDelCurso;


	/**
	 * Constructor de la clase <code>Curso</code>
	 * 
	 * @param idioma
	 *            String con el idioma de <code>Curso</code>
	 * @param fInicio
	 *            Fecha inicial de <code>Curso</code>
	 * @param fFinal
	 *            Fecha final de <code>Curso</code>
	 * @param horario
	 *            Horario de <code>Curso</code>
	 * @param maxAlumnos
	 *            float con el numero maximo de alumnos de <code>Curso</code>
	 * @param precio
	 *            float con el precio de <code>Curso</code>
	 */

	public Curso(String idioma, Calendar fInicio, Calendar fFinal, int horario, int maxAlumnos, float precio) {
		this.idioma = idioma;
		if (fInicio.after(fFinal)) {
			this.fInicio = fInicio;
			this.fFinal = fFinal;
		} else {
			this.fInicio = fFinal;
			this.fFinal = fInicio;
		}
		if (horario > 8 || horario < 21) {
			this.horario = horario;
		} else {
			this.horario = 12;
		}
		this.horario = horario;
		this.maxAlumnos = maxAlumnos;
		this.precio = precio;
		this.inscritos = new ArrayList<Alumno>();
		this.matriculasDelCurso = new ArrayList<Matricula>();
		this.codigo = idioma.substring(0, 3);
	}

	/**
	 * Funcion booleana que comprueba si hay plazas disponibles o si el alumno
	 * que se quiere inscribir ya esta inscrito
	 */
	public boolean plazaDisponible(Alumno alumno) {
		if (maxAlumnos > inscritos.size()) {
			for (int i = 0; i < inscritos.size(); i++) {
				if (inscritos.get(i).equals(alumno)) {
					System.out.println("No es posible inscribir a "+alumno.getNombre());
					return false;
				}
			}
			System.out.println("El alumno "+alumno.getNombre()+" se puede inscribir!");
			return true;
		} else
			System.out.println("No quedan plazas libres en este curso");
			return false;
	}

	/**
	 * Metodo que elimina un alumno de la lista de alumnos inscritos
	 * <code>inscritos</code>
	 */
	public void eliminaAlumno(Alumno alumno) {
		inscritos.remove(alumno);
	}

	/**
	 * Metodo que añado un alumno a la lista de alumnos inscritos
	 * <code>inscritos</code>
	 */
	public void agregaAlumno(Alumno alumno) {
		inscritos.add(alumno);
	}


	/**
	 * Getter del atributo <code>maxAlumnos</code>
	 * 
	 * @return maxAlumnos int con el numero maximo de alumnos de
	 *         <code>Curso</code>
	 */
	public int getMaxAlumnos() {
		return maxAlumnos;
	}

	/**
	 * Getter del atributo <code>precio</code>
	 * 
	 * @return precio int con el precio de <code>Curso</code>
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * Getter del atributo <code>idioma</code>
	 * 
	 * @return idioma int con el idioma de <code>Curso</code>
	 */
	public String getIdioma() {
		return idioma;
	}

	/**
	 * Getter del atributo <code>codigo</code>
	 * 
	 * @return codigo int con el codigo de <code>Curso</code>
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Getter del atributo <code>inscritos</code>
	 * 
	 * @return incritos Lista con los alumnos inscritos en el <code>Curso</code>
	 */
	public ArrayList<Alumno> getListaAlumnos() {
		return inscritos;
	}


	/**
	 * Getter del atributo <code>fFinal</code>
	 * 
	 * @return fFinal Calendar con la fecha final de <code>Curso</code>
	 */
	public Calendar getFechaFin() {
		return fFinal;
	}

	/**
	 * Getter del atributo <code>fInicio</code>
	 * 
	 * @return fInicio Calendar con la fecha inicial de <code>Curso</code>
	 */
	public Calendar getFechaInicio() {
		return fInicio;
	}

	/**
	 * Getter del atributo <code>horario</code>
	 * 
	 * @return horario Entero con el horario de <code>Curso</code>
	 */
	public int getHorario() {
		return horario;
	}

	/**
	 * Getter del atributo <code>matriculaDelCurso</code>
	 * 
	 * @return matriculasDelCurso Lista con las matriculas del curso asociadas
	 *         al <code>Curso</code>
	 */
	public ArrayList<Matricula> getListaMatriculas() {
		return matriculasDelCurso;
	}

	/**
	 * Crea y rellena la lista de las matriculas sin pagar asociadas a
	 * <code>Curso</code>
	 * 
	 * @return pendientes Lista con la lista de las matriculas sin pagar de
	 *         <code>Curso</code>
	 */
	public ArrayList<Matricula> getMatriculasSinPago() {
		ArrayList<Matricula> pendientes = new ArrayList<Matricula>();
		for (int i = 0; i < matriculasDelCurso.size(); i++) {
			if (!matriculasDelCurso.get(i).isPagado()) {
				pendientes.add(matriculasDelCurso.get(i));
			}
		}
		return pendientes;
	}

	/**
	 * Setter del atributo <code>idioma</code>
	 * 
	 * @param idioma
	 *            String con el idioma de <code>Curso</code>
	 */
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	/**
	 * Setter del atributo <code>fInicio</code>
	 * 
	 * @param fInicio
	 *            Calendar con la fecha de inicio de <code>Curso</code>
	 */
	public void setFInicio(Calendar fInicio) {
		this.fInicio = fInicio;
	}

	/**
	 * Setter del atributo <code>fFinal</code>
	 * 
	 * @param fFinal
	 *            Calendar con la fecha final de <code>Curso</code>
	 */
	public void setFFinal(Calendar fFinal) {
		this.fFinal = fFinal;
	}

	/**
	 * Setter del atributo <code>Horario</code>
	 * 
	 * @param horario
	 *            Entero con la hora de <code>Curso</code>
	 */
	public void setHorario(int horario) {
		this.horario = horario;
	}

	/**
	 * Sobreescribe el metodo toString() de la clase <code>Object</code>
	 * 
	 * Devuelve una cadena de caracteres con el formato Curso: xxxx; Idioma:
	 * xxxx;
	 * 
	 * @return Cadena de caracteres que representa el estado del objeto
	 *         <code>Curso</code>
	 */
	@Override
	public String toString() {
		return "Curso: " + this.codigo + "; Idioma: " + this.idioma;

	}
}
