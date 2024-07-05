package thoaldo.forum_hub.forum.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thoaldo.forum_hub.forum.model.Topico;
import thoaldo.forum_hub.forum.service.TopicoService;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<Topico> createTopico(@RequestBody @Valid Topico topico) {
        Topico createdTopico = topicoService.createTopico(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTopico);
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listTopicos() {
        return ResponseEntity.ok(topicoService.listTopicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> getTopico(@PathVariable Long id) {
        return ResponseEntity.ok(topicoService.getTopico(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> updateTopico(@PathVariable Long id, @RequestBody @Valid Topico topico) {
        return ResponseEntity.ok(topicoService.updateTopico(id, topico));
    }
}

