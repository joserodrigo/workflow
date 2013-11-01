package org.ticpy.tekoporu.reserva.business;

import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import org.ticpy.tekoporu.reserva.domain.People;
import org.ticpy.tekoporu.reserva.persistence.PeopleDAO;

@BusinessController
public class PeopleBC extends DelegateCrud<People, Long, PeopleDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
