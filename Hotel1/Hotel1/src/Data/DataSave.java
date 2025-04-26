package Data;

import Rooms.Room;
import Users.User;
import java.io.*;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
//C:\Users\22846\Downloads\IDEA\file\Project\Hotel1\Hotel1\src\Datafile\rooms.txt
public class DataSave {
    private static final String User_Path = "Hotel1\\src\\Datafile\\users.txt";
    private static final String Room_Path = "Hotel1\\src\\Datafile\\rooms.txt";
    private <T> void saveFile(String filename, ArrayList<T> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    private <T> ArrayList<T> getFile(String filename) {
        ArrayList<T> data = new ArrayList<>();
        try (ObjectInputStream ois =

                     new ObjectInputStream(new FileInputStream(filename))) {
            data = (ArrayList<T>) ois.readObject();
        } catch (FileNotFoundException e) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }
    public void saveUsers(ArrayList<User> users) {
        saveFile(User_Path, users);
    }
    public void saveRooms(ArrayList<Room> rooms) {
        saveFile(Room_Path, rooms);
    }
    public ArrayList<User> getUsers() {
        return getFile(User_Path);
    }
    public ArrayList<Room> getRooms() {
        return getFile(Room_Path);
    }

}
