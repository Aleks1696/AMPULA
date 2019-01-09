package com.api.request.directRequest;

import java.time.LocalDate;
import java.util.Date;

/****
 *
 *
 * Yaroslav Halindzovskiy 06.01.2018
 *
 * Изменил странные setter
 *
 * Aleksandr Borodavka 08.01.2019
 * удалил поле 'card'. Иначе полечается нелогично что при создании клиента мы требуем
 * карту и в то же время при создании карты требуем id пациента
 *
 * Aleksandr Borodavka 10.01.2019
 * поменял тип birthday на стринг так как непоятно в каком формате вводить дату рождения
 * (2019/10/23 или 02.02.2019 и тд.) Если не правильно ввести формат выдает ошибку.
 *
 * */

public class CreatePatientRequest {

    private String name;
    private String surname;
    private String birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreatePatientRequest{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append('}');
        return sb.toString();
    }
}
