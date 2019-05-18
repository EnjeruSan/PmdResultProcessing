package ru.sbt;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ValueFactoryImpl implements ValueFactory {


    public Double getValue(String ruleName, Element violation) {

        String msg = violation.getFirstChild().toString();

        if (ruleName.equals("ExcessiveClassLength")) {
            String argument = msg.split("Lenght is ")[1].split("\\n")[0];
            if(argument.equals("{0}")) {
                return null;
            } else {
                return Double.parseDouble(argument);
            }
        }

        if (ruleName.equals("ExcessiveImports")) {
            String argument = msg.split("Imports number is ")[1].split("\\n")[0];
            if(argument.equals("{0}")) {
                return null;
            } else {
                return Double.parseDouble(argument);
            }
        }

        if (ruleName.equals("ExcessiveMethodLength")) {
            String argument = msg.split("Method lenght is ")[1].split("\\n")[0];
            if(argument.equals("{0}")) {
                return null;
            } else {
                return Double.parseDouble(argument);
            }
        }

        if (ruleName.equals("TooManyFields")) {
            String argument = msg.split("Number of fields is ")[1].split("\\n")[0];
            if(argument.equals("{0}")) {
                return null;
            } else {
                return Double.parseDouble(argument);
            }
        }

        if (ruleName.equals("ExcessiveParameterList")) {
            String argument = msg.split("Parameters number is ")[1].split("\\n")[0];
            if(argument.equals("{0}")) {
                return null;
            } else {
                return Double.parseDouble(argument);
            }
        }

        return 0d;
    }
}
