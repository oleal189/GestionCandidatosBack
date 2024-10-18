# GestionCandidatosBack
Gestion de candidatos a nivel de backend

Pasos para levantar la aplicacion

1. crear base de datos en MySql nombre "candidatosdb"
2. actualizar las credenciales en el archivo properties en los campos
   spring.datasource.username=xxxxxx
   spring.datasource.password=xxxxxxx
3. levantar el aplicativo con el id intellij
4. Abrir postman u otro aplicativo que permita consumir apis
5. importar la curl para obtener el token de seguridad

   curl --location 'http://localhost:8081/login' \
        --header 'Content-Type: application/json' \
        --data-raw '{
               "email":"leal198745@gmail.com",
               "password":"18476189"
         }'
6. importar curls para gestionar los candidatos
   - Agregar Candidato:

     curl --location 'http://localhost:8081/empleado/addEmpleado' \
     --header 'Content-Type: application/json' \
     --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsZWFsMTk4NzQ1QGdtYWlsLmNvbSIsImV4cCI6MTcyOTI3MzcwNiwidXN1YXJpbyI6Ik9zY2FyIn0.E5TEilr6QsCoqbdlq9P1E7NrudPjmFEVY3cMAPRhHA8' \
     --data-raw '{
     "nombres":"Jorge",
     "apellidos":"Leal ",
     "estadoCivil":"Soltero",
     "fechaNacimiento":"1987-08-09",
     "genero":"Masculino",
     "salario":5800.00,
     "moneda":"PEN",
     "email":"leal20195@gmail.com",
     "direccion":"Bolivar, Bolivar, Colombia"
     }'
   
   - Consulta todos:
   
     curl --location 'http://localhost:8081/empleado/all' \
     --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsZWFsMTk4NzQ1QGdtYWlsLmNvbSIsImV4cCI6MTcyOTI3MTk5MCwidXN1YXJpbyI6Ik9zY2FyIn0.-Sdjj5U2RmijpRuwbTszcOShfXAzydCqVYVrBeyFoOw' \
     --data ''
   - Consulta individual:

     curl --location 'http://localhost:8081/empleado/4' \
     --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsZWFsMTk4NzQ1QGdtYWlsLmNvbSIsImV4cCI6MTcyOTI3MzM5MywidXN1YXJpbyI6Ik9zY2FyIn0.M5XOpO-NpqRbQWRyUB0L440joC6dIKHztKrtk_hyQVc' \
     --data ''
   - Actualizacion individual:

     curl --location --request PUT 'http://localhost:8081/empleado/updateEmpleado/4' \
     --header 'Content-Type: application/json' \
     --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsZWFsMTk4NzQ1QGdtYWlsLmNvbSIsImV4cCI6MTcyOTI3MzUwNCwidXN1YXJpbyI6Ik9zY2FyIn0.qq5NsNEaUORlgMiT7vMiNIsq-0LQ_3yTBgQXyrqc2Ns' \
     --data-raw '{
     "id": 4,
     "nombres": "emilio",
     "apellidos": "Tiquillahuanca",
     "estadoCivil": "casado",
     "fechaNacimiento": "1984-04-15T05:00:00.000+00:00",
     "genero": "masculino",
     "salario": 2500.0,
     "moneda": "S",
     "email": "tiquillahuanca@gmail.com",
     "direccion": "callao"
     }'
   
   - Eliminacion individual:

     curl --location --request DELETE 'http://localhost:8081/empleado/deleteEmpleado/4' \
          --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsZWFsMTk4NzQ1QGdtYWlsLmNvbSIsImV4cCI6MTcyOTI3MzU5MywidXN1YXJpbyI6Ik9zY2FyIn0.lsi1QCiXxU0CSwD7pUQ_0OmAaXYai0NQ-hbaxYU1LbQ' \
          --data ''


Documentacion con swagger 
url: http://localhost:8081/swagger-ui/index.html
usuario: leal198745@gamil.com
clave: 18476189

![img.png](img.png)