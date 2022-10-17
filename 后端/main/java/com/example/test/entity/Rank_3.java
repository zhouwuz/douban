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
@TableName("rank_3")
@ApiModel(value = "", description = "")
public class Rank_3 {  //排行榜
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private int id;//ID

    @ApiModelProperty("评分")
    private String score;//片名

    @ApiModelProperty("数量")
    private String num;//主演人数

    @ApiModelProperty("时间")
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Rank_3{" +
                "id=" + id +
                ", score='" + score + '\'' +
                ", num='" + num + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
