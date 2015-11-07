public class Matricula {
	private Alumno alumno;
	private Curso curso;
	private int numMatr;
	private boolean pagado;

	public Matricula(Alumno alumno, Curso curso) {
		this.alumno = alumno;
		this.curso = curso;
		numMatr = (int) Math.floor(Math.random()+1 *1000);
		pagado = false;
	}
	public int getMtriculaId() {
		return numMatr;
	}
	public boolean isPagado() {
		return pagado;
	}
	public double getPrecio() { 
		return curso.getPrecio();
	}
	public Curso getCurso() {
		return curso;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void marcaPagado() {
		pagado = true;
	}
	public void subirNivel() {
		if(curso.getCursoSuperior() != null && curso.getCursoSuperior().plazaDisponible(this.alumno)) {
			this.curso = curso.getCursoSuperior();
		}
	}
	public void bajarNivel() {
		if(curso.getCursoInferior() != null && curso.getCursoInferior().plazaDisponible(this.alumno)) {
			this.curso = curso.getCursoInferior();
		}
	}
	public float getPrecioDeMatricula() {
		if(this.isPagado()) {
			return 0;
		}
		return curso.getPrecio();
	}
}
