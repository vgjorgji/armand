package com.vcms.content.stub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vcms.content.model.ContentModel;
import com.vcms.content.model.Paragraph;
import com.vcms.content.model.ParagraphItem;
import com.vcms.content.model.ParagraphItemRepository;
import com.vcms.content.model.ParagraphLayout;
import com.vcms.design.model.CmsPage;
import com.vcms.design.model.DesignComponent;
import com.vcms.localization.model.Language;
import com.vcms.localization.model.LocalText;
import com.vcms.localization.model.LocalTextType;
import com.vcms.media.model.Media;
import com.vcms.media.model.MediaType;
import com.vcms.utils.StubUtils;

@Repository
public class ParagraphItemRepositoryStub implements ParagraphItemRepository {

	@Override
	public List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent) {
		if (designComponent.getId() == 1003) {
			return createParagraphAboutUs();
		} else if (designComponent.getId() == 1011) {
			return createParagraphs();
		} else if (designComponent.getId() == 1016) {
			return createAllParagraphs();
		}
		return Collections.emptyList();
	}

	@Override
	public List<ParagraphItem> getModels(long designComponentId) {
		return null;
	}
	
	private List<ContentModel> createParagraphAboutUs() {
		List<ContentModel> paragraphContainer = new ArrayList<>();
		
		// 1
		ParagraphItem paragraphItem = StubUtils.createStubDbModel(new ParagraphItem(), 1000);
		Paragraph paragraph = createParagraph();
		paragraph.getMedia().setSrc("/static/img/stub/a1.jpg");
		paragraphItem.setParagraph(paragraph);
		paragraphContainer.add(paragraphItem);
		
		// result
		return paragraphContainer;
	}
	
	private List<ContentModel> createParagraphs() {
		List<ContentModel> paragraphContainer = new ArrayList<>();
		
		// 1
		ParagraphItem paragraphItem = StubUtils.createStubDbModel(new ParagraphItem(), 1000);
		Paragraph paragraph = createParagraph();
		paragraph.getMedia().setSrc("/static/img/stub/a2.jpg");
		paragraph.setLayout(ParagraphLayout.TextRightMediaLeft);
		paragraphItem.setParagraph(paragraph);
		paragraphContainer.add(paragraphItem);
		
		// 2
		paragraphItem = StubUtils.createStubDbModel(new ParagraphItem(), 1001);
		paragraph = createParagraphOnlyText();
		paragraphItem.setParagraph(paragraph);
		paragraphContainer.add(paragraphItem);
		
		// result
		return paragraphContainer;
	}
	
	private List<ContentModel> createAllParagraphs() {
		List<ContentModel> result = new ArrayList<>();
		result.addAll(createParagraphAboutUs());
		result.addAll(createParagraphs());
		return result;
	}
	

	private Paragraph createParagraph() {
		Paragraph paragraph = new Paragraph();
		paragraph.setLayout(ParagraphLayout.TextLeftMediaRight);

		// text
		paragraph.setText(new LocalText(LocalTextType.Rich));
		paragraph.getText().addText(Language.English,
				"<h2>About us</h2>" + "<p>Lorem Ipsum is simply dummy text of the printing and"
						+ "	typesetting industry. Lorem Ipsum has been the industry's standard"
						+ "	dummy text ever since the 1500s, when an unknown printer took a"
						+ "	galley of type and scrambled it to make a type specimen book" + "</p>" + "<ul>" + "	<li>"
						+ "	<a href=\"#\">Ut wisi enim ad minim veniam, quis nostrud</a>" + "	</li>" + "	<li>"
						+ "	<a href=\"#\">Exerci tation ullamcorper suscipit lobortis nisl aliquip</a>" + "	</li>"
						+ "	<li>" + "	<a href=\"#\">Duis autem vel eum iriure dolor</a>" + "	</li>" + "</ul>");
		paragraph.getText().addText(Language.Macedonian,
				"<h2>За нас</h2>" + "<p>Содржина на македонски јазик. Оваа е обичен текст за да поплни место"
						+ "	и да се добие изглед. Тој ќе се замени потоа со вистински содржински"
						+ "	текст. Текст голем, мал или среден. Александар Македонски е македонски крал од династијата Аргеади, "
						+ " син на Филип II Македонски и Олимпија, ќерка на молоскиот владетел Неоптолем. " + "</p>"
						+ "<ul>" + "	<li>" + "	<a href=\"#\">Доаѓање на власт</a>" + "	</li>" + "	<li>"
						+ "	<a href=\"#\">Период на освојувањa</a>" + "	</li>" + "	<li>"
						+ "	<a href=\"#\">Личен живот</a>" + "	</li>" + "</ul>");

		// media
		Media media = new Media();
		media.setType(MediaType.Image);
		media.setSrc("/static/img/1.jpg");
		media.setExternal(false);
		paragraph.setMedia(media);
		
		// return
		return paragraph;
	}


	private Paragraph createParagraphOnlyText() {
		Paragraph paragraph = new Paragraph();
		paragraph.setLayout(ParagraphLayout.TextLeftMediaRight);
		paragraph.setText(new LocalText(LocalTextType.Rich));
		paragraph.getText().addText(Language.English,
				"<p>Lorem Ipsum is simply dummy text of the printing and"
						+ "	typesetting industry. Lorem Ipsum has been the industry's standard"
						+ "	dummy text ever since the 1500s, when an unknown printer took a"
						+ "	galley of type and scrambled it to make a type specimen book."
						+ " Lorem Ipsum is simply dummy text of the printing and"
						+ "	typesetting industry. Lorem Ipsum has been the industry's standard"
						+ "	dummy text ever since the 1500s, when an unknown printer took a"
						+ "	galley of type and scrambled it to make a type specimen book." + "</p>");
		paragraph.getText().addText(Language.Macedonian,
				"<p>Содржина на македонски јазик. Оваа е обичен текст за да поплни место"
						+ "	и да се добие изглед. Тој ќе се замени потоа со вистински содржински"
						+ "	текст. Текст голем, мал или среден. Александар Македонски е македонски крал од династијата Аргеади, "
						+ " син на Филип II Македонски и Олимпија, ќерка на молоскиот владетел Неоптолем. "
						+ " Содржина на македонски јазик. Оваа е обичен текст за да поплни место"
						+ "	и да се добие изглед. Тој ќе се замени потоа со вистински содржински"
						+ "	текст. Текст голем, мал или среден. Александар Македонски е македонски крал од династијата Аргеади, "
						+ " син на Филип II Македонски и Олимпија, ќерка на молоскиот владетел Неоптолем. " + "</p>");
		
		// link to page
		paragraph.setPage(StubUtils.createPageReadMore(new CmsPage()));
		return paragraph;
	}
	
}
