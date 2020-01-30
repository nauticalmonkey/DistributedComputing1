package Part1;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.util.logging.Logger;

import java.io.IOException;

public class Reduce extends Reducer<NameIdGrade, Text, Text, Text> {
    private static final Logger THE_LOGGER = Logger.getLogger("ClassesDriver.class");
    public void reduce(NameIdGrade key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        String result="";
        for (Text val : values) {
            result+= val+", ";
            THE_LOGGER.info("value passed "+val.toString());

        }
        result = result.substring(0,result.length()-2);
        context.write(key.naturalKey(), new Text(result));
    }
}
