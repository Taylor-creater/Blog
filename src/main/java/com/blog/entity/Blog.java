package com.blog.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Blog
        implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String title;
    private String summary;
    private Date releasedate;
    private Integer clickhit;
    private Integer replyhit;
    private String content;
    /**
     * 纯文本内容
     */
    private String contentnotag;
    private BlogType blogType;
    private Integer blogcount;
    private String releasedatestr;
    private String keyword;
    private List<String> imagesList = new LinkedList();

    public Blog() {
    }

    public Blog(Integer id, String title, String summary, Date releasedate, Integer clickhit, Integer replyhit, String content, String contentnotag, BlogType blogType, Integer blogcount, String releasedatestr, String keyword, List<String> imagesList) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.releasedate = releasedate;
        this.clickhit = clickhit;
        this.replyhit = replyhit;
        this.content = content;
        this.contentnotag = contentnotag;
        this.blogType = blogType;
        this.blogcount = blogcount;
        this.releasedatestr = releasedatestr;
        this.keyword = keyword;
        this.imagesList = imagesList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public Integer getClickhit() {
        return clickhit;
    }

    public void setClickhit(Integer clickhit) {
        this.clickhit = clickhit;
    }

    public Integer getReplyhit() {
        return replyhit;
    }

    public void setReplyhit(Integer replyhit) {
        this.replyhit = replyhit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentnotag() {
        return contentnotag;
    }

    public void setContentnotag(String contentnotag) {
        this.contentnotag = contentnotag;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }

    public Integer getBlogcount() {
        return blogcount;
    }

    public void setBlogcount(Integer blogcount) {
        this.blogcount = blogcount;
    }

    public String getReleasedatestr() {
        return releasedatestr;
    }

    public void setReleasedatestr(String releasedatestr) {
        this.releasedatestr = releasedatestr;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<String> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<String> imagesList) {
        this.imagesList = imagesList;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", releasedate=" + releasedate +
                ", clickhit=" + clickhit +
                ", replyhit=" + replyhit +
                ", content='" + content + '\'' +
                ", contentnotag='" + contentnotag + '\'' +
                ", blogType=" + blogType +
                ", blogcount=" + blogcount +
                ", releasedatestr='" + releasedatestr + '\'' +
                ", keyword='" + keyword + '\'' +
                ", imagesList=" + imagesList +
                '}';
    }
}




