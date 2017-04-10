package item;

/**
 * Created by Alexey on 09.04.2017.
 */
public interface Blockable {
    //if true then Object will blocked to selecting and changing for current user, if false - will unblocked
    void setBlock(boolean state);
}
