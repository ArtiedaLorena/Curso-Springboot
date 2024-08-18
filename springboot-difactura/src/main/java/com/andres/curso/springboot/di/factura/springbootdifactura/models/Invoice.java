package com.andres.curso.springboot.di.factura.springbootdifactura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
@Component
@RequestScope
@JsonIgnoreProperties({"targetSource","advisors"}) //Cada vez q aparece un error lo ignora
public class Invoice {
    @Autowired
    private Client client;

    @Value("${invoice.description.office}")
    private String description;

    @Autowired
    private List<Item> items;

    //Despues de que se instancia el constructor
    @PostConstruct
    public void init(){
        System.out.println("Creando el componente de la factura");
        client.setName(client.getName().concat("Pepe"));
        description=description.concat(" del cliente: ").concat(client.getName()).concat(client.getLastname());
    }

    //Despues de que se haya instanciado el contructor, antes de destrir el componente
    @PreDestroy
    public void destroy(){
        System.out.println("Destruyendo el componente factura");
    }

    public Invoice() {
    }

    public Invoice(Client client, String description, List<Item> items) {
        this.client = client;
        this.description = description;
        this.items = items;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal(){
        return  items.stream()
                .map(item-> item.getImport())
                .reduce(0,(sum, importe)->sum+importe);
    }
}
