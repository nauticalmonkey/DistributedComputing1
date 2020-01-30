package part2;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.util.logging.Logger;

public class TempDriver extends Configured implements Tool {
    private static final Logger THE_LOGGER = Logger.getLogger("TempDiver.class");

    @Override
    public int run(String[] args) throws Exception {

        Job job =Job.getInstance();
        job.setJarByClass(part2.TempDriver.class);
        job.setJobName("HighTemp");
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setMapperClass(part2.Map.class);
        job.setReducerClass(part2.Reduce.class);
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        boolean status =job.waitForCompletion(true);
        return status ? 0 : 1 ;
    }

    public static void main(String[] args) throws Exception {
        if(args.length !=2){
            throw new IllegalArgumentException("usage: <input> <output>");
        }
        int returnStatus = ToolRunner.run(new part2.TempDriver(),args);
    }
}
