package thoaldo.forum_hub.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thoaldo.forum_hub.forum.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}

