package com.imooc.pojo.vo;

import java.util.List;

public class NewItemsVO {
   private Integer  rootCatId;
   private String rootCatName;
   private String slogan;
   private String catImage;
   private String bgColor;
   private List<SimpleItemVO> simpleItemList;

    public int getRootCatId() {
        return rootCatId;
    }

    public void setRootCatId(int rootCatId) {
        this.rootCatId = rootCatId;
    }

    public String getRootCatName() {
        return rootCatName;
    }

    public void setRootCatName(String rootCatName) {
        this.rootCatName = rootCatName;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getCatImage() {
        return catImage;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }
}
