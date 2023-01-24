package com.example.covidtracker.ui

enum class Status(val strVal: String) {
    DOWNLOADING("Downloading"),
    WAITING("Waiting"),
    DOWNLOADED("Downloaded"),
    ERROR("Error")
}

enum class CovidDataType(val strVal: String){
    WEB("(Web)"),
    DATABASE("(Database)"),
    NONE("")
}