package org.test.ui;

import java.util.HashMap;
import java.util.Map;

public class Rooms {
    private Map<Key, Room> rooms = new HashMap<Key, Room>();

    public Room createRoom(com.vaadin.ui.UI ui, long password){
        return new Room(password, ui);
    }

    public String addRoom(Key name, Room room){
        if (rooms.containsKey(name))
            return "Sorry, this room-name is occupied";
        rooms.put(name, room);
        return "Room is successfully added";
    }

    public boolean RoomNameEmpty(Key name){
        return !rooms.containsKey(name);
    }
}
