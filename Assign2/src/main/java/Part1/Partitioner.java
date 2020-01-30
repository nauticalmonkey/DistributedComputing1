package Part1;

import javax.xml.soap.Text;

public class Partitioner extends org.apache.hadoop.mapreduce.Partitioner<NameIdGrade, Text> {

    @Override
    public int getPartition(NameIdGrade nameIdGrade, Text text, int i) {
        return Math.abs(nameIdGrade.getName().hashCode()% i);
    }
}
