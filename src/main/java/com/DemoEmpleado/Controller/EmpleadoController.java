package com.DemoEmpleado.Controller;


import com.DemoEmpleado.Models.Empleado;
import com.DemoEmpleado.Repository.IEmpleadoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/empleado")
public class EmpleadoController {

    @Autowired
    private IEmpleadoRepositoryImpl empleadoRepo;




    @GetMapping("/all")
    public Iterable<Empleado> mostrarEmpleados(){

        return empleadoRepo.getEmpleados();
    }
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Empleado getEmpleadoByID( @PathVariable Long id){

           Empleado employeed = empleadoRepo.getEmpleadoById(id);
           if (employeed == null) {
               throw new UsernameNotFoundException("El Empleado solicitado no se encuentra registrado");
           }
        return employeed;
    }


    @PostMapping("/addEmpleado")
    public String addEmpleado(@RequestBody Empleado empleado){
        empleadoRepo.saveEmpleado(empleado);
        return "Empleado Ingresado";
    }

    @PutMapping("/updateEmpleado/{id}")
    public String updateEmpleado(@RequestBody Empleado empleado, @PathVariable Long id){
        empleadoRepo.saveEmpleado(empleado);
        return "Empleador Actualizado";
    }

    @DeleteMapping("/deleteEmpleado/{id}")
    public String deleteEmpleado( @PathVariable Long id){
        Empleado employeed = new Empleado();
        employeed = empleadoRepo.getEmpleadoById(id);
        empleadoRepo.deleteEmpleado(employeed);
        return "Empleado Eliminado";
    }

}
