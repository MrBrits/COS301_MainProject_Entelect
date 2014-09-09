package za.co.tera.web_ca.business.State.impl;

import za.co.tera.web_ca.business.State.base.StateService;
import za.co.tera.web_ca.data_access.StateDao;
import za.co.tera.web_ca.data_access.impl.StateDaoImpl;
import za.co.tera.web_ca.domain.impl.State;

import java.util.List;

public class StateServiceImpl implements StateService{

    private StateDao stateDAO = new StateDaoImpl();
    @Override
    public boolean createState(State newState)
    {
        int ID = newState.getOwnerId();
        ID = (ID + 321)/369;
        newState.setOwnerId(ID);
        stateDAO.save(newState);
        return true;
    }
    @Override
    public void deleteState(State delState)
    {
        stateDAO.delete(delState);
    }
    @Override
    public void updateState(State updateState)
    {
        int ID = updateState.getOwnerId();
        ID = (ID + 321)/369;
        updateState.setOwnerId(ID);
        stateDAO.save(updateState);
    }
    @Override
    public State findState(int ID)
    {
        return stateDAO.findById(ID);
    }
    @Override
    public List<State> findAllStates()  {
        List<State> stateList = stateDAO.findAll();
        return  stateList;
    }

    @Override
    public List<State> findStateByUserId(int ID) {
        ID = (ID + 321)/369;
        List<State> stateList = stateDAO.findStateByUserId(ID);
        return  stateList;
    }
}
