# Gpt-entrainement

Projet pour m'entrener dans Java EE.

## Prérequis

IDE : Eclipse 12/24
Java : JDK11
WildFly : 17.0.0.Final
Mvn : 4
PrimeFaces : 8
JPA : Javax.persistence.api 2.2
JDBC : ojdbc8
CDI : cdi-api 2.0.SP1
JSP : javax.faces-api 2.3

### Installation

Exemple :
```bash
git clone https://github.com/JuanCarlos-Carretero/Gpt-entrainement.git

### Construit avec

- Maven - Gestionnaire de dépendances
- WildFly - Serveur d'applications
- PrimeFaces - Bibliothèque de composants d'interface utilisateur pour JSF

### Problèmes communs et solutions

- Problème de connexion entre eclipse et base de donne oracle (Oracle Database 23ai FREE)
Il faut ouvrir la perspective "Database Development". Creer une nouvelle connexion avec "Oracle". Aprés il faudra choissir un Driver (11 dans mon cas) et dans les proprietes il faudra Donner un nom a la base de donne, mettre la URL (jdbc:oracle:thin:@localhost:1521/FREEPDB1), choissir un utilisateur (hr) et mettre le mot de passe (oracle)

- Problème de creation automatique de JPA a partir d'une table Oracle
Differencier entre les nouvelles versions de Jakarta.persistence.* et Javax.persistence.* et donner des droits d'ecriture dans le cas ou on a pas les droits d'ecrire.

#### Auteur

Carretero Roldan Juan-Carlos



