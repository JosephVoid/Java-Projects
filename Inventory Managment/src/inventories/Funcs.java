package inventories;

import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Scanner;
import java.security.CryptoPrimitive;


class Funcs extends Thread {
    public void run(){}
    //Database connection intiater
    public static Statement connect_to_db(String DbName,String DbUserName,String DbPass){
        Statement q = null;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DbName,DbUserName,DbPass);
        q = conn.createStatement();
        return q;
        }catch(Exception e){
            e.printStackTrace();
        }
        return q;
    }
    
    File fid = new File("C:\\Users\\Yoseph\\Documents\\Inventories\\src\\inventories\\parts\\id.txt");
    File fname = new File("C:\\Users\\Yoseph\\Documents\\Inventories\\src\\inventories\\parts\\name.txt");
    File fqunatity = new File("C:\\Users\\Yoseph\\Documents\\Inventories\\src\\inventories\\parts\\quantity.txt");
    File fdate_in = new File("C:\\Users\\Yoseph\\Documents\\Inventories\\src\\inventories\\parts\\date_in.txt");
    File fprice = new File("C:\\Users\\Yoseph\\Documents\\Inventories\\src\\inventories\\parts\\price.txt");
    File ftype = new File("C:\\Users\\Yoseph\\Documents\\Inventories\\src\\inventories\\parts\\type.txt");
    File fmanu = new File("C:\\Users\\Yoseph\\Documents\\Inventories\\src\\inventories\\parts\\manu.txt");
    File fcount = new File("C:\\Users\\Yoseph\\Documents\\Inventories\\src\\inventories\\parts\\count.txt");
    
   
    public void write(String str,File f) {
        try {
            FileWriter writer = new FileWriter(f, true);
            writer.write(str+"\n");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addPartsfile(String id,int quantity,double price,String name,String date,String manu,String type){
        write(id,fid);write(quantity+"",fqunatity);write(price+"",fprice);write(name,fname);write(date,fdate_in);write(manu,fmanu);write(type,ftype);
    }
    public String[][] two_dim(){
        String data[][] = new String[2][6];
        
        try {int counter = 0;
            Scanner scanner = new Scanner(fid);
            Scanner scannerName = new Scanner(fname);
            Scanner scannerPrice = new Scanner(fprice);
            Scanner scannerQuant = new Scanner(fqunatity);
            Scanner scannerType = new Scanner(ftype);
            Scanner scannerDate_in = new Scanner(fdate_in);
            Scanner scannerManu = new Scanner(fmanu);
            Scanner scannerCount = new Scanner(fcount);
            
            
            while(scannerCount.hasNext()){
                
                System.out.println(scannerCount.next());
                counter++;System.out.println(counter);
            }
            
          for(int i = 0;i < counter;i++){
                //scannerName.reset();
                for(int j = 0;j <= 6;j++){
                    if(j==0){
                        int k = 0;
                        while(scanner.hasNext()){
                            //System.out.println(scanner.next());
                            if(k == counter){
                                data[counter][j] = scanner.next();System.out.println("id read");
                            }
                            k++;
                        }
                    } if(j==1){
                        int k = 0;
                        while(scannerName.hasNext()){
                            if(k == counter){
                                data[counter][j] = scannerName.next();System.out.println("name read");
                            }
                            k++;
                        }
                    }
                    if(j==2){
                        int k = 0;
                        while(scannerQuant.hasNext()){
                            if(k == counter){
                                data[counter][j] = scannerQuant.next();System.out.println("q read");
                            }
                            k++;
                        }
                    }
                    if(j==3){
                        int k = 0;
                        while(scannerDate_in.hasNext()){
                            if(k == counter){
                                data[counter][j] = scannerDate_in.next();System.out.println("d read");
                            }
                            k++;
                        }
                    }
                    if(j==4){
                        int k = 0;
                        while(scannerPrice.hasNext()){
                            if(k == counter){
                                data[counter][j] = scannerPrice.next();System.out.println("p read");
                            }
                            k++;
                        }
                    }
                    if(j==5){
                        int k = 0;
                        while(scannerType.hasNext()){
                            if(k == counter){
                                data[counter][j] = scannerType.next();System.out.println("t read");
                            }
                            k++;
                        }
                    }
                    if(j==6){
                        int k = 0;
                        while(scannerManu.hasNext()){
                            //scannerManu.reset();
                            if(k == counter){                                
                                data[counter][j] = scannerManu.next();System.out.println("m read");
                            }
                            k++;
                        }
                    }
                                         
                }
                
            }
            return data;
            
        } catch (Exception e) {
        }
       return data; 
    }
    public String[] colnamefile(){
        String str[] = {"ID","Name","Quantity","Date","Price","Type","Manufacture"};
        return str;
    }
    //variables and intializing
    static Statement connection = connect_to_db("invertory_managment","root","");
    static boolean found = false; 
    
    //Table Content 
    public static String[][] tableData(ResultSet rset)throws Exception{
      
        ResultSetMetaData meta = rset.getMetaData(); 
        rset.last();
        int numRows= rset.getRow();
        rset.first();
        String tableData[][] = new String[numRows][meta.getColumnCount()];
        String colNames[] = new String[meta.getColumnCount()];
           
        System.out.println("the row is "+numRows+" "+meta.getColumnCount());
        for (int row = 0; row < numRows; row++){
           for (int col = 0; col < meta.getColumnCount(); col++)
           {
               //will vary from db to db.
               if((col+1) == 3)   
                   tableData[row][col] = ""+rset.getInt(col+1);
               else if((col+1) == 4)
                   tableData[row][col] = ""+rset.getDate(col+1);
               else if((col+1) == 5)
                   tableData[row][col] = ""+rset.getFloat(col+1);
               else
                   tableData[row][col] = rset.getString(col+1);
                             
            }
            rset.next();  
        }
         
        return tableData;
         
    }
    //Table Column names
    public static String[] colNames(ResultSet rset)throws Exception{
        ResultSetMetaData meta = rset.getMetaData();
        String colNames[] = new String[meta.getColumnCount()];
        // Getting column names.
        for (int i = 0; i < meta.getColumnCount(); i++)
         {            
          colNames[i] = meta.getColumnLabel(i+1).toUpperCase();
         }
        return colNames;
    }
    //Views full table
    public static ResultSet viewAll()throws Exception{
        ResultSet rs = connection.executeQuery("SELECT * FROM car_parts");
        return rs;
    }
    //Item search  by id
    public static ResultSet searchItem(int id)throws Exception{
        ResultSet rs = connection.executeQuery("SELECT * FROM car_parts WHERE id LIKE %'"+id+"'%");
        if(rs.first())
            JOptionPane.showConfirmDialog(null, "No results found!");
        return rs;
              
    }
    
    //Item search  by name
    public static ResultSet searchItem(String id)throws Exception{
        ResultSet rs = connection.executeQuery("SELECT * FROM car_parts WHERE id LIKE '%"+id+"%'");
        return rs;
    }
    
    //Item delete by id
    public static void deleteItem(int id)throws Exception{
        connection.executeUpdate("DELETE FROM car_parts WHERE id='"+id+"'");
    }
    
    //Item delete by Name
    public static void deleteItem(String name)throws Exception{
        connection.executeUpdate("DELETE FROM car_parts WHERE name ='"+name+"'");
    }
    
    //Create an admin account
    public static void createAdminAccount(String id,String fname,String lname,String username,String password)throws Exception{
        connection.executeUpdate("INSERT INTO users VALUES('"+id+"','"+fname+"','"+lname+"','0','"+username+"','"+password+"')");
    }
    //Create an Storekeeper account
    public static void createStorekeeperAccount(String id,String fname,String lname,String username,String password)throws Exception{
        connection.executeUpdate("INSERT INTO users VALUES('"+id+"','"+fname+"','"+lname+"','1','"+username+"','"+password+"')");
    }
    
    //logining into an account
    public static int login(String username,String password)throws Exception{
        ResultSet rs = connection.executeQuery("SELECT * FROM users WHERE username = '"+username+"'");
        while(rs.next()){
            if(rs.getString("username").equals(username) && rs.getString("password").equals(password)){
                found = true;
                return rs.getInt("type");
            }                             
        }
        if(rs.next() == false && found == false)
            return 2;
        return 3;
    }
    
    //adding an Item
    public static void addItem(String id,int quantity,double price,String name,String date,String manu,String type)throws Exception{
        connection.executeUpdate("INSERT INTO car_parts VALUES('"+id+"','"+name+"','"+quantity+"','"+date+"','"+price+"','"+type+"','"+manu+"')");
    }
    //subtracting quantity number by id
    public static void subQuant(int id,int num)throws Exception{
        connection.executeUpdate("UPDATE car_parts SET quantity = quantity +'"+num+"' WHERE id='"+id+"'");
    }
    //subtracting quantity number by name
    public static void subQuant(String name,int num)throws Exception{
        connection.executeUpdate("UPDATE car_parts SET quantity = quantity +'"+num+"' WHERE name='"+name+"'");
    }
    //Adding parts to blacklist
    public static void add_part(String name)throws Exception{
        connection.executeUpdate("INSERT INTO denied_parts VALUES('"+name+"')");
    }
    //Adding users to blacklist
    public static void add_user(String name)throws Exception{
         connection.executeUpdate("INSERT INTO denied_users VALUES('"+name+"')");
    }
    //Remove the user from blacklist
    public static void forgive(String name)throws Exception{
        connection.executeUpdate("DELETE FROM denied_users WHERE name = '"+name+"'");
    }
    //Remove the user from blacklist
    public static void revive(String name)throws Exception{
        connection.executeUpdate("DELETE FROM denied_parts WHERE name = '"+name+"'");
    }
    //Checking if item is in black list or nah.
    public static boolean isItemBlacklisted(String name)throws Exception{
        boolean found = false;        
        ResultSet rsp = connection.executeQuery("SELECT * FROM denied_parts");        
        while(rsp.next()){
            if(name.equals(rsp.getString("name")))
                found = true;
        }        
        if(found)
            return true;
        else
            return false;
     
    }
    //Checking if users is in black list or nah.
    public static boolean isUserBlacklisted(String name)throws Exception{
        boolean found = false;        
        ResultSet rsu = connection.executeQuery("SELECT * FROM denied_users");        
        while(rsu.next()){
            if(name.equals(rsu.getString("name")))
                found = true;
        }        
        if(found)
            return true;
        else
            return false;
     
    }
    public static String randNum(){
        Random rnd = new Random();
        Random rnd2 = new Random();
        Random rnd3 = new Random();
        Random rnd4 = new Random();
        Random rnd5 = new Random();        
        String num = ""+rnd.nextInt(10)+""+rnd2.nextInt(10)+""+rnd3.nextInt(10)+""+rnd4.nextInt(10)+""+rnd5.nextInt(10)+"";
        return num;
    }
}

