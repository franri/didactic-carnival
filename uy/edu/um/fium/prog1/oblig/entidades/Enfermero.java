package uy.edu.um.fium.prog1.oblig.entidades;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class Enfermero extends Operativo{

    private String[] especialidades=new String[3];

		public Enfermero(String nombre, String ci, String fechaNacimientoSinParseo, String celular, String direccion,String email,String fechaEntradaSinParseo,String sueldoBase, int aux0, int aux1, int aux2){

			super(nombre, ci, fechaNacimientoSinParseo, celular, direccion, email, fechaEntradaSinParseo, sueldoBase);


			especialidades[0]=(aux0==1)?"Obstetra":null;
			especialidades[1]=(aux1==1)?"Geriatra":null;
			especialidades[2]=(aux2==1)?"Pediatra":null;

		}



}
