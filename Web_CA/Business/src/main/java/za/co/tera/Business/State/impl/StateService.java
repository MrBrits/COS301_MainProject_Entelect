package za.co.tera.Business.State.impl;

import za.co.tera.Data_Access.impl.StateDAO;
import za.co.tera.Domain.impl.State;

import java.util.List;

/**
 * Created by Christo on 2014/07/14.
 */
public class StateService {

    private StateDAO stateDAO = new StateDAO();
    
    public void createState(State newState)
    {
        stateDAO.insertState(newState);
    }

    public void deleteState(State delState)
    {
        stateDAO.delete(delState);
    }

    public void updateState(State updateState)
    {
        stateDAO.saveOrUpdate(updateState);
    }

    public State findState(int ID)
    {
        return stateDAO.find(ID);
    }

    public List<State> findAllStates()
    {
        List<State> stateList = stateDAO.findAllObject();
        return  stateList;
    }
}
