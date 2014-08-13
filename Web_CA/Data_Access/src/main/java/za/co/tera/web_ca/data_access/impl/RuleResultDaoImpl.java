package za.co.tera.web_ca.data_access.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import za.co.tera.web_ca.data_access.RuleResultDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.Ruleresult;

import java.util.List;

/**
 * Created by Laptop on 7/14/2014.
 */
public class RuleResultDaoImpl extends AbstractDaoImpl<Ruleresult> implements RuleResultDao {
    public RuleResultDaoImpl()
    {
        super(Ruleresult.class);
    }
    @Override
    public int getRuleResultId(Ruleresult ruleRes)
    {
        Session session= getSession();
        Query query = session.createQuery("From Ruleresult ruleRes where ruleRes.operation = :Operation and ruleRes.operand = :Operand and ruleRes.resultValue = :ResultValue");
        query.setParameter("Operation", ruleRes.getOperation());
        query.setParameter("Operand", ruleRes.getOperand());
        query.setParameter("ResultValue", ruleRes.getResultValue());
        List<Ruleresult> ruleConList = query.list();

        if (!ruleConList.isEmpty()) {
            return ruleConList.get(0).getRuleResultId();
        }
        return 0;
    }
}
