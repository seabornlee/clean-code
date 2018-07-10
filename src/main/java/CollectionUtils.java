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
        if (list == null || list.size() == 0 || len < 1) {
            return null;
        }
        List<List<Object>> result = new ArrayList<>();
        int size = list.size();
        int count = (size + len - 1) / len;
        for (int i = 0; i < count; i++) {
            List<Object> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
            result.add(subList);
        }
        return result;
    }
}
