/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author admin
 */
public class ProductBean {
 private Connection con;
 private PreparedStatement ps;
 private int code;
 
         private int price;
       private String name;
private String cat;
        private String disc;

          private byte []b;

    public ProductBean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   public ProductBean productsearch(){
        ProductBean bean=new ProductBean();

          try{
         Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restuarantmangmentdata","root","devchouhan123");
    String sql="SELECT * FROM PRODUCTS ";
  ps=con.prepareStatement(sql);
  ps.setInt(1, code);
 ResultSet rs= ps.executeQuery();
       rs.next();
       bean.setCode(rs.getInt(1));
       
       bean.setName(rs.getString(2));
bean.setDisc(rs.getString(3));
bean.setCat(rs.getString(4));
bean.setPrice(rs.getInt(5));
bean.setB(rs.getBytes(5));

          }catch(Exception e){
            e.printStackTrace();
        }

        
 return bean;   }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

     public byte[] getB() {
        return b;
    }

    public void setB(byte[] b) {
        this.b = b;
    }

}
