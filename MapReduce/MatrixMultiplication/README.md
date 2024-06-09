El metodo fue probado con 2 matrices de dimensiones 2x2. Si se quiere probar otras dimensiones, modificar los parametros: 
-Matrix1_rows
-Matrix1_cols_Matrix2_rows
-Matrix2_cols

El metodo entra:
-9 veces a la clase mapper (deberian ser 8, quizas hay una pasada oculta al principio o al final. En cada una de las 8 pasadas calcula 2 numeros dando un total de 16 valores)
-4 veces a reducer (Reducer se multplican 2 de esos 16 valores y se suman a la multiplicacion de otros 2 de los 16 valores.Osea En cada bloquecito entran 4 valores y sale 1. En cada vuelta se calcula uno de los 4 elementos de la matriz final (en caso provado de matrices 2x2))

#####################
sudo /home/cloudera/cloudera-manager --force --express
#####################
Activar servicios en (http://quickstart.cloudera:7180/cmf/home):
-HDFS
-YARN
#####################


ECLIPSE:
New --> Java Project
Poner los archivos Java (ver imagen en esta carpeta)
Exportar como JAR (click derecho en el proyecto FinalWordCount) --> Java --> JAR File --> (Incluir .classpath, .project)(ver imagen dentro de esta carpeta)


#####################
EN HADOOP
#####################
hdfs dfs -rm -r -skipTrash /user/cloudera/MatrixMultiplication.jar ; hdfs dfs -put MatrixMultiplication.jar /user/cloudera
hdfs dfs -ls /user/cloudera

hdfs dfs -rm -r -skipTrash /user/cloudera/MapDir ; hdfs dfs -mkdir -p /user/cloudera/MapDir ; hdfs dfs -put MapDir/* /user/cloudera/MapDir/
hdfs dfs -ls /user/cloudera/MapDir/
hdfs dfs -cat /user/cloudera/MapDir/AB.txt

hdfs dfs -rm -r -skipTrash /user/cloudera/MatrixMultiplication.jar ; hdfs dfs -put MatrixMultiplication.jar /user/cloudera ; hdfs dfs -rm -r -skipTrash /user/cloudera/MapDir ; hdfs dfs -mkdir -p /user/cloudera/MapDir ; hdfs dfs -put MapDir/* /user/cloudera/MapDir/

hdfs dfs -rm -r -skipTrash /user/cloudera/finalResult ; hadoop jar MatrixMultiplication.jar MatrixMultiplication_0Driver MapDir finalResult ; hdfs dfs -cat /user/cloudera/finalResult/part-r-00000
hdfs dfs -cat /user/cloudera/finalResult/part-r-00000

hdfs dfs -get /user/cloudera/finalResult/part-r-00000 /home/cloudera/Downloads

hdfs dfs -ls /user/cloudera/finalResult ; hdfs dfs -cat /user/cloudera/finalResult/part-r-00000

hdfs dfs -rm -r -skipTrash /user/cloudera/MapDir

hdfs dfs -rm -r -skipTrash /user/cloudera/MatrixMultiplication.jar ; hdfs dfs -put MatrixMultiplication.jar /user/cloudera ; hdfs dfs -rm -r -skipTrash /user/cloudera/MapDir ; hdfs dfs -mkdir -p /user/cloudera/MapDir ; hdfs dfs -put MapDir/* /user/cloudera/MapDir/ ; hdfs dfs -rm -r -skipTrash /user/cloudera/finalResult ; hadoop jar MatrixMultiplication.jar MatrixMultiplication_0Driver MapDir finalResult ; hdfs dfs -cat /user/cloudera/finalResult/part-r-00000
