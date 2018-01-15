package com.armand.cms.core.content.model;

import java.util.Date;

import com.armand.cms.core.classify.model.Categories;
import com.armand.cms.core.comment.model.Comments;
import com.armand.cms.core.design.model.FeedPage;
import com.armand.cms.core.design.model.Link;
import com.armand.cms.core.hashtag.model.HashTags;
import com.armand.cms.core.localization.model.LocalText;
import com.armand.cms.core.media.model.Media;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedItem extends ContentModel {

  private LocalText title;
  private LocalText infoText;
  private Media media;
  private FeedPage page;
  private Link link;
  private Categories categories;
  private HashTags hashTags;
  private Comments comments;

  private Date date;
  private Date dateStart;
  private Date dateEnd;
  private LocalText location;


  public void setPage(FeedPage page) {
    this.page = page;
    this.link = page.createLink();
  }

}
