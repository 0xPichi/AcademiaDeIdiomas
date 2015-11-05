public class Matricula {
	private Alumno alumno;
	private Curso curso;
	private int numMatr;
	private boolean pagado;

	public Matricula(Alumno alumno, Curso curso) {
		this.alumno = alumno;
		this.curso = curso;
		numMatr = 0;
		pagado = false;
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
}
