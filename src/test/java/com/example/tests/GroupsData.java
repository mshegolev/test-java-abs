package com.example.tests;

public class GroupsData {
    public String name;
    public String header;
    public String footer;

    public GroupsData() {
    }

    public GroupsData(String name, String header, String footer) {
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
}
