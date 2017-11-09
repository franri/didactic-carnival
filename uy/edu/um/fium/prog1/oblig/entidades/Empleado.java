package uy.edu.um.fium.prog1.oblig.entidades;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.math.RoundingMode;

public abstract class Empleado{

  protected String nombre;
  protected String ci;
  protected LocalDate fechaNacimiento;
	protected String celular;
	protected String direccion;
	protected String email;
  protected LocalDate fechaEntrada;
  protected BigDecimal sueldoBase;


	public Empleado(String nombre, String ci, LocalDate fechaNacimiento, String celular, String direccion,String email,LocalDate fechaEntrada,String sueldoBase){

		this.nombre=nombre;
		this.ci=ci;
		this.celular=celular;
		this.direccion=direccion;
		this.email=email;
		this.sueldoBase= new BigDecimal(sueldoBase);
		this.sueldoBase=this.sueldoBase.setScale(2, RoundingMode.HALF_UP); //Big.Decimal.setScale  RoundingMode


		this.fechaNacimiento=fechaNacimiento;
		this.fechaEntrada=fechaEntrada;
	}

	public double calcularPorcentajeAdicional(LocalDate ahora){

		Period tiempoEnCasmu=Period.between(fechaEntrada, ahora);

		int aniosTotales=tiempoEnCasmu.getYears();

		int cardinalIncrementosDeSueldo= aniosTotales/2; //xej, si tengo 7 años, tengo 3 incrementos, no joroba el truncado de la división. AVANTI

		return cardinalIncrementosDeSueldo*1.5;

	}

	public BigDecimal getSueldoActual(LocalDate ahora){
		double incrementoActual=calcularPorcentajeAdicional(ahora);
		double porcentajeActual=100+incrementoActual;
		BigDecimal aux=BigDecimal.valueOf(porcentajeActual/100);
		BigDecimal sueldoActual=sueldoBase.multiply(aux);
		return sueldoActual;
	}



	public String getNombre(){
		return nombre;
	}
	public String getCedula(){
		return ci;
	}
	public String getCelular(){
		return celular;
	}
	public String getDireccion(){
		return direccion;
	}
	public String getEmail(){
		return email;
	}
	public LocalDate getFechaNacimiento(){
		return fechaNacimiento;
	}
	public BigDecimal getSueldoBase(){
		return sueldoBase;
	}




}
