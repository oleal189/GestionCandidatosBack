package com.DemoEmpleado.Services;

import com.DemoEmpleado.Models.Empleado;
import com.DemoEmpleado.Repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class IEmpleadoRepositoryImpl {

    @Autowired
    IEmpleadoRepository empleadoRepository;

    public Iterable<Empleado> getEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado getEmpleadoById(Long id) {

        return empleadoRepository.findById(id).get();
    }

    public void saveEmpleado(Empleado p) {
        empleadoRepository.save(p);
    }

    public Boolean deleteEmpleado(Empleado p) {
        empleadoRepository.delete(p);
        return true;
    }
}
