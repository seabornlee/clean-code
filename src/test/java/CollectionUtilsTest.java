import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class CollectionUtilsTest {
    @Test
    public void should_return_empty_list_given_empty_list() {
        assertThat((List) CollectionUtils.split(emptyList(), 3)).isNull();
        assertThat((List) CollectionUtils.split(null, 3)).isNull();
        assertThat((List) CollectionUtils.split(Arrays.asList("item"), 0)).isNull();
    }

    @Test
    public void should_split_list_given_enough_items() {
        assertThat((List) CollectionUtils.split(
                Arrays.asList("item1", "item2", "item3", "item4"), 2)).isEqualTo(
                Arrays.asList(
                        Arrays.asList("item1", "item2"),
                        Arrays.asList("item3", "item4")
                ));

        assertThat((List) CollectionUtils.split(
                Arrays.asList("item1", "item2", "item3"), 2)).isEqualTo(
                Arrays.asList(
                        Arrays.asList("item1", "item2"),
                        Arrays.asList("item3")
                ));
    }

    @Test
    public void should_split_list_given_not_enough_items() {
        assertThat((List) CollectionUtils.split(Arrays.asList("item1"), 2)).isEqualTo(Arrays.asList(Arrays.asList("item1")));
    }
}
