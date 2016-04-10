package mars.model.validation;

public interface Rule<Type> {

    void apply(Type type);
}
