package com.andres.curso.springboot.di.factura.springbootdifactura;

import com.andres.curso.springboot.di.factura.springbootdifactura.models.Item;
import com.andres.curso.springboot.di.factura.springbootdifactura.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource(value= "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {
    @Bean
    List<Item> itemsInvoice(){
        Product p1= new Product("Camara Sony", 600);
        Product p2= new Product("Bicicleta Bianchi", 1200);
        return Arrays.asList(new Item(p1,2),new Item(p2, 4));
    }
    @Bean
    @Primary
    List<Item> itemsInvoiceOfice(){
        Product p1= new Product("Monitor Asus", 700);
        Product p2= new Product("Notebook Razr", 2400);
        Product p3= new Product("Impresora HP", 1400);
        Product p4= new Product("Notebook Sony", 2600);
        return Arrays.asList(new Item(p1,2),new Item(p2, 4),new Item(p3, 5),new Item(p4, 2));
    }
}
