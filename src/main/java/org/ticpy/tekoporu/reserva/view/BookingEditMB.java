package org.ticpy.tekoporu.reserva.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import org.ticpy.tekoporu.reserva.business.BookingBC;
import org.ticpy.tekoporu.reserva.domain.Booking;

@ViewController
@PreviousView("/booking_list.xhtml")
public class BookingEditMB extends AbstractEditPageBean<Booking, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private BookingBC bookingBC;
	
	@Override
	@Transactional
	public String delete() {
		this.bookingBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.bookingBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.bookingBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.bookingBC.load(getId()));
	}

}