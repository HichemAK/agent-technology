package com.app.admin;

import com.expertsystem.Statement;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import com.expertsystem.Rule;
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

    private String clrGreen, clrBlue, clrRed;

    private Font font;

    Label lblIF, lblTHEN, lblRules, lblName;

    public RuleVBox(Rule rule) {
        super();

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
        btnEdit.setText("+");
        btnEdit.setStyle("-fx-background-color: " + clrGreen);
        btnEdit.setFont(font);
    }

    private void initBtnDelete() {
        btnEdit = new JFXButton();
        btnEdit.setText("E");
        btnEdit.setStyle("-fx-background-color: " + clrRed);
        btnEdit.setFont(font);
    }

    private void initStatements() {
        this.antecedentsStatements = rule.getAntecedents();
        this.consequencesStatements = rule.getConsequences();
        this.initIFs();
        this.initTHENs();
    }

    private void initIFs() {
        for(Statement s : antecedentsStatements) {
            lblAntecedents.add(this.statementToLabel(s));
        }
    }

    private void initTHENs() {
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
        antecedentsVBox.setSpacing(2);

        antecedentsVBox.getChildren().addAll(lblAntecedents);
    }

    private void initConsequencesVBox() {
        consequencesVBox = new VBox();

        Reusables.setMinLayout(consequencesVBox, 28, 403);

        consequencesVBox.setAlignment(Pos.TOP_LEFT);
        consequencesVBox.setSpacing(2);

        consequencesVBox.getChildren().addAll(lblConsequences);
    }

    private void initUtilities() {
        utilitiesHBox = new HBox();

        Reusables.setStaticLayout(utilitiesHBox, 26, 70);
        utilitiesHBox.setSpacing(5);
        utilitiesHBox.setAlignment(Pos.CENTER_RIGHT);

        utilitiesHBox.getChildren().addAll(btnEdit, btnDelete);
    }

    public void initTitle() {
        titleHBox = new HBox();

        Reusables.setStaticLayout(titleHBox, 26, 400);
        titleHBox.setSpacing(10);
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

        ifSectionHBox.getChildren().addAll(ifVBox, antecedentsVBox);
    }

    private void initThenSectionHBox() {
        thenSectionHBox = new HBox();

        Reusables.setMinLayout(thenSectionHBox, 28, 473.6);

        thenSectionHBox.setAlignment(Pos.TOP_LEFT);

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
        this.getChildren().clear();
        this.getChildren().addAll(header, ifSectionHBox, thenSectionHBox);
    }
}
