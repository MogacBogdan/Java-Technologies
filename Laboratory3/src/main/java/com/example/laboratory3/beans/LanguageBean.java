package com.example.laboratory3.beans;

import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Locale;

@Named
@SessionScoped
public class LanguageBean implements Serializable {
    @Getter private Locale locale;

    @PostConstruct
    public void init() {
        locale = new Locale("en");
        Locale.setDefault(locale);
    }

    public void setLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
}
