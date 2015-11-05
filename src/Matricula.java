public class Matricula {
	private Alumno alumno;
	private Curso curso;
	private int numMatr;
	private boolean pagado;

	public Matricula(Alumno alumno, Curso curso) {
		// TODO Auto-generated constructor stub
		this.alumno = alumno;
		this.curso = curso;
		numMatr = 0;
		pagado = false;
	}

	public boolean isPagado() {
		return pagado;
	}

	public double getPrecio() { // devuelve desde curso, esta bien?
		return curso.getPrecio();
	}

	public Curso getCurso() {
		return curso;
	}
}
