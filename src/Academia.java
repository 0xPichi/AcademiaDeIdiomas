import java.util.ArrayList;

public class Academia {

	
	public static void main(String[] args) {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
		
		Alumno bayons = new Alumno("Miguel", "Bayon", "132432255k");
		Curso sida = new Curso("Siduli", 3, 24, 32, 20, 234.0);
		matricular(bayons,sida, matriculas);
	}

	public static void matricular(Alumno alu, Curso curs, ArrayList<Matricula> matriculas) {
		if(curs.plazaDisponible(alu)) {
			matriculas.add(new Matricula(alu, curs));
			alu.matricular(matriculas.get(matriculas.size()));
		}
	}

	public static void subirCurso(Matricula matricula) {
		if (hayCursoSuperior(matricula.getCurso())) {
			matricular(matricula.getAlumno(), cursoSuperior(matricula.getCurso()));
		} else
			System.out.println("No hay un curso superior disponible");
	}
	public static Curso cursoSuperior(Curso cursoInferior) {
		for(int i = 0; i < cursos.size(); i++) {
			if (cursoInferior.getIdioma() == cursos.get(i).getIdioma()
					&& cursoInferior.getNivel() < cursos.get(i).getNivel() && cursos.get(i).getNivel() - cursoInferior.getNivel() == 1) {
				return cursos.get(i);
			}
		}
		return null;
	}
	public static boolean hayCursoSuperior(Curso cursoInferior) {
		for (int i = 0; i < cursos.size(); i++) {
			if (cursoInferior.getIdioma() == cursos.get(i).getIdioma()
					&& cursoInferior.getNivel() < cursos.get(i).getNivel()) {
				return true;
			}
		}
		return false;
	}
	public static void bajarCurso(Matricula matricula) {}
	public static Curso cursoInferior(Curso cursoSuperior){}
	public static boolean hayCursoInferior(Curso cursoSuperior){}
}
