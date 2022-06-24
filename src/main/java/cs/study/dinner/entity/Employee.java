package cs.study.dinner.entity;

import lombok.Data;

@Data
public class Employee {

    private Long id;

    private String username;

    private String name;

    private String password;

    private int status;
}
