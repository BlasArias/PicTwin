package cl.ucn.disc.dsm.pictwin.frontend.model;

import java.time.ZonedDateTime;

import lombok.Getter;
import lombok.Setter;

public final class Pic {

 /**
  *
  *The Id
  */
 @Getter
 @Setter
 private Long Id;

 /**
  *
  *The ZonedDateTime Pic was saved.
  */
 @Getter
 @Setter
 private ZonedDateTime timestamp;

 /**
  *
  *The dislikes
  */
 @Getter
 @Setter
 private Integer dislikes;

 /**
  *
  *The latitude
  */
 @Getter
 @Setter
 private Double latitude;

 /**
  *
  *The longitude
  */
 @Getter
 @Setter
 private Double longitude;

 /**
  *
  *The error
  */
 @Getter
 @Setter
 private Double error;

 /**
  *
  *The views
  */
 @Getter
 @Setter
 private Integer views;

 /*
  *The views
  */
 @Getter
 @Setter
 private String name;

 /*
  *The views
  */
 @Getter
 @Setter
 private byte[] picture;

 /*
  *The views
  */
 @Getter
 @Setter
 private User owner;



}
