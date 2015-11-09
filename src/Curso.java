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
	private int nivel;
	private Calendar fInicio;
	private Calendar fFinal;
	private Calendar horario;
	private final int maxAlumnos;
	private final float precio;
	private ArrayList<Alumno> inscritos;
	private ArrayList<Matricula> matriculasDelCurso;
	private Curso cursoNivelSuperior;
	private Curso cursoNivelInferior;

	public Curso(String idioma, int nivel
			, Calendar fInicio, Calendar fFinal, Calendar horario, int maxAlumnos
			, float precio, Curso cursoNivelSuperior, Curso cursoNivelInferior) {
		this.idioma = idioma;
		this.nivel = nivel;
		/*if(fInicio.after(fFinal))	{
			this.fInicio = fInicio;
			this.fFinal = fFinal;
		}else {
			this.fInicio = fFinal;
			this.fFinal = fInicio;
		}*/
		this.horario = horario;
		this.maxAlumnos = maxAlumnos;
		this.precio = precio;
		this.cursoNivelInferior = cursoNivelInferior;
		this.cursoNivelSuperior = cursoNivelSuperior;
		this.inscritos = new ArrayList<Alumno>();
		this.matriculasDelCurso = new ArrayList<Matricula>();
		this.codigo = idioma.substring(0, 3) + nivel;

	}

	public int getNivel() {
		return nivel;
	}

	public int getMaxAlumnos() {
		return maxAlumnos;
	}

	public float getPrecio() {
		return precio;
	}

	public String getIdioma() {
		return idioma;
	}

	public String getCodigo() {
		return codigo;
	}

	public ArrayList<Alumno> getListaAlumnos() {
		return inscritos;
	}

	public Curso getCursoSuperior() {
		return cursoNivelSuperior;
	}

	public Curso getCursoInferior() {
		return cursoNivelInferior;
	}

	public Calendar getFechaFin() {
		return fFinal;
	}

	public Calendar getFechaInicio() {
		return fInicio;
	}

	public Calendar getHorario() {
		return horario;
	}
	
	public void setSuperior(Curso cursoSuperior) {
		this.cursoNivelSuperior = cursoSuperior;
	}
	
	public void setInferior(Curso cursoInferior) {
		this.cursoNivelInferior = cursoInferior;
	}

	public void eliminaAlumno(Alumno alumno) {
		inscritos.remove(alumno);
	}
	public void agregaAlumno(Alumno alumno) {
		inscritos.add(alumno);
	}
	public ArrayList<Matricula> getListaMatriculas() {
		return matriculasDelCurso;
	}

	public ArrayList<Matricula> getMatriculasSinPago() {
		ArrayList<Matricula> pendientes = new ArrayList<Matricula>();
		for (int i = 0; i < matriculasDelCurso.size(); i++) {
			if (!matriculasDelCurso.get(i).isPagado()) {
				pendientes.add(matriculasDelCurso.get(i));
			}
		}
		return pendientes;
	}

	public Matricula matricular(Alumno alumno) {
		if (plazaDisponible(alumno)) {
			inscritos.add(alumno);
			matriculasDelCurso.add(new Matricula(alumno, this));
			return matriculasDelCurso.get(matriculasDelCurso.size()-1);
		}
		return null;
	}

	public boolean plazaDisponible(Alumno alumno) {
		if (maxAlumnos > inscritos.size()) {
			for (int i = 0; i < inscritos.size(); i++) {
				if (inscritos.get(i).equals(alumno)) {
					return false;
					
				}
			}
			return true;
		} else
			return false;
	}
	
	@Override
	public String toString() {
		return "Curso: " + this.codigo + "; Idioma: " + this.idioma + "; Nivel: " + this.nivel;
		
	}
}
