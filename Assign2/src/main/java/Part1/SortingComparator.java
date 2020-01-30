package Part1;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class SortingComparator extends WritableComparator {
    protected SortingComparator(){
        super(NameIdGrade.class,true);
    }
    @Override
    public int compare(WritableComparable wc1, WritableComparable wc2){
        NameIdGrade comparing1 = (NameIdGrade) wc1;
        NameIdGrade comparing2 = (NameIdGrade) wc2;
        return comparing1.compareTo(comparing2);

    }

}
