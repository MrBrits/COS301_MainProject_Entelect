package za.co.tera.web_ca.data_access.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import za.co.tera.web_ca.data_access.RuleConditionDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;

import java.util.List;

/**
 * Created by Laptop on 7/14/2014.
 */
public class RuleConditionDaoImpl extends AbstractDaoImpl<Rulecondition> implements RuleConditionDao{
    public RuleConditionDaoImpl()
    {
        super(Rulecondition.class);
    }
    @Override
    public int getRuleConditionId(Rulecondition ruleCon)
    {
        Session session= getSession();
        Query query = session.createQuery("From Rulecondition ruleCon where ruleCon.not = :isNot and ruleCon.operation = :Operation and ruleCon.operand = :Operand and ruleCon.compareValue = :CompareValue");
        query.setParameter("isNot", ruleCon.isNot());
        query.setParameter("Operation", ruleCon.getOperation());
        query.setParameter("Operand", ruleCon.getOperand());
        query.setParameter("CompareValue", ruleCon.getCompareValue());
        List<Rulecondition> ruleConList = query.list();

        if (!ruleConList.isEmpty()) {
            return ruleConList.get(0).getRuleConditionId();
        }
        return 0;
    }
}
