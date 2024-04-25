package gm.rh.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gm.rh.modelo.Empleado;
import gm.rh.servicio.IEmpleadoServicio;

@RestController
@RequestMapping("rh-app")
@CrossOrigin(value = "http://localhost:3000")
public class EmpleadoControlodar {

	private static final Logger logger = LoggerFactory.getLogger(EmpleadoControlodar.class);

	@Autowired
	private IEmpleadoServicio empleadoServicio;
	
	
	@GetMapping("/empleados")
	public List<Empleado> obtenerEmpleados(){
		var empleados = empleadoServicio.listarEmpleado();
		empleados.forEach(empleado -> logger.info(empleado.toString()));
		return empleados;
	}
	

}