package com.darylteo.edge.core.requests;

import org.vertx.java.core.http.HttpServerResponse;

public class EdgeResponse {
  private final HttpServerResponse response;

  public EdgeResponse(HttpServerResponse response) {
    this.response = response;
  }

  /**
   * This sets the Http Response status value
   * 
   * @param value
   * @return
   */
  public EdgeResponse status(int value) {
    this.response.statusCode = value;
    return this;
  }

  /**
   * Sets a Http Response Header
   * 
   * @param header
   * @param value
   * @return
   */
  public EdgeResponse header(String header, Object value) {
    this.response.headers().put(header, value);
    return this;
  }

  /**
   * Renders a String to the response
   */
  public EdgeResponse renderText(String text) {
    return this.renderText(text, 200);
  }

  /**
   * Renders a String to the response
   */
  public EdgeResponse renderText(String text, int status) {
    this.response.end(text);
    return this;
  }

  /**
   * Renders a Template to the response
   */
  public EdgeResponse renderTemplate(String templateName) {
    return this.renderTemplate(templateName, 200);
  }

  public EdgeResponse renderTemplate(String templateName, int status) {
    this.response.end("Rendered: " + templateName);
    return this;
  }
}
