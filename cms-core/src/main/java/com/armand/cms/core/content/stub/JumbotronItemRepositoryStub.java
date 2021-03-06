package com.armand.cms.core.content.stub;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.armand.cms.core.content.model.Align;
import com.armand.cms.core.content.model.ContentModel;
import com.armand.cms.core.content.model.JumbotronItem;
import com.armand.cms.core.content.model.JumbotronItemRepository;
import com.armand.cms.core.content.model.Paragraph;
import com.armand.cms.core.content.model.Title;
import com.armand.cms.core.design.model.CmsPage;
import com.armand.cms.core.design.model.DesignComponent;
import com.armand.cms.core.localization.model.Language;
import com.armand.cms.core.localization.model.LocalText;
import com.armand.cms.core.localization.model.LocalTextType;
import com.armand.cms.core.media.model.Media;
import com.armand.cms.core.media.model.MediaType;
import com.armand.cms.core.utils.StubUtils;
import com.armand.cms.core.utils.TextUtils;

@Repository
public class JumbotronItemRepositoryStub implements JumbotronItemRepository {

  @Override
  public List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent) {
    List<ContentModel> jumbotron = new ArrayList<>();

    // 1
    JumbotronItem jumbotronItem = StubUtils.createStubDbModel(new JumbotronItem(), 1000);
    Title title = createTitle("Header 1", "Наслов 1");
    Paragraph paragraph = createJumbotronParagraph();
    jumbotronItem.setTitle(title);
    jumbotronItem.setParagraph(paragraph);
    jumbotron.add(jumbotronItem);

    // 2
    jumbotronItem = StubUtils.createStubDbModel(new JumbotronItem(), 1001);
    title = createTitle("Header 2", "Наслов 2");
    title.setAlign(Align.Center);
    paragraph = createJumbotronParagraph();
    paragraph.setAlign(Align.Center);
    paragraph.getMedia().setSrc("/img/2.jpg");
    jumbotronItem.setTitle(title);
    jumbotronItem.setParagraph(paragraph);
    jumbotron.add(jumbotronItem);

    // 3
    jumbotronItem = StubUtils.createStubDbModel(new JumbotronItem(), 1002);
    title = createTitle("Long header to see how mutch space there is, and again the same thing",
        "Голем наслов за да се види колку место има, и пак исто ваму и таму");
    title.setAlign(Align.Right);
    paragraph = createJumbotronParagraph();
    paragraph.setAlign(Align.Right);
    paragraph.getMedia().setSrc("/img/3.jpg");
    jumbotronItem.setTitle(title);
    jumbotronItem.setParagraph(paragraph);
    jumbotron.add(jumbotronItem);

    // result
    return jumbotron;
  }

  private Title createTitle(String enText, String mkText) {
    Title title = new Title();
    title.setText(TextUtils.createLocalText(LocalTextType.Normal, enText, mkText));
    return title;
  }

  private Paragraph createJumbotronParagraph() {
    Paragraph paragraph = new Paragraph();

    // text
    paragraph.setText(new LocalText(LocalTextType.Large));
    paragraph.getText().addText(Language.English,
        "Lorem Ipsum is simply dummy text of the printing and"
            + "	typesetting industry. Lorem Ipsum has been the industry's standard"
            + "	dummy text ever since the 1500s, when an unknown printer took a"
            + "	galley of type and scrambled it to make a type specimen book.");
    paragraph.getText().addText(Language.Macedonian,
        "Содржина на македонски јазик. Оваа е обичен текст за да поплни место"
            + "	и да се добие изглед. Тој ќе се замени потоа со вистински содржински"
            + "	текст. Текст голем, мал или среден. Александар Македонски е македонски крал од династијата Аргеади, "
            + " син на Филип II Македонски и Олимпија, ќерка на молоскиот владетел Неоптолем.");

    // media
    Media media = new Media();
    media.setType(MediaType.Image);
    media.setSrc("/img/1.jpg");
    media.setExternal(false);
    paragraph.setMedia(media);

    // link to page
    paragraph.setPage(StubUtils.createPageReadMore(new CmsPage()));
    return paragraph;
  }

  @Override
  public List<JumbotronItem> getModels(long designComponentId) {
    return null;
  }

}
