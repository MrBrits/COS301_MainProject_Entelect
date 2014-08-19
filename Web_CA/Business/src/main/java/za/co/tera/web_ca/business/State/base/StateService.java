package za.co.tera.web_ca.business.State.base;

import za.co.tera.web_ca.domain.impl.State;

import java.util.List;

/**
 * Created by Stepahn on 2014/07/14.
 */
public interface StateService {
    /**
     *
     * @param newState
     */
    public void createState(State newState);

    /**
     *
     * @param delState
     */
    public void deleteState(State delState);

    /**
     *
     * @param updateState
     */
    public void updateState(State updateState);

    /**
     *
     * @param ID
     * @return
     */
    public List<State> findStateByUserId(int ID);

    /**
     *
     * @param ID
     * @return
     */
    public State findState(int ID);

    /**
     *
     * @return
     */
    public List<State> findAllStates();
}
