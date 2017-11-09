package uy.edu.um.fium.prog1.oblig.entidades;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class Operativo extends Empleado{


	public Operativo(String nombre, String ci, LocalDate fechaNacimiento, String celular, String direccion,String email,LocalDate fechaEntrada,String sueldoBase){

		super(nombre, ci, fechaNacimiento, celular, direccion, email, fechaEntrada, sueldoBase);
	}

}
