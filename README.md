# Projet de groupe 10 - Programmation Java - 18VP

## Instructions
**Exécuter l'application**
Exécutez la méthode `main` dans la classe UnoApp

## Domaine principal 
La logique de base du jeu est construite selon les [règles officielles de l'uno] (https://en.wikipedia.org/wiki/Uno_ (card_game) #Official_rules). 

### Cartes Uno
Les cartes sont des objets de valeur, c'est-à-dire immuables. Les types de cartes suivants sont disponibles dans Uno: 
* Number Card
* Skip Action Card
* Reverse Action Card
* Draw Two Action Card
* Wild Color Card
* Wild Draw Four Card

Au départ, les jokers n'ont pas de couleur. Une fois dessiné, un nouvel objet de valeur est créé avec la couleur choisie. 

### Player

`Player` Est une entité qui contient une liste de cartes à jouer. 

`PlayerRoundIterator` Gère les joueurs et les commutateurs tournent comme si les joueurs étaient dans une table ronde.

### Game

`Game` Est l'agrégat qui maintient l'état des **players**, **draw pile** et **discard pile** au fur et à mesure que les cartes sont jouées.

### Événements de domaine 

`Game` Agrégat produit des événements de domaine en utilisant `DomainEventPublisher`

Les abonnés peuvent s'inscrire à ces événements et les gérer en conséquence. 

### Design Pattern
La logique de base du jeu en utilisant Domain-Driven Design