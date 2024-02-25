package dio.springbootweb.model;


import javax.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )
    private int id;

    private String nome;
    private String email_celular;
    private String senha;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail_celular() {
        return email_celular;
    }

    public void setEmail_celular(String email_celular) {
        this.email_celular = email_celular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
