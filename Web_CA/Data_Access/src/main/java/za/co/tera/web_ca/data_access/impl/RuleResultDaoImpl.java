package za.co.tera.web_ca.data_access.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import za.co.tera.web_ca.data_access.RuleResultDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.Ruleresult;

import java.util.List;

public class RuleResultDaoImpl extends AbstractDaoImpl<Ruleresult> implements RuleResultDao {
    public RuleResultDaoImpl()
    {
        super(Ruleresult.class);
    }
    @Override
    public int getRuleResultId(Ruleresult ruleRes)
    {
        int Id = 0;
        Session session= getSession();
        Query query;

        if (ruleRes.getResultValue() == null) {
            query = session.createQuery("From Ruleresult ruleRes where ruleRes.operation = :Operation and ruleRes.neighboursId = :NeighboursID");
            query.setParameter("Operation", ruleRes.getOperation());
            query.setParameter("NeighboursID", ruleRes.getNeighboursId());
        }
        else {
            query = session.createQuery("From Ruleresult ruleRes where ruleRes.resultValue = :ResultValue");
            query.setParameter("ResultValue", ruleRes.getResultValue());
        }
        List<Ruleresult> ruleConList = query.list();

        if (!ruleConList.isEmpty()) {
            Id = ruleConList.get(0).getRuleResultId();
        }
        return Id;
    }
}
