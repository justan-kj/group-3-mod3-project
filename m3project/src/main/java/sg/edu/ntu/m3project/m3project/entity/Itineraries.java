package sg.edu.ntu.m3project.m3project.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="itineraries")
public class Itineraries {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  Integer id;

  @OneToOne
  @JoinColumn(name="user_id")
  User user;

  @OneToOne
  @JoinColumn(name="transport_id")
  Transport transport_id;

  @OneToOne
  @JoinColumn(name="accommodation_id")
  Accommodation accommodation_id;

  String destination_city;

  String destination_country;

  Date destination_start_date;

  Date destination_end_date;
  
  Float budget;

  @Column(name="created_at", updatable= false)
  Timestamp createdAt = new Timestamp(new Date().getTime());
}
