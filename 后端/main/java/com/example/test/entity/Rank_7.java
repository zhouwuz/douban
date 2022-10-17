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
@TableName("rank_7")
@ApiModel(value = "", description = "")
public class Rank_7 {  //排行榜
    private static final long serialVersionUID = 1L;

    @TableId(value = "userid", type = IdType.AUTO)
    private int userid;//ID

    @ApiModelProperty("片名")
    private String areaname;//片名

    @ApiModelProperty("主演人数")
    private String price;//主演人数

    @ApiModelProperty("时间")
    private String time;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Rank_1{" +
                "userid=" + userid +
                ", areaname='" + areaname + '\'' +
                ", price='" + price + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
