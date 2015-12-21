
public class MatriculaJunior extends Matricula {
	
	private int telefonoDeContacto;
	
	public MatriculaJunior(Junior alumno, CursoJunior curso, int telefono) {
		//Comprobar edad del niño respecto a la edad para el curso
		//¿¿¿¿¿¿¿¿¿¿¿¿¿¿Assert????????????????????
		super(alumno, curso);
		this.telefonoDeContacto = telefono;
		
	}
	
	@Override
	public void subirNivel() {
		//assert(!(curso instanceof CursoNormal))
	}
	//Hay que mirarlo
	@Override
	public void bajarNivel(){}
	//Y esto tambien
	
	public int getTelefono() {
		return telefonoDeContacto;
	}
}
