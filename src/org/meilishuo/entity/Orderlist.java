package org.meilishuo.entity;



/**
 * Orderlist entity. @author MyEclipse Persistence Tools
 */

public class Orderlist  implements java.io.Serializable {


    // Fields    

     private String olid;
     private Orderinfo orderinfo;
     private Integer gdcount;
     private Double price;
     private Goodsinfo goodsinfo;

    // Constructors

    /** default constructor */
    public Orderlist() {
    }

    
  
    // Property accessors

    public String getOlid() {
        return this.olid;
    }
    
    public void setOlid(String olid) {
        this.olid = olid;
    }

    public Orderinfo getOrderinfo() {
        return this.orderinfo;
    }
    
    public void setOrderinfo(Orderinfo orderinfo) {
        this.orderinfo = orderinfo;
    }

    public Integer getGdcount() {
        return this.gdcount;
    }
    
    public void setGdcount(Integer gdcount) {
        this.gdcount = gdcount;
    }

    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }



	public Goodsinfo getGoodsinfo() {
		return goodsinfo;
	}



	public void setGoodsinfo(Goodsinfo goodsinfo) {
		this.goodsinfo = goodsinfo;
	}
   
    







}