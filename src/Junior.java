import java.util.Calendar;
import java.util.GregorianCalendar;

public class Junior extends Alumno {

	private GregorianCalendar fechaNacimiento;
	private Adulto adultoResponsable;

	/**
	 * Constructor de la clase <code>Junior</code> que hereda de
	 * <code>Alumno</code>
	 * 
	 * @param nombre
	 *            String con el nombre de <code>Junior</code>
	 * @param apellidos
	 *            String con los apellidos de <code>Junior</code>
	 * @param fechaNacimiento
	 *            GregorianCalendar con la fecha de nacimiento de
	 *            <code>Junior</code>
	 * @param responsable
	 *            Adulto responsable de <code>Junior</code>
	 */
	public Junior(String nombre, String apellidos, GregorianCalendar fechaNacimiento, Adulto responsable) {
		super(nombre, apellidos);
		assert(responsable != null);
		assert(compruebaEdad());
		assert(fechaNacimiento != null);
		this.fechaNacimiento = fechaNacimiento;
		
		this.adultoResponsable = responsable;

	}

	/**
	 * Getter del atributo <code>fechaNacimiento</code>
	 * 
	 * @return fechaNacimiento GregorianCalendar con la fecha de nacimiento del
	 *         <code>Junior</code>
	 */
	public GregorianCalendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Getter del atributo <code>adultoResponsable</code>
	 * 
	 * @return adultoResponsable Adulto encargado del <code>Junior</code>
	 */
	public Adulto getAdultoResponsable() {
		return adultoResponsable;
	}

	/**
	 * Metodo que sobreescribe el metodo calculadeuda() de la clase
	 * <code>Alumno</code>
	 * 
	 * Puesto que la deuda de alumno la lleva exclusivamente el adulto
	 * responsable, devuelve 0
	 */
	@Override
	public float calculaDeuda() {
		return 0;
	}

	/**
	 * Metodo que compara la edad de <code>Junior</code> y comprueba que sea
	 * menor de edad
	 */
	public boolean compruebaEdad() {
		GregorianCalendar menor = new GregorianCalendar();
		menor.set(Calendar.YEAR, menor.get(Calendar.YEAR) - 17);
		Junior alumno = (Junior) this;
		if (menor.before(alumno.getFechaNacimiento())) {
			return false;
		}
		return true;
	}

	/**
	 * Metodo que sobreescribe el metodo equals(Object object) de la clase
	 * <code>Object</code>.
	 * 
	 * Determina si dos instancias de la clase <code>Alumno</code> son iguales a
	 * partir del numero de su <code>nombre</code>, <code>apellidos</code> y
	 * <code>dni</code>.
	 * 
	 */
	@Override
	public boolean equals(Object object) {
		assert(object instanceof Alumno);
		if (!(super.getNombre().equals(((Alumno) object).getNombre()))
				&& (super.getApellidos().equals(((Alumno) object).getApellidos()))
				&& this.adultoResponsable.equals(((Junior) object).getAdultoResponsable())) {
			return false;

		} else
			return true;

	}

}
