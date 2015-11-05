import java.util.ArrayList;

public class Curso {

	private String code;
	private String idioma;
	private int nivel;
	private int fInicio;
	private int fFinal;
	private int horario;
	/*
	 * Se entiende que horario es a una hora todos los dias de la semana (hasta las 8 maximo creo)
	 */
	private final int maxAlumnos;
	private final double precio;
	private ArrayList<Alumno> inscritos;

	public Curso(String idioma, int nivel, int fInicio, int fFinal, int maxAlumnos, int precio) {
		this.idioma = idioma;
		this.nivel = nivel;
		this.fInicio = fInicio;
		this.fFinal = fFinal;
		horario = new ArrayList<int>(); //Tu sabras, Pichi
		/*
		 * horario esta sin acabar, hay que hacer copy con el ArrayList
		 */
		this.maxAlumnos = maxAlumnos;
		this.precio = precio;
		inscritos = new ArrayList<Alumno>();
		this.code = idioma.substring(0, 2) + nivel;

	}
	public void aņadirAlumno(Alumno alumno) {
		inscritos.contains(alumno);
	}
	
	public double getPrecio (){
		return precio;
	}
}
