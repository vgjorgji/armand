package com.armand.cms.core.conf;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Style {
  Default("#fff", "#000", "#000", "#000", "#000"),
  BlackModern("#fff", "#000", "#333", "#000", "#000"),
  BlackLight("#fff", "#000", "#333", "#777", "#000");

  private String backgroundHex;
  private String header1Hex;
  private String header3Hex;
  private String paragraphHex;
  private String inputHex;

  public String getId() {
    return name();
  }

}
