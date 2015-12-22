import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * Clase <code>Academia</code>
 * 
 * @author Sergio Delgado Álvarez
 * @author Miguel Bayón Sanz
 * @author Daniel Paredes Santamaría
 *
 */

public class NuevaAcademia {

	public static void main(String[] args) {

		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		ArrayList<Curso> listaCursos = new ArrayList<Curso>();
		ArrayList<Matricula> listaMatriculas = new ArrayList<Matricula>();

		// Creamos varios cursos de cada tipo: cuatro cursos normales y
		// tres junior, y los agregamos a la lista
		System.out.println("Creando cursos normales y cursos junior...\n");

		CursoNormal ingles1 = new CursoNormal("Ingles", 1, new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 10, 10, 25, null, null);
		CursoNormal ingles2 = new CursoNormal("Ingles", 2, new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 20, 12, 35, null, ingles1);
		CursoNormal ingles3 = new CursoNormal("Ingles", 3, new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 17, 5, 50, null, ingles2);
		CursoNormal aleman2 = new CursoNormal("Aleman", 2, new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 17, 2, 50, null, null);

		ingles1.setCursoSuperior(ingles2);
		ingles2.setCursoSuperior(ingles3);

		CursoJunior aleman = new CursoJunior("Aleman", new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 10, 5, 50, 10, 16);
		CursoJunior chino = new CursoJunior("Chino", new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 10, 5, 50, 10, 16);
		CursoJunior frances = new CursoJunior("Frances", new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 10, 2, 50, 10, 16);

		// Los añadimos a una lista de cursos
		System.out.println("Añadiendo a listas de cursos...\n");

		listaCursos.add(ingles1);
		listaCursos.add(ingles2);
		listaCursos.add(ingles3);
		listaCursos.add(aleman);
		listaCursos.add(chino);
		listaCursos.add(frances);

		// Imprimimos la lista de cursos con sus alumnos matriculados, que en
		// este momento sera ninguno.

		imprimeListaDeCursos(listaCursos);
		System.out.println("-------------------------------------------------");

		// Creamos 4 adultos distintos y los añadimos a la lista de
		// alumnos. Luego imprimimos la lista de alumnos
		// y los cursos en los que estan matriculados los alumnos, en este
		// momento ninguno.

		System.out.println("\nCreando alumnos...");

		Adulto sergio = new Adulto("Sergio", "Delgado Álvarez", "12427851P");
		Adulto miguel = new Adulto("Miguel", "Bayón Sanz", "12457637H");
		Adulto daniel = new Adulto("Daniel", "Paredes Santamaria", "7115725G");
		Adulto ivan = new Adulto("Iván", "Castaño Fernandez", "12435352K");
		Adulto cristina = new Adulto("Cristina", "Blanco Rodriguez", "12435678U");

		// Igual con los junior, pero comprobando que son menores de edad
		Alumno vicente = null;
		Alumno alberto = null;
		Alumno jony = null;

		GregorianCalendar nacimiento = new GregorianCalendar(2013, 12, 3);
		if (compruebaEdad(nacimiento)) {
			vicente = new Junior("Vicente", "de Daniel Garrote", nacimiento, sergio);
		} else {
			vicente = new Adulto("Vicente", "de Daniel Garrote", "12345678K");
		}
		nacimiento = new GregorianCalendar(2012, 6, 3);
		if (compruebaEdad(nacimiento)) {
			alberto = new Junior("Alberto", "Amigo", nacimiento, daniel);
		} else {
			vicente = new Adulto("Alberto", "Amigo", "15138449L");
		}
		nacimiento = new GregorianCalendar(2010, 1, 3);
		if (compruebaEdad(nacimiento)) {
			jony = new Junior("Jonathan", "Rios Giron", nacimiento, sergio);
		} else {
			jony = new Adulto("Jonathan", "Rios Giron", "15937813O");
		}

		System.out.println("Añadiendo a listas de alumnos...\n");

		listaAlumnos.add(sergio);
		listaAlumnos.add(miguel);
		listaAlumnos.add(daniel);
		listaAlumnos.add(cristina);
		listaAlumnos.add(ivan);
		listaAlumnos.add(vicente);
		listaAlumnos.add(alberto);
		listaAlumnos.add(jony);
		imprimeListaDeAlumnos(listaAlumnos);
		System.out.println("--------------------------------------------------\n");

		// Comprobaremos que diferentes alumnos tienen plaza en diferentes
		// cursos, los matricularemos y guardamos sus matriculas a la lista

		System.out.println("\nMatricular Miguel en Ingles 1 y Aleman 2");
		if (ingles1.plazaDisponible(miguel)) {
			MatriculaNormal miIn1 = new MatriculaNormal(miguel, ingles1);
			listaMatriculas.add(miIn1);
		}
		if (aleman2.plazaDisponible(miguel)) {
			MatriculaNormal miAl2 = new MatriculaNormal(miguel, aleman2);
			listaMatriculas.add(miAl2);
		}

		System.out.println("\nMatricular Sergio en Ingles 3 y Aleman 2");
		if (ingles3.plazaDisponible(sergio)) {
			MatriculaNormal seIn3 = new MatriculaNormal(sergio, ingles3);
			listaMatriculas.add(seIn3);
		}
		if (aleman2.plazaDisponible(sergio)) {
			MatriculaNormal seAl2 = new MatriculaNormal(sergio, aleman2);
			listaMatriculas.add(seAl2);
		}
		System.out.println("\nMatricular Ivan en Ingles 3");
		if (ingles3.plazaDisponible(ivan)) {
			MatriculaNormal ivIn3 = new MatriculaNormal(ivan, ingles3);
			listaMatriculas.add(ivIn3);
		}

		System.out.println("\nMatricular Vicente en Aleman y Frances");
		if (aleman.plazaDisponible(vicente)) {
			MatriculaJunior viAl = new MatriculaJunior((Junior) vicente, aleman, 983154679);
			listaMatriculas.add(viAl);
		}

		if(frances.plazaDisponible(vicente)) {
			MatriculaJunior viFr = new MatriculaJunior((Junior) vicente, frances, 983154679);
			listaMatriculas.add(viFr);
		}

		System.out.println("\nMatricular Jonathan en frances");
		if (frances.plazaDisponible(jony)) {
			MatriculaJunior joFr = new MatriculaJunior((Junior) jony, frances, 983154679);
			listaMatriculas.add(joFr);
		}

		System.out.println("\nMatricular Alberto en chino");
		if (chino.plazaDisponible(alberto)) {
			MatriculaJunior alCh = new MatriculaJunior((Junior) alberto, chino, 983154679);
			listaMatriculas.add(alCh);
		}
		
		//Matriculamos a un junior en un curso normal
		if (ingles2.plazaDisponible(alberto)) {
			MatriculaNormal alIn2 = new MatriculaNormal((Junior) alberto, ingles2);
			listaMatriculas.add(alIn2);
		}
		
		//Intentamos matricular a un adulto en un curso junior
		if (!aleman.plazaDisponible(ivan)) {
			System.out.println("No se puede matricular a un adulto en un curso junior");
		}
		
		//Intentamos meter a un adulto y a un junior en cursos que ya esten llenos
		System.out.println("\nMatricular Ivan en Aleman 2");
		if (aleman2.plazaDisponible(ivan)) {
			MatriculaNormal ivAl2 = new MatriculaNormal(ivan, aleman2);
			listaMatriculas.add(ivAl2);
		}
		System.out.println("\nMatricular Alberto en frances");
		if (frances.plazaDisponible(alberto)) {
			MatriculaJunior alFr = new MatriculaJunior((Junior) alberto, frances, 983154679);
			listaMatriculas.add(alFr);
		}
		
		//Intentamos matricular un alumno en un curso en el que ya este
		System.out.println("\nMatricular Ivan en Ingles 3 otra vez");
		if (ingles3.plazaDisponible(ivan)) {
			MatriculaNormal ivIn3 = new MatriculaNormal(ivan, ingles3);
			listaMatriculas.add(ivIn3);
		}
		
		System.out.println("\nMatricular Jonathan en frances");
		if (frances.plazaDisponible(jony)) {
			MatriculaJunior joFr = new MatriculaJunior((Junior) jony, frances, 983154679);
			listaMatriculas.add(joFr);
		}
		
		System.out.println("Matriculas en ingles1...");
		for (int i=0; i<ingles1.getListaMatriculas().size(); i++){
			System.out.println("Pollas"+ingles1.getListaMatriculas().get(i).getMtriculaId());
		}
		
		//Pagamos la matriculas de Miguel
		for(int i = 0; i < miguel.getListaDeMatriculas().size(); i++) {
			pagarMatricula(miguel.getListaDeMatriculas().get(i));
			System.out.println("Pagando "+miguel.getListaDeCursos().get(i).getCodigo());//ALGO PASA CON MERI
		}
		System.out.println("Lista de alumnos");
		imprimeListaDeAlumnos(listaAlumnos);
		System.out.println("----------------------------------------------------");
		System.out.println("Lista de Cursos que tienen matriculas sin pagar");
		imprimeCursosSinPagar(listaCursos);

		//Subimos y bajamos de nivel a un alumno
		System.out.println("Subimos de nivel a Alberto:");
		subirNivelCurso(listaMatriculas, alberto, ingles2);
		imprimeListaDeAlumnos(listaAlumnos);
		System.out.println("----------------------------------------------------");
		System.out.println("Bajamos de nivel a Alberto:");
		bajarNivelCurso(listaMatriculas, alberto, ingles3);
		imprimeListaDeAlumnos(listaAlumnos);
		

	}
	
	

	public static void imprimeListaDeCursos(ArrayList<Curso> listaDeCursos) {
		for (int i = 0; i < listaDeCursos.size(); i++) {
			System.out.println(listaDeCursos.get(i).toString() + " ");
			System.out.println("Alumnos matriculados: \n");
			imprimeAlumnosDeCurso(listaDeCursos.get(i));
		}
	}

	public static void imprimeListaDeAlumnos(ArrayList<Alumno> listaDeAlumnos) {
		for (int i = 0; i < listaDeAlumnos.size(); i++) {
			System.out.print(listaDeAlumnos.get(i).toString() + " ");
			System.out.println("\nMatriculado en: ");
			imprimeCursosDeAlumno(listaDeAlumnos.get(i));
			System.out.println("La deuda total del alumno es: " + listaDeAlumnos.get(i).calculaDeuda() + "\n");
		}

	}

	public static void imprimeAlumnosDeCurso(Curso curso) {
		for (int i = 0; i < curso.getListaAlumnos().size(); i++) {
			System.out.println(curso.getListaAlumnos().get(i).toString());
		}
	}

	public static void imprimeCursosDeAlumno(Alumno alumno) {
		for (int i = 0; i < alumno.getListaDeCursos().size(); i++) {
			System.out.println(alumno.getListaDeCursos().get(i).toString());
		}
	}

	public static boolean plazaDisponible(Alumno alumno, Curso curso) {
		if (curso.plazaDisponible(alumno)) {
			System.out.println("¡Hay plazas disponibles!, el alumno puede matricularse");
			return true;
		} else {
			System.out.println("¡No hay plazas disponibles!");
			return false;
		}
	}

	public static void pagarMatricula(Matricula matricula) {
		matricula.pagar();
	}

	public static void imprimeCursosSinPagar(ArrayList<Curso> listaDeCursos) {
		for (int i = 0; i < listaDeCursos.size(); i++) {
			if (listaDeCursos.get(i).getMatriculasSinPago().size() != 0) {
				System.out.println(listaDeCursos.get(i).toString());
			}
		}
	}

	public static boolean compruebaEdad(GregorianCalendar fecha) {
		GregorianCalendar hoy = new GregorianCalendar();
		hoy.set(Calendar.YEAR, hoy.get(Calendar.YEAR) - 17);
		if (hoy.before(fecha)) {
			return true;
		}
		return false;
	}

	public static void subirNivelCurso(ArrayList<Matricula> listaDeMatriculas, Alumno alumno, Curso curso) {
		MatriculaNormal nuevaMatricula = null;
		for(int i = 0; i < listaDeMatriculas.size(); i++) {
			if(listaDeMatriculas.get(i).getAlumno().equals(alumno)
					&& listaDeMatriculas.get(i).getCurso().getCodigo().equals(curso.getCodigo())) {
				nuevaMatricula = (MatriculaNormal)listaDeMatriculas.get(i);
				nuevaMatricula.subirNivel();
			}
		}
	}
	
	public static void bajarNivelCurso(ArrayList<Matricula> listaDeMatriculas, Alumno alumno, Curso curso) {
		MatriculaNormal  nuevaMatricula = null;
		for(int i = 0; i < listaDeMatriculas.size(); i++) {
			if(listaDeMatriculas.get(i).getAlumno().equals(alumno)
					&& listaDeMatriculas.get(i).getCurso().getCodigo().equals(curso.getCodigo())) {
				nuevaMatricula = (MatriculaNormal) listaDeMatriculas.get(i);
				nuevaMatricula.bajarNivel();
			}
		}
	}
}
