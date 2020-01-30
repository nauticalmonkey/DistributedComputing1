package Part1;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupingComparator extends WritableComparator {
    public GroupingComparator(){
        super(NameIdGrade.class,true);
    }
    @Override
    public int compare(WritableComparable wc1, WritableComparable wc2){
        NameIdGrade compare1 = (NameIdGrade) wc1;
        NameIdGrade compare2 = (NameIdGrade) wc2;
        if(compare1.getName().compareTo(compare2.getName())==0){
            return compare1.getId().compareTo(compare2.getId());
        }
        return compare1.getName().compareTo(compare2.getName());
    }
}
