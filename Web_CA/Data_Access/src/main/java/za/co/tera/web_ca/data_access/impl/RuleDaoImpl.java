package za.co.tera.web_ca.data_access.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import za.co.tera.web_ca.data_access.RuleDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.Rule;

import java.util.List;

public class RuleDaoImpl extends AbstractDaoImpl<Rule> implements RuleDao {
    public RuleDaoImpl()
    {
        super(Rule.class);
    }

    @Override
    public List<Rule> findRuleByUserId(int ownerId) {
        Session session= getSession();
        Query query = session.createQuery("From Rule rule where rule.ownerId = :ownerId");
        query.setParameter("ownerId", ownerId);
        List<Rule> ruleList = query.list();
        return ruleList;
    }
}
