import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MatrixMultiplication_1Mapper
  extends Mapper<LongWritable, Text, Text, Text> {
        @Override
        public void map(LongWritable key, Text value, Context context)
                        throws IOException, InterruptedException {
                Configuration conf = context.getConfiguration();
                
                int Matrix1_rows = Integer.parseInt(conf.get("Matrix1_rows"));//2
                //int m = Integer.parseInt(conf.get("n"));
                int Matrix2_cols = Integer.parseInt(conf.get("Matrix2_cols"));//2
                String line = value.toString();//"M,0,0,1"
                // (M, i, j, Mij);
                String[] Key_Values = line.split(",");//[0]=M; [1]=0; [2]=0;[3]=1
                Text outputKey = new Text();
                Text outputValue = new Text();
                List<List<String>> outputKeyList = new ArrayList<>();
                List<List<String>> outputValueList = new ArrayList<>();
                
                
                if (Key_Values[0].equals("A")) {   
                	System.out.printf("ENTRO a A\n");
                	for (int j_Matrix2_col = 0; j_Matrix2_col < Matrix2_cols; j_Matrix2_col++) {
                		
                		//Key. Fila, Columna
                		outputKey.set(Key_Values[1] + "," + 
                					  j_Matrix2_col);
	                    // outputKey.set(i,k);
	                    
                		//Value. El nombreMatriz=M, columna, valor de la Matrix1 
                        outputValue.set("A" + "," +
                        				Key_Values[2] + "," + 
                        				Key_Values[3]);
	                    // outputValue.set(M,j,Mij);
                        
                        //ParaDebug INICIO
                        List<String> outputKeyListi = new ArrayList<>();
                        outputKeyListi.add(Key_Values[1]);
                        outputKeyListi.add(String.valueOf(j_Matrix2_col));
                                                
                        List<String> outputValueListi = new ArrayList<>();
                        outputValueListi.add("A");
                        outputValueListi.add(Key_Values[2]);
                        outputValueListi.add(Key_Values[3]);
                        
                        outputKeyList.add(outputKeyListi);
                        outputValueList.add(outputValueListi);
                        
                        //System.out.printf("outputKeyListi: %s%n", outputKeyListi, );
                        //System.out.printf("outputValueListi: %s%n", outputValueListi);
                        System.out.printf("line: %s%n", line);
                        System.out.printf("outputKeyListi-outputValueListi: %s-%s%n", outputKeyListi, outputValueListi);


                        //ParaDebug FIN

                        //Key-Value
                        context.write(outputKey, outputValue);
	                    //System.out.printf("outputKey: %s\noutputValue: %s",outputKey, outputValue);
                        }
                } 
                else if (Key_Values[0].equals("B")){//Matrix2	
                	System.out.printf("ENTRO a B\n");
                      // (N, j, k, Njk);
                	for (int i_Matrix1_row = 0; i_Matrix1_row < Matrix1_rows; i_Matrix1_row++) {
                		//Key
                		//outputKey.set(i_Matrix1_row + "," + indicesAndValue[2]);//aqui estaba el problema en indicesAndValue[2]
                		outputKey.set(i_Matrix1_row + "," + 
                					Key_Values[2]);
	                    
                		//Value. Fila Matriz2, ValorMatriz2
                		outputValue.set("B" + "," +
	                				Key_Values[1] + "," + 
	                				Key_Values[3]);
                		
                		//ParaDebug INICIO
                        List<String> outputKeyListi = new ArrayList<>();
                        outputKeyListi.add(String.valueOf(i_Matrix1_row));
                        outputKeyListi.add(Key_Values[2]);
                        
                                                
                        List<String> outputValueListi = new ArrayList<>();
                        outputValueListi.add("B");
                        outputValueListi.add(Key_Values[1]);
                        outputValueListi.add(Key_Values[3]);
                        
                        outputKeyList.add(outputKeyListi);
                        outputValueList.add(outputValueListi);
                        
                        //System.out.printf("outputKeyListi: %s%n", outputKeyListi);
                        System.out.printf("line: %s%n", line);
                        System.out.printf("outputKeyListi-outputValueListi: %s-%s%n", outputKeyListi, outputValueListi);
                        //ParaDebug FIN
	                    
                		//Key-Value
                		context.write(outputKey, outputValue);
                        }
                }
        }
}


