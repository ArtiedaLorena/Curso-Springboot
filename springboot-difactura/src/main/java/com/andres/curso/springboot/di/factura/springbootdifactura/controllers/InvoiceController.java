package com.andres.curso.springboot.di.factura.springbootdifactura.controllers;

import com.andres.curso.springboot.di.factura.springbootdifactura.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private Invoice invoice;

    @GetMapping("/show")
    public Invoice show(){
        return invoice;
    }
}
