package br.com.vwco.onedigitalplatform.cliente.common.constants;

public class LogMessage {
	
	private LogMessage() {
	}

	public static final String AUTH_CONTROLLER_REACHED = "Reached auth controller with: {}";
	public static final String AUTH_REQUEST_USER = "Authenticating user: {}";
	public static final String AUTH_SUCCESS_USER = "User authenticated successfully: {}";
	public static final String AUTH_NOT_ACTIVATED_USER = "User account not activated for email: {}";
	public static final String AUTH_NOT_AUTHENTICATED = "Authentication failed for user: {}";
	public static final String AUTH_NOT_VALID_ROLE = "User ROLE {} is not valid for your email domain: {}";

	public static final String REFRESH_TOKEN_INVALID = "Refresh token invalid";
	public static final String REFRESH_TOKEN_ERROR = "Something went wrong with refresh token";
	public static final String REFRESH_TOKEN_REQUEST = "Requested a refresh token";
	public static final String REFRESH_TOKEN_SUCCESS = "Successfully generated a refresh token";

	public static final String USER_GET_ALL = "All users request, size: {}";
	public static final String USER_ANY_FOUND = "Any user found";
	public static final String USER_ENDPOINT_REACHED = "Reached user controller: {}";
	public static final String USER_DELETE_SUCCESS = "User deleted successfully: {}";
	public static final String USER_DELETE_FAILED = "User delete failed";
	public static final String USER_GET_SUCCESS = "User retrieved successfully: {}";
	public static final String USER_UPDATE_SUCCESS = "User updated successfully: {}";
	public static final String USER_REGISTER_SUCCESS = "User registered {}";
	public static final String USER_PASSWORD_UPDATED = "Password updated for {}";
	public static final String USER_ACTIVATE_SUCCESS = "User is activated with email {}";
	public static final String USER_ALREADY_ACTIVATED = "User already activated with email {}";

	public static final String TOKEN_INVALID = "Invalid token {}";

	public static final String INVALID_EMAIL_FORMAT = "Invalid email format: {}";
	public static final String INVALID_CPF_FORMAT = "Invalid CPF format: {}";
	public static final String INVALID_PASSWORD = "Invalid password: {}";
	public static final String USER_NOT_FOUND = "User not found with: {}";
	public static final String EMAIL_ALREADY_TAKEN = "Email already taken: {}";
	public static final String CPF_ALREADY_TAKEN = "CPF already taken: {}";
	public static final String RANDOM_ALREADY_GENRED = "Numeric random number already genred {}";
	public static final String CODE_PASSED = "Code found{}";
	public static final String NEW_PASSWORD_REQUEST = "Password updated{}";


}
