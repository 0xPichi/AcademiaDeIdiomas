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
public class Academia {


	public static void main(String[] args) {
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		ArrayList<Curso> listaCursos = new ArrayList<Curso>();
		ArrayList<Matricula> listaMatriculas = new ArrayList<>();
		
		//Creamos 3 cursos de Ingles con un nivel diferente y uno de Aleman y los agregamos a una lista.
		
		Curso ingles1 = new Curso("Ingles", 1, new GregorianCalendar(2015,11,25), new GregorianCalendar(2016,6,30), 10, 10, 25, null, null);
		Curso ingles2 = new Curso("Ingles", 2, new GregorianCalendar(2015,11,25), new GregorianCalendar(2016,6,30), 20, 12, 35, null, ingles1);
		Curso ingles3 = new Curso("Ingles", 3, new GregorianCalendar(2015,11,25), new GregorianCalendar(2016,6,30), 17, 2, 50, null, ingles2);
		ingles1.setSuperior(ingles2);
		ingles2.setSuperior(ingles3);
		ingles2.setInferior(ingles1);
		Curso aleman1 = new Curso("Aleman", 1, new GregorianCalendar(2015,11,25), new GregorianCalendar(2016,6,30), 12, 15, 30, null, null);
		listaCursos.add(ingles1);
		listaCursos.add(ingles2);
		listaCursos.add(ingles3);
		listaCursos.add(aleman1);
		
		//Imprimimos la lista de cursos con sus alumnos matriculados que en este momento sera ninguno.
		
		imprimeListaDeCursos(listaCursos);
		System.out.println("-------------------------------------------------");
		
		//Creamos 5 alumnos distintos y los añadimos a la lista de alumnos luego imprimimos la lista de alumnos 
		// y los cursos en los que estan matriculados los alumnos en este momento ninguno.
		
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
		
		//Comprobaremos que diferentes alumnos tienen plaza en diferentes cursos y los matricularemos.
		
		System.out.println("Matricular Miguel en Ingles 1 y Aleman 1");
		matricular(miguel, ingles1, listaMatriculas);
		matricular(miguel, aleman1, listaMatriculas);
		System.out.println();
		System.out.println("Matricular Sergio en Ingles 3 y Aleman 1");
		matricular(sergio, ingles3, listaMatriculas);
		System.out.println();
		System.out.println("Matricular Ivan en Ingles 3");
		matricular(ivan, ingles3, listaMatriculas);
		System.out.println();
		
		//Intentamos matricular a un alumno en un curso en el que ya esta matriculado
		
		System.out.println("Matricular alumno en un curso en el que ya esta matriculado");
		matricular(miguel, ingles1, listaMatriculas);
		System.out.println();
		
		//Intentamos matricular un alumno en un curso con el numero maximo de alumnos completo
		
		System.out.println("Matricular un alumno en un curso con todas las plazas ocupadas");
		matricular(miguel,ingles3,listaMatriculas);
		System.out.println();
		System.out.println("----------------------------------------------------");
		System.out.println("Lista de cursos y alumnos que estan matriculados: \n");
		imprimeListaDeCursos(listaCursos);
		System.out.println();
		System.out.println("----------------------------------------------------");
		System.out.println("Lista de alumnos y cursos en los que estan matriculados: \n");
		imprimeListaDeAlumnos(listaAlumnos);
		System.out.println();
		System.out.println("----------------------------------------------------");

		
		//Marcamos como pagadas las matriculas del alumno Miguel
		
		for(int i = 0; i < miguel.getListaDeMatriculas().size(); i++) {
			pagarMatricula(miguel.getListaDeMatriculas().get(i));
		}
		System.out.println("Lista de alumnos");
		imprimeListaDeAlumnos(listaAlumnos);
		System.out.println("----------------------------------------------------");
		System.out.println("Lista de Cursos que tienen matriculas sin pagar");
		imprimeCursosSinPagar(listaCursos);
		
		//Cambiaremos al alumno Miguel de curso subiendolo al curso ingles2
		
		System.out.println("----------------------------------------------------");
		System.out.println("Cambiamos de curso al alumno Miguel a ingles 2");
		subirNivelCurso(listaMatriculas, miguel, ingles1);
		System.out.println("Imprimimos los cursos del alumno Miguel tras el cambio Ingles1 -> Ingles2");
		imprimeCursosDeAlumno(miguel);
		
		//Revertimos el cambio ahora bajando un nivel
		
		System.out.println("----------------------------------------------------");
		bajarNivelCurso(listaMatriculas, miguel, ingles2);
		System.out.println("Imprimimos los cursos del alumno Miguel tras el cambio Ingles2 -> Ingles1");
		imprimeCursosDeAlumno(miguel);
		System.out.println("Imprimimos la lista de los alumnos incritos en Ingles 1 y en Ingles 2");
		imprimeAlumnosDeCurso(ingles1);
		System.out.println("Ingles 2: ");
		imprimeAlumnosDeCurso(ingles2);

	}
	public static void imprimeListaDeCursos(ArrayList<Curso> listaDeCursos) {
		for(int i = 0; i < listaDeCursos.size(); i++) {
			System.out.println(listaDeCursos.get(i).toString() + " ");
			System.out.println("Alumnos matriculados: \n");
			imprimeAlumnosDeCurso(listaDeCursos.get(i));
		}
	}
	public static void imprimeListaDeAlumnos(ArrayList<Alumno> listaDeAlumnos) {
		for(int i = 0; i < listaDeAlumnos.size(); i++) {
			System.out.print(listaDeAlumnos.get(i).toString() + " ");
			System.out.println("\nMatriculado en: ");
			imprimeCursosDeAlumno(listaDeAlumnos.get(i));
			System.out.println("La deuda total del alumno es: " + listaDeAlumnos.get(i).calculaDeuda() + "\n");
		}
		
	}
	public static void imprimeAlumnosDeCurso(Curso curso) {
		for(int i = 0; i < curso.getListaAlumnos().size(); i++) {
			System.out.println(curso.getListaAlumnos().get(i).toString());
		}
	}
	public static void imprimeCursosDeAlumno(Alumno alumno) {
		for(int i = 0; i < alumno.getListaDeCursos().size(); i++) {
			System.out.println(alumno.getListaDeCursos().get(i).toString());
		}
	}
	public static boolean plazaDisponible(Alumno alumno, Curso curso) {
		if(curso.plazaDisponible(alumno)) {
			System.out.println("¡Hay plazas disponibles!, el alumno puede matricularse");
			return true;
		} else {
			System.out.println("¡No hay plazas disponibles!");
			return false;
		}
	}	
	public static void matricular(Alumno alumno, Curso curso, ArrayList<Matricula> listaDeMatricula) {
		if(plazaDisponible(alumno,curso)) {
			listaDeMatricula.add(curso.matricular(alumno));
		}
	}
	public static void pagarMatricula(Matricula matricula) {
		matricula.pagar();
	}
	public static void imprimeCursosSinPagar(ArrayList<Curso> listaDeCursos) {
		for(int i = 0; i < listaDeCursos.size(); i++) {
			if(listaDeCursos.get(i).getMatriculasSinPago().size() != 0) {
				System.out.println(listaDeCursos.get(i).toString());
			}
		}
	}
	public static void subirNivelCurso(ArrayList<Matricula> listaDeMatriculas, Alumno alumno, Curso curso) {
		for(int i = 0; i < listaDeMatriculas.size(); i++) {
			if(listaDeMatriculas.get(i).getAlumno().equals(alumno)
					&& listaDeMatriculas.get(i).getCurso().getCodigo().equals(curso.getCodigo())) {
				listaDeMatriculas.get(i).subirNivel();
			}
		}
	}
	public static void bajarNivelCurso(ArrayList<Matricula> listaDeMatriculas, Alumno alumno, Curso curso) {
		for(int i = 0; i < listaDeMatriculas.size(); i++) {
			if(listaDeMatriculas.get(i).getAlumno().equals(alumno)
					&& listaDeMatriculas.get(i).getCurso().getCodigo().equals(curso.getCodigo())) {
				listaDeMatriculas.get(i).bajarNivel();
			}
		}
	}
}