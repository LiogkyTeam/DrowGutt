package org.test.ui;

import java.util.HashMap;
import java.util.Map;

public class Rooms {
    private static Rooms ourInstance = new Rooms();
    public static Rooms getInstance() {
        return ourInstance;
    }
    private Rooms(){

    }

    private Map<Key, Room> rooms = new HashMap<Key, Room>();

    private Room newRoom(com.vaadin.ui.UI ui, long password){
        return new Room(password, ui);
    }

    private void addRoom(Key name, Room room) throws NonUniqName{
        if (rooms.containsKey(name)) throw new NonUniqName();
        rooms.put(name, room);
    }

    public Room createRoom(Key name, long password, com.vaadin.ui.UI ui) throws NonUniqName{
        Room room = newRoom(ui, password);
        addRoom(name, room);
        return room;
    }

    public Room enterTheRoom(Key key, long password, com.vaadin.ui.UI ui) throws RoomNotExists, WrongPassword{
        if (!rooms.containsKey(key)) throw new RoomNotExists();
        rooms.get(key).registerUI(password, ui);
        return rooms.get(key);
    }

    public boolean RoomNameEmpty(Key name){
        return !rooms.containsKey(name);
    }
}
