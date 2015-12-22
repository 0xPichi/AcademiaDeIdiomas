import java.util.ArrayList;
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
		ArrayList<Matricula> listaMatriculas = new ArrayList<>();

		// Creamos varios varios cursos de cada tipo: cuatro cursos normales y
		// tres junior, y los agregamos a la lista
		System.out.println("Creando cursos normales y cursos junior...\n");

		CursoNormal ingles1 = new CursoNormal("Ingles", 1, new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 10, 10, 25, null, null);
		CursoNormal ingles2 = new CursoNormal("Ingles", 2, new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 20, 12, 35, null, ingles1);
		CursoNormal ingles3 = new CursoNormal("Ingles", 3, new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 17, 2, 50, null, ingles2);
		CursoNormal aleman2 = new CursoNormal("Aleman", 2, new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 17, 2, 50, null, null);

		ingles1.setCursoSuperior(ingles2);
		ingles2.setCursoSuperior(ingles3);

		CursoJunior aleman = new CursoJunior("Aleman", new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 10, 5, 50, 10, 16);
		CursoJunior chino = new CursoJunior("Aleman", new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 10, 5, 50, 10, 16);
		CursoJunior frances = new CursoJunior("Aleman", new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 10, 5, 50, 10, 16);

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

		// Creamos 4 adultos y 3 niños distintos y los añadimos a la lista de
		// alumnos. Luego imprimimos la lista de alumnos
		// y los cursos en los que estan matriculados los alumnos en este
		// momento ninguno.
		
		System.out.println("\nCreando alumnos...");
		
		Adulto sergio = new Adulto("Sergio", "Delgado Álvarez", "12427851P");
		Adulto miguel = new Adulto("Miguel", "Bayón Sanz", "12457637H");
		Adulto daniel = new Adulto("Daniel", "Paredes Santamaria", "7115725G");
		Adulto ivan = new Adulto("Iván", "Castaño Fernandez", "12435352K");
		Adulto cristina = new Adulto("Cristina", "Blanco Rodriguez", "12435678U");
		
		Junior vicente = new Junior("Vicente", "de Daniel Garrote", new GregorianCalendar(2013, 12, 3), ivan);
		Junior alberto = new Junior("Alberto", "Amigo", new GregorianCalendar(2012, 6, 3), daniel);
		Junior jony = new Junior("Jonathan", "Rios Giron", new GregorianCalendar(2008, 4, 15), ivan);
		
		//ASDFASDFASDF
		jony.getListaDeCursos();
		ivan.getListaDeCursos();
		
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
		// cursos y los matricularemos.

		System.out.println("Matricular Miguel en Ingles 1 y Aleman 1\n");
		MatriculaNormal miIn1 = new MatriculaNormal(miguel, ingles1);
		MatriculaNormal miAl2 = new MatriculaNormal(miguel, aleman2);

		System.out.println("Matricular Sergio en Ingles 3 y Aleman 2\n");
		MatriculaNormal seIn3 = new MatriculaNormal(sergio, ingles3);
		MatriculaNormal seAl2 = new MatriculaNormal(sergio, aleman2);

		System.out.println("Matricular Ivan en Ingles 3\n");
		MatriculaNormal ivIn3 = new MatriculaNormal(ivan, ingles3);
		
		System.out.println("Matricular Vicente en Aleman y frances\n");
		MatriculaJunior viAl = new MatriculaJunior(vicente, aleman, 983154679);
		
		System.out.println("Matricular Ivan en Ingles 3\n");
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
	// ARREGLAR
	/*
	 * public static void subirNivelCurso(ArrayList<Matricula>
	 * listaDeMatriculas, Alumno alumno, Curso curso) { for(int i = 0; i <
	 * listaDeMatriculas.size(); i++) { if(listaDeMatriculas.get(i) instanceof
	 * MatriculaNormal && listaDeMatriculas.get(i).getAlumno().equals(alumno) &&
	 * listaDeMatriculas.get(i).getCurso().getCodigo().equals(curso.getCodigo())
	 * ) { listaDeMatriculas.get(i).subirNivel(); } } } public static void
	 * bajarNivelCurso(ArrayList<Matricula> listaDeMatriculas, Alumno alumno,
	 * Curso curso) { for(int i = 0; i < listaDeMatriculas.size(); i++) {
	 * if(listaDeMatriculas.get(i).getAlumno().equals(alumno) &&
	 * listaDeMatriculas.get(i).getCurso().getCodigo().equals(curso.getCodigo())
	 * ) { listaDeMatriculas.get(i).bajarNivel(); } } }
	 */
}
