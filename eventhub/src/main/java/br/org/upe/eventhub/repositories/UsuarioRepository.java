package br.org.upe.eventhub.repositories;

import br.org.upe.eventhub.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
    public Optional<Usuario> findByEmail(String email);
    public Optional<Usuario> findByCpf(String cpf);
    public Optional<Usuario> findByEmailAndSenha(String email, String senha);
    @Query("select u from Usuario u where (u.email =:login OR u.cpf =:login)" +
            "and u.senha = :senha")
    public Optional<Usuario> findByLoginAndSenha
            (@Param("login") String login, @Param("senha")String senha);
}
