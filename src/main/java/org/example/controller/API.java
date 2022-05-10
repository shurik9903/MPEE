package org.example.controller;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.io.IOException;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

@ApplicationPath("api")
public class API extends Application {}



