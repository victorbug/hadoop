hdfs dfs -put ItemSort.jar /user/cloudera
hdfs dfs -put Input_ToSort.txt /user/cloudera

hdfs dfs -rm -r -skipTrash /user/cloudera/finalWordResult
hadoop jar ItemSort.jar ItemSort_0Driver Input_ToSort.txt finalWordResult
hdfs dfs -cat /user/cloudera/finalWordResult/part-r-00000

hdfs dfs -get /user/cloudera/finalWordResult/part-r-00000 /home/cloudera/Downloads
