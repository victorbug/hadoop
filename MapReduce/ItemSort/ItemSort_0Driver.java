import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;

public class ItemSort_0Driver {
    public static void main(String[] args) throws Exception {
       if (args.length != 2) {
          System.out.printf("Usage: WordCount <input dir> <output dir>\n");
          System.exit(-1);
                }
                Job job = new Job();

                job.setJarByClass(ItemSort_0Driver.class);
                job.setJobName("Word Count");
                FileInputFormat.setInputPaths(job, new Path(args[0]));
                FileOutputFormat.setOutputPath(job, new Path(args[1]));

                job.setMapperClass(ItemSort_1Mapper.class);
                job.setReducerClass(ItemSort_2Reducer_.class);

                job.setMapOutputKeyClass(IntWritable.class);
                job.setMapOutputValueClass(IntWritable.class);

                job.setOutputKeyClass(IntWritable.class);
                job.setOutputValueClass(IntWritable.class);

                boolean success = job.waitForCompletion(true);
                System.exit(success ? 0 : 1);

        }
}
