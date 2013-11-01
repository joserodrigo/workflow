package org.ticpy.tekoporu.reserva.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import org.ticpy.tekoporu.reserva.business.RoomBC;
import org.ticpy.tekoporu.reserva.domain.Room;

@ViewController
@PreviousView("/room_list.xhtml")
public class RoomEditMB extends AbstractEditPageBean<Room, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private RoomBC roomBC;
	
	@Inject
	private Room room;
	
	@Override
	@Transactional
	public String delete() {
		this.roomBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		room = getBean();
		room.setDele(0);
		setBean(room);
		this.roomBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.roomBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.roomBC.load(getId()));
	}

}