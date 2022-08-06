# CRUD avec JDBC en menu sur la console
Ce repository contient une template de menu JDBC en console des fonctionnalité d'un CRUD.

# Dependance
    . OS: windows ou autre.
    . IDE ou environement de travaille: IntelliJC ou IntelliJU

# Guide
    . Dans le dossier src/main/java se trouve les codes sources de la template
    . le fichier "Main" est celui du menu et qui relit toutes fonctionnalité du CRUD
    . Les autres fichiers sont les foncitonnalités du CRUD 

# Usage
    . Pour utiliser que la console pour faire un CRUD il suffit de "runer" la fonction main dans le fichier "Main"
    . Pour utiliser qu'une fonctionnalite du CRUD ex: "Inserer une valeur à une table", vous pouvez utilisez directement la fonction correspondante.

# Fonction existant
    . Create.CreateDataBase() => pour creer une nouvelle base de donnée. 
    . Create.CreateTable() => pour creer une nouvelle table.
    . Read.Read() => pour lire un tableau.
    . Update.Insert() => pour inserer une valeur à un tableau.
    . Update.Update() => pour changer la valeur.
    . Delete.DropDataBase() => pour effacer une base de donnée
    . Delete.DeleteValue() => pour effacer une valeur.

Pour precision chaque fonction a ses propres paramettres. Pour plus d'information vous pouvez faire un hover sur chaque fonction pour plus de documentation.