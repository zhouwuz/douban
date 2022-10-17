package com.example.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("phb")
@ApiModel(value = "", description = "")
public class RankingList {  //排行榜
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private int id;//ID

    @ApiModelProperty("片名")
    private String name;//片名

    @ApiModelProperty("主演人数")
    private String nub;//主演人数
    @ApiModelProperty("主演")
    private String actor;//主演
    @ApiModelProperty("评分")
    private String sorce;//评分
    @ApiModelProperty("时间")
    private String time;
    @ApiModelProperty("类型")
    private String type;
    @ApiModelProperty("评论数")
    private String sum;//评论数
    @ApiModelProperty("国家")
    private String cou;//国家

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNub() {
        return nub;
    }

    public void setNub(String nub) {
        this.nub = nub;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getSorce() {
        return sorce;
    }

    public void setSorce(String sorce) {
        this.sorce = sorce;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getCou() {
        return cou;
    }

    public void setCou(String cou) {
        this.cou = cou;
    }

    @Override
    public String toString() {
        return "RankingList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nub='" + nub + '\'' +
                ", actor='" + actor + '\'' +
                ", sorce='" + sorce + '\'' +
                ", time='" + time + '\'' +
                ", type='" + type + '\'' +
                ", sum='" + sum + '\'' +
                ", cou='" + cou + '\'' +
                '}';
    }
}
