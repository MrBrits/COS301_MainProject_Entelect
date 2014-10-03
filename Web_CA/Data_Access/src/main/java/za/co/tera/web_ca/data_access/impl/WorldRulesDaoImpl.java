package za.co.tera.web_ca.data_access.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import za.co.tera.web_ca.data_access.WorldRulesDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.Worldrules;

import java.util.List;

public class WorldRulesDaoImpl extends AbstractDaoImpl<Worldrules> implements WorldRulesDao {
    public WorldRulesDaoImpl()
    {
        super(Worldrules.class);
    }

    @Override
    public List<Worldrules> findRuleByWorldId(int worldID) {
        Session session= getSession();
        Query query = session.createQuery("From Worldrules worldrules where worldrules.worldId = :worldId");
        query.setParameter("worldId", worldID);
        List<Worldrules> worldList = query.list();
        return worldList;

    }
}
