/**
 * The MIT License
 *
 * Copyright (C) 2007 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.swing.panels.login;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import de.alpharogroup.generic.mvc.controller.AbstractGenericController;

public class LoginController extends AbstractGenericController<LoginModel, LoginView>
	implements
		WindowListener
{

	private LoginPanel loginPanel;

	private final LoginDialog dialog;

	public LoginController(final LoginDialog dialog)
	{
		super();
		this.dialog = dialog;
		this.dialog.addWindowListener(this);
	}

	protected LoginModel getLoginModel()
	{
		return getModel();
	}

	protected LoginPanel getLoginPanel()
	{
		return getView().getComponent();
	}

	protected LoginView getLoginView()
	{
		return getView();

	}

	@Override
	protected void preinitialize()
	{
		setModel(new LoginModel());
		super.preinitialize();
	}

	@Override
	public void process(final ActionEvent actionEvent)
	{
		if (null == loginPanel)
		{
			loginPanel = getView().getComponent();
		}
		if (actionEvent.getSource() == getView().getComponent().getBtnLogin())
		{

			final LoginModel model = getModel();
			model.getModelObject().setUsername(getView().getComponent().getTxtUsername().getText());
			final String pw = new String(getView().getComponent().getTxtPassword().getPassword());
			model.getModelObject().setPassword(pw);
			// AuthorisationService authorisationService = new AuthorisationServiceImpl();
			// Users user = authorisationService.authenticateUser( getModel() );
			// if(null != user){
			// this.dialog.dispose();
			// MainFrame.getInstance().setVisible( true );
			// } else {
			// getView().getComponent().getTxtInfo().setForeground( Color.RED );
			// loginPanel.getTxtInfo().setText( "Access denied!" );
			// loginPanel.getTxtUsername().setText( "" );
			// loginPanel.getTxtPassword().setText( "" );
			// }

		}
		else if (actionEvent.getSource() == loginPanel.getBtnCancel())
		{
			System.exit(0);
		}

	}


	@Override
	public void windowActivated(final WindowEvent e)
	{
	}

	@Override
	public void windowClosed(final WindowEvent e)
	{
	}

	@Override
	public void windowClosing(final WindowEvent e)
	{
	}

	@Override
	public void windowDeactivated(final WindowEvent e)
	{
	}

	@Override
	public void windowDeiconified(final WindowEvent e)
	{
	}

	@Override
	public void windowIconified(final WindowEvent e)
	{
	}

	@Override
	public void windowOpened(final WindowEvent e)
	{
	}

}