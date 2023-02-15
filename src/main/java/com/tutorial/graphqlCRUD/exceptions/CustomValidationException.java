package com.tutorial.graphqlCRUD.exceptions;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import lombok.Data;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.http.HttpStatus;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class CustomValidationException extends RuntimeException implements GraphQLError {

    private String message;

    public CustomValidationException (String message){
        this.message = message;
    }

    @Override
    public Map<String, Object> getExtensions() {
        Map<String, Object> attr = new LinkedHashMap<>();
        attr.put("status", HttpStatus.BAD_REQUEST.value());
        return attr;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return ErrorType.BAD_REQUEST;
    }
}
