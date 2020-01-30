package Part1;

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


public class ClassesDriver extends Configured implements Tool {
    private static final Logger THE_LOGGER = Logger.getLogger("ClassesDriver.class");

    @Override
    public int run(String[] args) throws Exception {

        Job job =Job.getInstance();
        job.setJarByClass(ClassesDriver.class);
        job.setJobName("Class list with grades");
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setMapperClass(Map.class);
        job.setPartitionerClass(Partitioner.class);
        job.setReducerClass(Reduce.class);
        job.setGroupingComparatorClass(GroupingComparator.class);
        job.setSortComparatorClass(SortingComparator.class);
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        boolean status =job.waitForCompletion(true);
        return status ? 0 : 1 ;
    }

    public static void main(String[] args) throws Exception {
        if(args.length !=2){
            throw new IllegalArgumentException("usage: <input> <output>");
        }
        THE_LOGGER.info("input dir "+args[0]);
        THE_LOGGER.info("output dir "+args[1]);
        int returnStatus = ToolRunner.run(new ClassesDriver(),args);
        THE_LOGGER.info("return status "+returnStatus);
        System.exit(returnStatus);

    }
}
