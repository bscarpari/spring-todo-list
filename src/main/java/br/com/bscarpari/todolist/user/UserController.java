package br.com.bscarpari.todolist.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity<List<UserModel>> findAll() {
        List<UserModel> usersList = userRepository.findAll();

        if (usersList.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(usersList);

        return ResponseEntity.ok(usersList);
    }

    @PostMapping("/")
    public ResponseEntity createAUser(@RequestBody UserModel userModel) {
        UserModel user = userRepository.findByUsername(userModel.getUsername());

        if (user != null)
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário já existe");

        var userCreated = userRepository.save(userModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}