import java.util.Calendar;
import java.util.GregorianCalendar;

public class MatriculaJunior extends Matricula {

	private int telefonoDeContacto;

	/**
	 * Constructor de la clase <code>MatriculaJunior</code>
	 * 
	 * @param alumno
	 *            Alumno asociado a la clase <code>MatriculaJunior</code>
	 * @param curso
	 *            Curso asociado a la clase <code>MatriculaJunior</code>
	 * @param telefono
	 *            int asociado a la clase <code>MatriculaJunior</code>
	 */
	public MatriculaJunior(Junior alumno, CursoJunior curso, int telefono) {
		super(alumno, curso);
		assert(comprobarEdad());
		assert(curso.plazaDisponible(alumno));
		alumno.getAdultoResponsable().addMatriculaJunior(this);
		alumno.addMatricula(this);
		curso.agregaAlumno(alumno);
		this.telefonoDeContacto = telefono;
	}

	/**
	 * Getter de la variable <code>telefonoDeContacto</code>
	 * 
	 * @return telefonoDeContacto int con el telefono de contacto asociado a
	 *         <code>MatriculaJunior</code>
	 */
	public int getTelefono() {
		return telefonoDeContacto;
	}

	/**
	 * Getter de la variable <code>Curso</code> devuelta desde
	 * <code>Matricula</code>
	 * 
	 * @return curso Curso asociado a la <code>MatriculaJunior</code>
	 */
	public CursoJunior getCurso() {
		return (CursoJunior) super.getCurso();
	}

	/**
	 * Getter de la variable <code>Curso</code> devuelta desde
	 * <code>Matricula</code>
	 * 
	 * @return alumno Alumno asociado a la <code>MatriculaJunior</code>
	 */
	public Junior getAlumno() {
		return (Junior) super.getAlumno();
	}

	/**
	 * Metodo que comprueba que el alumno que se intenta matricular es menor de
	 * 18 anos
	 */
	public boolean comprobarEdad() {
		GregorianCalendar menor = new GregorianCalendar();
		menor.set(Calendar.YEAR, menor.get(Calendar.YEAR) - 17);
		Junior alumno = (Junior) super.getAlumno();
		if (!menor.before(alumno.getFechaNacimiento())) {
			return false;
		}

		return true;
	}
}
