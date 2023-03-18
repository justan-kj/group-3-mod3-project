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

   String destinationCity;
   String destinationCountry;
   Date destinationStartDate;
   Date destinationEndDate;
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

   public String getDestinationCity() {
     return destinationCity;
   }

   public void setdestinationCity(String destinationCity) {
     this.destinationCity = destinationCity;
   }

   public String getDestinationCountry() {
     return destinationCountry;
   }

   public void setDestinationCountry(String destinationCountry) {
     this.destinationCountry = destinationCountry;
   }

   public Date getDestinationStartDate() {
     return destinationStartDate;
   }

   public void setDestinationStartDate(Date destinationStartDate) {
     this.destinationStartDate = destinationStartDate;
   }

   public Date getDestinationEndDate() {
     return destinationEndDate;
   }

   public void setDestinationEndDate(Date destinationEndDate) {
     this.destinationEndDate = destinationEndDate;
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