package com.udemy.compras.input;

import lombok.Data;

@Data
public class ClienteI {
    private Long id;
    private String nome;
    private String email;
    private Long cliente;
    private Long produto;
}
