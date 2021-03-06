package client.core;

import client.view.chat.ChatController;
import client.view.clientListView.ClientListViewController;
import client.view.login.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewHandler
{
  private Stage stage;

  private static ViewHandler handler = new ViewHandler();

  private ViewHandler()
  {
  }

  public void start()
  {
    stage = new Stage();
    openLoginView();
  }

  public void openChatView()
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("../view/chat/Chat.fxml"));
      Parent root = loader.load();
      ChatController controller = loader.getController();

      controller.init();

      Scene scene = new Scene(root);

      stage.setScene(scene);
      stage.setResizable(false);
      stage.show();
    }
    catch (Exception e)
    {

    }
  }

  public void openLoginView()
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("../view/login/Login.fxml"));
      Parent root = loader.load();
      LoginController controller = loader.getController();

      controller.init();

      Scene scene = new Scene(root);

      stage.setScene(scene);
      stage.setResizable(false);
      stage.show();
    }
    catch (Exception e)
    {

    }
  }

  public void openClientListView()
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(
          getClass().getResource("../view/clientListView/ClientListView.fxml"));
      Parent root = loader.load();
      ClientListViewController controller = loader.getController();

      controller.init();

      Scene scene = new Scene(root);

      stage.setScene(scene);
      stage.setResizable(false);
      stage.show();
    }
    catch (Exception e)
    {

    }
  }

  public static ViewHandler getInstance()
  {
    return handler;
  }
}
