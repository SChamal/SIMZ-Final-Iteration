/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simz1;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class ProductDetails {
    private int productID;
    private String productType;
    private String productName;
    private double receivingPrice;
    private double sellingPrice;
    private String date;                            ///?????????? How can we store date??

    public int getProductID() {
        return productID;
    }
    
    public void setProductID(int id) {
        this.productID = id;
    }
    /**
     * @return the productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the receivingPrice
     */
    public double getReceivingPrice() {
        return receivingPrice;
    }

    /**
     * @param receivingPrice the receivingPrice to set
     */
    public void setReceivingPrice(double receivingPrice) {
        this.receivingPrice = receivingPrice;
    }

    /**
     * @return the sellingPrice
     */
    public double getSellingPrice() {
        return sellingPrice;
    }

    /**
     * @param sellingPrice the sellingPrice to set
     */
    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    
}
