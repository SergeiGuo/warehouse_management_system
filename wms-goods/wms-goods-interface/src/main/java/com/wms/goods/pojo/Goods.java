package com.wms.goods.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author childwanwan
 * @since 2019-01-17
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("tbl_goods")
public class Goods extends Model<Goods> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    private String sequenceId;
    private String name;
    private Date createTime;
    private Integer damagedCondition;
    private String providerId;
    private String goodsDescription;
    private BigDecimal price;
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
