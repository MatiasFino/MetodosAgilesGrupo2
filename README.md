## Prerequisitos:
-   Instalar mongoDB (v5) siguiendo los pasos en: [Install MongoDB Community Edition](https://www.mongodb.com/docs/v5.0/administration/install-community/)
-   Instalar Java (de no tenerlo) y Maven (de no tenerlo) siguiendo los siguientes pasos: [How to Install Maven on Windows, Linux, and Mac | Baeldung](https://www.baeldung.com/install-maven-on-windows-linux-mac)
-   [*WINDOWS*] Recomiendo descargar algún archivo `apache-maven-3.x.y-bin.zip`, descomprimirlo y seguir los pasos del `README.txt` dentro de la carpeta.
-   [*WINDOWS*] Es probable que necesites reiniciar para completar alguna instalación.
-   Clonar repositorio mediante el comendo: `git clone https://github.com/MatiasFino/MetodosAgilesGrupo2.git`
    

  

## Ejecución:
-   Abrir terminal
-   Moverse a la raiz del proyecto
-   [*LINUX*] ejecutar por command line `sudo systemctl start mongod` (para ejecutar el proceso de mongoDB).
-   [*CUALQUIERA*] ejecutar comando `mvn compile` (para actualizar dependencias de maven de ser necesario)
-   [*CUALQUIERA*] ejecutar comando `mvn exec:java -Dexec.mainClass=com.sistema.ayudantes.sistayudantes.MainApplication` para ejecutar el programa.