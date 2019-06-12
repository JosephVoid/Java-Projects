package inventories;
import java.lang.Runnable;
import java.io.*;
import java.util.*;

class Handler {
    private String fileName;
    private FileWriter writer;
    private Scanner infile;
    private File file;
    
    public Handler (String fileName) {
        this.file = new File(fileName);
    }
    
    public void write(String str) {
        try {
            writer = new FileWriter(file, true);
            writer.write(str);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList readWhole() {
        ArrayList toBeReturned = new ArrayList<String>();
        try {
            infile = new Scanner(file);
            String ss;
            while(infile.hasNext()) {
                ss = infile.nextLine();
                toBeReturned.add(ss);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return toBeReturned;
    }
    
    public void writeWhole(ArrayList <User> users) {
        User toWrite;
        for (int i = 0; i < users.size(); ++i) {
            toWrite = users.get(i);
            write(toWrite.getID() + "\n");
            write(toWrite.getFirstName() + "\n");
            write(toWrite.getLastName() + "\n");
            write(toWrite.getPassword() + "\n");
            write(toWrite.getType() + "\n");
            write(toWrite.getUsername() + "\n");
            write("*");
        }
    }
    
}


public class FilePart extends Thread {
    public static void p(String str) {
        System.out.println(str);
    }
    
    public void run() {
        p("One");
    }
    
    public static void main(String[] args) {
        FilePart runn = new FilePart();
        runn.run();
    }
}


class TableFormat {
    private String[] colNames;
    private String[][] data;
    
    public void setColNames(String[] str) {
        this.colNames = str;
    }
    
    public void setData(String[][] data) {
        this.data = data;
    }
    
    public String[] getColNames() {
        return colNames;
    }
    
    public String[][] getData() {
        return data;
    }
    
    public void displayColNames() {
        for (int i = 0; i < colNames.length; ++i) {
            System.out.println(colNames[i]);
        }
    }
    
    public void displayData() {
        String[] str;
        for (int i = 0; i < data.length; ++i) {
            str = data[i];
            for (int j = 0; j < str.length; ++j) {
                System.out.print(str[j] + " | ");
            }
            System.out.print("\n");
        }
    }
}

class User {
    private int id;
    private String fileName;
    private String firstName;
    private String lastName;
    private int type;
    private String userName;
    private String password;
    
    public User(int id, String firstName, String lastName, int type, String userName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.userName = userName;
        this.password = password;
    }
    
    public ArrayList addUser(ArrayList users, int id, String firstName, String lastName, int type, String userName, String password) {
       User newUser = new User(id, firstName, lastName, type, userName, password);
       users.add(newUser);
       return users;
    }
    
    public int getID() {
        return this.id;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public int getType() {
        return this.type;
    }
    
    public String getUsername() {
        return this.userName;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getName() {
        return this.userName;
    }
    
    public ArrayList removeUser(ArrayList users, int id) {
        User temp;
        for (int i = 0; i < users.size(); ++i) {
            temp = (User) users.get(i);
            if (id == temp.getID()) {
                users.remove(i);
                return users;
            }
        }
        return null;
    }
    
    public void displayAll(ArrayList users) {
        User user;
        for (int i = 0; i < users.size(); ++i) {
            user = (User) users.get(i);
            System.out.println(user.getName());
        }
    }
}

class Part {
    private int id;
    private String fileName;
    private String partName;
    private int quantity;
    private String dateIn;
    private double price;
    private String type;
    private String manufacturer;
    
    public Part(int id, String partName, int quantity, String dateIn, double price, String type, String manufacturer) {
        this.id = id;
        this.partName = partName;
        this.quantity = quantity;
        this.dateIn = dateIn;
        this.price = price;
        this.type = type;
        this.manufacturer = manufacturer;
    }
    
    public ArrayList addPart(ArrayList parts, int id, String partName, int quantity, String dateIn, double price, String type, String manufacturer) {
       Part newPart = new Part(id, partName, quantity, dateIn, price, type, manufacturer);
       parts.add(newPart);
       return parts;
    }
    
    public int getID() {
        return this.id;
    }
    
    public String getName() {
        return this.partName;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public String getDateIn() {
        return this.dateIn;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public String getType() {
        return this.type;
    }
    
    public String getManufacturer() {
        return this.manufacturer;
    }
    
    public ArrayList removePart(ArrayList parts, int id) {
        Part temp;
        try {
            for (int i = 0; i < parts.size(); ++i) {
                temp = (Part) parts.get(i);
                if (id == temp.getID()) {
                    parts.remove(i);
                    return parts;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
    
    public void displayAll(ArrayList parts) {
        Part part;
        for (int i = 0; i < parts.size(); ++i) {
            part = (Part) parts.get(i);
            System.out.println(part.getName());
        }
    }
    
    public TableFormat getTable(ArrayList parts) {
       String[] colNames = new String[7];
       int sizeOfRows = parts.size();
       System.out.println(sizeOfRows);
       String[][] data = new String[sizeOfRows][7];
       colNames[0] = "ID";
       colNames[1] = "Name";
       colNames[2] = "Quantity";
       colNames[3] = "Date In";
       colNames[4] = "Price";
       colNames[5] = "Type";
       colNames[6] = "Manufacturer";
       
       TableFormat table = new TableFormat();
       table.setColNames(colNames);
       Part tempo;
       for (int i = 0; i < parts.size(); ++i) {
           tempo = (Part) parts.get(i);
           data[i][0] = tempo.getID() + "";
           data[i][1] = tempo.getName();
           data[i][2] = tempo.getQuantity() + "";
           data[i][3] = tempo.getPrice() + "";
           data[i][4] = tempo.getDateIn();
           data[i][5] = tempo.getType();
           data[i][6] = tempo.getManufacturer();
       }
       table.setData(data);
       
       return table;
        
    }
    
} 

class test {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList();
        ArrayList<Part> parts = new ArrayList();
        
        User temp = new User(1, "FNAME", "LNAME", 0, "username", "password");
        users = temp.addUser(users, 0, "firstName", "lastName", 0, "kevvo", "password");
        //users = temp.removeUser(users, 0);
        //temp.getTable(users);
        //temp.displayAll(users);
        Handler handler = new Handler("C:\\Users\\Yoseph\\Documents\\Inventories\\src\\inventories\\parts.txt");
        //ArrayList hh = handler.readWhole();
        //handler.writeWhole(users);
        handler.write("Vsauce");
    }
}