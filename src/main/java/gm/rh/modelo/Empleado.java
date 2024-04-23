package gm.rh.modelo;

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

	String nombreEmpleado;

	String departamento;

	Double sueldo;

	public Empleado(Integer idEmpleado, String nombreEmpleado, String departamento, Double sueldo) {
		this.idEmpleado = idEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.departamento = departamento;
		this.sueldo = sueldo;
	}

	public Empleado() {

	}

}
