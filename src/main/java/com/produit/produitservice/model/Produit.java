package com.produit.produitservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private double price;
}
