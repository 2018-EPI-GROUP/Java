package cn.edu.xiyou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classmate {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private String hobby;
}
