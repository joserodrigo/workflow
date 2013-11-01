package org.ticpy.tekoporu.reserva.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import org.ticpy.tekoporu.reserva.business.CityBC;
import org.ticpy.tekoporu.reserva.domain.City;

@ViewController
@PreviousView("/city_list.xhtml")
public class CityEditMB extends AbstractEditPageBean<City, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private CityBC cityBC;
	@Inject
	private City city;
	@Override
	@Transactional
	public String delete() {
		this.cityBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		city = getBean();
		city.setDele(0);
		setBean(city);
		this.cityBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.cityBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.cityBC.load(getId()));
	}

}