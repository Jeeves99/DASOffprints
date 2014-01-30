package com.jeversoft.android.sqlite.first;

public class OffPrint {
  private long id;
  private String author;
  private String title;
  private int year;
  private String proceedings;
  private String copies;
  private int pages;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getOffPrint() {
    return "";
  }

  public void setOffPrint(String comment) {
    this.author = comment;
  }

  // Will be used by the ArrayAdapter in the ListView
  @Override
  public String toString() {
    return author;
  }
}