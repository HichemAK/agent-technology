package com.app.admin;

import com.expertsystem.Statement;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import com.expertsystem.Rule;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class RuleVBox extends VBox {

    private GridPane header;
    private VBox antecedentsVBox, consequencesVBox, ifVBox, thenVBox;
    private HBox ifSectionHBox, thenSectionHBox, titleHBox, utilitiesHBox;
    private JFXButton btnEdit, btnDelete;

    private ArrayList<Statement> antecedentsStatements, consequencesStatements;
    private ArrayList<Label> lblAntecedents, lblConsequences;

    private String strRule, strIf, strTHEN, strName;

    private Rule rule;

    private String clrGreen, clrBlue, clrRed, clrGrey, clrBack, clrBlack, clrWhite;

    private Font font;

    private Label lblIF, lblTHEN, lblRules, lblName;

    private ImageView imvDelete, imvEdit;

    public RuleVBox(Rule rule) {
        super();

        this.initImages();
        this.initFont();
        this.initStrings();
        this.initColors();
        this.initBtnEdit();
        this.initBtnDelete();
        this.rule = rule;
        strName = rule.getName();
        this.initStatements();
        this.initLabels();

        this.initVBs();

        this.generate();
    }

    private void initImages() {
        imvDelete = new ImageView(getClass().getResource("./icons/bin.png").toExternalForm());
        imvDelete.setFitWidth(15);
        imvDelete.setFitHeight(15);

        imvEdit = new ImageView(getClass().getResource("./icons/settings.png").toExternalForm());
        imvEdit.setFitWidth(15);
        imvEdit.setFitHeight(15);
    }

    private void initFont() {
        this.font = Font.font("Consolas", FontWeight.BOLD, FontPosture.REGULAR, 18);
    }

    private void initStrings() {
        strRule = "Rule:";
        strIf = "IF";
        strTHEN = "THEN";
    }

    private void initColors() {
        clrGreen = "#30ee30";
        clrBlue = "#42acff";
        clrRed = "#e03d3d";
        clrGrey =  "#aaaaaa";
        clrBack = "#c8c8c8";
        clrBlack = "#000000";
        clrWhite = "#ffffff";
    }

    private void initLabels() {
        lblIF = new Label();
        lblIF.setText(strIf);
        lblIF.setFont(font);
        lblIF.setUnderline(true);

        lblTHEN = new Label();
        lblTHEN.setText(strTHEN);
        lblTHEN.setFont(font);
        lblTHEN.setUnderline(true);

        lblName = new Label();
        lblName.setText(strName);
        lblName.setFont(font);

        lblRules = new Label();
        lblRules.setText(strRule);
        lblRules.setFont(font);
    }

    private void initBtnEdit() {
        btnEdit = new JFXButton();
        btnEdit.setStyle("-fx-background-color: " + clrBlue + "88");
        btnEdit.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        btnEdit.setCursor(Cursor.HAND);
        Reusables.setMaxLayout(btnEdit, 20, 20);
        Reusables.setMinLayout(btnEdit, 20, 20);

        btnEdit.setAlignment(Pos.CENTER);
        btnEdit.setRipplerFill(Paint.valueOf(clrBlack));
        btnEdit.setGraphic(imvEdit);

        btnEdit.setOnMouseEntered(mouseEvent -> {
            btnEdit.setStyle("-fx-background-color: " + clrBlue + "ff");
        });

        btnEdit.setOnMouseExited(mouseEvent -> {
            btnEdit.setStyle("-fx-background-color: " + clrBlue + "88");
        });
    }

    private void initBtnDelete() {
        btnDelete = new JFXButton();
        btnDelete.setStyle("-fx-background-color: " + clrRed + "88");
        btnDelete.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        btnDelete.setCursor(Cursor.HAND);
        Reusables.setMaxLayout(btnDelete, 20, 20);
        Reusables.setMinLayout(btnDelete, 20, 20);

        btnDelete.setAlignment(Pos.CENTER);
        btnDelete.setRipplerFill(Paint.valueOf(clrBlack));
        btnDelete.setGraphic(imvDelete);

        btnDelete.setOnMouseEntered(mouseEvent -> {
            btnDelete.setStyle("-fx-background-color: " + clrRed + "ff");
        });

        btnDelete.setOnMouseExited(mouseEvent -> {
            btnDelete.setStyle("-fx-background-color: " + clrRed + "88");
        });
    }

    private void initStatements() {
        this.antecedentsStatements = rule.getAntecedents();
        this.consequencesStatements = rule.getConsequences();
        this.initIFs();
        this.initTHENs();
    }

    private void initIFs() {
        lblAntecedents = new ArrayList<>();
        for(Statement s : antecedentsStatements) {
            lblAntecedents.add(this.statementToLabel(s));
        }
    }

    private void initTHENs() {
        lblConsequences = new ArrayList<>();
        for(Statement s : consequencesStatements) {
            lblConsequences.add(this.statementToLabel(s));
        }
    }

    private Label statementToLabel(Statement st) {
        Label lbl = new Label();

        lbl.setText(st.toString());
        lbl.setFont(font);

        return lbl;
    }

    public Rule getRule() {
        return rule;
    }

    private void initIfVBox() {
        ifVBox = new VBox();

        Reusables.setMinLayout(ifVBox, 28, 60.8);
        ifVBox.setMaxWidth(60.8);
        ifVBox.setAlignment(Pos.TOP_RIGHT);

        ifVBox.getChildren().add(lblIF);
    }

    private void initThenVBox() {
        thenVBox = new VBox();

        Reusables.setMinLayout(thenVBox, 28, 60.8);
        thenVBox.setMaxWidth(60.8);
        thenVBox.setAlignment(Pos.TOP_RIGHT);

        thenVBox.getChildren().add(lblTHEN);
    }

    private void initAntecedentsVBox() {
        antecedentsVBox = new VBox();

        Reusables.setMinLayout(antecedentsVBox, 28, 403);

        antecedentsVBox.setAlignment(Pos.TOP_LEFT);
        antecedentsVBox.setSpacing(5);

        antecedentsVBox.getChildren().addAll(lblAntecedents);
    }

    private void initConsequencesVBox() {
        consequencesVBox = new VBox();

        Reusables.setMinLayout(consequencesVBox, 28, 403);

        consequencesVBox.setAlignment(Pos.TOP_LEFT);
        consequencesVBox.setSpacing(4);

        consequencesVBox.getChildren().addAll(lblConsequences);
    }

    private void initUtilities() {
        utilitiesHBox = new HBox();

        Reusables.setStaticLayout(utilitiesHBox, 26, 70);
        utilitiesHBox.setSpacing(4);
        utilitiesHBox.setAlignment(Pos.CENTER_RIGHT);

        utilitiesHBox.getChildren().addAll(btnEdit, btnDelete);
    }

    public void initTitle() {
        titleHBox = new HBox();

        Reusables.setStaticLayout(titleHBox, 26, 400);
        titleHBox.setSpacing(8);
        titleHBox.setPadding(new Insets(0, 0, 0, 14));
        titleHBox.setAlignment(Pos.CENTER_LEFT);

        titleHBox.getChildren().addAll(lblRules, lblName);
    }

    private void initHeader() {
        header = new GridPane();

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setMinWidth(70);
        col1.setMaxWidth(70);

        header.getColumnConstraints().addAll(new ColumnConstraints(), col1);

        GridPane.setRowIndex(titleHBox, 0);
        GridPane.setColumnIndex(titleHBox, 0);
        GridPane.setRowIndex(utilitiesHBox, 0);
        GridPane.setColumnIndex(utilitiesHBox, 1);

        header.getChildren().addAll(titleHBox, utilitiesHBox);
    }

    private void initIfSectionHBox() {
        ifSectionHBox = new HBox();

        Reusables.setMinLayout(ifSectionHBox, 28, 473.6);

        ifSectionHBox.setAlignment(Pos.TOP_LEFT);
        ifSectionHBox.setSpacing(10);

        ifSectionHBox.getChildren().addAll(ifVBox, antecedentsVBox);
    }

    private void initThenSectionHBox() {
        thenSectionHBox = new HBox();

        Reusables.setMinLayout(thenSectionHBox, 28, 473.6);

        thenSectionHBox.setAlignment(Pos.TOP_LEFT);
        thenSectionHBox.setSpacing(10);

        thenSectionHBox.getChildren().addAll(thenVBox, consequencesVBox);
    }

    private void initVBs() {

        // header elements
        initTitle();
        initUtilities();
        initHeader();

        // ifSection elements
        initIfVBox();
        initAntecedentsVBox();
        initIfSectionHBox();

        // thenSection elements
        initThenVBox();
        initConsequencesVBox();
        initThenSectionHBox();

        // all elements
        generate();
    }

    private void generate() {

        String styles = "-fx-background-color: " + clrGrey + ";" +
                "-fx-border-color: " + clrBack + ";" +
                "";

        Line s1 = new Line();
        s1.setStroke(Paint.valueOf(clrBack));
        s1.setStrokeWidth(2);
        s1.setStrokeType(StrokeType.CENTERED);
        s1.setStrokeLineCap(StrokeLineCap.SQUARE);
        s1.setStrokeLineJoin(StrokeLineJoin.MITER);
        s1.setStartX(0);
        s1.setStartY(0);
        s1.setEndX(474);
        s1.setEndY(0);

        Line s2 = new Line();
        s2.setStroke(Paint.valueOf(clrBack));
        s2.setStrokeWidth(2);
        s2.setStrokeType(StrokeType.CENTERED);
        s2.setStrokeLineCap(StrokeLineCap.SQUARE);
        s2.setStrokeLineJoin(StrokeLineJoin.MITER);
        s2.setStartX(0);
        s2.setStartY(0);
        s2.setEndX(474);
        s2.setEndY(0);

        this.setStyle(styles);
        this.getChildren().clear();
        this.getChildren().addAll(header, s1, ifSectionHBox, s2, thenSectionHBox);
    }
}
