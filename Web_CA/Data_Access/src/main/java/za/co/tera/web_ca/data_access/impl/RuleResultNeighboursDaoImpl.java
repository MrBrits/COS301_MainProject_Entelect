package za.co.tera.web_ca.data_access.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import za.co.tera.web_ca.data_access.RuleResultneighboursDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.Ruleresultneighbours;

import java.util.List;

public class RuleResultNeighboursDaoImpl extends AbstractDaoImpl<Ruleresultneighbours> implements RuleResultneighboursDao {
    public RuleResultNeighboursDaoImpl()
    {
        super(Ruleresultneighbours.class);
    }

    @Override
    public int getRuleResNeighId(Ruleresultneighbours ruleResNeigh)
    {
        int Id = 0;
        Session session= getSession();
        Query query = session.createQuery("From Ruleresultneighbours ruleResNeigh where ruleResNeigh.neighbours = :Neighbours");
        query.setParameter("Neighbours", ruleResNeigh.getNeighbours());
        List<Ruleresultneighbours> ruleConNeighList = query.list();

        if (!ruleConNeighList.isEmpty()) {
            Id = ruleConNeighList.get(0).getRuleResultNeighId();
        }

        return Id;
    }
}
