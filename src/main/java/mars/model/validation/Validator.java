package mars.model.validation;

public abstract class Validator<Type> implements Rule<Type> {

    public abstract boolean validate(Type toBeValidate);
}
