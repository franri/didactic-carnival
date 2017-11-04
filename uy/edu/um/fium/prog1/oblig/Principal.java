package uy.edu.um.fium.prog1.oblig;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import uy.edu.um.fium.prog1.oblig.entidades.*;

public class Principal{

	public static ArrayList<Empleado> listaEmpleados=new ArrayList<Empleado>();

	public static LocalDate diaActual;

	/*
	ArrayList<Operativo> static listaOperativos= new ArrayList<Operativo>();
	ArrayList<Medico> static listaMedicos= new ArrayList<Medico>();
	ArrayList<Enfermero> static listaEnfermeros= new ArrayList<Enfermero>();
	*/

  public static void main(String[] args){

		diaActual=LocalDate.now();

		DateTimeFormatter formatoUruguayo= DateTimeFormatter.ofPattern("dd/MM/yyyy");

		String diaActualSinParseo=diaActual.format(formatoUruguayo);

		Scanner keyboard= new Scanner(System.in);

	  System.out.println("BASE DE DATOS DE EMPLEADOS CASMU\n\nFecha:"+diaActualSinParseo+"\nActividades que puede realizar:\n\n1.\tRegistar nuevo empleado.\n2.\tBuscar operativo por cédula.\n3.\tEnviar saludo a operativos que cumplan años el día deseado.\n4.\tObtener presupuesto de área deseada.");


		while(true){

		/*
			boolean lala=false;
			if(lala){
				System.out.println("¿Qué quiere hacer ahora?");
			}
			lala=true;
		*/ //porque no funca esto? la idea era que fuera para imprimir que queres hacer para saber que termino de hacer la actividad anterior
			int temp=	keyboard.nextInt();

			switch(temp){
				case 1:
					comenzarAgrego();
				break;
				case 2:
					System.out.println("Ingrese cédula");
					String tempCi= keyboard.next();
					buscarOperativo(tempCi);
				break;
				case 3:
					/*System.out.println("Ingrese fecha (dd/mm/aaaa)  //en año, ingrese cualquiera//");
					String tempFechaSinParseo= keyboard.nextLine();*/
					listarFC(/*tempFechaSinParseo*/);
				break;
				case 4:
					obtenerPresupuesto(diaActual);
				break;
				default:
					System.out.println("Su opción es válida. Por favor reintente.");
				break;
			}
		}
  }

	public static void comenzarAgrego(){

		System.out.println("Para agregar un médico, ingrese 1.\nPara agregar un enfermero, ingrese 2.\nDe lo contrario, ingrese 0.");

		Scanner keyboard= new Scanner(System.in);
		int seleccionarModo= keyboard.nextInt();

		switch(seleccionarModo){
			case 0:
				agregarEmpleado(0);
				System.out.println("¿Qué quiere hacer ahora?");
			break;
			case 1:
				agregarEmpleado(1);
				System.out.println("¿Qué quiere hacer ahora?");
			break;
			case 2:
				agregarEmpleado(2);
				System.out.println("¿Qué quiere hacer ahora?");
			break;
		}

		//keyboard.close();

	}

	public static void agregarEmpleado(int modo){

		Scanner keyboard= new Scanner(System.in);

		System.out.println("Ingrese nombre completo:");
		String nombre=keyboard.nextLine();
		System.out.println("Ingrese cédula sin guión:");
		String ci=keyboard.nextLine();
		System.out.println("Ingrese fecha de nacimiento (dd/mm/aaaa):");
		String fechaNacimientoSinParseo=keyboard.nextLine();
		System.out.println("Ingrese celular:");
		String celular=keyboard.nextLine();
		System.out.println("Ingrese direccion:");
		String direccion=keyboard.nextLine();
		System.out.println("Ingrese email:");
		String email=keyboard.nextLine();
		System.out.println("Ingrese fecha de entrada (dd/mm/aaaa):");
		String fechaEntradaSinParseo=keyboard.nextLine();
		System.out.println("Ingrese sueldo base:");
		String sueldoBase=keyboard.nextLine();
		System.out.println("");//porque si no pongo esta impresion se me queda en enter infinito
		//keyboard.close();

		switch(modo){
			case 0:
				Empleado oOpTemp= new Operativo(nombre, ci, fechaNacimientoSinParseo, celular, direccion, email, fechaEntradaSinParseo, sueldoBase);

				listaEmpleados.add(oOpTemp);
				//listaOperativos.add(oOpTemp);
			break;

			case 1:
			boolean aux=false;
			String especialidad;
			do{
				System.out.println("Ingrese especialidad:");
				especialidad=keyboard.nextLine();
				if(especialidad.equals("Pediatria")||especialidad.equals("Cardiologia")||especialidad.equals("Ginecologia")||especialidad.equals("Clinica")||especialidad.equals("Cirugia")||especialidad.equals("Anestesiologia")||especialidad.equals("Gastroenterologia")||especialidad.equals("Neurologia")){
					aux=true;
				}
				else{
					System.out.println("Esa especialidad no existe. Intente nuevamente.");
				}
			}while(!aux);
				System.out.println("Ingrese fecha de graduado:");
				String fechaGraduadoSinParseo=keyboard.nextLine();
				System.out.println("");

				Empleado oMedTemp= new Medico(nombre, ci, fechaNacimientoSinParseo, celular, direccion, email, fechaEntradaSinParseo, sueldoBase, especialidad, fechaGraduadoSinParseo);

				listaEmpleados.add(oMedTemp);
				//listaMedicos.add(oMedTemp);
			break;

			case 2:
				System.out.println("¿Es obstetra? (y/n)");
				String auxScan=keyboard.nextLine();
				int aux0=(auxScan.equals("y"))?1:0;
				System.out.println("¿Es geriatra? (y/n)");
				auxScan=keyboard.nextLine();
				int aux1=(auxScan.equals("y"))?1:0;
				System.out.println("¿Es pediatra? (y/n)");
				auxScan=keyboard.nextLine();
				int aux2=(auxScan.equals("y"))?1:0;
				System.out.println("");

				Empleado oEnfTemp= new Enfermero(nombre, ci, fechaNacimientoSinParseo, celular, direccion, email, fechaEntradaSinParseo, sueldoBase, aux0, aux1, aux2);

				listaEmpleados.add(oEnfTemp);
				//listaEnfermeros.add(oEnfTemp);
			break;



		}

	}

	public static void buscarOperativo(String cedula){

		boolean hayConMismaCedula=false;

		for(int i=0; i<listaEmpleados.size(); i++){
			if(listaEmpleados.get(i).getCedula().equals(cedula)){
				hayConMismaCedula=true;
				Empleado temp=listaEmpleados.get(i);
				System.out.println("\nDatos del empleado "+temp.getNombre()+":\n"+"Celular:\t"+temp.getCelular()+"\nDirección:\t"+temp.getDireccion()+"\nEmail:\t"+temp.getEmail());
			}
			if(!hayConMismaCedula){
				System.out.println("No hay ningún empleado con ese número de cédula.");
			}
		}
		System.out.println("¿Qué quiere hacer ahora?");

	}

	public static void listarFC(/*String /*tempFechaSinParseo*/){
		Scanner keyboard=new Scanner(System.in);
		System.out.println("Ingrese fecha (dd/mm/aaaa)  //en año, ingrese cualquiera//");
		String tempFechaSinParseo= keyboard.nextLine();

		DateTimeFormatter formatoUruguayo= DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate tempFecha=LocalDate.parse(tempFechaSinParseo,formatoUruguayo);

		int tempDia=tempFecha.getDayOfMonth();
		int tempMes=tempFecha.getMonthValue();

		ArrayList<Empleado> tempArrayDeFC = new ArrayList<Empleado>();

		for(int i=0; i<listaEmpleados.size(); i++){

			Empleado tempEmpleado=listaEmpleados.get(i);
			LocalDate tempEmpFechaNac=tempEmpleado.getFechaNacimiento();
			int tempEmpDia=tempEmpFechaNac.getDayOfMonth();
			int tempOpMes=tempEmpFechaNac.getMonthValue();

			if(tempDia==tempEmpDia && tempMes==tempEmpDia){
				tempArrayDeFC.add(tempEmpleado);
			}
		}

		if(tempArrayDeFC.size()==0){
			System.out.println("Ningún empleado cumple años el día"+tempFechaSinParseo);
		}
		else{
			System.out.println("Lista de empleados que cumplen años el día "+tempFechaSinParseo+":\n");
			for(int i=0; i<tempArrayDeFC.size(); i++){
				System.out.println(i+".\t"+tempArrayDeFC.get(i).getNombre()+".");
			}
		}

		System.out.println("¿Qué quiere hacer ahora?");
	}

	public static void obtenerPresupuesto(LocalDate ahora){

		//Proceso primero Médicos
		BigDecimal totalMedicos= new BigDecimal(0);
		for(int i=0; i<listaEmpleados.size(); i++){
			Empleado temp=listaEmpleados.get(i);
			if(temp instanceof Medico){
				totalMedicos=totalMedicos.add(temp.getSueldoActual(ahora));
			}
		}
		System.out.println("Total de presupuesto de los médicos: "+totalMedicos);

		//ahora enfermeros
		BigDecimal totalEnfermeros= new BigDecimal(0);
		for(int i=0; i<listaEmpleados.size(); i++){
			Empleado temp2=listaEmpleados.get(i);
			if(temp2 instanceof Enfermero){
				totalEnfermeros=totalEnfermeros.add(temp2.getSueldoActual(ahora));
			}
		}
		System.out.println("Total de presupuesto de los enfermeros: "+totalEnfermeros);

		//ahora operativos
		BigDecimal totalOperativos= new BigDecimal(0);
		for(int i=0; i<listaEmpleados.size(); i++){
			Empleado temp3=listaEmpleados.get(i);
			if(temp3 instanceof Operativo){
				totalOperativos=totalOperativos.add(temp3.getSueldoActual(ahora));
			}
		}
		System.out.println("Total de presupuesto de los operativos: "+totalOperativos);
		BigDecimal totalTotalEh= totalOperativos.add(totalEnfermeros.add(totalMedicos));
		System.out.println("Total de presupuesto: "+totalTotalEh);
		System.out.println("¿Qué quiere hacer ahora?");
	}
}
