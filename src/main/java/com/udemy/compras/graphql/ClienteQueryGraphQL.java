package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.model.Cliente;
import com.udemy.compras.repository.ClienteRepository;
import com.udemy.compras.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ClienteQueryGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService clienteService;

    @Transactional
    public Cliente saveCliente(Long id, String nome, String email){
        return this.clienteService.save(new Cliente(id,nome,email));
    }

    @Transactional
    public String deleteCliente(Long id){
        try {
            this.clienteService.deleteById(id);
            return "Cliente "+id+" excluido com sucesso!";
        }catch (Exception e){
            return "Falha ao excluir cliente "+id;
        }
    }

    public Cliente cliente(Long id){
        return this.clienteService.findById(id);
    }

    public List<Cliente> clientes(){
      return this.clienteService.listAll();
    }

}
