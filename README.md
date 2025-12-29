# 📚 API REST pour Bibliothèque

Une API web pour gérer des livres dans une bibliothèque. Développé avec Java et Jakarta EE.

## 🔗 Lien de l'API 
http://localhost:8080/biblivre/api/livres

## ✨ Fonctionnalités
- Ajouter, voir, modifier et supprimer des livres
- Voir seulement les livres disponibles
- Format JSON pour toutes les réponses

## 📡 Points d'accès (Endpoints)

| Méthode | URL | Action |
|---------|-----|---------|
| GET | `/api/livres` | Voir tous les livres |
| GET | `/api/livres/1` | Voir le livre avec ID=1 |
| GET | `/api/livres/disponibles` | Voir les livres disponibles |
| POST | `/api/livres` | Ajouter un nouveau livre |
| PUT | `/api/livres/1` | Modifier le livre avec ID=1 |
| DELETE | `/api/livres/1` | Supprimer le livre avec ID=1 |

## 🛠️ Technologies utilisées
- **Java 11**
- **Jakarta EE 10** (pour faire des APIs web)
- **Jersey** (pour les services REST)
- **Maven** (pour gérer les bibliothèques)
- **Tomcat 10** (serveur web)

