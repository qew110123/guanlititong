package yineng.datacenter.manager.entity;

import java.util.Date;

public class ArtCount {
    private Long id;

    private String classOne;

    private String classTwo;

    private String classThree;

    private Long countNum;

    private String countData;

    private Date data;

    private Date updata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassOne() {
        return classOne;
    }

    public void setClassOne(String classOne) {
        this.classOne = classOne == null ? null : classOne.trim();
    }

    public String getClassTwo() {
        return classTwo;
    }

    public void setClassTwo(String classTwo) {
        this.classTwo = classTwo == null ? null : classTwo.trim();
    }

    public String getClassThree() {
        return classThree;
    }

    public void setClassThree(String classThree) {
        this.classThree = classThree == null ? null : classThree.trim();
    }

    public Long getCountNum() {
        return countNum;
    }

    public void setCountNum(Long countNum) {
        this.countNum = countNum;
    }

    public String getCountData() {
        return countData;
    }

    public void setCountData(String countData) {
        this.countData = countData == null ? null : countData.trim();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getUpdata() {
        return updata;
    }

    public void setUpdata(Date updata) {
        this.updata = updata;
    }
}