package actions;

import actions.BaseAction;

import java.util.List;

public abstract class AbstractListAction<T> extends BaseAction<T> {

    public List<T> execute() {
        return run();
    }

    protected abstract List<T> run();

}
