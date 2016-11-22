package com.example.tests;

import com.google.common.base.Objects;

public class GroupData implements Comparable<GroupData> {
    public String name;
    public String header;
    public String footer;

    public GroupData() {
    }

    public GroupData(String name, String header, String footer) {
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "name='" + name + '\'' +
                ", header='" + header + '\'' +
                ", footer='" + footer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupData)) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equal(getName(), groupData.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }

    public String getHeader() {
        return header;
    }

    public String setHeader(String header) {
        this.header = header;
        return header;
    }

    public String getFooter() {
        return footer;
    }

    public String setFooter(String footer) {
        this.footer = footer;
        return footer;
    }

    public int compareTo(GroupData other) {
        return this.name.toLowerCase().compareTo(other.name.toLowerCase());
    }
}
