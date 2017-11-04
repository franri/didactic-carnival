package uy.edu.um.fium.prog1.oblig.entidades;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class Medico extends Operativo{

  private String especialidad;
  private LocalDate fechaGraduado;
	private LocalDate fechaGraduadoSinParseo;

	public Medico(String nombre, String ci, String fechaNacimientoSinParseo, String celular, String direccion,String email,String fechaEntradaSinParseo,String sueldoBase,String especialidad,String fechaGraduadoSinParseo){

		super(nombre, ci, fechaNacimientoSinParseo, celular, direccion, email, fechaEntradaSinParseo, sueldoBase);

		this.especialidad=especialidad;

		DateTimeFormatter formatoUruguayo= DateTimeFormatter.ofPattern("dd/MM/yyyy");

		fechaGraduado=LocalDate.parse(fechaGraduadoSinParseo,formatoUruguayo);
	}



}
