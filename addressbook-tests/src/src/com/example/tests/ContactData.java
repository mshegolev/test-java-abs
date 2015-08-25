package com.example.tests;

public class ContactData {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String homePhone;
    private final String modilePhone;
    private final String workPhone;
    private final String emailFirsts;
    private final String emailSecond;
    private final String birthdayDay;
    private final String bithdayMounth;
    private final String birthdayYear;
    private final String selectGroup;
    private final String secondaryAddressSecond;
    private final String secondaryAddressHome;

    public ContactData(String firstName, String lastName, String address, String homePhone, String modilePhone, String workPhone, String emailFirsts, String emailSecond, String birthdayDay, String bithdayMounth, String birthdayYear, String selectGroup, String secondaryAddressSecond, String secondaryAddressHome) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.homePhone = homePhone;
        this.modilePhone = modilePhone;
        this.workPhone = workPhone;
        this.emailFirsts = emailFirsts;
        this.emailSecond = emailSecond;
        this.birthdayDay = birthdayDay;
        this.bithdayMounth = bithdayMounth;
        this.birthdayYear = birthdayYear;
        this.selectGroup = selectGroup;
        this.secondaryAddressSecond = secondaryAddressSecond;
        this.secondaryAddressHome = secondaryAddressHome;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getModilePhone() {
        return modilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getEmailFirsts() {
        return emailFirsts;
    }

    public String getEmailSecond() {
        return emailSecond;
    }

    public String getBirthdayDay() {
        return birthdayDay;
    }

    public String getBithdayMounth() {
        return bithdayMounth;
    }

    public String getBirthdayYear() {
        return birthdayYear;
    }

    public String getSelectGroup() {
        return selectGroup;
    }

    public String getSecondaryAddressSecond() {
        return secondaryAddressSecond;
    }

    public String getSecondaryAddressHome() {
        return secondaryAddressHome;
    }
}
