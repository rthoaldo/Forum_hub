package thoaldo.forum_hub.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import thoaldo.forum_hub.forum.model.Usuario;
import thoaldo.forum_hub.forum.repository.UsuarioRepository;
import thoaldo.forum_hub.forum.security.JwtUtil;

@Service
public class AuthService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    public String login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        if (passwordEncoder.matches(senha, usuario.getSenha())) {
            return jwtUtil.generateToken(email);
        } else {
            throw new BadCredentialsException("Senha inválida");
        }
    }

    public Usuario register(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }
}

