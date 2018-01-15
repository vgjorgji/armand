package com.armand.cms.core.design.model;

public enum FeedFilter {
  // standard
  Latest,
  Popular,
  Views,

  // event
  Upcoming,
  Current,
  Past,

  // public procurement, (survey, quiz)
  Active,
  Finished,

  // project
  Preparing,
  Constructing,
  Maintenance,

  // partner
  VIP;
}
