FROM eclipse-temurin:17

# Diretorio de trabalho
WORKDIR /app

# Copia do package
COPY /target/cicero-app-0.0.1-SNAPSHOT.jar /app/cicero-app-docker.jar

ENTRYPOINT ["java","-jar","cicero-app-docker.jar"]