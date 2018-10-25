package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Salg;
import model.SalgsLinie;
import service.Service;

public class VidereWindow extends Stage {
    private Service service;
    private Salg s;

    public VidereWindow(Salg s) {
        service = Service.getService();
        this.s = s;

        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        setTitle("Salgslinie Window");

        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        initContent(pane);
        setScene(scene);

    }

    private ListView<SalgsLinie> lwTilFojet;
    private Label lbTF, lbTP, lbTPNy, lbBetalling, lbKredit;
    private TextField txfTP, txfTPNy, txfBP, txfPD, txfKlippekort;
    private CheckBox cbBP, cbPD, cbKlippekort;
    private Button btnLuk, btnGTB;
    private ComboBox<?> cbbKredit;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        // ---------- VBox 1 ----------------

        VBox vboks1 = new VBox();
        pane.add(vboks1, 0, 0);

        lbTF = new Label("Tilføjet produkter");
        vboks1.getChildren().add(lbTF);

        lwTilFojet = new ListView<>();
        vboks1.getChildren().add(lwTilFojet);
        lwTilFojet.getItems().addAll(s.getProdukter());

        // ---------- VBox 2 ----------------

        VBox vboks2 = new VBox(10);
        pane.add(vboks2, 1, 0);

        lbTP = new Label("Total pris");
        vboks2.getChildren().add(lbTP);

        txfTP = new TextField();
        vboks2.getChildren().add(txfTP);
        txfTP.setText(Double.toString(s.getTotalPris()));

        cbBP = new CheckBox("Bestemt pris");
        vboks2.getChildren().add(cbBP);
        cbBP.setOnAction(event -> cbBPIsSelected());

        txfBP = new TextField();
        vboks2.getChildren().add(txfBP);
        txfBP.setDisable(true);

        cbPD = new CheckBox("Procent Discount");
        vboks2.getChildren().add(cbPD);
        cbPD.setOnAction(event -> cbPDIsSelected());

        txfPD = new TextField();
        vboks2.getChildren().add(txfPD);
        txfPD.setDisable(true);

        lbTPNy = new Label("Ny total pris");
        vboks2.getChildren().add(lbTPNy);

        txfTPNy = new TextField();
        vboks2.getChildren().add(txfTPNy);

        btnLuk = new Button("Luk");
        pane.add(btnLuk, 0, 1);

        btnGTB = new Button("Gå til Betaling");
        pane.add(btnGTB, 1, 1);

        lbBetalling = new Label("----------Betalling---------");
        vboks2.getChildren().add(lbBetalling);

        lbKredit = new Label("Kredit kort");
        vboks2.getChildren().add(lbKredit);

        cbbKredit = new ComboBox();
        vboks2.getChildren().add(cbbKredit);

        cbKlippekort = new CheckBox("Klippekort");
        vboks2.getChildren().add(cbKlippekort);
        cbKlippekort.setOnAction(event -> cbKlippekortSelected());

        txfKlippekort = new TextField();
        vboks2.getChildren().add(txfKlippekort);
        txfKlippekort.setDisable(true);

    }

    private void cbBPIsSelected() {
        if (cbBP.isSelected()) {
            txfBP.setDisable(false);
        }

    }

    private void cbPDIsSelected() {
        if (cbPD.isSelected()) {
            txfPD.setDisable(false);
        }

    }

    private void cbKlippekortSelected() {
        if (cbKlippekort.isSelected()) {
            txfKlippekort.setDisable(false);
        }
    }

}
