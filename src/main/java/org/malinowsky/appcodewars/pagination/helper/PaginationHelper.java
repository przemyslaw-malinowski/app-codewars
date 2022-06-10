package org.malinowsky.appcodewars.pagination.helper;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import java.util.List;

@LocalBean
@Stateful
public class PaginationHelper<I> {

    private List<I> collection;
    private int itemsPerPage;
    private int restOfDivided;
    private int subtraction;
    private int size;

    public PaginationHelper() {
    }

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
        this.restOfDivided = collection.size() % itemsPerPage;
        this.subtraction = collection.size() / itemsPerPage;
        this.size = collection.size();
    }

    public void set(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
        this.size = collection.size();
        this.restOfDivided = this.size % itemsPerPage;
        this.subtraction = this.size / itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return size;
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return (restOfDivided == 0) ?
                subtraction :
                subtraction + 1;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        int pointerLocation = pageIndex * itemsPerPage;
        if (pointerLocation < 0 || pointerLocation > size) { return -1; }
        return (pointerLocation + itemsPerPage < size) ?
                itemsPerPage :
                restOfDivided;
    }
    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        int pagination = itemIndex / itemsPerPage;
        if(itemIndex < 0 || size == 0) return -1;
        return (pagination >= 0 && pagination <= pageCount()) ? pagination : -1;
    }

}
