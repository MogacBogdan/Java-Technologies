package info.uaic.ro.laboratory7.entities;

import lombok.*;
import org.primefaces.model.file.UploadedFile;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Document implements Serializable {
    private Integer registrationNumber;
    private String author;
    private UploadedFile file;

    public Document(String author, UploadedFile file) {
        this.author = author;
        this.file = file;
    }
}
