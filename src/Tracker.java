import java.util.*;

public class Tracker {

    private final HashMap<String, TreeSet<Integer>> collection = new HashMap<>();
    private final String doubleColon = ":";

    public String attach(String label){
        if(!collection.containsKey(label)){

            collection.put(label, new TreeSet<>(List.of(1)));
            return label + doubleColon + 1;
        }
        TreeSet<Integer> count = collection.get(label);
        Integer countSequence = 1;
        for (Integer integer : count) {
            if (!Objects.equals(integer, countSequence)) {
                break;
            }
            countSequence++;
        }
        count.add(countSequence);
        collection.put(label , count);
        return label + doubleColon + countSequence;
    }

    public void detach(String label){
       String[] division = label.split(doubleColon);
       String modifyLabel = division[0];
       Integer count = Integer.parseInt(division[1]);
       TreeSet<Integer> listCount = collection.get(modifyLabel);
       collection.remove(modifyLabel, listCount.remove(count));
    }



}
