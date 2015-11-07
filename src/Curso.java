import java.util.ArrayList;
import java.util.Calendar;

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

	public Curso(String idioma, int nivel, Calendar fInicio, Calendar fFinal, Calendar horario, int maxAlumnos,
			float precio, Curso cursoNivelSuperior, Curso cursoNivelInferior) {
		this.idioma = idioma;
		this.nivel = nivel;
		this.fInicio = fInicio;
		this.fFinal = fFinal;
		this.horario = horario;
		this.maxAlumnos = maxAlumnos;
		this.precio = precio;
		this.cursoNivelInferior = cursoNivelInferior;
		this.cursoNivelSuperior = cursoNivelSuperior;
		this.inscritos = new ArrayList<Alumno>();
		this.matriculasDelCurso = new ArrayList<Matricula>();
		this.codigo = idioma.substring(0, 2) + nivel;
		
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
	public ArrayList<Matricula> getListaMatriculas() {
		return matriculasDelCurso;
	}
	public ArrayList<Matricula> getMatriculasSinPago() {
		ArrayList<Matricula> pendientes = new ArrayList<Matricula>();
		for(int i = 0; i < matriculasDelCurso.size(); i++) {
			if(!matriculasDelCurso.get(i).isPagado()) {
				pendientes.add(matriculasDelCurso.get(i));
			}
		}
		return pendientes;
	}	
	public Matricula matricular(Alumno alumno) {
		if(this.plazaDisponible(alumno)) {
			return matriculasDelCurso.get(matriculasDelCurso.size());
		}
		return null;
	}
	public boolean plazaDisponible(Alumno alumno) {
		if(maxAlumnos < inscritos.size()) {
			for(int i = 0; i < inscritos.size(); i++) {
				if(inscritos.get(i).equals(alumno)) {
					return false;
				}
			}
		}
		return false;
	}
}
