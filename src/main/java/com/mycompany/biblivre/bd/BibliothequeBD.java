/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblivre.bd;
import com.mycompany.biblivre.model.Livre;
import java.util.ArrayList;
import java.util.List;


public class BibliothequeBD {
    private static List<Livre> livres = new ArrayList<>();
    static {
        livres.add(new Livre(1,"Le Petit Prince","Antoine de Saint-Exupéry",1943,true));
        livres.add(new Livre(2,"1984","George Orwell",1949,true));
        livres.add(new Livre(3,"Harry Potter","J.K. Rowling",1997,false));}
    
    public static List<Livre> getLivres(){
        return livres;
    }
    
}
