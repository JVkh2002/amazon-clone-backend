package dio.springbootweb.controller;

import dio.springbootweb.model.Cliente;
import dio.springbootweb.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/registrar")
    public String handleSubmit(@RequestParam String nome, @RequestParam String emailOuCelular,
                               @RequestParam String senha, @RequestParam String confirmar_senha) {

        if(senha.equals(confirmar_senha)) {
            Cliente cliente = new Cliente();
            cliente.setNome(nome);
            cliente.setEmail_celular(emailOuCelular);
            cliente.setSenha(senha);
            clienteRepository.save(cliente);
        }

        else {
            System.out.println("senhas diferentes");
        }


        // Faça o que for necessário com os dados recebidos
        System.out.println("Nome: " + nome);
        System.out.println("Email ou celular: " + emailOuCelular);
        System.out.println("Senha: " + senha);

        // Retorne a página de confirmação ou redirecione para outra página
        return "redirect:http://localhost:3000/register";


    }
}