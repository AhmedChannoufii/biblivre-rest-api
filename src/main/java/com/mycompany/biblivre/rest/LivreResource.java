package com.mycompany.biblivre.rest;

import com.mycompany.biblivre.model.Livre;
import com.mycompany.biblivre.bd.BibliothequeBD;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;
import java.util.ArrayList;

@Path("/livres")
@Produces(MediaType.APPLICATION_JSON)
public class LivreResource {
    
    @GET
    public Response getAllLivres() {
        try {
            List<Livre> livres = BibliothequeBD.getLivres();
            return Response.ok(livres).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erreur serveur: " + e.getMessage())
                    .build();
        }
    }
    
    @GET
    @Path("/{id}")
    public Response getLivreById(@PathParam("id") int id) {
        try {
            List<Livre> livres = BibliothequeBD.getLivres();
            
            for (Livre livre : livres) {
                if (livre.getid() == id) {
                    return Response.ok(livre).build();
                }
            }
            
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Livre non trouvé avec ID: " + id)
                    .build();
                    
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erreur serveur: " + e.getMessage())
                    .build();
        }
    }
    
    @GET
    @Path("/disponibles")
    public Response getLivresDisponibles() {
        try {
            List<Livre> tousLesLivres = BibliothequeBD.getLivres();
            List<Livre> disponibles = new ArrayList<>();
            
            for (Livre livre : tousLesLivres) {
                if (livre.Isdisponible()) {
                    disponibles.add(livre);
                }
            }
            
            return Response.ok(disponibles).build();
            
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erreur serveur: " + e.getMessage())
                    .build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLivre(Livre nouveauLivre) {
        try {
            if (nouveauLivre == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Données livre manquantes")
                        .build();
            }
            
            // Générer un ID automatique si non fourni
            if (nouveauLivre.getid() == 0) {
                List<Livre> livres = BibliothequeBD.getLivres();
                int maxId = 0;
                for (Livre l : livres) {
                    if (l.getid() > maxId) {
                        maxId = l.getid();
                    }
                }
                nouveauLivre.setid(maxId + 1);
            }
            
            BibliothequeBD.getLivres().add(nouveauLivre);
            
            return Response.status(Response.Status.CREATED)
                    .entity(nouveauLivre)
                    .build();
                    
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erreur serveur: " + e.getMessage())
                    .build();
        }
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateLivre(@PathParam("id") int id, Livre livreMaj) {
        try {
            List<Livre> livres = BibliothequeBD.getLivres();
            boolean trouve = false;
            
            for (int i = 0; i < livres.size(); i++) {
                Livre livre = livres.get(i);
                if (livre.getid() == id) {
                    // Conserve l'ID original
                    livreMaj.setid(id);
                    livres.set(i, livreMaj);
                    trouve = true;
                    break;
                }
            }
            
            if (trouve) {
                return Response.ok(livreMaj).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Livre non trouvé avec ID: " + id)
                        .build();
            }
            
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erreur serveur: " + e.getMessage())
                    .build();
        }
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteLivre(@PathParam("id") int id) {
        try {
            List<Livre> livres = BibliothequeBD.getLivres();
            boolean supprime = false;
            
            for (Livre livre : livres) {
                if (livre.getid() == id) {
                    livres.remove(livre);
                    supprime = true;
                    break;
                }
            }
            
            if (supprime) {
                return Response.ok().build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Livre non trouvé avec ID: " + id)
                        .build();
            }
            
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erreur serveur: " + e.getMessage())
                    .build();
        }
    }
    
    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "API LivreResource fonctionne! Nombre de livres: " + 
               BibliothequeBD.getLivres().size();
    }
}