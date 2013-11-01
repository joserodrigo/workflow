package org.ticpy.tekoporu.reserva.persistence;

import java.util.List;
import java.util.Set;
import java.util.Map;
import javax.inject.Inject;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;

import org.ticpy.tekoporu.stereotype.PersistenceController;
import org.ticpy.tekoporu.template.JPACrud;

import org.ticpy.tekoporu.reserva.domain.City;

@PersistenceController
public class CityDAO extends JPACrud<City, Long> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	@SuppressWarnings("unused")
	private Logger logger;
	
	public int count() {
		Query q = createQuery("SELECT COUNT(*) FROM City c");
		return ((Long) q.getSingleResult()).intValue();
	}
	
	public List<City> findPage(int pageSize, int first, String sortField,
			boolean sortAsc, Map<String, String> filters) {

		Session session = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(City.class);

		// add order by
		Order order = Order.asc(sortField);
		if (!sortAsc) {
			order = Order.desc(sortField);
		}
		criteria.addOrder(order);

		Set<String> keySet = filters.keySet();
		for (String string : keySet) {
			criteria.add(Restrictions.like(string, filters.get(string),
					MatchMode.ANYWHERE).ignoreCase());
		}

		// add limit, offset
		criteria.setFirstResult(first);
		criteria.setMaxResults(pageSize);

		return criteria.list();
	}

}
