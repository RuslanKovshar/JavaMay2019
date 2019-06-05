package com.kovshar.controller;

/**
 * Хранит регулярные выражения
 */
public interface RegularExpressions {
    String firstName = "^[А-ЩҐЄІЇЮЯ]{1}[а-щґіїьюя]+$";
    String secondName = "^[А-ЩҐЄІЇЮЯ]{1}[а-щґіїьюя]+$";
    String fathersName = "^[А-ЩҐЄІЇЮЯ]{1}[а-щґіїьюя]+$";
    String nickName = "^[A-Za-z]+[A-Za-z0-9._-]{3,20}$";
    String comment = "^[А-ЩҐЄІЇЮЯа-щґіїьюя., -]*$";
    String homePhone = "^[\\d]{3}[\\-]?[\\d]{2}[\\-]?[\\d]{2}$";
    String mobilePhone = "^(\\+38)?[\\d]{10}$";
    String email = "^([a-z0-9_\\.-]+)@([a-z0-9_\\.-]+)\\.([a-z\\.]{2,6})$";
    String skype = "^[A-Za-z]+[A-Za-z0-9._-]{3,20}$";
    String postIndex = "^[\\d]{5}$";
    String city = "^[А-ЩҐЄІЇЮЯ]{1}[а-щґіїьюя]+$";
    String street = "^[А-ЩҐЄІЇЮЯ]{1}[а-щґіїьюя]+$";
    String houseNumber = "^[\\d]{1,3}$";
    String apartmentNumber = "^[\\d]{1,4}$";
    String date = "^(0[1-9]|1[0-9]|2[0-9]|3[01])-(0[1-9]|1[012])-[\\d]{4}$";
}
