package com.springboot.web.controller;

public class Alien {
  private String aid;
  private String aname;

  public String getAid() {
    return aid;
  }

  public void setAid(String aid) {
    this.aid = aid;
  }

  public String getAname() {
    return aname;
  }

  public void setAname(String aname) {
    this.aname = aname;
  }

  @Override
  public String toString() {
    return "Alien [aid=" + aid + ", aname=" + aname + "]";
  }

  public Alien(String aid, String aname) {
    this.aid = aid;
    this.aname = aname;
  }

  public Alien() {
    super();
  }
}
