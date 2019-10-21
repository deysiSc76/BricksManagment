package com.fiuni.sd.bricks_management.dao.providers;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.bricks_management.dao.base.BaseDaoImpl;
import com.fiuni.sd.bricks_management.domain.ProviderDomain;

@Repository
public class ProvidersDaoImpl extends BaseDaoImpl<ProviderDomain> implements IProvidersDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ProviderDomain save(ProviderDomain domain) {
		sessionFactory.getCurrentSession().save(domain);
		return domain;
	}

	@Override
	public ProviderDomain getById(Integer domainId) {
		return (ProviderDomain) sessionFactory.getCurrentSession().get(ProviderDomain.class, domainId);
	}

	@Override
	public List<ProviderDomain> findAll() {
		// se abre una session con la base de datos
		Session session = sessionFactory.openSession();
		
		// construyo el select
		CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
		final CriteriaQuery<ProviderDomain> criteria = builder.createQuery(ProviderDomain.class);
		criteria.from(ProviderDomain.class);
		
		// ejecuto el select y cierro la sesion
		List<ProviderDomain> providers = session.createQuery(criteria).getResultList();
		session.close();
		
		return providers;
	}

	@Override
	public List<ProviderDomain> findAll(Integer page, Integer size) {

		// se abre una session con la base de datos
		Session session = sessionFactory.openSession();
		
		// construyo el select
		CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
		final CriteriaQuery<ProviderDomain> criteria = builder.createQuery(ProviderDomain.class);
		criteria.from(ProviderDomain.class);
		
		// ejecuto el select y cierro la sesion
		List<ProviderDomain> providers = session.createQuery(criteria)
				.setMaxResults(size)
				.setFirstResult(page * size)
				.getResultList();
		session.close();
		
		return providers;
	}

	@Override
	public ProviderDomain update(ProviderDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public void delete(ProviderDomain domain) {
		sessionFactory.getCurrentSession().delete(domain);		
	}

	@Override
	public List<ProviderDomain> find(String text, Integer page, Integer size) {

		// se abre una session con la base de datos
		Session session = sessionFactory.openSession();
		
		// construyo el select
		CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
		final CriteriaQuery<ProviderDomain> criteria = builder.createQuery(ProviderDomain.class);
		Root<ProviderDomain> root = criteria.from(ProviderDomain.class);
		
		
		Predicate c1 = builder.like(root.get("business_name"), "%"+text+"%");
		Predicate c2 = builder.like(root.get("address"), "%"+text+"%");
		Predicate c3 = builder.like(root.get("ruc"), "%"+text+"%");

		criteria.select(root).where(builder.or(c1, c2, c3));
		
		// ejecuto el select y cierro la sesion
		List<ProviderDomain> providers = session.createQuery(criteria)
		
				.setMaxResults(size)
				.setFirstResult(page * size)
				.getResultList();
		session.close();
		
		return providers;
	}

}
