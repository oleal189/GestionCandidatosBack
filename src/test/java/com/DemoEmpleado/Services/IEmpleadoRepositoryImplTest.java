package com.DemoEmpleado.Services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.DemoEmpleado.Models.Empleado;
import com.DemoEmpleado.Repository.IEmpleadoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class IEmpleadoRepositoryImplTest {

    @Mock
    private IEmpleadoRepository empleadoRepository;

    @InjectMocks
    private IEmpleadoRepositoryImpl empleadoService;

    private Empleado empleado;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        empleado = new Empleado();
        empleado.setId(1L);
        empleado.setNombres("Juan");
        empleado.setEmail("juan@example.com");
    }

    // Probando para getEmpleados
    @Test
    public void testGetEmpleados() {
        // Se realiza el mock del resultado del repositorio
        when(empleadoRepository.findAll()).thenReturn(List.of(empleado));

        // Se invoca al método del servicio
        Iterable<Empleado> empleados = empleadoService.getEmpleados();

        // se realiza la Verificacion del método del repositorio empleadoRepository
        verify(empleadoRepository, times(1)).findAll();

        // Verificar el resultado
        assertNotNull(empleados);
        assertEquals(1, ((List<Empleado>) empleados).size());
        assertEquals(empleado.getNombres(), ((List<Empleado>) empleados).get(0).getNombres());
    }

    // se realiza prueba para getEmpleadoById
    @Test
    public void testGetEmpleadoById() {
        // se realiza Mockeo del resultado del repositorio
        when(empleadoRepository.findById(1L)).thenReturn(Optional.of(empleado));

        // Llamar al método del servicio
        Empleado result = empleadoService.getEmpleadoById(1L);

        // se realiza verificacion del método del repositorio fue findById
        verify(empleadoRepository, times(1)).findById(1L);

        // Verificar el resultado
        assertNotNull(result);
        assertEquals(empleado.getNombres(), result.getNombres());
    }

    // Prueba para Registro de candidato
    @Test
    public void testSaveEmpleado() {
        // Llamar al método del servicio
        empleadoService.saveEmpleado(empleado);

        // Verificar que el método del repositorio fue llamado
        verify(empleadoRepository, times(1)).save(empleado);
    }

    // Prueba para Eliminacion de candidato
    @Test
    public void testDeleteEmpleado() {
        // Llamar al método del servicio
        Boolean result = empleadoService.deleteEmpleado(empleado);

        // Verificar que el método del repositorio fue llamado
        verify(empleadoRepository, times(1)).delete(empleado);

        // Verificar el resultado
        assertTrue(result);
    }
}