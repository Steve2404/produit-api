package com.produit.produitservice.controller;

import com.produit.produitservice.ProduitApplication;
import com.produit.produitservice.model.Produit;
import com.produit.produitservice.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produits")
@RequiredArgsConstructor
public class ProduitController {
    private final ProduitService produitService;

    @GetMapping("/all")
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.createProduit(produit);
    }

    @GetMapping("{id}")
    public Produit getProduitById(@PathVariable long id) {
        return produitService.getProduitById(id);
    }

    @DeleteMapping("{id}")
    public String deleteProduitById(@PathVariable("id") long idpro) {
        return produitService.deleteProduitById(idpro);
    }

    @PutMapping("{id}")
    public Produit editProduitById(@PathVariable long id, @RequestBody Produit produit) {
        return produitService.editProduit(id, produit);
    }
}
