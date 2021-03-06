
public class MatriculaNormal extends Matricula {

	/**
	 * Constructor de la clase <code>MatriculaNormal</code>
	 * 
	 * @param alumno
	 *            Alumno asociado a la clase <code>MatriculaNormal</code>
	 * @param curso
	 *            Curso asociado a la clase <code>MatriculaNormal</code>
	 */
	public MatriculaNormal(Alumno alumno, CursoNormal curso) {
		super(alumno, curso);
		assert(curso.plazaDisponible(alumno));
		curso.agregaAlumno(alumno);
		alumno.addMatricula(this);

	}

	/**
	 * Metodo que comprueba y cambia de ser posible a un nivel superior el
	 * atributo <code>curso</code>
	 */
	public void subirNivel() {
		CursoNormal curso = null;
		if (super.getCurso() instanceof CursoNormal) {
			curso = (CursoNormal) super.getCurso();
		}
		if (curso.getCursoSuperior() != null && curso.getCursoSuperior().plazaDisponible(super.getAlumno())) {
			curso.eliminaAlumno(super.getAlumno());
			curso.getCursoSuperior().agregaAlumno(super.getAlumno());
			this.setCurso(curso.getCursoSuperior());
		}
	}

	/**
	 * Metodo que comprueba y cambia de ser posible a un nivel inferior el
	 * atributo <code>curso</code>
	 */
	public void bajarNivel() {
		CursoNormal curso = null;
		if (super.getCurso() instanceof CursoNormal) {
			curso = (CursoNormal) super.getCurso();
		}
		if (curso.getCursoInferior() != null && curso.getCursoInferior().plazaDisponible(super.getAlumno())) {
			curso.eliminaAlumno(super.getAlumno());
			curso.getCursoInferior().agregaAlumno(super.getAlumno());
			this.setCurso(curso.getCursoInferior());
		}
	}

}
