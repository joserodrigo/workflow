package org.ticpy.tekoporu.reserva.persistence;

import javax.inject.Inject;

import org.slf4j.Logger;

import org.ticpy.tekoporu.stereotype.PersistenceController;
import org.ticpy.tekoporu.template.JPACrud;

import org.ticpy.tekoporu.reserva.domain.Room;

@PersistenceController
public class RoomDAO extends JPACrud<Room, Long> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	@SuppressWarnings("unused")
	private Logger logger;

}
