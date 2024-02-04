import java.util.*;

public class PaginationHelper {

    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder,
            int itemsPerPage, int pageNumber) {
        // Sort the items based on the sortParameter and sortOrder
        items.sort((a, b) -> {
            if (sortOrder == 0) { // Ascending
                return a.get(sortParameter).compareTo(b.get(sortParameter));
            } else { // Descending
                return b.get(sortParameter).compareTo(a.get(sortParameter));
            }
        });

        // Calculate the start index of the given page
        int start = pageNumber * itemsPerPage;
        List<String> pageItems = new ArrayList<>();
        // Collect items for the specified page
        for (int i = start; i < start + itemsPerPage && i < items.size(); i++) {
            pageItems.add(items.get(i).get(0)); // Get the name of the item
        }
        return pageItems;
    }

    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        items.add(Arrays.asList("item1", "10", "15"));
        items.add(Arrays.asList("item2", "3", "4"));
        items.add(Arrays.asList("item3", "17", "8"));

        int sortParameter = 1; // Sorting by relevance
        int sortOrder = 0; // Ascending order
        int itemsPerPage = 2;
        int pageNumber = 1;

        List<String> result = fetchItemsToDisplay(items, sortParameter, sortOrder, itemsPerPage, pageNumber);
        System.out.println(result);
    }
}
