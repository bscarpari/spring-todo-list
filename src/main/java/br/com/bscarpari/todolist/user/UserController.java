package br.com.bscarpari.todolist.user;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        List<UserModel> usersList = this.userRepository.findAll();

        if (usersList.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(usersList);

        return ResponseEntity.ok(usersList);
    }

    @GetMapping("/{userId}")
    public ResponseEntity findById(@PathVariable UUID userId) {
        var user = this.userRepository.findById((UUID) userId);

        if (user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/")
    public ResponseEntity createAUser(@RequestBody UserModel userModel) {
        UserModel user = this.userRepository.findByUsername(userModel.getUsername());

        if (user != null)
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário já existe");

        var userCreated = userRepository.save(userModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}