package com.armand.cms.core.conf;

import java.util.Set;

import com.armand.cms.core.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Component {
  // mandatory
  Header(Utils.asSet(ComponentStyle.Learn)),
  Navigation(Utils.asSet(ComponentStyle.Learn)),
  Footer(Utils.asSet(ComponentStyle.Learn)),

  // content
  Titles(Utils.asSet(ComponentStyle.Learn)),
  Paragraphs(Utils.asSet(ComponentStyle.Learn)),
  Medias(Utils.asSet(ComponentStyle.Learn)),
  Links(Utils.asSet(ComponentStyle.Learn)),

  // standard
  Jumbotron(Utils.asSet(ComponentStyle.Learn, ComponentStyle.Training)),
  Highlights(Utils.asSet(ComponentStyle.Learn)),
  ContactInfos(Utils.asSet(ComponentStyle.Learn)),
  ContactForms(Utils.asSet(ComponentStyle.Learn)),
  Feed(Utils.asSet(ComponentStyle.Learn)),

  // special
  Testimonials(Utils.asSet(ComponentStyle.Learn)),
  Staff(Utils.asSet(ComponentStyle.Learn)),
  ClassSchedule(Utils.asSet(ComponentStyle.Learn)),

  // ????
  EventsCalendar(Utils.asSet(ComponentStyle.Learn));


  private Set<ComponentStyle> supportedStyles;

}
