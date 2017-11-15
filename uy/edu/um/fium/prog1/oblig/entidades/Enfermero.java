package uy.edu.um.fium.prog1.oblig.entidades;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Enfermero extends Empleado{


    private ArrayList<String> especialidades=new ArrayList<String>();

		public Enfermero(String nombre, String ci, LocalDate fechaNacimiento, String celular, String direccion,String email,LocalDate fechaEntrada,String sueldoBase, int aux0, int aux1, int aux2){

			super(nombre, ci, fechaNacimiento, celular, direccion, email, fechaEntrada, sueldoBase);


      if(aux0==1){
        especialidades.add("Obstetra");
      }

      if(aux1==1){
        especialidades.add("Geriatra");
      }

      if(aux2==1){
        especialidades.add("Pediatra");
      }

		}



}
