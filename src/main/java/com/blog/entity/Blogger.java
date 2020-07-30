 package com.blog.entity;

 public class Blogger
 {
     /**主键*/
   private Integer id;
     /**用户名*/
   private String username;
     /**密码*/
   private String password;
     /**昵称*/
   private String nickname;
     /**个性签名*/
   private String sign;
     /**个人信息*/
   private String profile;
     /**头像地址*/
   private String imagename;

     public Blogger() {
     }

     public Blogger(Integer id, String username, String password, String nickname, String sign, String profile, String imagename) {
         this.id = id;
         this.username = username;
         this.password = password;
         this.nickname = nickname;
         this.sign = sign;
         this.profile = profile;
         this.imagename = imagename;
     }

     public Integer getId() {
         return id;
     }

     public void setId(Integer id) {
         this.id = id;
     }

     public String getUsername() {
         return username;
     }

     public void setUsername(String username) {
         this.username = username;
     }

     public String getPassword() {
         return password;
     }

     public void setPassword(String password) {
         this.password = password;
     }

     public String getNickname() {
         return nickname;
     }

     public void setNickname(String nickname) {
         this.nickname = nickname;
     }

     public String getSign() {
         return sign;
     }

     public void setSign(String sign) {
         this.sign = sign;
     }

     public String getProfile() {
         return profile;
     }

     public void setProfile(String profile) {
         this.profile = profile;
     }

     public String getImagename() {
         return imagename;
     }

     public void setImagename(String imagename) {
         this.imagename = imagename;
     }

     @Override
     public String toString() {
         return "Blogger{" +
                 "id=" + id +
                 ", username='" + username + '\'' +
                 ", password='" + password + '\'' +
                 ", nickname='" + nickname + '\'' +
                 ", sign='" + sign + '\'' +
                 ", profile='" + profile + '\'' +
                 ", imagename='" + imagename + '\'' +
                 '}';
     }
 }



