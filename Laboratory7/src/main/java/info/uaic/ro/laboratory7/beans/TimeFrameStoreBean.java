package info.uaic.ro.laboratory7.beans;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;

@Singleton
@Getter
@Setter
@Named
@ApplicationScoped
public class TimeFrameStoreBean implements Serializable {
    private int beginHour;
    private int endHour;

    @PostConstruct
    public void init() {
        beginHour = 0;
        endHour = 0;
    }
}
