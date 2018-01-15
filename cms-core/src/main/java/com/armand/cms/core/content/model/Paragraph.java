package com.armand.cms.core.content.model;

import com.armand.cms.core.design.model.Link;
import com.armand.cms.core.design.model.Page;
import com.armand.cms.core.localization.model.LocalText;
import com.armand.cms.core.media.model.Media;
import lombok.Getter;

@Getter
public class Paragraph {

  private ParagraphLayout layout = ParagraphLayout.TextLeftMediaRight;
  private Media media;
  private LocalText text;
  private Align align = Align.Left;
  private Page page;
  private Link link;

  public void setLayout(ParagraphLayout layout) {
    this.layout = layout;
  }

  public void setText(LocalText text) {
    this.text = text;
  }

  public void setAlign(Align align) {
    this.align = align;
  }

  public void setMedia(Media media) {
    this.media = media;
  }

  public void setPage(Page page) {
    this.page = page;
    this.link = page.createLink();
  }

}
