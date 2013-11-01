package org.ticpy.tekoporu.reserva.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="b_details")
public class BDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="B_DETAILS_ID_GENERATOR", sequenceName="B_DETAILS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="B_DETAILS_ID_GENERATOR")
	private Long id;

	//bi-directional many-to-one association to Booking
    @ManyToOne
	@JoinColumn(name="booking_id")
	private Booking booking;

	//bi-directional many-to-one association to People
    @ManyToOne
	@JoinColumn(name="people_id")
	private People people;

	//bi-directional many-to-one association to Room
    @ManyToOne
	@JoinColumn(name="room_id")
	private Room room;

    public BDetail() {
    }

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Booking getBooking() {
		return this.booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	public People getPeople() {
		return this.people;
	}

	public void setPeople(People people) {
		this.people = people;
	}
	
	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
}