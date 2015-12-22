import java.util.ArrayList;
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

		// Creamos varios varios cursos de cada tipo: tres cursos normales y
		// tres junior, y los agregamos a la lista
		System.out.println("Creando cursos normales y cursos junior...");

		CursoNormal ingles1 = new CursoNormal("Ingles", 1, new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 10, 10, 25, null, null);
		CursoNormal ingles2 = new CursoNormal("Ingles", 2, new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 20, 12, 35, null, ingles1);
		CursoNormal ingles3 = new CursoNormal("Ingles", 3, new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 17, 2, 50, null, ingles2);
		ingles1.setCursoSuperior(ingles2);
		ingles2.setCursoSuperior(ingles3);
		ingles2.setCursoInferior(ingles1);

		CursoJunior aleman = new CursoJunior("Aleman", new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 10, 5, 50, 10, 16);
		CursoJunior chino = new CursoJunior("Aleman", new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 10, 5, 50, 10, 16);
		CursoJunior frances = new CursoJunior("Aleman", new GregorianCalendar(2015, 11, 25),
				new GregorianCalendar(2016, 6, 30), 10, 5, 50, 10, 16);

		// Los añadimos a una lista de cursos

		listaCursos.add((Curso) ingles1);
		listaCursos.add((Curso) ingles2);
		listaCursos.add((Curso) ingles3);
		listaCursos.add((Curso) aleman);
		listaCursos.add((Curso) chino);
		listaCursos.add((Curso) frances);

		// Imprimimos la lista de cursos con sus alumnos matriculados, que en
		// este momento sera ninguno.

		imprimeListaDeCursos(listaCursos);
		System.out.println("-------------------------------------------------");

		// Creamos 5 alumnos distintos y los añadimos a la lista de alumnos
		// luego imprimimos la lista de alumnos
		// y los cursos en los que estan matriculados los alumnos en este
		// momento ninguno.

		Alumno sergio = new Alumno("Sergio", "Delgado Álvarez", "12427851P");
		Alumno miguel = new Alumno("Miguel", "Bayón Sanz", "12457637H");
		Alumno daniel = new Alumno("Daniel", "Paredes Santamaria", "7115725G");
		Alumno ivan = new Alumno("Iván", "Castaño Fernandez", "12435352K");
		Alumno cristina = new Alumno("Cristina", "Blanco Rodriguez", "12435678U");
		listaAlumnos.add(sergio);
		listaAlumnos.add(miguel);
		listaAlumnos.add(daniel);
		listaAlumnos.add(cristina);
		listaAlumnos.add(ivan);
		imprimeListaDeAlumnos(listaAlumnos);
		System.out.println("--------------------------------------------------");

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
