package thoaldo.forum_hub.forum.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import thoaldo.forum_hub.forum.model.Usuario;
import thoaldo.forum_hub.forum.repository.UsuarioRepository;
import thoaldo.forum_hub.forum.security.JwtUtil;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email já está em uso");
        }
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuário registrado com sucesso");
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody Usuario loginRequest) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(loginRequest.getEmail());
        if (optionalUsuario.isPresent() && passwordEncoder.matches(loginRequest.getSenha(), optionalUsuario.get().getSenha())) {
            String token = jwtUtil.generateToken(loginRequest.getEmail());
            return ResponseEntity.ok("Bearer " + token);
        }
        return ResponseEntity.badRequest().body("Credenciais inválidas");
    }
}
