package com.udemy.compras.input;

import com.udemy.compras.model.Cliente;
import com.udemy.compras.model.Produto;
import lombok.Data;
import java.util.Date;

@Data
public class CompraI {

    private Long id;
    private Long quantidade;
    private String status;

    private Long cliente;

    private Long produto;
}
