import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.log4j.Logger;//para tirar mensajes como log. /usr/lib/hadoop/client/log4j.jar

public class MatrixMultiplication_0Driver {

	private static final Logger log = Logger.getLogger(MatrixMultiplication_0Driver.class);//para tirar mensajes como log
	
	
	
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: MatrixMultiply <in_dir> <out_dir>");
            System.exit(2);
        }
        Configuration conf = new Configuration();
        // M is an m-by-n matrix; N is an n-by-p matrix.
        conf.set("Matrix1_rows", "2");
        conf.set("Matrix1_cols_Matrix2_rows", "2");
        conf.set("Matrix2_cols", "2");

        Job job = new Job(conf, "MatrixMultiply");


        job.setJarByClass(MatrixMultiplication_0Driver.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setMapperClass(MatrixMultiplication_1Mapper.class);        
        job.setReducerClass(MatrixMultiplication_2Reducer.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        //System.out.printf("Usage: WordCount <input dir> <output dir>\n");
        log.debug("Hello this is an debug message");//para tirar mensajes como log
        log.info("Hello this is an info message");//para tirar mensajes como log
        
        job.waitForCompletion(true);
    }
}

