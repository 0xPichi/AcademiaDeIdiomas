import java.util.Calendar;

public class CursoJunior extends Curso {

	private int edadMinima;
	private int edadMaxima;

	/**
	 * Constructor de la clase <code>CursoJunior</code>
	 * 
	 * @param idioma
	 *            String con el idioma de <code>CursoJunior</code>
	 * @param fInicio
	 *            Calendar con la fecha de inicio del <code>CursoJunior</code>
	 * @param fFinal
	 *            Calendar con la fecha final del <code>CursoJunior</code>
	 * @param horario
	 *            int con el horario del <code>CursoJunior</code>
	 * @param maxAlumnos
	 *            int con el numero maximo de alumnos del
	 *            <code>CursoJunior</code>
	 * @param precio
	 *            float con el precio del <code>CursoJunior</code>
	 * @param edadMinima
	 *            int con la edad minima del <code>CursoJunior</code>
	 * @param edadMaxima
	 *            int con la edad maxima del <code>CursoJunior</code>
	 */
	public CursoJunior(String idioma, Calendar fInicio, Calendar fFinal, int horario, int maxAlumnos, float precio,
			int edadMinima, int edadMaxima) {
		super(idioma, fInicio, fFinal, horario, maxAlumnos, precio);
		this.edadMaxima = edadMaxima;
		this.edadMinima = edadMinima;
	}

	/**
	 * Getter del parametro <code>edadMinima</code>
	 * 
	 * @return edadMinima int con la edad minima del <code>CursoJunior</code>
	 */
	public int getEdadMinima() {
		return edadMinima;
	}

	/**
	 * Getter del parametro <code>edadMaxima</code>
	 * 
	 * @return edadMaxima int con la edad maxima del <code>CursoJunior</code>
	 */
	public int getEdadMaxima() {
		return edadMaxima;
	}

	/**
	 * Funcion booleana que sobreescribe la funcion plazaDisponible(Alumno
	 * alumno) y comprueba si hay plazas disponibles o si el alumno que se
	 * quiere inscribir ya esta inscrito
	 */
	@Override
	public boolean plazaDisponible(Alumno alumno) {
		if (alumno instanceof Junior) {
			if (super.plazaDisponible(alumno)) {
				return true;
			} else
				return false;
		}
		return false;
	}

}
