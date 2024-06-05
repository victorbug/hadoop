#####################
sudo /home/cloudera/cloudera-manager --force --express
#####################

ECLIPSE:
New --> Java Project
Poner los archivos Java (ver imagen en esta carpeta)
Exportar como JAR (click derecho en el proyecto FinalWordCount) --> Java --> JAR File --> (Incluir .classpath, .project)(ver imagen dentro de esta carpeta)

#####################
EN HADOOP
#####################
hdfs dfs -put FinalWordCount.jar /user/cloudera
hdfs dfs -ls /user/cloudera

touch finalWord.txt
nano finalWord.txt
hdfs dfs -put finalWord.txt /user/cloudera

hadoop jar FinalWordCount.jar WordCount finalWord.txt finalWordResult

hdfs dfs -ls /user/cloudera/finalWordResult

El resultado esta en:
hdfs dfs -cat /user/cloudera/finalWordResult/part-r-00000
