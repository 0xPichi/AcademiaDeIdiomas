
public class MatriculaJunior extends Matricula {
	
	private int telefonoDeContacto;
	
	public MatriculaJunior(Junior alumno, CursoJunior curso, int telefono) {
		super(alumno, curso);
		//assert(comprobarEdad());
		//assert(curso.plazaDisponible(alumno));
		alumno.addMatricula(this);
		curso.agregaAlumno(alumno);
		this.telefonoDeContacto = telefono;
		
	}
	
	public int getTelefono() {
		return telefonoDeContacto;
	}
	
	public CursoJunior getCurso() {
		return (CursoJunior)super.getCurso();
	}
	
	public Junior getAlumno() {
		return (Junior)super.getAlumno();
	}
	//Implement
	public boolean comprobarEdad() {
		return true;
	}
}
