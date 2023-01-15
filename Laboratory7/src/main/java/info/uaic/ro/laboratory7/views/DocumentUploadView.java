package info.uaic.ro.laboratory7.views;

import info.uaic.ro.laboratory7.beans.TimeFrameBean;
import info.uaic.ro.laboratory7.entities.Document;
import info.uaic.ro.laboratory7.services.DocumentService;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Getter
@Setter
@Named
@RequestScoped
public class DocumentUploadView {
    private UploadedFile document;

    @Inject
    DocumentService documentService;

    @Inject
    TimeFrameBean timeFrameBean;

    public void upload() {
        if (!timeFrameBean.canUpload()) return;
        if (document == null) return;

        documentService.persist(new Document("author", document));
        FacesMessage message = new FacesMessage("Successful", document.getFileName() + " is uploaded !");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}