package Part1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.Text;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NameIdGrade implements Writable, WritableComparable<NameIdGrade> {
    private final Text name = new Text();
    private final IntWritable Id = new IntWritable();
    private final Text grade = new Text();
    public NameIdGrade(){}
    public NameIdGrade(String name, int Id, String grade){
        this.name.set(name);
        this.Id.set(Id);
        this.grade.set(grade);
    }

    public Text getName(){
        return name;
    }
    public IntWritable getId(){
        return Id;
    }
    public Text getGrade(){
        return grade;
    }
    public Text naturalKey(){
        return new Text(name+", "+ Id.toString());
    }

    @Override
    public void write(DataOutput out)throws IOException{
        name.write(out);
        Id.write(out);
        grade.write(out);
    }


    @Override
    public int compareTo(NameIdGrade other) {
        if(name.compareTo(other.getName())==0){
            return grade.compareTo(other.getGrade());
        }
        return name.compareTo(other.getName());
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        name.readFields(dataInput);
        Id.readFields(dataInput);
        grade.readFields(dataInput);

    }
}
