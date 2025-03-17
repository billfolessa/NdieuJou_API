# Étape 1 : Compilation du projet
FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Étape 2 : Image de production plus légère

FROM eclipse-temurin:17-jre-alpine
# Définir le répertoire de travail
WORKDIR /app
# Copier l’application compilée
COPY --from=builder /app/target/ApiGetway.jar app.jar
# Exposer le port sur lequel l'application écoute
EXPOSE 8080
# Commande pour exécuter l'application
ENTRYPOINT ["sh", "-c", "exec java -jar app.jar"]
