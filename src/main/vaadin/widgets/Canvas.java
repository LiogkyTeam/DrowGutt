package main.vaadin.widgets;

/**
 * Created by Alexey on 17.04.2017.
 */
// This is the server-side UI component that provides public API for Canvas:
// various get/set methods for work, event listeners and data source connections
public class Canvas extends com.vaadin.ui.AbstractComponent {
    //the following field need for serialization, better to change it to more hard after some time
    private static final long serialVersionUID = 1L;
    //the following field is used to uniquely identify a browser
    String sessionID;
    //need continue work
}
