package dio.springbootweb.controller;

import dio.springbootweb.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/verificarEmail")
    public String VerifyEmail(@RequestParam String email){

        // Verificar se o e-mail já está cadastrado no banco de dados

        String sql = "SELECT COUNT(*) FROM cliente WHERE email_celular = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, email);


        if (count > 0) {
            return "E-mail já cadastrado";
        } else {
            return "E-mail não cadastrado";
        }

    }
}
