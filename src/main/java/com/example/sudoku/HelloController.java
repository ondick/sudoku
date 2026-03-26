package com.example.sudoku;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class HelloController {
    @FXML
    private GridPane hraciPole;
    private final int SIZE = 9;
    private TextField[][] cells = new TextField[SIZE][SIZE];
    private boolean[][] locked = new boolean[SIZE][SIZE];


    @FXML
    public void initialize() {
        generateTextFields();
    }

    @FXML
    protected void generateTextFields() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                TextField textField = new TextField("" + (j + 1));
                textField.setPrefHeight(50);
                hraciPole.add(textField, j, i);
                cells[j][i] = textField;
            }
        }
    }

    private String[] getRadku(int misto) {
        String[] radka = new String[SIZE];
        for (int j = 0; j < SIZE; j++) {
            radka[j] = cells[j][misto].getText();
        }
        for (int i = 0; i < radka.length; i++) {
            System.out.println(radka[i]);
        }
        return radka;
    }

    private String[] getSloupec(int misto) {
        String[] sloupec = new String[SIZE];
        for (int j = 0; j < SIZE; j++) {
            sloupec[j] = cells[misto][j].getText();
        }
        for (int i = 0; i < sloupec.length; i++) {
            System.out.println(sloupec[i]);
        }
        return sloupec;
    }

    @FXML
    private String[] getSubGrid(int startRow, int startCol) {
        String[] values = new String[SIZE];
        int index = 0;
        for (int row = startRow; row < startRow + 1; row++) {
            for (int col = startCol; col < startCol + 1; col++) {
                values[index++] = cells[row][col].getText();
            }
        }
        return values;
    }
    @FXML
    protected boolean getDupZadani(String[] radka) {
        boolean[] seen = new boolean[SIZE+1];
        for (String s: radka) {
            int num;
            try {
                num = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return false;
            }
            if (num < 1 || num > 9) return true;
            if (seen[num]) return true;
            seen[num] = true;
        }
        return false;
    }

    @FXML
    protected boolean getDuplicities(String[] radka) {
        boolean[] seen = new boolean[SIZE + 1];
        for (String s : radka) {
            if (s.isEmpty()) return true;
            int num;
            try {
                num = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return false;
            }
            if (num < 1 || num > 9) return true;
            if (seen[num]) return true;
            seen[num] = true;
        }
        return false;
    }

    @FXML
    protected void kontrola() {
        boolean sloupce = true;
        boolean radky = true;
        for (int j = 0; j < SIZE; j++) {
            String[] radka = getRadku(j);
            if (getDuplicities(radka)) {
                System.out.println("V radce " + (j + 1) + " je chyba");
                radky = false;
            } else {
                System.out.println("Radka " + (j + 1) + " je ok");
            }
        }
        for (int j = 0; j < SIZE; j++) {
            String[] sloupec = getSloupec(j);
            if (getDuplicities(sloupec)) {
                System.out.println("Ve sloupci " + (j + 1) + " je chyba");
                sloupce = false;
            } else {
                System.out.println("Sloupec " + (j + 1) + " je ok");
            }
        }

        for (String s : getSubGrid(0, 0)) {
            
        }


        if (sloupce && !radky) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("informace");
            alert.setHeaderText("DULEZITE UPOZORNENI");
            alert.setContentText("V radkach je chyba");
            alert.showAndWait();
        } else if (!sloupce && radky) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("informace");
            alert.setHeaderText("DULEZITE UPOZORNENI");
            alert.setContentText("V sloupcich je chyba");
            alert.showAndWait();
        } else if (!sloupce && !radky) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("informace");
            alert.setHeaderText("DULEZITE UPOZORNENI");
            alert.setContentText("V radkach i sloupcich je chyba");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("informace");
            alert.setHeaderText("DULEZITE UPOZORNENI");
            alert.setContentText("Vse je v poho");
            alert.showAndWait();
        }
    }

    @FXML
    public void kontrolaZadani() {
        boolean sloupce = true;
        boolean radky = true;
        for (int j = 0; j < SIZE; j++) {
            String[] radka = getRadku(j);
            if (getDupZadani(radka)) {
                System.out.println("V radce " + (j + 1) + " je chyba");
                radky = false;
            } else {
                System.out.println("Radka " + (j + 1) + " je ok");
            }
        }
        for (int j = 0; j < SIZE; j++) {
            String[] sloupec = getSloupec(j);
            if (getDupZadani(sloupec)) {
                System.out.println("Ve sloupci " + (j + 1) + " je chyba");
                sloupce = false;
            } else {
                System.out.println("Sloupec " + (j + 1) + " je ok");
            }
        }

        for (int j = 0; j < SIZE; j =j+3) {

        }

        if (sloupce && !radky) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("informace");
            alert.setHeaderText("DULEZITE UPOZORNENI");
            alert.setContentText("V radkach je chyba");
            alert.showAndWait();
        } else if (!sloupce && radky) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("informace");
            alert.setHeaderText("DULEZITE UPOZORNENI");
            alert.setContentText("V sloupcich je chyba");
            alert.showAndWait();
        } else if (!sloupce && !radky) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("informace");
            alert.setHeaderText("DULEZITE UPOZORNENI");
            alert.setContentText("V radkach i sloupcich je chyba");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("informace");
            alert.setHeaderText("DULEZITE UPOZORNENI");
            alert.setContentText("Vse je v poho");
            alert.showAndWait();

        }
    }

    @FXML
    protected void onZamknoutTlacitkoClick() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (!cells[row][col].getText().equals("")) {
                    cells[row][col].setDisable(true);
                }
            }
        }
    }
    @FXML
    protected void odZamknoutTlacitkoClick() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                cells[row][col].setDisable(false);
            }
        }
    }
    @FXML
    protected void restartPokusu() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (!cells[row][col].isDisable()) {
                    cells[row][col].setText("");
                }
            }
        }
    }
    @FXML
    protected void vymazani() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (cells[row][col].isDisable()) {
                    cells[row][col].setDisable(false);
                }
                cells[row][col].setText("");
            }
        }
    }

}
