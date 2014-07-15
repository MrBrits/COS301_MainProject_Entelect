package za.co.tera.web_ca.business.State.impl;

import za.co.tera.web_ca.business.State.base.StateService;
import za.co.tera.web_ca.data_access.StateDao;
import za.co.tera.web_ca.data_access.impl.StateDaoImpl;
import za.co.tera.web_ca.domain.impl.State;

import java.util.List;

/**
 * Created by Laptop on 7/14/2014.
 */
public class StateServiceImpl implements StateService{

    private StateDao stateDAO = new StateDaoImpl();
    @Override
    public void createState(State newState)
    {
        stateDAO.save(newState);
    }
    @Override
    public void deleteState(State delState)
    {
        stateDAO.delete(delState);
    }
    @Override
    public void updateState(State updateState)
    {
        stateDAO.save(updateState);
    }
    @Override
    public State findState(int ID)
    {
        return stateDAO.findById(ID);
    }
    @Override
    public List<State> findAllStates()
    {
        List<State> stateList = stateDAO.findAll();
        return  stateList;
    }
}