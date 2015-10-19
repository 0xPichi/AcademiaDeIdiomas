import java.util.ArrayList;

public class Alumno {
	
	private String nombre;
	private String apellidos;
	private String dni;
	private ArrayList<Curso> cursos;
	
	public Alumno (String nombre, String apellidos, String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		cursos = new ArrayList<Curso>();
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	private void setApellidos(String Apellidos) {
		this.apellidos = apellidos;
	}
	public String getApellidos() {
		return apellidos;
	}
	private void setDni(String dni) {
		this.dni = dni;
	}
	public String getDni() {
		return dni;
	}
	public void setCursos(ArrayList<Curso> listaDeCursos) {
		/**
		 * Esto casi seguro que no es asi, habra que copiarlos de uno en uno.
		 * Para utilizar el objeto que creamos con el constructor.
		 */
		cursos = (ArrayList<Curso>) listaDeCursos.clone();
	}
	public ArrayList<Curso> getCursos() {

		return cursos;
	}
	
	public void inscribeCurso(Curso nuevoCurso) {
		cursos.add(nuevoCurso);
	}
	public void eliminaCurso(Curso cursoEliminado) {

				cursos.remove(cursoEliminado);
	}
	
	public double calculaDeuda() {
		double deudaAcumulada = 0;
		for(int i = 0; i < cursos.size(); i++) {
			deudaAcumulada =+ cursos.get(i).getImporte(;
		}
		return deudaAcumulada;
	}
	
	
}