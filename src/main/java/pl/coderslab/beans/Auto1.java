package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Auto1 {
    private Auto2 auto2;

    @Autowired
    public void setAuto2(Auto2 auto2){
        this.auto2 = auto2;
    }

    public Auto2 getAuto2() {
        return auto2;
    }
}
