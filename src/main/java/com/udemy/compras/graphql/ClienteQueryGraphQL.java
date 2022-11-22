package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.input.ClienteI;
import com.udemy.compras.model.Cliente;
import com.udemy.compras.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ClienteQueryGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService clienteService;

    @Transactional
    public Cliente saveCliente(ClienteI cliente){
        ModelMapper mapper = new ModelMapper();
        Cliente cli = mapper.map(cliente, Cliente.class);
        return this.clienteService.save(cli);
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
