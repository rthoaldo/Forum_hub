package thoaldo.forum_hub.forum.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    private LocalDateTime dtcriacao = LocalDateTime.now();
    @ManyToOne
    private Topico topico;
    @ManyToOne
    private Usuario autor;
    private Boolean solucao = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDtcriacao() {
        return dtcriacao;
    }

    public void setDtcriacao(LocalDateTime dtcriacao) {
        this.dtcriacao = dtcriacao;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Boolean getSolucao() {
        return solucao;
    }

    public void setSolucao(Boolean solucao) {
        this.solucao = solucao;
    }
}
