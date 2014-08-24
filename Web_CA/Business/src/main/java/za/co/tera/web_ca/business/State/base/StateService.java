package za.co.tera.web_ca.business.State.base;

import za.co.tera.web_ca.domain.impl.State;

import java.util.List;

public interface StateService {

    public boolean createState(State newState);
    public void deleteState(State delState);
    public void updateState(State updateState);
    public List<State> findStateByUserId(int ID);
    public State findState(int ID);
    public List<State> findAllStates();
}
