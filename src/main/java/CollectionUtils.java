import java.util.ArrayList;
import java.util.List;

public class CollectionUtils {
    /**
     * 按指定大小，分隔集合，将集合按规定个数分为n个部分
     *
     * @param list
     * @param len
     * @return
     */
    public static List<List<Object>> split(List<Object> list, int len) {
        if (list == null || list.isEmpty() || len < 1) {
            return null;
        }

        ArrayList<List<Object>> result = new ArrayList<>();
        ArrayList<Object> subList = new ArrayList<>();

        for (Object o : list) {
            subList.add(o);

            if (isSubListFull(len, subList)) {
                result.add(subList);
                subList = new ArrayList<>();
            }
        }

        if (!subList.isEmpty()) {
            result.add(subList);
        }

        return result;
    }

    private static boolean isSubListFull(int len, ArrayList<Object> subList) {
        return subList.size() == len;
    }
}
