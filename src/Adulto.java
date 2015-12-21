import java.util.ArrayList;

public class Adulto extends Alumno {
	
	private ArrayList<MatriculaJunior> listaDeMatriculasJunior;
		
		public Adulto(String nombre, String apellidos, String dni) {
			super(nombre, apellidos, dni);
			
		}
		
		public ArrayList<MatriculaJunior> getListaDeCursosJunior() {
			ArrayList<CursoJunior> cursosJunior = new ArrayList<CursoJunior>();
			for(int i = 0; i < listaDeMatriculasJunior.size(); i++) {
				cursosJunior.add(listaDeMatriculasJunior.get(i).getCurso());
			}
			return cursosJunior;
		}
		
		@Override
		public float calculaDeuda() {
			float deudaAcumulada;
			deudaAcumulada = super.calculaDeuda();
			for(int i = 0; i < listaDeMatriculasJunior.size(); i++) {
				deudaAcumulada += listaDeMatriculasJunior.get(i).getPrecioDeMatricula();
			}
			return deudaAcumulada;	
		}
		
		public void addMatriculaJunior(MatriculaJunior matricula) {
			listaDeMatriculasJunior.add(matricula);
		}
		
		public ArrayList<Junior> getListaDeJuniors() {
			ArrayList<Junior> listaJuniors = new ArrayList<Junior>();
			for(int i = 0; i < listaDeMatriculasJunior.size(); i++) {
				listaJuniors.add(listaDeMatriculasJunior.get(i).getAlumno());
			}
			return listaJunior;
		}
}


