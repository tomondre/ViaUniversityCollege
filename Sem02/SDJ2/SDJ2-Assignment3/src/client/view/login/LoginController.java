package client.view.login;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController
{
  public TextField nameField;
  public Button submitButton;

  private LoginViewModel viewModel;
  private ViewHandler handler;

  public void init()
  {
    this.handler = ViewHandler.getInstance();
    this.viewModel = ViewModelFactory.getInstance().getLoginViewModel();
    nameField.textProperty().bindBidirectional(viewModel.getNameProperty());
  }

  public void onSubmitButton(ActionEvent actionEvent)
  {
    viewModel.setName();
    handler.openChatView();
  }
}
