/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblivre.model;

/**
 *
 * @author chano
 */
public class Livre {
    private int id;
    private String titre;
    private String auteur;
    private int annePublication ;
    private boolean disponible;
    public Livre(){};
    public Livre(int id, String titre,String auteur, int annePublication,boolean disponible){
        this.id=id;
        this.titre=titre;
        this.auteur=auteur;
        this.annePublication=annePublication;
        this.disponible=disponible;
    }
    public int getid(){
        return id;
    }
    public String gettitre(){
        return titre;
    }
    public String getauteur(){
        return auteur;
    }
    public int getAnnePublication(){
        return annePublication;
    }
    public boolean Isdisponible(){
        return disponible;
    }
    public void setid(int id){
        this.id=id;
    }
    public void settitre(String titre){
        this.titre=titre;   
    }
    public void setannepublication(int annePublication){
        this.annePublication=annePublication;
    }
    public void setdisponible(boolean disponible){
    this.disponible= disponible ;
    }

    
    
    
    
    
}
