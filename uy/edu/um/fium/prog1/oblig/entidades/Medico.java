package uy.edu.um.fium.prog1.oblig.entidades;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class Medico extends Empleado{

  private String especialidad;
  private LocalDate fechaGraduado;

	public Medico(String nombre, String ci, LocalDate fechaNacimiento, String celular, String direccion,String email,LocalDate fechaEntrada,String sueldoBase,String especialidad,LocalDate fechaGraduado){

		super(nombre, ci, fechaNacimiento, celular, direccion, email, fechaEntrada, sueldoBase);

		this.especialidad=especialidad;

		this.fechaGraduado=fechaGraduado;
	}



}
