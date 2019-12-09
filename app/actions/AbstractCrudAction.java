package actions;

import java.util.Optional;

public abstract class AbstractCrudAction<T> extends BaseAction<T> {

    protected Long id;

    protected T dto;

    public Optional<T> execute(String id) {
        this.id = parseId(id);
        if (this.id != null) {
            return run();
        }
        return Optional.empty();
    }

    public Optional<T> execute(T dto) {
        this.dto = dto;
        return run();
    }

    public Optional<T> execute(String id, T dto) {
        this.id = parseId(id);
        this.dto = dto;
        if (this.id != null) {
            return run();
        }
        return Optional.empty();
    }

    private Long parseId(String id) {
        try {
            return Long.valueOf(id);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    protected abstract Optional<T> run();

}
