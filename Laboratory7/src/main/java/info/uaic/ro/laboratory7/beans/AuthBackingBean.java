package info.uaic.ro.laboratory7.beans;

import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;

@Named
@Dependent
public class AuthBackingBean implements Serializable {
    String HOME_URL = "http://localhost:8080/Laboratory7-1.0-SNAPSHOT/";

    public void logout() {
        try {
            logoutAndRedirect();
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void logoutAndRedirect() throws ServletException, IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        request.logout();
        context.getExternalContext().redirect(HOME_URL);
    }
}
