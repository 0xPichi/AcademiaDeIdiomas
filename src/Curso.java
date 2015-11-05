import java.util.ArrayList;

public class Curso {

	private String code;
	private String idioma;
	private int nivel;
	private int fInicio;
	private int fFinal;
	private int horario;
	private final int maxAlumnos;
	private final double precio;
	private ArrayList<Alumno> inscritos;

	public Curso(String idioma, int nivel, int fInicio, int fFinal, int maxAlumnos, double precio) {
		this.idioma = idioma;
		this.nivel = nivel;
		this.fInicio = fInicio;
		this.fFinal = fFinal;
		this.maxAlumnos = maxAlumnos;
		this.precio = precio;
		inscritos = new ArrayList<Alumno>();
		this.code = idioma.substring(0, 2) + nivel;

	}
	public void aniadirAlumno(Alumno alumno) {
			inscritos.add(alumno);
		
	}
	
	public boolean plazaDisponible(Alumno nuevoAlumno) {
		if(!inscritos.contains(nuevoAlumno) && inscritos.size() < maxAlumnos) {
			return true; 
		}else return false;
	}
	
	public double getPrecio (){
		return precio;
	}
	
	public String getIdioma() {
		return idioma;
	}
	
	public int getNivel() {
		return nivel;
	}
}
