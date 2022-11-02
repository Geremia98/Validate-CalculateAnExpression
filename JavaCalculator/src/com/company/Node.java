package com.company;
import javax.swing.*;

public class Node {

    String val;
    Node left, right;

    public Node (String theVal, Node left, Node right) {
        this.val = theVal;
        this.left = left;
        this.right = right;
    }

    public Node (String theVal) {
        this(theVal, null, null);
    }

    //data una stringa si genera l'albero corrispondente
    public Node generate (String stringa) {
        if (Helper.isNotAlfaNumeric(stringa)) {
            return new Node("Solo caratteri alfa-numerici sono validi");
        } else if (Helper.checkStart(stringa)) {
            return new Node ("Un'espressione NON può cominciare con un operatore");
        } else if (Helper.checkFinish(stringa)) {
            return new Node("Un'espressione NON può finire con un operatore");
        } else if (Helper.containsDoubleOperators(stringa)){
            return new Node("Un'espressione valida NON può contenere due operatori consecutivi");
        } else {
            for (int i=0; i<stringa.length(); i++) {
                if (Helper.plusOrMinus(stringa.charAt(i))){
                    this.val = String.valueOf(stringa.charAt(i));
                    this.left = generate(stringa.substring(0, i-1));
                    this.right = generate(stringa.substring(i+1, stringa.length()));
                    break;
                }
            }
            for (int i=0; i<stringa.length(); i++){
                if (Helper.timesOrDivide(stringa.charAt(i))){
                    this.val = String.valueOf(stringa.charAt(i));
                    this.left = generate(stringa.substring(0, i-1));
                    this.right = generate(stringa.substring(i+1, stringa.length()));
                    break;
                }
            }
            return new Node(stringa);
        }
    }




}
