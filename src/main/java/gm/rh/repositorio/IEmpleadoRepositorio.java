package gm.rh.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gm.rh.modelo.Empleado;

@Repository
public interface IEmpleadoRepositorio extends JpaRepository<Empleado, Integer>{

}
