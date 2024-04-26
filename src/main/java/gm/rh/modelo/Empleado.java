package gm.rh.modelo;

import org.hibernate.annotations.Collate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idEmpleado;


	String nombre;

	String departamento;

	Double sueldo;

	public Empleado(Integer idEmpleado, String nombre, String departamento, Double sueldo) {
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.departamento = departamento;
		this.sueldo = sueldo;
	}

	public Empleado() {

	}

}
