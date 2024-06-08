import org.apache.hadoop.io.Text;

import java.io.IOException;
import java.util.HashMap;

public class MatrixMultiplication_2Reducer
  extends org.apache.hadoop.mapreduce.Reducer<Text, Text, Text, Text> {
        @Override
        public void reduce(Text key, Iterable<Text> values, Context context)
                        throws IOException, InterruptedException {
        	
        	
	            String line = key.toString();	            
	            String[] keys = line.split(",");
	            
                String[] NoKey_JustValues;
                //key=(i,k),
                //Values = [(M/N,j,V/W),..]
                HashMap<Integer, Float> hashA = new HashMap<Integer, Float>();
                HashMap<Integer, Float> hashB = new HashMap<Integer, Float>();
                for (Text val : values) {//values tiene 3 valores: la matriz la columna y el valor
                	NoKey_JustValues = val.toString().split(",");
                        if (NoKey_JustValues[0].equals("A")) {
                                hashA.put( Integer.parseInt(NoKey_JustValues[1]), Float.parseFloat(NoKey_JustValues[2]));
                                //List<String> list = Arrays.asList(Integer.parseInt(keys[0]),Integer.parseInt(keys[1]), Integer.parseInt(indicesAndValue[1]), Float.parseFloat(indicesAndValue[2]));
                        } 
                        else if (NoKey_JustValues[0].equals("B")) {
                                hashB.put( Integer.parseInt(NoKey_JustValues[1]), Float.parseFloat(NoKey_JustValues[2]));
                        }
                }
                
                int n = Integer.parseInt(context.getConfiguration().get("Matrix1_cols_Matrix2_rows"));
                float result = 0.0f;
                float a_ij;
                float b_jk;
                for (int j = 0; j < n; j++) {//En cada Loop completo, de inicio a fin de j, computa un elemento de la matriz. El orden del calculo lo da el output de Mapper. Este for se invoca tantas veces como lineas entrega mapper en matriz 2x2 mapper entrega 4 lineas, una para cada elemento 
                	a_ij = hashA.containsKey(j) ? hashA.get(j) : 0.0f;
                	b_jk = hashB.containsKey(j) ? hashB.get(j) : 0.0f;
                        result += a_ij * b_jk;
                }
                if (result != 0.0f) {
                        context.write(null,
                                        new Text(key.toString() + "," + Float.toString(result)));
                }
        }
}