package com.example.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 周wz
 * @since 2022-06-08
 */
@Getter
@Setter
@TableName("lishi")
@ApiModel(value = "lishi", description = "")
public class Lishi implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("账号")
    private String account;

    @ApiModelProperty("数据量")
    private String num;

    @ApiModelProperty("时间")
    private String time;


    @ApiModelProperty("规则")
    private String a;

    @Override
    public String toString() {
        return "Lishi{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", num='" + num + '\'' +
                ", time='" + time + '\'' +
                ", a='" + a + '\'' +
                '}';
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
