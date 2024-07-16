# Projet Java : Analyse et évaluation d’expressions arithmétiques

Ce projet implémente une application Java pour l'analyse syntaxique et l'évaluation d'expressions mathématiques simples.

## Architecture du Projet

L'architecture du projet est organisée comme suit :

```
└── syntaxanalysisexpressionevaluation
    ├── enums
    │   ├── AdditiveOperator.java
    │   └── MultiplicativeOperator.java
    ├── enumsBuilder
    │   ├── AdditiveOperatorBuilder.java
    │   └── MultiplicativeOperatorBuilder.java
    ├── exceptions
    │   ├── AdditiveOperatorNotExist.java
    │   ├── FactorParenthesisMissingException.java
    │   ├── MultiplicativeOperatorNotExist.java
    │   ├── StringBufferOverflowException.java
    │   └── SyntaxException.java
    ├── Grammar.java
    ├── Reader.java
    ├── Screen.java
    ├── Session.java
    └── SyntaxAnalysisEvaluationProcess.java
```

## Prérequis

- JDK (Java Development Kit) installé sur votre système.

## Installation

1. Clonez ce repository :

   ```bash
   git clone https://github.com/lamine-f/dic1-mini-projet-java.git
   ```

2. Compilez le projet en utilisant Java :

   ```bash
   javac Main.java
   ```

## Utilisation

1. Exécutez la classe principale pour évaluer les expressions :

   ```bash
   java Main
   ```

2. Suivez les instructions pour entrer des expressions à évaluer.


## Prérequis

- Java JDK 8 ou supérieur.


## Contact

Pour toute question ou suggestion, contactez [Mouhamed Lamine Faye](mailto:persoitlamine42@gmail.com).
