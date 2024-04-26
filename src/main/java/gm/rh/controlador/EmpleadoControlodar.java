package gm.rh.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gm.rh.excepcion.RecursoNoEncontradoExcepcion;
import gm.rh.modelo.Empleado;
import gm.rh.servicio.IEmpleadoServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("rh-app")
@CrossOrigin(value = "http://localhost:5173")
public class EmpleadoControlodar {

	private static final Logger logger = LoggerFactory.getLogger(EmpleadoControlodar.class);

	@Autowired
	private IEmpleadoServicio empleadoServicio;

	@GetMapping("/empleados")
	public List<Empleado> obtenerEmpleados() {
		var empleados = empleadoServicio.listarEmpleado();
		empleados.forEach(empleado -> logger.info(empleado.toString()));
		return empleados;
	}

	@PostMapping("/empleados")
	public Empleado agregarEmpleado(@RequestBody Empleado empleado) {
		logger.info("Empleado a agregar" + empleado);
		return empleadoServicio.guardarEmpleado(empleado);
	}

	@GetMapping("empleados/{id}")
	public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Integer id) {
		Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
		if (empleado == null)
			throw new RecursoNoEncontradoExcepcion("No se encontro el id: " + id);
		return ResponseEntity.ok(empleado);
	}

	@PutMapping("/empleados/{id}")
	public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id,
			@RequestBody Empleado empleadoRecibido) {
		Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
		if (empleado == null)
			throw new RecursoNoEncontradoExcepcion("El id recibido no existe:" + id);
		empleado.setNombre(empleadoRecibido.getNombre());
		empleado.setDepartamento(empleadoRecibido.getDepartamento());
		empleado.setSueldo(empleado.getSueldo());
		empleadoServicio.guardarEmpleado(empleado);
		return ResponseEntity.ok(empleado);

	}

	@DeleteMapping("/empleados/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarEmpleado(@PathVariable Integer id) {
		Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
		if (empleado == null)
			throw new RecursoNoEncontradoExcepcion("El id recibido no existe" + id);
		empleadoServicio.eliminarEmpleado(empleado);
		// Json
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminado", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
}
