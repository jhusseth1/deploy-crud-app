package com.codingdojo.jhusseth.controller.constans;

public class Constants {
    public static final String FAILED_SIMILAR_PASSWORD_MESSAGE = "Password and confirmPassword field do not match";
    public static final String FAILED_SIMILAR_EMAIL_MESSAGE = "There is a user registered with the same email";

    public static final String FAILED_DELETE_PROJECT_MESSAGE = "Cannot delete project, probably has enrolled users";

    public static final String FAILED_DUE_DATE_MESSAGE = "The date must be greater than today";
    public static final String FAILED_TASK_ASSIGNEE = "the assigning user already has 3 tasks";

    public static final String FAILED_UPDATE_TASK = "An error occurred while updating the task the assigning user cannot be changed has 3 tasks already assigned";
}
