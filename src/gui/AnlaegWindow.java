package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AnlaegWindow extends Stage {

    public AnlaegWindow() {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        setTitle("Anlæg Window");

        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        initContent(pane);
        setScene(scene);
    }

    // Attributter til klassen
    private Button btnUdlejning, btnReserveringer;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        // Buttom oprettet med navnet "Udlejning" og tilføjet til panet på lokationen
        // (0,1)
        btnUdlejning = new Button("Udlejning");
        pane.add(btnUdlejning, 0, 1);
        btnUdlejning.setOnAction(event -> btnUdlejningAction());
        btnUdlejning.setPrefSize(200, 100);

        // Buttom oprettet med navnet "Reserveringer" og tilføjet til panet på
        // lokationen
        // (0,2)
        btnReserveringer = new Button("Reserveringer");
        pane.add(btnReserveringer, 0, 2);
        // btnReserveringer.setOnAction(event -> btnReserveringerAction());
        btnReserveringer.setPrefSize(200, 100);

    }

    // Denne metode åbner for UdlejningsWindow'et og venter på at det vindue lukker.
    public void btnUdlejningAction() {
        UdlejningsWindow uw = new UdlejningsWindow();
        uw.showAndWait();
        hide();
    }

    // public void btnReserveringerAction() {
    // hide();
    // }

}
