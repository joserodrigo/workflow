package org.ticpy.tekoporu.reserva.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import org.ticpy.tekoporu.reserva.business.PeopleBC;
import org.ticpy.tekoporu.reserva.domain.People;

@ViewController
@NextView("/people_edit.xhtml")
@PreviousView("/people_list.xhtml")
public class PeopleListMB extends AbstractListPageBean<People, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private PeopleBC peopleBC;
	
	@Override
	protected List<People> handleResultList() {
		return this.peopleBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				peopleBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}