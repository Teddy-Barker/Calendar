package guiPackage;

import calendarPackage.Event;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EventLabel extends Button
{
    private Label title;
    private Label location;
    private Event event;

    private int fontSize;

    /**
     * Constructor initializes the Event Label with an event
     * @param event is event to be labeled
     */
    public EventLabel(Event event, int fontSize)
    {
        this.event = event;
        title = new Label(event.getTitle());
        location = new Label(event.getLocation());
        this.fontSize = fontSize;
        this.setGraphic(setText(false));
        this.setStyle("-fx-background-color: rgba(234,234,234,0);" +
                " -fx-border-color: rgba(26,26,26,0); " +
                "-fx-pref-width: 300px; " +
                "-fx-pref-height: 60px;");
        this.setOnMouseEntered(e -> {
            this.setStyle("-fx-background-color: rgba(234,234,234,0);" +
                    " -fx-border-color: rgba(26,26,26,0); " +
                    "-fx-pref-width: 300px; " +
                    "-fx-pref-height: 60px;");
            this.setGraphic(setText(true));
        });
        this.unselected();
    }

    /**
     * This method takes no arguments and sets the state of the
     * EventLabel to selected, which makes it indefinitely bold
     */
    public void selected()
    {
        this.setOnMouseExited(e -> {
            this.setStyle("-fx-background-color: rgba(234,234,234,0);" +
                    " -fx-border-color: rgba(26,26,26,0); " +
                    "-fx-pref-width: 300px; " +
                    "-fx-pref-height: 60px;");
            this.setGraphic(setText(true));
        });
    }

    /**
     * This method takes no arguments and removes the bold feature
     */
    public void unselected()
    {
        this.setGraphic(setText(false));
        this.setOnMouseExited(e -> {
            this.setStyle("-fx-background-color: rgba(234,234,234,0);" +
                    " -fx-border-color: rgba(26,26,26,0); " +
                    "-fx-pref-width: 300px; " +
                    "-fx-pref-height: 60px;");
            this.setGraphic(setText(false));
        });
    }

    /**
     * This method sets the Text for the EventLabel
     * @param bold is the bool if it is to be bolded or not
     * @return a VBox containing the Title and Location labels
     *         that is meant to be set as a graphic to the
     *         EventLabel
     */
    private VBox setText(boolean bold)
    {
        VBox vbox = new VBox();
        vbox.getChildren().add(title);
        if(!location.getText().equals(""))
        {
            if (location.getText().charAt(0) != '\t')
                location = new Label("\t" + location.getText());
            else
                location = new Label(location.getText());
        }
        if(bold)
        {
            location.setFont(Font.font("Cambria", FontWeight.BOLD, fontSize * 3 / 4));
            title.setFont(Font.font("Cambria", FontWeight.BOLD, fontSize));
        }
        else
        {
            location.setFont(new Font("Cambria", fontSize * 3 / 4));
            title.setFont(new Font("Cambria", fontSize));
        }
        vbox.getChildren().add(location);
        return vbox;
    }

    /**
     * Getter for Title
     * @return title
     */
    public Label getTitle()
    {
        return title;
    }
    /**
     * Getter for Location
     * @return location
     */
    public Label getLocation()
    {
        return location;
    }
    /**
     * Getter for Event
     * @return event
     */
    public Event getEvent()
    {
        return event;
    }
}
