package org.ticpy.tekoporu.reserva.business;

import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import org.ticpy.tekoporu.reserva.domain.Booking;
import org.ticpy.tekoporu.reserva.persistence.BookingDAO;

@BusinessController
public class BookingBC extends DelegateCrud<Booking, Long, BookingDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
