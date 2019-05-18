package ru.sbt;

import java.util.HashSet;
import java.util.Set;

public class ClassMetaData {
    private String className;
    private Set<RulesInfo> rulesInfoSet = new HashSet<RulesInfo>();

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Set<RulesInfo> getRulesInfoList() {
        return rulesInfoSet;
    }

    public void setRulesInfoList(Set<RulesInfo> rulesInfoList) {
        this.rulesInfoSet = rulesInfoList;
    }

    public void addRuleInfo(RulesInfo rulesInfo) {
        this.rulesInfoSet.add(rulesInfo);
    }
}
