package Part1;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;
import java.util.logging.Logger;

public class Map extends Mapper<LongWritable, Text, NameIdGrade, Text> {
    private static Logger THE_LOGGER = Logger.getLogger("ClassesDriver.class");

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String valueString= value.toString().trim();
        String[] tokens = valueString.split(", ");
        String newValue = "("+ tokens[2]+ ", "+tokens[3]+")";
        THE_LOGGER.info("Token0 "+tokens[0]);
        THE_LOGGER.info("value "+ newValue);
        THE_LOGGER.info("Token1 "+tokens[1]);
        THE_LOGGER.info("Token2 "+tokens[2]);


        context.write(new NameIdGrade(tokens[0],Integer.parseInt(tokens[1]),tokens[2]), new Text(newValue));
    }
}
