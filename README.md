# 🏡 Ndieujou API  

**Ndieujou** est une plateforme innovante de **vente, location et rénovation de logements** au Québec. Ce projet vise à faciliter la mise en relation entre **propriétaires** et **locataires/acheteurs** tout en offrant une expérience utilisateur fluide et intuitive.  

🔧 Ce repository contient l’API backend de Ndieujou, développée avec **Spring Boot** et une architecture **microservices**. 

---

## Fonctionnalités  

L’API de **Ndieujou** intègre plusieurs fonctionnalités essentielles :  

###  **Gestion des utilisateurs & Authentification**  
- Inscription et connexion sécurisées avec **Spring Security & JWT**  
- Rôles et permissions (Admin, Propriétaire, Locataire)  
- Authentification sociale (Google, Facebook)  

###  **Gestion des annonces immobilières**  
- Création, modification et suppression d’annonces  
- Recherche avancée avec filtres (prix, localisation, type de bien, etc.)  
- Ajout de photos et vidéos avec stockage sur **AWS S3**  

###  **Cartographie & Géolocalisation**  
- Intégration avec **Google Maps API** pour la recherche de logements  
- Affichage des logements sur une carte interactive  

###  **Recommandations en temps réel**  
- Système de **suggestion personnalisée** basé sur **Kafka & machine learning**  
- Algorithme de matching entre locataires et logements disponibles  

###  **Messagerie & Notifications**  
- Chat en temps réel entre propriétaires et locataires (**WebSockets**)  
- Notifications push et emails transactionnels (**Twilio, AWS SES**)  

###  **Paiements & Contrats**  
- Intégration avec **Stripe** pour les paiements sécurisés  
- Génération automatique de contrats numériques pour la location  

###  **Tableau de bord & Analytics**  
- Statistiques sur les logements consultés et interactions des utilisateurs  
- Suivi des transactions et historique des paiements   

---

##  Technologies & Outils  

### **Backend**  
- **Langage** : Java  
- **Framework principal** : Spring Boot  
- **Sécurité** : Spring Security, JWT, OAuth2  
- **API Documentation** : Swagger  

### **Base de données & Stockage**  
- **Base de données principale** : PostgreSQL  
- **Cache** : Redis  
- **Stockage des fichiers** : AWS S3  

### **Communication & Événements**  
- **Système de messagerie** : Apache Kafka  
- **Notifications push & emails** : Twilio, AWS SES  

### **DevOps & Déploiement**  
- **Conteneurisation** : Docker  
- **Orchestration** : Kubernetes  
- **CI/CD** : GitHub Actions, AWS CodePipeline  
- **Cloud** : AWS (EC2, Lambda, RDS, API Gateway)  

### **Tests & Qualité**  
- **Tests unitaires** : JUnit, Mockito  

---

##  Installation & Exécution  

1. **Cloner le repository**  
   ```sh
   git clone https://github.com/votre-utilisateur/ndieujou-api.git
   cd ndieujou-api

