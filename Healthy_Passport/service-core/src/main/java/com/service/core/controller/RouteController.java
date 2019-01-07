package com.service.core.controller;

/****
 *
 *
 * Anton Platunov 07.01.2018
 *
 *
 *
 *
 * */

 /* @RequestMapping - позволяет нам указать путь к странице либо на функции
    на backend.

    @RequestMethod - позволяет нам указать ти запроса
    GET- для получения используется для получения данных от сервера
    POST - используется когда необходимо создать какие либо данные на сервере
    PUT - используется для модификации данных на сервере
    DELETE - удаление каких лиюл данных на сервере
     */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RouteController {

    @RequestMapping(value = "/index.html",method = RequestMethod.GET)
    public String indexPage(){
        return "index";
    }
}
