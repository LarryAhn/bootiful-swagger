package com.geekswise;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Data
    @ApiModel(value = "유저 Save Dto")
    public static class save {

        @NotBlank(message = "유저 이름은 필수 값 입니다.")
        @ApiModelProperty(value = "이름", position = 1, required = true)
        private String name;

    }

}
