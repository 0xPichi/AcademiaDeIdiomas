import java.util.ArrayList;

public class Curso {

	private String code;
	private String idioma;
	private int nivel;
	private int fInicio;
	private int fFinal;
	private ArrayList<String> horario;
	/*
	 * Horario habra que preguntar si es simplemente una hora o son que dias y a
	 * que horas se imparte
	 */
	private final int maxAlumnos;
	private final int precio;
	private ArrayList<Alumno> inscritos;

	public Curso(String idioma, int nivel, int fInicio, int fFinal, int maxAlumnos, int precio) {
		this.idioma = idioma;
		this.nivel = nivel;
		this.fInicio = fInicio;
		this.fFinal = fFinal;
		horario = new ArrayList<String>();
		/*
		 * horario esta sin acabar, hay que hacer copy con el ArrayList
		 */
		this.maxAlumnos = maxAlumnos;
		this.precio = precio;
		inscritos = new ArrayList<Alumno>();
		this.code = idioma.substring(0, 2) + nivel;

	}
	public void añadirAlumno(Alumno alumno) {
		inscritos.contains(alumno);
	}
}
