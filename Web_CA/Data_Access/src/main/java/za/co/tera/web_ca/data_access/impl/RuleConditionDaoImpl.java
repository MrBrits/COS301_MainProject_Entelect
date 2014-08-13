package za.co.tera.web_ca.data_access.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import za.co.tera.web_ca.data_access.RuleConditionDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.Rulecondition;

import java.util.List;

public class RuleConditionDaoImpl extends AbstractDaoImpl<Rulecondition> implements RuleConditionDao{
    public RuleConditionDaoImpl()
    {
        super(Rulecondition.class);
    }
    @Override
    public int getRuleConditionId(Rulecondition ruleCon)
    {
        int Id = 0;

        Session session= getSession();
        Query query = session.createQuery("From Rulecondition ruleCon where ruleCon.not = :isNot and ruleCon.operation = :Operation and ruleCon.operand = :Operand and ruleCon.compareValue = :CompareValue and ruleCon.neighboursId = :NeighboursID");
        query.setParameter("isNot", ruleCon.isNot());
        query.setParameter("Operation", ruleCon.getOperation());
        query.setParameter("Operand", ruleCon.getOperand());
        query.setParameter("CompareValue", ruleCon.getCompareValue());
        query.setParameter("NeighboursID", ruleCon.getNeighboursId());
        List<Rulecondition> ruleConList = query.list();

        if (!ruleConList.isEmpty()) {
            Id =  ruleConList.get(0).getRuleConditionId();
        }
        return Id;
    }
}
