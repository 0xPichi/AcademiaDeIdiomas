import java.util.ArrayList;

public class Alumno {
	private ArrayList<Matricula> listaDeMatriculas;
	private String nombre;
	private String apellidos;
	private String dni;

	public Alumno(String nombre, String apellidos, String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		listaDeMatriculas = new ArrayList<Matricula>();
	}

	public double calculaDeuda() {
		double deudaAcumulada = 0.0;
		for (int i = 0; i < listaDeMatriculas.size(); i++) {
			if (!listaDeMatriculas.get(i).isPagado()) {
				deudaAcumulada = +listaDeMatriculas.get(i).getPrecio();
			}
		}
		return deudaAcumulada;
	}

	public void matricular(Matricula nuevaMatricula) { 
		listaDeMatriculas.add(nuevaMatricula);
	}

	public void pagar(Curso curso) {

		for (int i = 0; i < listaDeMatriculas.size(); i++) {
			if (curso == listaDeMatriculas.get(i).getCurso() && !listaDeMatriculas.get(i).isPagado()) {
				listaDeMatriculas.get(i).marcaPagado();

			}
		}
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

}