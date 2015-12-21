import java.sql.Date;

public class Junior extends Alumno {
	
	private Date fechaNacimiento;
	private Adulto adultoResponsable;
	
	public Junior(String nombre, String apellidos, Date fechaNacimiento, Adulto responsable) {
		super(nombre, apellidos);
		this.fechaNacimiento = fechaNacimiento;
		this.adultoResponsable = responsable;
		
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public Adulto getAdultoResponsable() {
		return adultoResponsable;
	}
	
	@Override
	public float calculaDeuda() {
		return 0;
	}

	

}
