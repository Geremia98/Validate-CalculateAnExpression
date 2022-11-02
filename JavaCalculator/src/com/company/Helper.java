package com.company;

//una classe in cui metto tutti i metodo di controllo
public class Helper {

    //questo metodo è designato per il calcolo dell'espressione, dato l'albero.
    public int calcola (Node root){

        switch (root.val) {
            case "*":
                return calcola(root.left) * calcola(root.right);
            case "/":
                if (!isZero(root.left))
                    return calcola(root.left) / calcola(root.right);
                break;
            case "+":
                return calcola(root.left) + calcola(root.right);
            case "-":
                return calcola(root.left) - calcola(root.right);
            default:
                return Integer.parseInt(root.val);
        }
        return 0; //? senza questo mi dà errore, ma non so il perchè
    }

    // per prevenire la divisione per 0
    private boolean isZero(Node node){
        return node.val.equals("0");
    }


    public static boolean timesOrDivide(char charAt) {
        if ((Character.compare(charAt, '*') == 0) || Character.compare(charAt, '/') == 0) {
            return true;
        }
        return false;
    }

    public static boolean plusOrMinus(char charAt) {
        if ((Character.compare(charAt, '+') == 0) || Character.compare(charAt, '-') == 0) {
            return true;
        }
        return false;
    }

    //metodo per verificare se la stringa dell'espressione contiene due operatori di fila
    public static boolean containsDoubleOperators(String stringa) {
        for (int i=0; i<stringa.length(); i++){
            if (stringa.charAt(i) == '+' ||
                    stringa.charAt(0) == '/' ||
                    stringa.charAt(0) == '-' ||
                    stringa.charAt(0) == '*') {
                for (int j=i+1; j<stringa.length(); j++) {
                    if (stringa.charAt(j) == '+' ||
                            stringa.charAt(0) == '/' ||
                            stringa.charAt(0) == '-' ||
                            stringa.charAt(0) == '*') {
                        return true;
                    }
                }
            }
        }

        return false;

    }

    //se l'espressione finisce con un operatore NON è valida
    public static boolean checkFinish(String stringa) {

        if (stringa.charAt(stringa.length()-1) == '+' ||
                stringa.charAt(0) == '/' ||
                stringa.charAt(0) == '-' ||
                stringa.charAt(0) == '*') {
            return true;
        }
        return false;

    }

    //se l'espressione comincia con un operatore NON è valida
    public static boolean checkStart(String stringa) {

        if (stringa.charAt(0) == '+' ||
                stringa.charAt(0) == '/' ||
                stringa.charAt(0) == '-' ||
                stringa.charAt(0) == '*') {
            return true;
        }
        return false;
    }

    //verifico che la stringa inserita, da cui ricavo l'espressione, sia fatta o da numeri o da operatori validi
    public static boolean isNotAlfaNumeric(String stringa) {
        for (int i=0; i<stringa.length(); i++){
            if (stringa.charAt(i) != '+' ||
                    stringa.charAt(i) != '-' ||
                    stringa.charAt(i) != '*' ||
                    stringa.charAt(i) != '/' ||
                    stringa.charAt(i) != '1' ||
                    stringa.charAt(i) != '2' ||
                    stringa.charAt(i) != '3' ||
                    stringa.charAt(i) != '4' ||
                    stringa.charAt(i) != '5' ||
                    stringa.charAt(i) != '6' ||
                    stringa.charAt(i) != '7' ||
                    stringa.charAt(i) != '8' ||
                    stringa.charAt(i) != '9' ||
                    stringa.charAt(i) != '0') {
                return true;
            }
        }
        return false;
    }


}
