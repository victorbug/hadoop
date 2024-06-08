Para tirar mensajes a la consola y terminal al ejecutar las lineas "hadoop jar Modulo.jar Driver Input Output":
System.out.printf("line: %s%n", line);

###################
Lineas para meter log. El log en mi caso sale en la consola de Eclipse, sale en el terminal, pero no sale en los logs de YARN
###################
import org.apache.log4j.Logger;//para tirar mensajes como log. /usr/lib/hadoop/client/log4j.jar
private static final Logger log = Logger.getLogger(MatrixMultiplication_0Driver.class);//para tirar mensajes como log
log.debug("Hello this is an debug message");//para tirar mensajes como log
log.info("Hello this is an info message");//para tirar mensajes como log
