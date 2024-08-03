package br.com.vwco.onedigitalplatform.cliente.common.constants;

public class MessageReturn {

	private MessageReturn() {
	}

	public static final String AUTH_USER_NOT_ACTIVATED = "auth.user.not.activated";
	public static final String AUTH_USER_NOT_AUTHENTICATED = "auth.user.not.authenticated";
	public static final String AUTH_NOT_VALID_ROLE = "auth.not.valid.role";

	public static final String USER_ANY_FOUND = "user.any.found";
	public static final String USER_DELETE_FAILED = "user.delete.failed";
	public static final String USER_UPDATE_SUCCESS = "user.update.success";
	public static final String USER_PASSWORD_UPDATED = "user.password.updated";
	public static final String USER_ALREADY_ACTIVATED = "user.already.activated";
	public static final String USER_ACTIVATED = "user.activated";
	public static final String USER_DELETED_SUCCESS = "user.deleted.success";
	public static final String USER_DESACTIVATED_EXCEEDED_LIMIT_ATTEMPTS = "user.desactivated.excedeed.limit.attempts";
	public static final String USER_PASSWORDS_NOT_MATCH = "passwords.not.match";
	public static final String USER_NOT_FOUND = "user.not.found";

	public static final String REFRESH_TOKEN_INVALID = "refresh.token.invalid";
	public static final String REFRESH_TOKEN_ERROR = "refresh.token.error";

	public static final String EMAIL_INVALID = "email.invalid";
	public static final String EMAIL_ALREADY_TAKEN = "email.already.taken";
	public static final String CPF_ALREADY_TAKEN = "cpf.already.taken";
	public static final String INVALID_TOKEN = "invalid.token";
	public static final String INVALID_ROLE = "invalid.role";
	public static final String INVALID_USER_OR_PASSWORD = "invalid.user.or.password";
	public static final String INVALID_OR_EXPIRED_CODE = "invalid.or.expired.code";
	public static final String VALID_CODE_PASSWORD_RESET = "valid.code.password.reset";

}
