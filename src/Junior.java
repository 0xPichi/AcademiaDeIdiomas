import java.util.Calendar;
import java.util.GregorianCalendar;

public class Junior extends Alumno {
	
	private GregorianCalendar fechaNacimiento;
	private Adulto adultoResponsable;
	
	public Junior(String nombre, String apellidos, GregorianCalendar fechaNacimiento, Adulto responsable) {
		super(nombre, apellidos);
		this.fechaNacimiento = fechaNacimiento;
		assert(responsable != null);
		this.adultoResponsable = responsable;
		
	}
	
	public GregorianCalendar getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public Adulto getAdultoResponsable() {
		return adultoResponsable;
	}
	
	@Override
	public float calculaDeuda() {
		return 0;
	}
	
	public boolean compruebaEdad(){
		GregorianCalendar menor = new GregorianCalendar();
		menor.set(Calendar.YEAR, menor.get(Calendar.YEAR)-17);
		Junior alumno = (Junior) super.getAlumno();
		if(menor.before(alumno.getFechaNacimiento())){
			return false;
		}
		return true;
	}

}
