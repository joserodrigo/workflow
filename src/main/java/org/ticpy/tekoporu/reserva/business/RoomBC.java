package org.ticpy.tekoporu.reserva.business;

import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import org.ticpy.tekoporu.reserva.domain.Room;
import org.ticpy.tekoporu.reserva.persistence.RoomDAO;

@BusinessController
public class RoomBC extends DelegateCrud<Room, Long, RoomDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
