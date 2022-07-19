package cl.ucn.disc.dsm.pictwin.frontend.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public final class User {

    /**
     *
     *The Id
     */

    @Getter
    @Setter
    private Long Id;
    /**
     *
     *The email for the user
     */
    @Getter
    @Setter
    private String email;
    /**
     *
     *The password for the user
     */
    @Getter
    @Setter
    private String password;
    /**
     *
     *The strikes for the user/person
     */
    @Getter
    @Setter
    private int strikes;

    /**
     *
     *The Twins
     */
    @Getter
    @Setter
    private List<Twin> twins;

    public void add(final Twin twin){
        this.twins.add(twin);
    }

    public List<Twin> getTwin(){
        return twins;
    }


}
