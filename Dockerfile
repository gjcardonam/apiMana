# Etapa 1: Construcción
FROM ubuntu:latest AS build
LABEL authors="gjcar"

# Instalar dependencias necesarias para la construcción
RUN apt-get update && apt-get install -y openjdk-17-jdk wget unzip

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar todo el código fuente al contenedor
COPY . .

# Dar permisos de ejecución a gradlew
RUN chmod +x gradlew

# Construir el archivo JAR usando Gradle
RUN ./gradlew bootJar --no-daemon

# Etapa 2: Ejecución
FROM openjdk:17-jdk-alpine
LABEL authors="gjcar"

# Exponer el puerto
EXPOSE 8080

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR desde la etapa de construcción
COPY --from=build /app/build/libs/*.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
