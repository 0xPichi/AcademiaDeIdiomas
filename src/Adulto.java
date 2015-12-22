import java.util.ArrayList;

public class Adulto extends Alumno {

	private ArrayList<MatriculaJunior> listaDeMatriculasJunior;

	public Adulto(String nombre, String apellidos, String dni) {
		super(nombre, apellidos, dni);
		listaDeMatriculasJunior = new ArrayList<MatriculaJunior>();

	}

	public ArrayList<CursoJunior> getListaDeCursosJunior() {
		ArrayList<CursoJunior> cursosJunior = new ArrayList<CursoJunior>();
		for (int i = 0; i < listaDeMatriculasJunior.size(); i++) {
			cursosJunior.add(listaDeMatriculasJunior.get(i).getCurso());
		}
		return cursosJunior;
	}


	public void addMatriculaJunior(MatriculaJunior matricula) {
		this.addMatricula(matricula);
		listaDeMatriculasJunior.add(matricula);
	}

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
	 * Determina si dos instancias de la clase <code>Alumno</code> son iguales a
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

	@Override
	public String toString() {
		return "Nombre: " + super.getNombre() + "; Apellidos: " + super.getApellidos() + "; DNI: " + super.getDni();
	}
}
