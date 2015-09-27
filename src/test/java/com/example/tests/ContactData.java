package com.example.tests;

public class ContactData {
    public String firstName;
    public String lastName;
    public String address;
    public String homePhone;
    public String modilePhone;
    public String workPhone;
    public String emailFirsts;
    public String emailSecond;
    public String birthdayDay;
    public String bithdayMounth;
    public String birthdayYear;
    public String selectGroup;
    public String secondaryAddressSecond;
    public String secondaryAddressHome;
    public String groupName;

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

    public ContactData() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() { return address;
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

    public String setSelectGroup(String groupName) {
        this.groupName = groupName;
        return groupName;
    }

    public String getSecondaryAddressSecond() {
        return secondaryAddressSecond;
    }

    public String getSecondaryAddressHome() {
        return secondaryAddressHome;
    }
}
