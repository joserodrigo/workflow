package org.ticpy.tekoporu.reserva.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Time;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the booking database table.
 * 
 */
@Entity
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BOOKING_BOOKINGID_GENERATOR", sequenceName="BOOKING_BOOKING_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BOOKING_BOOKINGID_GENERATOR")
	@Column(name="booking_id")
	private Long bookingId;

	private Integer annl;

    @Temporal( TemporalType.DATE)
	private Date date;

	private Time time;

	//bi-directional many-to-one association to BDetail
	@OneToMany(mappedBy="booking")
	private Set<BDetail> BDetails;

    public Booking() {
    }

	public Long getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getAnnl() {
		return this.annl;
	}

	public void setAnnl(Integer annl) {
		this.annl = annl;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Set<BDetail> getBDetails() {
		return this.BDetails;
	}

	public void setBDetails(Set<BDetail> BDetails) {
		this.BDetails = BDetails;
	}
	
}