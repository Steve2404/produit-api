package com.produit.produitservice.service;

import com.produit.produitservice.model.Produit;
import com.produit.produitservice.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProduitService {
    private final ProduitRepository produitRepository;

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit getProduitById(Long id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if (optionalProduit.isEmpty()) {
            throw new RuntimeException("Desole produit inexistant");
        }
        return optionalProduit.get();
    }

    public String deleteProduitById(long idpro) {
        Optional<Produit> optionalProduit = produitRepository.findById(idpro);
        if (optionalProduit.isEmpty()) {
            throw new RuntimeException("Suppression Impossible: Produit not found");
        }
        produitRepository.delete(optionalProduit.get());
        return "Produit supprime avec succes !";
    }

    public Produit editProduit(long id, Produit produit) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if (optionalProduit.isEmpty()) {
            throw new RuntimeException("Modification Impossible: Produit not found");
        }
        Produit produitModified = optionalProduit.get();
        produitModified.setNom(produit.getNom());
        produitModified.setPrice(produit.getPrice());
        return produitRepository.save(produitModified);
    }
}
