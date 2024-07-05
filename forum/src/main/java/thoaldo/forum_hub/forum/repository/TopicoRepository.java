package thoaldo.forum_hub.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thoaldo.forum_hub.forum.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensagem(String titulo, String mensagem);
}