package za.co.tera.Business.State;

import za.co.tera.Domain.impl.State;
import za.co.tera.data_access.impl.StateDAO;

import java.util.List;

/**
 * Created by Christo on 2014/07/04.
 */
public class StateEntityManager {

    private StateDAO stateDAO = new StateDAO();

    public void createState(State newState)
    {
        stateDAO.insertState(newState.getStateName(), newState.getStateDesc(), newState.getStateValue(), newState.getStateRgb(), newState.getOwnerId());
    }

    public void createState(String stateName, String stateDesc, int stateValue, String stateRGB, int ownerID)
    {
        stateDAO.insertState(stateName, stateDesc, stateValue, stateRGB, ownerID);
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
