package org.meilishuo.dao;

import org.hibernate.SessionFactory;
import org.meilishuo.entity.Rollingadvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class RollingAdvertisementDAO extends BaseDAO<Rollingadvertisement> {
	@Autowired
	public RollingAdvertisementDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}
