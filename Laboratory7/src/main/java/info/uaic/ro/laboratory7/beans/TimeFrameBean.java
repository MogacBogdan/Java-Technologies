package info.uaic.ro.laboratory7.beans;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Named
@ApplicationScoped
public class TimeFrameBean implements Serializable {
    @Inject
    TimeFrameStoreBean timeFrameStoreBean;
    private String beginHour;
    private String endHour;

    public boolean canUpload() {
        int currentHour = getCurrentHour();
        return currentHour >= timeFrameStoreBean.getBeginHour() && currentHour < timeFrameStoreBean.getEndHour();
    }

    public void save() {
        timeFrameStoreBean.setBeginHour(Integer.parseInt(beginHour));
        timeFrameStoreBean.setEndHour(Integer.parseInt(endHour));
    }

    private int getCurrentHour() {
        LocalDateTime now = LocalDateTime.now();
        int currentHour = now.getHour(); // between 0 and 23
        if (currentHour == 0)
            return 24;
        return currentHour;
    }

}
