package onpoint.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import onpoint.beans.Invitees;

@Transactional
@Component(value="inviteesDao")
@Scope(value="prototype")
public class InviteesDaoImpl implements InviteesDao{

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public List<Invitees> namedQueryGetInviteesByEventId(int id) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Query q = s.getNamedQuery("namedQueryGetInviteesByEventId");
		q.setInteger("id", id);
		List<Invitees> il = q.list();
		tx.commit();
		if(s.isOpen()) {
			s.close();
		}
		return il;
		
	}
	
	@Override
	public Invitees getInviteeById(int id) {
		Session s = sessionFactory.getCurrentSession();
		Invitees i = (Invitees) s.get(Invitees.class, id);
		if(s.isOpen()) {
			s.close();
		}
		return i;
	}

	@Override
	public int addInvitee(Invitees i) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(i);
		tx.commit();
		if(s.isOpen()) {
			s.close();
		}
		return result;
	}

	@Override
	public void updateInvitee(Invitees i) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.merge(i);
		tx.commit();
		if(s.isOpen()) {
			s.close();
		}
		
	}

	@Override
	public void deleteBat(Invitees i) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.delete(i);
		tx.commit();
		if(s.isOpen()) {
			s.close();
		}
		
	}

}
