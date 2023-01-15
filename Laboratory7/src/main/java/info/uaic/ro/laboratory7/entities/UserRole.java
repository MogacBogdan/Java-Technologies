package info.uaic.ro.laboratory7.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserRole {
    private String username;
    private String userRole;
}
