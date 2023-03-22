package sg.edu.ntu.m3project.m3project.entity;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="itinerary_items")
public class ItineraryItem {

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Integer id;

   @ManyToOne
   @JoinColumn(name="itinerary_id")
   private Itinerary itinerary;

  @ManyToOne
   @JoinColumn(name="transport_id")
   private Transport transport;

   @ManyToOne
   @JoinColumn(name="accommodation_id")
   private Accommodation accommodation;

   @ManyToOne
   @JoinColumn(name="destination_id")
   private Destination destination;

   @Column(name="start_date")
   private Date startDate;

   @Column(name="end_date")
   private Date endDate;

   @Column(name="notes")
   private String notes;

  @Column(name="created_at", updatable= false)
   private Timestamp createdAt = new Timestamp(new Date().getTime());


   //#region Getters and Setters
   public Integer getId() {
     return id;
   }

   public void setId(Integer id) {
     this.id = id;
   }

   
   public Itinerary getItinerary() {
    return itinerary;
  }

  public void setItinerary(Itinerary itinerary) {
    this.itinerary = itinerary;
  }

   public Transport getTransport() {
     return transport;
   }

   public void setTransport(Transport transportId) {
     this.transport = transportId;
   }

   public Accommodation getAccommodation() {
     return accommodation;
   }

   public void setAccommodation(Accommodation accommodationId) {
     this.accommodation = accommodationId;
   }

   public Destination getDestination() {
     return destination;
   }

   public void setDestination(Destination destinationId) {
     this.destination = destinationId;
   }

   public Date getStartDate() {
     return startDate;
   }

   public void setStartDate(Date startDate) {
     this.startDate = startDate;
   }

   public Date getEndDate() {
     return endDate;
   }

   public void setEndDate(Date endDate) {
     this.endDate = endDate;
   }

   public Timestamp getCreatedAt() {
     return createdAt;
   }

   public void setCreatedAt(Timestamp createdAt) {
     this.createdAt = createdAt;
   }

   public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

   //#endregion
}
