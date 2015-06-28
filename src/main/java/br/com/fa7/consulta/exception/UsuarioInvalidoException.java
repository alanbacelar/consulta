package br.com.fa7.consulta.exception;
public class UsuarioInvalidoException extends Exception {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -1071896537277884578L;

	public UsuarioInvalidoException() {
		super("Login ou senha inválidos");
	}
}