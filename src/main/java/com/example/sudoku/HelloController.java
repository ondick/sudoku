package com.example.sudoku;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class HelloController {
    @FXML
    private GridPane hraciPole;

    @FXML
    public void initialize() {
        generateTextFileds();
    }

    @FXML
    protected void generateTextFileds(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){

                TextField textField = new TextField(""+(j+1));
                textField.setPrefWidth(30);
                textField.setPrefHeight(30);

                hraciPole.add(textField,j,i);
            }
        }
    }

    /*@FXML
    protected void generatePole(){

        String[] radek;
        radek = new String[9];
        for(int i=0;i<9;i++){
            radek[i] = ;
        }
    }*/

    @FXML
    protected boolean zkontrolovat(String[] values){
        boolean[] seen = new boolean[10];
        for(String s: values){
            if(s.isEmpty())return false;
            int num;
            try{
                num = Integer.parseInt(s);
                if(num<1 || num>9)return true;
            } catch (NumberFormatException e) {
                return false;
            }
            if(seen[num])return true;
            seen[num]=true;
        }
        return false;

    }

    @FXML
    protected void zamkoutTo(){

    }






}
