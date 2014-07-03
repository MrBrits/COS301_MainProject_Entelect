package za.co.tera.data_access.impl;

import za.co.tera.Domain.impl.State;
import za.co.tera.data_access.base.EntityDOA;

import java.util.List;

/**
 * Created by Laptop on 7/3/2014.
 */
public class StateDOA implements EntityDOA<State> {
    @Override
    public void saveOrUpdate(State object) {

    }

    @Override
    public void delete(State object) {

    }

    @Override
    public State find(int id) {
        return new State();
    }

    @Override
    public List<State> findAllObject() {
        return null;
    }

    public void insertState(String stateName,String stateDesc, double stateValue,String stateRgb,int ownerId)
    {
        State state = new State( stateName,stateDesc,stateValue,stateRgb,ownerId);
    }
}
