package com.company.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDTO {

    @Pattern(regexp = "^([a-z0-9_.-]+)@([a-z0-9_-]+).([a-z]{2,6})$",message = "{input.email}")
    private String email;

    @NotBlank(message = "{input.password}")
    private String password;
}
