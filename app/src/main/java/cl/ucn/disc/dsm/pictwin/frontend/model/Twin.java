package cl.ucn.disc.dsm.pictwin.frontend.model;

import lombok.Getter;
import lombok.Setter;

public final class Twin {

    /**
     *
     *The Id
     */
    @Getter
    @Setter
    private Long Id;
    /**
     *
     *The dislike
     */
    @Getter
    @Setter
    private Boolean dislike;
    /**
     *
     *The pic my
     */
    @Getter
    @Setter
    private Pic my;
    /**
     *
     *The pic yours
     */
    @Getter
    @Setter
    private Pic yours;

    @Getter
    @Setter
    private User owner;


}
