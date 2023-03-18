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
 public class Itinerary {

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

   public Integer getId() {
     return id;
   }

   public void setId(Integer id) {
     this.id = id;
   }

   public User getUser() {
     return user;
   }

   public void setUser(User user) {
     this.user = user;
   }

   public Transport getTransport_id() {
     return transport_id;
   }

   public void setTransport_id(Transport transport_id) {
     this.transport_id = transport_id;
   }

   public Accommodation getAccommodation_id() {
     return accommodation_id;
   }

   public void setAccommodation_id(Accommodation accommodation_id) {
     this.accommodation_id = accommodation_id;
   }

   public String getDestination_city() {
     return destination_city;
   }

   public void setDestination_city(String destination_city) {
     this.destination_city = destination_city;
   }

   public String getDestination_country() {
     return destination_country;
   }

   public void setDestination_country(String destination_country) {
     this.destination_country = destination_country;
   }

   public Date getDestination_start_date() {
     return destination_start_date;
   }

   public void setDestination_start_date(Date destination_start_date) {
     this.destination_start_date = destination_start_date;
   }

   public Date getDestination_end_date() {
     return destination_end_date;
   }

   public void setDestination_end_date(Date destination_end_date) {
     this.destination_end_date = destination_end_date;
   }

   public Float getBudget() {
     return budget;
   }

   public void setBudget(Float budget) {
     this.budget = budget;
   }

   public Timestamp getCreatedAt() {
     return createdAt;
   }

   public void setCreatedAt(Timestamp createdAt) {
     this.createdAt = createdAt;
   }

 }