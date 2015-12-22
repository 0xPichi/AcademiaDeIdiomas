import java.util.Calendar;
import java.util.GregorianCalendar;

public class MatriculaJunior extends Matricula {
	
	private int telefonoDeContacto;
	
	public MatriculaJunior(Junior alumno, CursoJunior curso, int telefono) {
		super(alumno, curso);
		assert(comprobarEdad());
		assert(curso.plazaDisponible(alumno));
		alumno.getAdultoResponsable().addMatriculaJunior(this);
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
		GregorianCalendar menor = new GregorianCalendar();
		menor.set(Calendar.YEAR, menor.get(Calendar.YEAR)-17);
		Junior alumno = (Junior) super.getAlumno();
		if(menor.before(alumno.getFechaNacimiento())){
			return false;
		}

		return true;
	}
}
