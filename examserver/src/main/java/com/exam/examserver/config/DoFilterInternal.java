package com.exam.examserver.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import java.io.IOException;

public interface DoFilterInternal {
    void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException;
}
