 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simz2;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author CHAM PC
 */
public class DBOperations {

    String url = "jdbc:mysql://localhost:3306/simz";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement st =null;
    
    
    /////////////////////////////////////////USER DETAILS/////////////////////////////////////////////////////

    boolean addEmployee(EmployeeDetails ed) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO employeedetails VALUES(?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setInt(1, ed.getEmpId());//add values to the sql query
            pst.setString(2, ed.getFirstName());//add values to the sql query
            pst.setString(3, ed.getLastName());//add values to the sql query
            pst.setString(4, ed.getDesignation());//add values to the sql query
            pst.setString(5, ed.getUserName());//add values to the sql query
            pst.setString(6, ed.getPassword());//add values to the sql query
            pst.setString(7, ed.getPropic());//add values to the sql query
            pst.setString(8, ed.getHint());//add values to the sql query
            pst.setString(9,ed.getNIC()); //add values to the sql query

            pst.executeUpdate();//execute the sql query and insert the values to the db table
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

            }
        }

    }
    
    int removeUser(int empID, String NIC ){
        try{
            con = (Connection)DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM employeedetails WHERE emp_id = ?  AND NICno = ? ";
            pst =(PreparedStatement)con.prepareStatement(query);
            
            pst.setInt(1, empID);
            pst.setString(2, NIC);
            
            pst.executeUpdate();
            return 1; //true: successfully removed
        }catch(SQLException e){
            System.out.println(e);
            return 0; //false: user didn't remove successfully
        }
    }

    int checkUserName(String userName) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "SELECT user_name FROM employeedetails";
            
            pst = (PreparedStatement) con.prepareStatement(query); 
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                if(userName.equals(rs.getString(1))){
                    return 0;//the provided username already exists in the db
                }
            }
            return 1;//the provided username does not exist in the db
            
        } catch (SQLException e) {
            System.out.println(e);
            return 2;//an error occured while executing
            
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

            }
        }
    }
    
    int checkLogin(String userName, String pswrd){
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "SELECT user_name,password,designation FROM employeedetails";
            
            pst = (PreparedStatement) con.prepareStatement(query); 
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                if(userName.equals(rs.getString(1)) && pswrd.equals(rs.getString(2)) && rs.getString(3).equals("Manager")){
                    return 1;//the provided username & password matched
                }else if(userName.equals(rs.getString(1)) && pswrd.equals(rs.getString(2)) && rs.getString(3).equals("Sales Person")){
                    return 11;//the provided username & password matched
                }
                else if(userName.equals(rs.getString(1)) && !(pswrd.equals(rs.getString(2)))){
                    return 2;//the provided password does not exist in the db
                }
            }
            return 0;//the provided username & password do not exist in the db
            
        } catch (SQLException e) {
            System.out.println(e);
            return 3;//an error occured while executing
            
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

            }
        }
    }
    
    String getPropic(String userName){
        try{
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "SELECT user_name,profile_pic FROM employeedetails";
            
            pst = (PreparedStatement) con.prepareStatement(query); 
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                if(userName.equals(rs.getString(1))){
                    return rs.getString(2);//the provided username matched
                }
                /*else if(!userName.equals(rs.getString(1))){
                    return null;//the provided username does not exist in the db
                }*/
            }
        }catch(SQLException x){
            System.out.println(x);
            return null;
        }
        finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

            }
        }
        return null;
    }
    
    String getHint(String userName){
        try{
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "SELECT user_name,password_hint FROM employeedetails";
            
            pst = (PreparedStatement) con.prepareStatement(query); 
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                if(userName.equals(rs.getString(1))){
                    return rs.getString(2);//the provided username matched
                }
                /*else if(!userName.equals(rs.getString(1))){
                    return null;//the provided username does not exist in the db
                }*/
            }
        }catch(SQLException x){
            System.out.println(x);
            return null;
        }
        finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

            }
        }
        return null;
    }
    
    boolean addProPic(String pic, String userName) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "UPDATE employeedetails SET profile_pic = ? WHERE user_name = ?";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setString(1, pic);//add values to the sql query
            pst.setString(2, userName);//add values to the sql query

            pst.executeUpdate();//execute the sql query and insert the values to the db table
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

            }
        }

    }
    
    EmployeeDetails getDetails(EmployeeDetails ed, String userName){
        try{
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "SELECT first_name,last_name,emp_id,user_name FROM employeedetails";
            
            pst = (PreparedStatement) con.prepareStatement(query);
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                if(userName.equals(rs.getString(4))){
                    ed.setFirstName(rs.getString(1));
                    ed.setLastName(rs.getString(2));
                    ed.setEmpId(rs.getInt(3));
                    ed.setUserName(rs.getString(4));
            
                    return ed;
                }
            }
            return null;
            
        }catch(SQLException x){
            System.out.println(x);
            return null;
        }
        finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

            }
        } 
    }
    
    boolean updateName(String name1, String name2, int id){
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "UPDATE employeedetails SET first_name = ?, last_name = ? WHERE emp_id = ?";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setString(1, name1);//add values to the sql query
            pst.setString(2, name2);//add values to the sql query
            pst.setInt(3, id);//add values to the sql query

            pst.executeUpdate();//execute the sql query and insert the values to the db table
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

            }
        }   
    }
    
    boolean updateUserName(String name, int id){
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "UPDATE employeedetails SET user_name = ? WHERE emp_id = ?";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setString(1, name);//add values to the sql query
            pst.setInt(2, id);//add values to the sql query

            pst.executeUpdate();//execute the sql query and insert the values to the db table
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

            }
        }
    }
    
    boolean updatePswrd(String ps,String hnt, int id){
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "UPDATE employeedetails SET password = ?, password_hint = ? WHERE emp_id = ?";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setString(1, ps);//add values to the sql query
            pst.setString(2, hnt);//add values to the sql query
            pst.setInt(3, id);//add values to the sql query

            pst.executeUpdate();//execute the sql query and insert the values to the db table
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

            }
        }
    }
    
    int checkPasswrd(String pswrd, int id) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "SELECT emp_id,password FROM employeedetails";
            
            pst = (PreparedStatement) con.prepareStatement(query); 
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                if(id==(rs.getInt(1)) && pswrd.equals(rs.getString(2))){
                    return 1;//the provided password matches with the id
                }else if(id==(rs.getInt(1)) && !pswrd.equals(rs.getString(2))){
                    return 2; // the provided password mismatched with the id
                }
            }
            return 0;//the provided password isn't in the db
            
        } catch (SQLException e) {
            System.out.println(e);
            return 3;//an error occured while executing
            
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

            }
        }
    }
    boolean checkPassword(String pswd){
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "SELECT designation, password  FROM employeedetails ";
            
            pst = (PreparedStatement) con.prepareStatement(query); 
            rs = pst.executeQuery();
            while(rs.next()){
                if((rs.getString(1)=="Manager") &&  pswd.equals(rs.getString(2))){
                    return true;//the provided password matches with the id
                }
            }
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
            
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

            }
        }
    }
    
    /*boolean addToUsersTable(){
        try{
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "SELECT emp_id,first_name,last_name,NICno FROM employeedetails ";
            
            st = con.createStatement();
            rs = st.executeQuery(query);
            ResultSetMetaData rsmt = rs.getMetaData();
            
            int columnCount = rsmt.getColumnCount();
            Vector column = new Vector(columnCount);
            
            for(int i=1;i<=columnCount;i++){
                column.add(rsmt.getColumnName(i));
            }

            Vector data = new Vector();
            Vector row =new Vector();
            
            while(rs.next()){
                row = new Vector();
                for(int i =1;i<=columnCount;i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
            
            //JTable table = new JTable(data,column);
                res.column=column;
                res.data = data;
            }return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error !!");
            return false;
        }finally{
            try{
                st.close();
                rs.close();
                con.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error in the process");
            }
        }
    }*/
    
    //////////////////////////////////////////STOCK DETAILS////////////////////////////////////////
    
    boolean addProduct(ProductDetails pd){
        try{
            con=(Connection)DriverManager.getConnection(url, username, password);
            String query ="INSERT INTO productdetails VALUES(?,?,?,?,?,?)";
            pst=(PreparedStatement)con.prepareStatement(query);
            
            pst.setInt(1, pd.getProductID());
            pst.setString(2, pd.getProductType());
            pst.setString(3, pd.getProductName());
            pst.setDouble(4, pd.getReceivingPrice());
            pst.setDouble(5, pd.getSellingPrice());
            pst.setString(6, pd.getDate());
            
            pst.executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }finally{
            try{
                if(pst!=null){
                    pst.close();
                }
                if(con!=null){
                    con.close();
                }
            }catch(SQLException e){
                System.out.println(e);
            }
        }
    }
    int removeProduct(int productID, String productType ){
        try{
            con = (Connection)DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM productdetails WHERE productID = ?  AND productType = ? ";
            pst =(PreparedStatement)con.prepareStatement(query);
            
            pst.setInt(1, productID);
            pst.setString(2, productType);
            
            pst.executeUpdate();
            return 1; //true: successfully removed
        }catch(SQLException e){
            System.out.println(e);
            return 0; //false: user didn't remove successfully
        }
    }
    String getName(String name){
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "SELECT first_name,last_name FROM employeedetails WHERE user_name = ?";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setString(1, name);//add values to the sql query
            rs= pst.executeQuery();
            while(rs.next()){
                String tmp = rs.getString(1)+ " " + rs.getString(2);
                return tmp;
            }

        } catch (SQLException e) {
            System.out.println(e);
            return "";
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

            }
        }
        return "";
    }

    String getId(String name){
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "SELECT emp_id FROM employeedetails WHERE user_name = ?";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setString(1, name);//add values to the sql query
            rs= pst.executeQuery();
            while(rs.next()){
                String tmp = rs.getString(1);
                return tmp;
            }

        } catch (SQLException e) {
            System.out.println(e);
            return "";
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

            }
        }
        return "";
    }

}

