package alex;

import com.vaadin.shared.AbstractFieldState;

import java.util.ArrayList;
import java.util.List;

/*The AbstractComponentState needs to create shared state object.
* Variables must be declared as public
* or public setters must exists for these variables.
* Shared state shouldn't contain any logic.
*/
public class TodoListState extends AbstractFieldState {

    public List<Task> tasks = new ArrayList<Task>();

}