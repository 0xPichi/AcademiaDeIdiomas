import java.util.ArrayList;

public class Alumno {
	private ArrayList<Curso> listaDeCursos;
	private ArrayList<Matricula> listaDeMatriculas;
	private String nombre;
	private String apellidos;
	private String dni;

	public Alumno(String nombre, String apellidos, String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		listaDeCursos = new ArrayList<Curso>();
		listaDeMatriculas = new ArrayList<Matricula>();
	}
	
	public float calculaDeuda() {
		float deudaAcumulada = 0;
		for(int i = 0; i < listaDeMatriculas.size(); i++) {
			deudaAcumulada += listaDeMatriculas.get(i).getPrecioDeMatricula();
		}
		return deudaAcumulada;
	}
	public ArrayList<Curso> getListaDeCursos() {
		return listaDeCursos;
	}
	public ArrayList<Matricula> getListaDeMatriculas() {
		return listaDeMatriculas;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getDni() {

		return dni;
	}
	@Override
	public boolean equals(Object alumno) {
		if(this.dni != ((Alumno) alumno).getDni()) {
			return false;
		}
		return true;
		
	}
}