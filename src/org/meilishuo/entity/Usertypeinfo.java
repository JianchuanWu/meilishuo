package org.meilishuo.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Usertypeinfo entity. @author MyEclipse Persistence Tools
 */

public class Usertypeinfo  implements java.io.Serializable {


    // Fields    

     private Integer utid;
     private String utname;


    // Constructors

    /** default constructor */
    public Usertypeinfo() {
    }

	/** minimal constructor */
    public Usertypeinfo(String utname) {
        this.utname = utname;
    }
    

   
    // Property accessors

    public Integer getUtid() {
        return this.utid;
    }
    
    public void setUtid(Integer utid) {
        this.utid = utid;
    }

    public String getUtname() {
        return this.utname;
    }
    
    public void setUtname(String utname) {
        this.utname = utname;
    }








}