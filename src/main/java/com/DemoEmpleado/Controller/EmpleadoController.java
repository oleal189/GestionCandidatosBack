package com.DemoEmpleado.Controller;


import com.DemoEmpleado.Models.Empleado;
import com.DemoEmpleado.Services.IEmpleadoRepositoryImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/empleado")
public class EmpleadoController {

    @Autowired
    private IEmpleadoRepositoryImpl empleadoRepo;



    @Operation(summary = "Obtener todos los empleados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de empleados obtenida con éxito",
                    content = {@Content(mediaType = "application/json",
                            schema = @
                                    Schema(implementation = Empleado.class))}),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    @GetMapping("/all")
    public Iterable<Empleado> mostrarEmpleados(){

        return empleadoRepo.getEmpleados();
    }

    @Operation(summary = "Obtener un empleado por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empleado obtenido con éxito",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Empleado.class))}),
            @ApiResponse(responseCode = "404", description = "Empleado no encontrado", content = @Content)
    })
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Empleado getEmpleadoByID( @PathVariable Long id){

           Empleado employeed = empleadoRepo.getEmpleadoById(id);
           if (employeed == null) {
               throw new UsernameNotFoundException("El Empleado solicitado no se encuentra registrado");
           }
        return employeed;
    }

    @Operation(summary = "Agregar un nuevo empleado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Empleado ingresado con éxito"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos proporcionados", content = @Content)
    })
    @PostMapping("/addEmpleado")
    public String addEmpleado(@RequestBody Empleado empleado){
        empleadoRepo.saveEmpleado(empleado);
        return "Empleado Ingresado";
    }
    @Operation(summary = "Actualizar un empleado existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empleado actualizado con éxito"),
            @ApiResponse(responseCode = "404", description = "Empleado no encontrado", content = @Content),
            @ApiResponse(responseCode = "400", description = "Datos inválidos proporcionados", content = @Content)
    })
    @PutMapping("/updateEmpleado/{id}")
    public String updateEmpleado(@RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Empleado con los datos actualizados",
            required = true,
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Empleado.class))
    ) Empleado empleado, @PathVariable Long id){
        empleadoRepo.saveEmpleado(empleado);
        return "Empleador Actualizado";
    }

    @Operation(summary = "Eliminar un empleado por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empleado eliminado con éxito"),
            @ApiResponse(responseCode = "404", description = "Empleado no encontrado", content = @Content)
    })
    @DeleteMapping("/deleteEmpleado/{id}")
    public String deleteEmpleado( @PathVariable Long id){
        Empleado employeed = new Empleado();
        employeed = empleadoRepo.getEmpleadoById(id);
        empleadoRepo.deleteEmpleado(employeed);
        return "Empleado Eliminado";
    }

}
