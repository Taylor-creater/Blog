package com.blog.entity;

 import java.io.Serializable;

 public class BlogType
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
   private Integer id;
   private String typename;
   private Integer blogcount;
   private Integer orderno;

     public BlogType() {
     }

     public BlogType(Integer id, String typename, Integer blogcount, Integer orderno) {
         this.id = id;
         this.typename = typename;
         this.blogcount = blogcount;
         this.orderno = orderno;
     }

     public Integer getId() {
         return id;
     }

     public void setId(Integer id) {
         this.id = id;
     }

     public String getTypename() {
         return typename;
     }

     public void setTypename(String typename) {
         this.typename = typename;
     }

     public Integer getBlogcount() {
         return blogcount;
     }

     public void setBlogcount(Integer blogcount) {
         this.blogcount = blogcount;
     }

     public Integer getOrderno() {
         return orderno;
     }

     public void setOrderno(Integer orderno) {
         this.orderno = orderno;
     }

     @Override
     public String toString() {
         return "BlogType{" +
                 "id=" + id +
                 ", typename='" + typename + '\'' +
                 ", blogcount=" + blogcount +
                 ", orderno=" + orderno +
                 '}';
     }
 }



