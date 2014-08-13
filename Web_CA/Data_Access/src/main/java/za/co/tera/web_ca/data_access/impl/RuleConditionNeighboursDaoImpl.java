package za.co.tera.web_ca.data_access.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import za.co.tera.web_ca.data_access.RuleConditionNeighboursDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.Ruleconditionneighbours;

import java.util.List;

public class RuleConditionNeighboursDaoImpl extends AbstractDaoImpl<Ruleconditionneighbours> implements RuleConditionNeighboursDao {
    public RuleConditionNeighboursDaoImpl()
    {
        super(Ruleconditionneighbours.class);
    }

    @Override
    public int getRuleConNeighId(Ruleconditionneighbours ruleConNeigh)
    {
        int Id = 0;
        Session session= getSession();
        Query query = session.createQuery("From Ruleconditionneighbours ruleConNeigh where ruleConNeigh.neighbours = :Neighbours");
        query.setParameter("Neighbours", ruleConNeigh.getNeighbours());
        List<Ruleconditionneighbours> ruleConNeighList = query.list();

        if (!ruleConNeighList.isEmpty()) {
            Id = ruleConNeighList.get(0).getRuleConditionNeighId();
        }

        return Id;
    }
}
