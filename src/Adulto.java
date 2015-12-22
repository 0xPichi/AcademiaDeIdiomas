import java.util.ArrayList;

public class Adulto extends Alumno {

	private ArrayList<MatriculaJunior> listaDeMatriculasJunior;

	/**
	 * Constructor de la clase <code>Adulto</code> que hereda de
	 * <code>Alumno</code>
	 * 
	 * @param nombre
	 *            String con el nombre de <code>Adulto</code>
	 * @param apellidos
	 *            String con los apellidos de <code>Adulto</code>
	 * @param dni
	 *            String con el dni de <code>Adulto</code>
	 */
	public Adulto(String nombre, String apellidos, String dni) {
		super(nombre, apellidos, dni);
		listaDeMatriculasJunior = new ArrayList<MatriculaJunior>();

	}

	/**
	 * Crea y rellena la lista de los cursos junior asociados al
	 * <code>Adulto</code>
	 * 
	 * @return cursosJunior Lista con los cursos de los que se encarga el
	 *         <code>Adulto</code>
	 */
	public ArrayList<CursoJunior> getListaDeCursosJunior() {
		ArrayList<CursoJunior> cursosJunior = new ArrayList<CursoJunior>();
		for (int i = 0; i < listaDeMatriculasJunior.size(); i++) {
			cursosJunior.add(listaDeMatriculasJunior.get(i).getCurso());
		}
		return cursosJunior;
	}

	/**
	 * Añade una matricula junior a la lista de matriculas junior de las que se
	 * encarga el <code>Adulto</code>
	 * 
	 * @param matricula
	 *            <code>Matricula</code> añadida a la lista de matriculas junior
	 */
	public void addMatriculaJunior(MatriculaJunior matricula) {
		this.addMatricula(matricula);
		listaDeMatriculasJunior.add(matricula);
	}

	/**
	 * Crea y rellena la lista de juniors que dependen del <code>Adulto</code>
	 * 
	 * @return
	 */
	public ArrayList<Junior> getListaDeJuniors() {
		ArrayList<Junior> listaJuniors = new ArrayList<Junior>();
		for (int i = 0; i < listaDeMatriculasJunior.size(); i++) {
			listaJuniors.add(listaDeMatriculasJunior.get(i).getAlumno());
		}
		return listaJuniors;
	}

	/**
	 * Metodo que sobreescribe el metodo equals(Object object) de la clase
	 * <code>Object</code>.
	 * 
	 * Determina si dos instancias de la clase <code>Adulto</code> son iguales a
	 * partir del numero de <code>dni</code>.
	 * 
	 */
	@Override
	public boolean equals(Object object) {
		assert(object instanceof Alumno);
		if (!(super.getDni().equals(((Alumno) object).getDni()))) {
			return false;

		} else
			return true;

	}

	/**
	 * Sobreescribe el metodo toString() de la clase <code>Object</code>
	 * 
	 * Devuelve una cadena de caracteres con el formato: Nombre: xxxx;
	 * Apellidos: xxxx; DNI: xxx.
	 * 
	 * @return String cadena de caracteres que representa el estado del objeto
	 *         <code>Adulto</code>
	 */
	@Override
	public String toString() {
		return "Nombre: " + super.getNombre() + "; Apellidos: " + super.getApellidos() + "; DNI: " + super.getDni();
	}
}
