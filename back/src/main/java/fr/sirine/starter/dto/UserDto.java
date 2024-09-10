package fr.sirine.starter.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Integer id;

    @NonNull
    @Size(max = 50)
    @Email
    private String email;

    @NonNull
    @Size(max = 20)
    private String pseudo;



}
