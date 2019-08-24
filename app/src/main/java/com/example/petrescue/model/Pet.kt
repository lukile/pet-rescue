package com.example.petrescue.model

class Pet {
    private var id: Int = 0
    private var type: String = ""
    private var name: String = ""
    private var age: Int = 0
    private var picture: MutableList<String> = arrayListOf()
    private var description: String = ""
}