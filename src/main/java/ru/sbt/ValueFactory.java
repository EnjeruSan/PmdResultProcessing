package ru.sbt;

import org.w3c.dom.Element;

public interface ValueFactory {

    Double getValue(String ruleName, Element violation);
}
