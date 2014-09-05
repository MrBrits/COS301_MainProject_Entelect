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
        System.out.println("DAO");
        int Id = 0;
        Session session= getSession();
        Query query = null;

        if (ruleCon.getCompareValueTwo() == null)
        {
            query = session.createQuery("From Rulecondition ruleCon where ruleCon.not = :isNot and ruleCon.operation = :Operation and ruleCon.neighboursId = :NeighboursID and ruleCon.operand = :Operand and ruleCon.compareValueOne = :CompareValueOne");
            query.setParameter("isNot", ruleCon.isNot());
            query.setParameter("Operation", ruleCon.getOperation());
            query.setParameter("NeighboursID", ruleCon.getNeighboursId());
            query.setParameter("Operand", ruleCon.getOperand());
            query.setParameter("CompareValueOne", ruleCon.getCompareValueOne());
        }
        else
        {
            query = session.createQuery("From Rulecondition ruleCon where ruleCon.not = :isNot and ruleCon.operation = :Operation and ruleCon.neighboursId = :NeighboursID and ruleCon.operand = :Operand and ruleCon.compareValueOne = :CompareValueOne and ruleCon.compareValueTwo = :CompareValueTwo");
            query.setParameter("isNot", ruleCon.isNot());
            query.setParameter("Operation", ruleCon.getOperation());
            query.setParameter("NeighboursID", ruleCon.getNeighboursId());
            query.setParameter("Operand", ruleCon.getOperand());
            query.setParameter("CompareValueOne", ruleCon.getCompareValueOne());
            query.setParameter("CompareValueTwo", ruleCon.getCompareValueTwo());
        }

        List<Rulecondition> ruleConList = query.list();

        if (!ruleConList.isEmpty()) {
            Id =  ruleConList.get(0).getRuleConditionId();
        }
        return Id;
    }
}
