package com.wms.user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * description:用户实体
 * Author:Childwanwan
 * Date:2019/1/16 16:37
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("tbl_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;            //用户id
    private String weChatId;    //微信id
    private String qqId;        //企鹅id
    private String telephone;   //电话
    private String username;    //用户名
    private String nickname;    //昵称
    private String password;    //密码
    private String idcard;      //身份证号
    private Integer age;        //年龄
    private Date birthday;      //出生日期
    private String email;       //邮箱
    private Date createTime;    //注册时间
    private String headImg;     //头像地址
    private Integer likeCount;  //被赞次数
    private Integer status;     //状态信息

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
