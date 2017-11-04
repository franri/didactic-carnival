package uy.edu.um.fium.prog1.oblig.entidades;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class Operativo extends Empleado{


	public Operativo(String nombre, String ci, String fechaNacimientoSinParseo, String celular, String direccion,String email,String fechaEntradaSinParseo,String sueldoBase){

		super(nombre, ci, fechaNacimientoSinParseo, celular, direccion, email, fechaEntradaSinParseo, sueldoBase);
	}

}
