package info.uaic.ro.laboratory7.entities;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private String username;
    private String password;
}