# 1º Ejecutar variables de entorno
source $1

# 2º Clonar el repositorio
git clone $GITHUB_URL ..

# 3º Entrar en el repositorio
repo=$(basename -s .git $GITHUB_URL)
cd $repo

# 4º Mover a la rama de desarrollo
git switch $BRANCH

# 5º Compilar JAVA
mvn clean install

# 6º Crear variables:
PK=../certificados/id_rsa      # para la ruta de la SSH privada
TARGET=$USER@$IP:/home/richard # para la ruta del servidor

#---------------------- MANUAL ----------------------#
# 7º Ejecutar el script build.sh que se encarga de compilar SASS y ANGULAR
source ./build.sh

# 8º  Generar par de claves SSH en local (/home/user/.ssh)
ssh-keygen -f $PK -t rsa -b 4096 -C "richard@fpmislata.com"

# 9º Copiar la clave pública al servidor
cat $PK.pub >> ~/.ssh/authorized_keys

# 10º Descargar JAVA JDK Temurin
wget https://adoptium.net/es/download/
#----------------------------------------------------#

# 11º Copiar el JDK por SCP y el jar
scp -i $PK -r $HOME/openjdk-11.0.12_linux-x64_bin.tar.gz $TARGET
scp -i $PK ../target/bookstore-0.0.1.jar $TARGET

# 12º Eliminar el repositorio local
rm -rf ../$repo

# 13º Descomprimir el JDK y eliminarlo después en el remoto
ssh -i $PK $TARGET tar -xvf openjdk-11.0.12_linux-x64_bin.tar.gz
ssh -i $PK $TARGET rm openjdk-11.0.12_linux-x64_bin.tar.gz

# 14º Ejecutar el jar
ssh -i $PK $TARGET java -Dserver.port=$PORT -jar bookstore-0.0.1.jar