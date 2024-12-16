# 1º Ejecutar variables de entorno
source $1

# 2º Clonar el repositorio
git clone $REPO

# 3º Entrar en el repositorio
cd $REPO

# 4º Mover a la rama de desarrollo
git checkout $BRANCH

# 5º Compilar JAVA
mvn clean install

# 6º Ejecutar el script build.sh que se encarga de compilar SASS y ANGULAR
source ./build.sh

# 7º  Generar par de claves SSH en local (/home/user/.ssh)
ssh-keygen -f $HOME/.ssh/id_rsa -t rsa -b 4096 -C "richard@fpmislata.com"

# 8º Copiar la clave pública al servidor
cat $HOME/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys

# 9º Descargar JAVA JDK Temurin
wget https://adoptium.net/es/download/

# 10º Crear variables:
PK = $HOME/.ssh/id_rsa           # para la ruta de la SSH privada
TARGET = $USER@$IP:/home/richard # para la ruta del servidor

# 11º Copiar el JDK por SCP y el jar
scp -i $PK -r $HOME/openjdk-11.0.12_linux-x64_bin.tar.gz $TARGET
scp -i $PK ../target/bookstore-0.0.1.jar $TARGET

# 12º Eliminar el repositorio local
rm -r $REPO

# 13º Descomprimir el JDK y eliminarlo después
tar -xvf openjdk-11.0.12_linux-x64_bin.tar.gz
rm openjdk-11.0.12_linux-x64_bin.tar.gz

# 14º Ejecutar el jar
ssh -i $PK $TARGET java -Dserver.port=2024 -jar bookstore-0.0.1.jar