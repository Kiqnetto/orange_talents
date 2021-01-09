package com.example.processo_zup.controller;

import com.example.processo_zup.model.Cliente;
import com.example.processo_zup.repository.ClienteCustomRepository;
import com.example.processo_zup.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final ClienteCustomRepository clienteCustomRepository;

    public ClienteController(ClienteRepository clienteRepository, ClienteCustomRepository clienteCustomRepository) {
        this.clienteRepository = clienteRepository;
        this.clienteCustomRepository = clienteCustomRepository;
    }

    @GetMapping("/")
        public List<Cliente> getAllClient(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable("id") Long id){
        return clienteRepository.getOne(id);
    }

    @PostMapping("/")
    public void saveClient(@RequestBody Cliente cliente){
        Cliente c = new Cliente();
        c.setNome(cliente.getNome());
        c.setDataNascimento(cliente.getDataNascimento());
        c.setCpf(cliente.getCpf());
        c.setEmail(cliente.getEmail());
        clienteRepository.save(c);
    }


}
