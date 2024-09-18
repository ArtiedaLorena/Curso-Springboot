package springbootError.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import springbootError.exceptions.UserNotFoundException;
import springbootError.services.UserService;
import springbootError.models.domain.User;



@RestController
@RequestMapping("/api")
public class AppController {

    private final UserService userService;

    @Autowired
    public AppController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/app")
    public String index() {
        try {
            //int value = 100 / 0;  // Esto lanzará una excepción
            int value = Integer.parseInt("10x");
            return "ok 200";

        } catch (NumberFormatException e) {
            return ("Error: "+ e); // Imprime la traza del error

        }
    }
    // Método para buscar un usuario con manejo de excepciones
    @GetMapping("/show/{id}")
    public ResponseEntity<?> show(@PathVariable(name="id") Long id) {
        try {
            User user = userService.findById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);  // Retorna el usuario si se encuentra
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);  // Manejo de usuario no encontrado
        } catch (Exception e) {
            return new ResponseEntity<>("Error inesperado: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);  // Manejo de errores generales
        }
    }
}
