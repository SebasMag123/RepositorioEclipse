package com.miescuela.sistema;

import com.miescuela.alumno.*;
public class Sistema {

	public static void main(String[] args) {
		Alumno miAlumno = new Alumno();
		miAlumno.dblPromedio_Alumno=9.9;
		miAlumno.strNombre_Alumno="Pedro";
		System.out.print(miAlumno.strNombre_Alumno);
		System.out.print("\n");
		System.out.print("El promedio es de:");
		miAlumno.DevolverPromedio();
	}

}
