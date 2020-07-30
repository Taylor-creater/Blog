 package com.blog.entity;

 public class Link {
     private Integer id;
     private String linkname;
     private String linkurl;
     private Integer orderno;

     public Link() {
     }

     public Link(Integer id, String linkname, String linkurl, Integer orderno) {
         this.id = id;
         this.linkname = linkname;
         this.linkurl = linkurl;
         this.orderno = orderno;
     }

     public Integer getId() {
         return id;
     }

     public void setId(Integer id) {
         this.id = id;
     }

     public String getLinkname() {
         return linkname;
     }

     public void setLinkname(String linkname) {
         this.linkname = linkname;
     }

     public String getLinkurl() {
         return linkurl;
     }

     public void setLinkurl(String linkurl) {
         this.linkurl = linkurl;
     }

     public Integer getOrderno() {
         return orderno;
     }

     public void setOrderno(Integer orderno) {
         this.orderno = orderno;
     }

     @Override
     public String toString() {
         return "Link{" +
                 "id=" + id +
                 ", linkname='" + linkname + '\'' +
                 ", linkurl='" + linkurl + '\'' +
                 ", orderno=" + orderno +
                 '}';
     }
 }

