package info.uaic.ro.laboratory7.services;

import info.uaic.ro.laboratory7.entities.Document;
import info.uaic.ro.laboratory7.interceptors.DocumentInterceptor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

@Named
@Transactional
@ApplicationScoped
@Interceptors(DocumentInterceptor.class)
public class DocumentService {
    final static String API_URL = "http://localhost:8080/RestService-1.0-SNAPSHOT/api";
    final static String GET_ALL_DOCUMENTS = API_URL + "/documents";
    final static String ADD_DOCUMENT = API_URL + "/documents";

    public List<Document> findAll() {
        try {
            return ClientBuilder.newClient()
                    .target(URI.create(new URL(GET_ALL_DOCUMENTS).toExternalForm()))
                    .request(MediaType.APPLICATION_JSON)
                    .get()
                    .readEntity(new GenericType<List<Document>>() {});
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public void persist(Document document) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = ClientBuilder.newClient().target(URI.create(new URL(ADD_DOCUMENT).toExternalForm()));
            Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
            Entity<Document> entity = Entity.entity(document, MediaType.APPLICATION_JSON);
            builder.post(entity);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
