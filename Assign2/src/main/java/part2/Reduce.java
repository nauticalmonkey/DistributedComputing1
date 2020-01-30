package part2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

//Exact same if combiner no need to change
public class Reduce extends Reducer<Text, IntWritable, Text, IntWritable> {

    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        int highTemp = 0;
        for (IntWritable val : values) {
            if(val.get() > highTemp){
                highTemp = val.get();
            }
        }
        context.write(key, new IntWritable(highTemp));
    }
}
