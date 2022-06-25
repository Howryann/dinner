package cs.study.dinner.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Employee {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    private String name;

    private String password;

    private int status;

    private String sex;

    private String idNumber;

    private String phone;

}
