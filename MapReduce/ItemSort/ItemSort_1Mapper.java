import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ItemSort_1Mapper extends Mapper<LongWritable, Text, IntWritable,
IntWritable> {
@Override
     public void map(LongWritable key, Text value, Context context)
throws IOException, InterruptedException {
         String line = value.toString();
           String[] tokens = line.split(","); // This is the delimiter between
           int keypart = Integer.parseInt(tokens[0]);
           int valuePart = Integer.parseInt(tokens[1]);
           context.write(new IntWritable(valuePart), new IntWritable(keypart)); //Aquí esta la clave del script, invierte el orden (key,value)



        }
}
