package za.co.tera.web_ca.data_access.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import za.co.tera.web_ca.data_access.RuleNeighboursDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.Ruleneighbours;

import java.util.List;

public class RuleNeighboursDaoImpl extends AbstractDaoImpl<Ruleneighbours> implements RuleNeighboursDao {
    public RuleNeighboursDaoImpl(){super(Ruleneighbours.class);}

    @Override
    public Ruleneighbours save(Ruleneighbours ruleneighbours){

        if(ruleneighbours!=null) {
            Session session = getSession();
            session.beginTransaction();
            session.save(ruleneighbours);
            session.getTransaction().commit();
            Query query = session.createQuery("from Ruleneighbours");
            List<Ruleneighbours> objects = query.list();
            return objects.get(objects.size()-1);

        }
        return null;
    }

    @Override
    public int getRuleNeighboursId(Ruleneighbours ruleneighbours){
        int Id = 0;

        Session session= getSession();
        Query query = session.createQuery("From Ruleneighbours ruleneighbours where ruleneighbours.neighbours = :Neighbours");
        query.setParameter("Neighbours", ruleneighbours.getNeighbours());
        List<Ruleneighbours> ruleConNeighList = query.list();

        if (!ruleConNeighList.isEmpty()) {
            Id = ruleConNeighList.get(0).getRuleNeighboursId();
        }

        return Id;
    }
}

