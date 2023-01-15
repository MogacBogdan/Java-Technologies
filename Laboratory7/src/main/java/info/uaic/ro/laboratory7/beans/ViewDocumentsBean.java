package info.uaic.ro.laboratory7.beans;

import info.uaic.ro.laboratory7.entities.Document;
import info.uaic.ro.laboratory7.services.DocumentService;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Setter
@Named
@SessionScoped
public class ViewDocumentsBean implements Serializable {
    @Inject
    private DocumentService documentService;

    private List<Document> documents;

    @PostConstruct
    public void init() {
        documents = documentService.findAll();
    }

    public List<Document> getDocuments() {
        documents = documentService.findAll();
        return documents;
    }

}
