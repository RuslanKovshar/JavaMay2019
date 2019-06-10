package com.kovshar.controller;

/**
 * Хранит регулярные выражения
 */
public interface RegularExpressions {
    String FIRST_NAME_UA = "^[А-ЩҐЄІЇЮЯ]{1}[а-щґіїьюя]+$";
    String SECOND_NAME_UA = "^[А-ЩҐЄІЇЮЯ]{1}[а-щґіїьюя]+$";
    String FATHERS_NAME = "^[А-ЩҐЄІЇЮЯ]{1}[а-щґіїьюя]+$";
    String NICK_NAME = "^[A-Za-z]+[A-Za-z0-9._-]{3,20}$";
    String COMMENT = "^[А-ЩҐЄІЇЮЯа-щґіїьюя., -]*$";
    String HOME_PHONE = "^[\\d]{3}[\\-]?[\\d]{2}[\\-]?[\\d]{2}$";
    String MOBILE_PHONE = "^(\\+38)?[\\d]{10}$";
    String EMAIL = "^([a-z0-9_\\.-]+)@([a-z0-9_\\.-]+)\\.([a-z\\.]{2,6})$";
    String SKYPE = "^[A-Za-z]+[A-Za-z0-9._-]{3,20}$";
    String POST_INDEX = "^[\\d]{5}$";
    String CITY = "^[А-ЩҐЄІЇЮЯ]{1}[а-щґіїьюя]+$";
    String STREET = "^[А-ЩҐЄІЇЮЯ]{1}[а-щґіїьюя]+$";
    String HOUSE_NUMBER = "^[\\d]{1,3}$";
    String APARTMENT_NUMBER = "^[\\d]{1,4}$";
    String DATE = "^(0[1-9]|1[0-9]|2[0-9]|3[01])-(0[1-9]|1[012])-[\\d]{4}$";

    String FIRST_NAME_EN = "^[A-Z][a-z]{1,20}$";
    String SECOND_NAME_EN = "^[A-Z][a-z]{1,20}$";
}
