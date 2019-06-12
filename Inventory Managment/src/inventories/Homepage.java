
package inventories;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;



public class Homepage extends javax.swing.JFrame {
    
    private javax.swing.JMenuItem create_admin_account;
    private javax.swing.JMenuItem create_store_keeper;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu file_menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JMenuItem login;
    private javax.swing.JMenuItem refresh_menu_item;
    private javax.swing.JButton request_btn;
    private javax.swing.JTextField request_tf;
    private javax.swing.JTextField requester_name;
    private javax.swing.JTextField searcg_tf;
    private javax.swing.JButton search_btn;
    private javax.swing.JPanel table_pnl;
    private javax.swing.JPanel upper_pnl;
    private javax.swing.JMenuItem view_all_menu_item;
    Font font = new Font("SansSerif",Font.PLAIN,20);
    Funcs fn = new Funcs();
    Statement connection  = fn.connect_to_db("invertory_managment","root","");//Creating the db connection
    
    public Homepage() {
        initComponents();
    }     
                                 
    private void initComponents() {

        upper_pnl = new javax.swing.JPanel();
        searcg_tf = new javax.swing.JTextField();
        request_btn = new javax.swing.JButton();
        request_tf = new javax.swing.JTextField();
        search_btn = new javax.swing.JButton();
        requester_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        table_pnl = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        file_menu = new javax.swing.JMenu();
        create_admin_account = new javax.swing.JMenuItem();
        create_store_keeper = new javax.swing.JMenuItem();
        login = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        view_all_menu_item = new javax.swing.JMenuItem();
        refresh_menu_item = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Homepage");
        setResizable(false);

        request_btn.setText("Request");
        request_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                request_btnActionPerformed(evt);
                //Request button Event
                String item_id = request_tf.getText();
                String name_of_requester = requester_name.getText();
                int quantity_item = (Integer)jSpinner1.getValue();
                try{
                    if(!fn.isUserBlacklisted(name_of_requester) && !fn.isItemBlacklisted(item_id)){
                        connection.executeUpdate("UPDATE car_parts SET quantity = quantity - "+quantity_item+" WHERE id = '"+item_id+"'");
                        JOptionPane.showMessageDialog(null, "You have borrowed "+quantity_item+" item(s):"+item_id);
                    }
                    else if(!fn.isUserBlacklisted(name_of_requester) && fn.isItemBlacklisted(item_id)){
                        JOptionPane.showMessageDialog(null, "You can't take this item:"+item_id);
                    }
                    else if(fn.isUserBlacklisted(name_of_requester) && !fn.isItemBlacklisted(item_id)){
                        JOptionPane.showMessageDialog(null, "You are not allowed to take items,"+name_of_requester);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Item id:"+item_id+" not found!");
                    }
                }
                
                catch(SQLException se){
                    //file?
                }
                
                catch(Exception e){e.printStackTrace();}
                
            }
        });

        request_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                request_tfActionPerformed(evt);
            }
        });

        search_btn.setText("Search");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
                
            }
        });

        requester_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requester_nameActionPerformed(evt);
            }
        });

        jLabel1.setText("NAME");

        jLabel2.setText("REQUEST");

        jLabel3.setText("ITEM ID");

        jLabel4.setText("USER");

        jLabel5.setText("QUANTITY");

        javax.swing.GroupLayout upper_pnlLayout = new javax.swing.GroupLayout(upper_pnl);
        upper_pnl.setLayout(upper_pnlLayout);
        upper_pnlLayout.setHorizontalGroup(
            upper_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(upper_pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searcg_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addGroup(upper_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(requester_name, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(upper_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(request_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(request_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        upper_pnlLayout.setVerticalGroup(
            upper_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(upper_pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(upper_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, upper_pnlLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, upper_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searcg_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(search_btn)
                        .addComponent(request_btn))
                    .addComponent(requester_name, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, upper_pnlLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, upper_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinner1)
                        .addComponent(request_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout table_pnlLayout = new javax.swing.GroupLayout(table_pnl);
        table_pnl.setLayout(new FlowLayout());
        table_pnl.setBackground(new Color(51,51,51));
        //Adding the table to the panel.
        JScrollPane spane = null;
        Font font = new Font("SansSerif",Font.PLAIN,20);
        try{
            ResultSet r = connection.executeQuery("SELECT * FROM car_parts");
            JTable all_data_table = new JTable(fn.tableData(r),fn.colNames(r));
            //JTable all_data_table = new JTable(fn.two_dim(),fn.colnamefile());
            all_data_table.setRowHeight(30);
            all_data_table.setFont(font);
            //all_data_table.setBackground(new Color(102,102,102));
            TableColumnModel columnModel = all_data_table.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(200);
            columnModel.getColumn(1).setPreferredWidth(200);
            columnModel.getColumn(2).setPreferredWidth(200);
            columnModel.getColumn(3).setPreferredWidth(200);
            columnModel.getColumn(4).setPreferredWidth(200);
            columnModel.getColumn(5).setPreferredWidth(200);
            columnModel.getColumn(6).setPreferredWidth(200);
            spane = new JScrollPane(all_data_table);
            
            spane.setPreferredSize(new Dimension(1415,500));
            //fn.two_dim();
            
            
        }
        
        catch(SQLException se){
            //file?
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
        table_pnl.add(spane);
        
        table_pnlLayout.setHorizontalGroup(
        table_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
        );
        table_pnlLayout.setVerticalGroup(
        table_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 617, Short.MAX_VALUE)
        );
        
        table_pnlLayout.setHorizontalGroup(
            table_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        table_pnlLayout.setVerticalGroup(
            table_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 617, Short.MAX_VALUE)
        );

        file_menu.setText("File");

        create_admin_account.setText("Create Admin Account");
        create_admin_account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_admin_accountActionPerformed(evt);
            }
        });
        file_menu.add(create_admin_account);

        create_store_keeper.setText("Create Store Keeper Account");
        create_store_keeper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_store_keeperActionPerformed(evt);
            }
        });
        file_menu.add(create_store_keeper);

        login.setText("Log in");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        file_menu.add(login);

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        file_menu.add(exit);

        jMenuBar1.add(file_menu);

        jMenu1.setText("View");

        view_all_menu_item.setText("View All");
        view_all_menu_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_all_menu_itemActionPerformed(evt);
            }
        });
        jMenu1.add(view_all_menu_item);

        refresh_menu_item.setText("Refresh");
        refresh_menu_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_menu_itemActionPerformed(evt);
            }
        });
        jMenu1.add(refresh_menu_item);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(upper_pnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(table_pnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(upper_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(table_pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void create_admin_accountActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        
        AdminAccount aa = new AdminAccount();
        aa.setVisible(true);
        
    }                                                    

    private void request_tfActionPerformed(java.awt.event.ActionEvent evt) {                                           
              
    }                                          

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {                                      
        
        Login l = new Login();
        l.setVisible(true);        
    }                                     

    private void create_store_keeperActionPerformed(java.awt.event.ActionEvent evt) {                                                    
       
         StoreKeeperAccount sca = new StoreKeeperAccount();
         sca.setVisible(true);
        
    }                                                   

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
        System.exit(0);
        
    }                                    

    private void view_all_menu_itemActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // For viewing all items
        JScrollPane spane_all = null;
        try {
            ResultSet r = connection.executeQuery("SELECT * FROM car_parts");
            
            JTable search_result = new JTable(fn.tableData(r),fn.colNames(r));
            search_result.setRowHeight(30);
            search_result.setFont(font);
            TableColumnModel columnModel = search_result.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(200);
            columnModel.getColumn(1).setPreferredWidth(200);
            columnModel.getColumn(2).setPreferredWidth(200);
            columnModel.getColumn(3).setPreferredWidth(200);
            columnModel.getColumn(4).setPreferredWidth(200);
            columnModel.getColumn(5).setPreferredWidth(200);
            columnModel.getColumn(6).setPreferredWidth(200);
            spane_all = new JScrollPane(search_result);
            spane_all.setPreferredSize(new Dimension(1415,500));
            
        } 
        
        catch(SQLException se){
            //file?
        }
        
        catch (Exception e) {
            System.out.println(e);
        }
        
        table_pnl.removeAll();
        table_pnl.repaint();
        table_pnl.add(spane_all);
        table_pnl.revalidate();
    }                                                  

    private void refresh_menu_itemActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // Refreshing the table
        String id = searcg_tf.getText();
        if(id != ""){
            // Searching:
            JScrollPane spane_search = null;
            try {
                ResultSet r = fn.searchItem(id);
                if(!r.next())
                    JOptionPane.showMessageDialog(null, "No results found!");
                JTable search_result = new JTable(fn.tableData(r),fn.colNames(r));
                search_result.setRowHeight(30);
                search_result.setFont(font);
                TableColumnModel columnModel = search_result.getColumnModel();
                columnModel.getColumn(0).setPreferredWidth(200);
                columnModel.getColumn(1).setPreferredWidth(200);
                columnModel.getColumn(2).setPreferredWidth(200);
                columnModel.getColumn(3).setPreferredWidth(200);
                columnModel.getColumn(4).setPreferredWidth(200);
                columnModel.getColumn(5).setPreferredWidth(200);
                columnModel.getColumn(6).setPreferredWidth(200);
                spane_search = new JScrollPane(search_result);
                spane_search.setPreferredSize(new Dimension(1415,500));

            } 
            
            catch(SQLException se){
                //file?
            }
            
            catch (Exception e) {
                System.out.println(e);
            }

            table_pnl.removeAll();
            table_pnl.repaint();
            table_pnl.add(spane_search);
            table_pnl.revalidate();
        
        }
        else{
            // For viewing all items
        JScrollPane spane_all = null;
        try {
            ResultSet r = connection.executeQuery("SELECT * FROM car_parts");
            
            JTable search_result = new JTable(fn.tableData(r),fn.colNames(r));
            search_result.setRowHeight(30);search_result.setFont(font);
            TableColumnModel columnModel = search_result.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(200);
            columnModel.getColumn(1).setPreferredWidth(200);
            columnModel.getColumn(2).setPreferredWidth(200);
            columnModel.getColumn(3).setPreferredWidth(200);
            columnModel.getColumn(4).setPreferredWidth(200);
            columnModel.getColumn(5).setPreferredWidth(200);
            columnModel.getColumn(6).setPreferredWidth(200);
            spane_all = new JScrollPane(search_result);
            spane_all.setPreferredSize(new Dimension(1415,500));
            
            } 
            catch(SQLException se){
                //file?
            }
            catch (Exception e) {
                System.out.println(e);
            }

            table_pnl.removeAll();
            table_pnl.repaint();
            table_pnl.add(spane_all);
            table_pnl.revalidate();
            }
          setLocationRelativeTo(null);
    }                                                 

    private void requester_nameActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // Searching:
        String id = searcg_tf.getText();
        JScrollPane spane_search = null;
        try {
            ResultSet r = fn.searchItem(id);
            if(!r.next())
                JOptionPane.showMessageDialog(null, "No results found!");
            JTable search_result = new JTable(fn.tableData(r),fn.colNames(r));
            search_result.setRowHeight(30);search_result.setFont(font);search_result.setEnabled(false);
            TableColumnModel columnModel = search_result.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(200);
            columnModel.getColumn(1).setPreferredWidth(200);
            columnModel.getColumn(2).setPreferredWidth(200);
            columnModel.getColumn(3).setPreferredWidth(200);
            columnModel.getColumn(4).setPreferredWidth(200);
            columnModel.getColumn(5).setPreferredWidth(200);
            columnModel.getColumn(6).setPreferredWidth(200);
            spane_search = new JScrollPane(search_result);
            spane_search.setPreferredSize(new Dimension(1415,500));
            
        } 
        catch(SQLException se){
            //file?
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        table_pnl.removeAll();
        table_pnl.repaint();
        table_pnl.add(spane_search);
        table_pnl.revalidate();
        
    }                                          

    private void request_btnActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           
    
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //multithreading
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Homepage hp = new Homepage();
                hp.setVisible(true);
                hp.setLocationRelativeTo(null);
            }
        });
    }
             
}

