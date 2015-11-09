
/**
 * 
 * Clase <code>Matricula</code>
 * 
 * @author Sergio Delgado �lvarez
 * @author Miguel Bay�n Sanz
 * @author Daniel Paredes Santamar�a
 *
 */
public class Matricula {
	private Alumno alumno;
	private Curso curso;
	private int numMatr;
	private boolean pagado;

	/**
	 * Constructor de la clase <code>Matricula</code>
	 * 
	 * @param alumno Alumno asociado a la clase <code>Matricula</code>
	 * @param curso Curso asociado a la clase <code>Matricula</code>
	 */

	public Matricula(Alumno alumno, Curso curso) {
		this.alumno = alumno;
		this.curso = curso;
		numMatr = (int) Math.floor(Math.random() + 1 * 1000);
		pagado = false;
		alumno.addMatricula(this);
	}
	
	/**
	 * Getter del atributo <code>numMatr</code>
	 * 
	 * @return numMatr int con el c�digo de <code>Matricula</code>
	 */
	public int getMtriculaId() {
		return numMatr;
	}

	/**
	 * Getter de la variable booleana <code>pagado</code>
	 */
	public boolean isPagado() {
		return pagado;
	}

	/**
	 * Getter del atributo <code>precio</code> de la clase <code>Curso</code>
	 * 
	 * @return precio float con el precio de <code>Curso</code>
	 */
	public double getPrecio() {
		return curso.getPrecio();
	}

	/**
	 * Getter del atributo <code>curso</code>
	 * 
	 * @return Curso curso asociado a la <code>Matricula</code>
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * Getter del atributo <code>alumno</code>
	 * 
	 * @return Alumno alumno asociado a la <code>Matricula</code>
	 */
	public Alumno getAlumno() {
		return alumno;
	}

	/**
	 * Metodo que cambia el valor del atributo <code>pagado</code> a true
	 */
	public void pagar() {
		pagado = true;
	}

	/**
	 * Metodo que comprueba y cambia de ser posible a un nivel superior
	 * el atributo <code>curso</code>
	 */
	public void subirNivel() {
		if (curso.getCursoSuperior() != null 
				&& curso.getCursoSuperior().plazaDisponible(this.alumno)) {
			this.curso.eliminaAlumno(alumno);
			this.curso.getCursoSuperior().agregaAlumno(alumno);
			this.curso = curso.getCursoSuperior();
		}
	}

	/**
	 * Metodo que comprueba y cambia de ser posible a un nivel inferior
	 * el atributo <code>curso</code>
	 */
	public void bajarNivel() {
		if (curso.getCursoInferior() != null 
				&& curso.getCursoInferior().plazaDisponible(this.alumno)) {
			this.curso.eliminaAlumno(alumno);
			this.curso.getCursoInferior().agregaAlumno(alumno);
			this.curso = curso.getCursoInferior();
		}
	}

	/**
	 * Getter del atributo <code>precio</code> de la clase <code>Curso</code>
	 * 
	 * @return float con el valor de la deuda de la matricula
	 */
	public float getPrecioDeMatricula() {
		if (isPagado()) {
			return 0;
		}
		return curso.getPrecio();
	}
}
