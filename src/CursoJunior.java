import java.util.Calendar;

public class CursoJunior extends Curso {

	private int edadMinima;
	private int edadMaxima;

	public CursoJunior(String idioma, Calendar fInicio, Calendar fFinal, int horario, int maxAlumnos, float precio,
			int edadMinima, int edadMaxima) {
		super(idioma, fInicio, fFinal, horario, maxAlumnos, precio);
		this.edadMaxima = edadMaxima;
		this.edadMinima = edadMinima;
	}
	
	public int getEdadMinima(){
		return edadMinima;
	}
	
	public int getEdadMaxima(){
		return edadMaxima;
	}

}
