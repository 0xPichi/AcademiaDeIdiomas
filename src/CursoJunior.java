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
	/**
	 * Funcion booleana que comprueba si hay plazas disponibles o si el alumno
	 * que se quiere inscribir ya esta inscrito
	 */
	@Override
	public boolean plazaDisponible(Alumno alumno) {
		if(alumno instanceof Junior) {
			if(super.plazaDisponible(alumno)) {
				return true;
			}else return false;
		}
		return false;
	}

}
