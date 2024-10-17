package com.DemoEmpleado.Repository;

import com.DemoEmpleado.Models.Empleado;
import com.DemoEmpleado.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Long> {


}
