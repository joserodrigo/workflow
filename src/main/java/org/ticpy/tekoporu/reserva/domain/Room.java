package org.ticpy.tekoporu.reserva.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import java.util.Set;


/**
 * The persistent class for the room database table.
 * 
 */
@Entity
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROOM_ROOMID_GENERATOR", sequenceName="ROOM_ROOM_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROOM_ROOMID_GENERATOR")
	@Column(name="room_id")
	private Long roomId;

	private Integer dele;

	@Column(name="room_desc")
	private String roomDesc;

	//bi-directional many-to-one association to BDetail
	@OneToMany(mappedBy="room")
	private Set<BDetail> BDetails;

    public Room() {
    }

	public Long getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Integer getDele() {
		return this.dele;
	}

	public void setDele(Integer dele) {
		this.dele = dele;
	}

	public String getRoomDesc() {
		return this.roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	public Set<BDetail> getBDetails() {
		return this.BDetails;
	}

	public void setBDetails(Set<BDetail> BDetails) {
		this.BDetails = BDetails;
	}
	
}