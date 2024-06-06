hdfs dfs -put ItemSort.jar /user/cloudera
hdfs dfs -put ToSort.txt /user/cloudera

hdfs dfs -rm -r -skipTrash /user/cloudera/finalWordResult
hadoop jar ItemSort.jar ItemSort_0Driver ToSort.txt finalWordResult
hdfs dfs -cat /user/cloudera/finalWordResult/part-r-00000

hdfs dfs -get /user/cloudera/finalWordResult/part-r-00000 /home/cloudera/Downloads
