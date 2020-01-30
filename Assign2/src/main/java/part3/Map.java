package part3;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.logging.Logger;

public class Map extends Mapper<LongWritable, Text, Text, IntWritable> {
    private static final Logger THE_LOGGER = Logger.getLogger("TempDriver.class");

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String valueString= value.toString().trim();
        String[] tokens = valueString.split(" ");
        THE_LOGGER.info("this is the date"+ tokens[0]);
        if(tokens.length != 2){
            return;
        }
        context.write(new Text(tokens[0]), new IntWritable(Integer.parseInt(tokens[1])));
    }
}
