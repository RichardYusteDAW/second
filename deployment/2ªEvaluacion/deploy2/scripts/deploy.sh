# 1º Ejecutar las variables de entorno
source $1

# 2º Clonar el repositorio en local
git clone $GITHUB_URL

# 3º Entrar en el directorio del repositorio
repo=$(basename -s .git $GITHUB_URL)
cd $repo

# 4º Cambiar rama
git switch $BRANCH

# 5º Compilar JAVA (Ejecutar el script build.sh que se encarga de compilar SASS y ANGULAR)
mvn clean install

# 6º Volvemos al directorio anterior
cd ..

# 7º Crear variables
PK=./certificates/id_rsa
TARGET=$USER@$IP

# 8º Copiar el JDK y el fichero JAR a la máquina remota
scp -i $PK ./downloads/$JAVA $TARGET:/home/$USER
scp -i $PK ./logongas/target/*.jar $TARGET:/home/$USER

# 9º Descomprimir el JDK en la máquina remota y eliminar el fichero comprimido
ssh -i $PK $TARGET "tar -xzvf $JAVA"

# 10º Eliminar el repositorio en local y el fichero comprimido
rm -rf $repo
rm -rf ./downloads/$JAVA
ssh -i $PK $TARGET "rm $JAVA"

# 11º Ejecutar la aplicación en la máquina remota
ssh -i $PK $TARGET "jdk-21.0.5+11/bin/java -jar *.jar"