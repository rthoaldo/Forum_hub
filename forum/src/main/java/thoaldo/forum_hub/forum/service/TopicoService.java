package thoaldo.forum_hub.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import thoaldo.forum_hub.forum.model.Topico;
import thoaldo.forum_hub.forum.repository.TopicoRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    public Topico createTopico(Topico topico) {
        if (topicoRepository.existsByTituloAndMensagem(topico.getTitulo(), topico.getMensagem())) {
            throw new IllegalArgumentException("Tópico duplicado");
        }
        return topicoRepository.save(topico);
    }

    public List<Topico> listTopicos() {
        return topicoRepository.findAll(Sort.by("dtcriacao").ascending());
    }

    public Topico getTopico(Long id) {
        return topicoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Tópico não encontrado"));
    }

    public Topico updateTopico(Long id, Topico updatedTopico) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Tópico não encontrado"));
        topico.setTitulo(updatedTopico.getTitulo());
        topico.setMensagem(updatedTopico.getMensagem());
        topico.setStatus(updatedTopico.getStatus());
        return topicoRepository.save(topico);
    }
}

