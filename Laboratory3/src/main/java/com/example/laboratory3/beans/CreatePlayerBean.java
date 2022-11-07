package com.example.laboratory3.beans;

import com.example.laboratory3.services.PlayerService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Named
@SessionScoped
public class CreatePlayerBean implements Serializable {
    @Inject
    private PlayerService playerService;
}
