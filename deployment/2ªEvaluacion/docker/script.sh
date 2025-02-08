#! /bin/bash

# Descargar mi repositorio de GitHub y darle permisos a la carpeta app
mkdir volumes
git clone https://github.com/RichardYusteDAW/logongas.git volumes/app
chmod 777 -R volumes/app

# Descargar la imagen compiler de Lorenzo
docker image pull logongas/compilar:1.0.0

# Levantar el contenedor compiler y COMPILAR el proyecto
docker container run -it --rm --pull=never -v ./volumes/app:/opt/app --name compilar --hostname compilar logongas/compilar:1.0.0

# Cambiarle el nombre al jar compilado
cp volumes/app/target/demo-0.0.1-SNAPSHOT.jar volumes/app/target/richard.jar