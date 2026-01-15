/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.ecom_app.basic_ecom.adapter.input.rest;

import com.example.ecom_app.basic_ecom.domain.dto.User;


public interface RegisterUserUseCase {
    User register(String name, String email, String password, String phoneNumber);
}