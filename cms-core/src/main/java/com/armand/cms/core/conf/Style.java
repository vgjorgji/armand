package com.armand.cms.core.conf;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Style {
  Default("#fff", "#000", "#000", "#000", "#000"),
  BlackModern("#fff", "#000", "#333", "#000", "#000"),
  BlackLight("#fff", "#000", "#333", "#777", "#000");

  private String backgroundHex;
  private String header1Hex;
  private String header3Hex;
  private String paragraphHex;
  private String inputHex;

}
