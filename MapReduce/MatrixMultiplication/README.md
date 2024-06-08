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
