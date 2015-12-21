import java.util.ArrayList;
/**
 * 
 * Clase <code>Alumno</code>
 * 
 * @author Sergio Delgado Álvarez
 * @author Miguel Bayón Sanz
 * @author Daniel Paredes Santamaría
 *
 */
public class Alumno {
	private ArrayList<Matricula> listaDeMatriculas;
	private String nombre;
	private String apellidos;
	private String dni;
	/**
	 * Constructor de la clase <code>Alumno</code>
	 * 
	 * 
	 * @param nombre String con el nombre de <code>Alumno</code>
	 * @param apellidos String con los apellidos de <code>Alumno</code>
	 * @param dni String con el dni/nif de <code>Alumno</code>
	 * 
	 */
	public Alumno(String nombre, String apellidos, String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		listaDeMatriculas = new ArrayList<Matricula>();
	}
	/**
	 * Funcion que calcula la deuda acumulada del <code>Alumno</code>
	 * 
	 * @return deudaAcumulada Float con la deuda total acumulada del <code>Alumno</code>
	 * 
	 */
	public float calculaDeuda() {
		float deudaAcumulada = 0;
		for (int i = 0; i < listaDeMatriculas.size(); i++) {
			deudaAcumulada += listaDeMatriculas.get(i).getPrecioDeMatricula();
		}
		return deudaAcumulada;
	}
	/**
	 * 
	 * Crea y rellena la lista de los cursos asociados 
	 * a las matriculas del <code>Alumno</code>
	 * 
	 * @return listaDeCursos Lista con los cursos 
	 * a los que esta inscrito el <code>Alumno</code>
	 */
	public ArrayList<Curso> getListaDeCursos() {
		ArrayList<Curso> listaDeCursos = new ArrayList<Curso>();
		for(int i = 0; i < listaDeMatriculas.size(); i++) {
			listaDeCursos.add(listaDeMatriculas.get(i).getCurso());
		}
		return listaDeCursos;
	}
	/**
	 * Getter del atributo <code>listaDeMatriculas</code>
	 * 
	 * @return listaDeMatriculas Lista con las matriculas 
	 * asociadas al <code>Alumno</code>
	 */
	public ArrayList<Matricula> getListaDeMatriculas() {
		return listaDeMatriculas;
	}
	/**
	 * Getter del atributo <code>nombre</code>
	 * 
	 * @return nombre String con el nombre del <code>Alumno</code>
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Getter del atributo <code>apellidos</code>
	 * 
	 * @return apellidos String con los apellidos del <code>Alumno</code>
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * Getter del atributo <code>dni</code>
	 * 
	 * @return dni String con el dni/nif del <code>Alumno</code>
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * Metodo que sobreescribe el metodo equals(Object object) de la clase <code>Object</code>.
	 * 
	 * Determina si dos instancias de la clase <code>Alumno</code> son iguales a partir
	 * del numero de <code>dni</code>.
	 * 
	 */
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Alumno)) {
			return false;
		}
		if (!(this.dni.equals(((Alumno) object).getDni()))) {
			return false;
			
		}else return true;

	}
	/**
	 * Metodo que añade una instancia de <code>Matricula</code> a la lista
	 * de matriculas del <code>Alumno</code>.
	 * 
	 * @param matricula <code>Matricula</code> que se añade a la lista.
	 */
	public void addMatricula(Matricula matricula) {
		listaDeMatriculas.add(matricula);

	}
	/**
	 * Sobreescribe el metodo toString() de la clase <code>Object</code>
	 * 
	 * Devuelve una cadena de caracteres con el formato: Nombre: xxxx; Apellidos: xxxx; DNI: xxx.
	 * 
	 * @return String cadena de caracteres que representa el estado del objeto <code>Alumno</code>
	 */
	@Override
	public String toString (){
		return "Nombre: " + nombre + "; Apellidos: " + apellidos + "; DNI: " + dni;
	}
}