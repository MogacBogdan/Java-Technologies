package com.example.laboratory3.beans;

import com.example.laboratory3.listeners.SessionCounter;
import lombok.Getter;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Getter
@ManagedBean
@SessionScoped
@Named
public class ActiveSessionsBean implements Serializable {
    private int count = 1;

    public void checkSessionCounter() {
        count = SessionCounter.getSessionCount();
    }
}
