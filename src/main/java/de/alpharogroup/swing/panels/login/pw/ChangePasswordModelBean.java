package de.alpharogroup.swing.panels.login.pw;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class {@link ChangePasswordModelBean} captures the data for change the password of a user.
 *
 * @author Asterios Raptis
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder=true)
public class ChangePasswordModelBean implements Serializable
{

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The current password of a user. */
	@Builder.Default
	private String currentPassword = "";

	/** The new password of a user. */
	@Builder.Default
	private String newPassword = "";

	/** The repeated new password of a user. */
	@Builder.Default
	private String repeatNewPassword = "";

}
