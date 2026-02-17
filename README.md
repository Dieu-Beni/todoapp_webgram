C'est une application de gestion de taches, ou l'utilisateur peut:

- S'incrire
- Se connecter
- Gerer son profil
- Ajouter une tache
- Modifier une tache
- Supprimer une tache
- Filtrer les taches par categories
- Rechercher une tache par titre
- Recevoir des notifications de rappel

La structure de table

---- User ----
- id
- nom
- email
- password

---- Tache ---
- id
- titre 
- contenu
- etat (fini: gris, encours: blue)
- priorite (eleve: rouge, moyenne: orange, basse: dune)
- date 
- heure