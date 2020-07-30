 package com.blog.entity;

 import java.util.Date;

 public class Comment {
     private Integer id;
     private String userip;
     private String content;
     private Blog blog;
     private Date commentdate;
     private Integer state;

     public Comment() {
     }

     public Comment(Integer id, String userip, String content, Blog blog, Date commentdate, Integer state) {
         this.id = id;
         this.userip = userip;
         this.content = content;
         this.blog = blog;
         this.commentdate = commentdate;
         this.state = state;
     }

     public Integer getId() {
         return id;
     }

     public void setId(Integer id) {
         this.id = id;
     }

     public String getUserip() {
         return userip;
     }

     public void setUserip(String userip) {
         this.userip = userip;
     }

     public String getContent() {
         return content;
     }

     public void setContent(String content) {
         this.content = content;
     }

     public Blog getBlog() {
         return blog;
     }

     public void setBlog(Blog blog) {
         this.blog = blog;
     }

     public Date getCommentdate() {
         return commentdate;
     }

     public void setCommentdate(Date commentdate) {
         this.commentdate = commentdate;
     }

     public Integer getState() {
         return state;
     }

     public void setState(Integer state) {
         this.state = state;
     }

     @Override
     public String toString() {
         return "Comment{" +
                 "id=" + id +
                 ", userip='" + userip + '\'' +
                 ", content='" + content + '\'' +
                 ", blog=" + blog +
                 ", commentdate=" + commentdate +
                 ", state=" + state +
                 '}';
     }
 }


