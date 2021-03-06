package org.musteat.fragment.validator.rule.logic;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Objects;

import org.musteat.fragment.validator.ValidationResult;
import org.musteat.fragment.validator.engine.ResultStatus;
import org.musteat.fragment.validator.engine.ValidationRule;
import org.musteat.fragment.validator.rule.Optional;
import org.musteat.fragment.validator.rule.Required;

/**
 * @see Required
 */
public class RequiredLogic extends ValidationRule
{

	public RequiredLogic(Annotation validationAnnotation, Field fieldToValidate) throws Exception
	{
		super(validationAnnotation, fieldToValidate);		
		if(fieldToValidate.getAnnotation(Optional.class) != null)
			throw new Exception("Required and Optional annotations can not exist on the same field");
	}

	@Override
	public ValidationResult validate(Object obj) throws Exception
	{
		if(Objects.isNull(obj))
			return new ValidationResult("Field is required", ResultStatus.Failure);
		return null;
	}
	
	@Override
	public int getPriority()
	{
		return 10;
	}

}
