# 1º Configurar el shell de npm para que ejecute los scripts en bash
npm config set script-shell "C:\\Program Files\\Git\\bin\\bash.exe"

# 2º Generar el par de clave pública y privada SSH
ssh-keygen -f ../certificates/id_rsa -t rsa -b 4096 -C "richard@fpmislata.com"

# 3º Copiar manualmente en máquina remota (Ubuntu) la clave pública en el fichero ~/.ssh/authorized_keys
cat ../certificates/id_rsa.pub >> ~/.ssh/authorized_keys

# 4º Descomentar en el fichero /etc/ssh/sshd_config las siguientes líneas:
PasswordAuthentication yes
AuthorizedKeysFile      .ssh/authorized_keys .ssh/authorized_keys2

# 5º Reiniciar el servicio SSH
sudo systemctl restart ssh

# 6º Comprobar que se puede conectar a la máquina remota y abrir puerto 80 en la máquina remota
ssh -i ../certificates/id_rsa ubuntu@192.168.0.125 "sudo ufw allow 80"

# 7º Descargar JAVA JDK Temurin en local
wget https://adoptium.net/es/download/