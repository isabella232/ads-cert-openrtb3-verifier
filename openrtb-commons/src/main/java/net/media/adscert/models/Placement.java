package net.media.adscert.models;

import lombok.Getter;
import lombok.Setter;
import net.media.adscert.models.validator.CheckAtLeastOneNotNull;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
public class Placement {

  private static final Integer DEFAULT_SERVER_SIDE_AD_INSERTION = 0;
  private static final Integer DEFAULT_REWARDED_PLACEMENT = 0;

  private String tagid;
  private Integer ssai = DEFAULT_SERVER_SIDE_AD_INSERTION;
  private String sdk;
  private String sdkver;
  private Integer reward = DEFAULT_REWARDED_PLACEMENT;
  private Collection<String> wlang;
  private Integer secure;
  private Integer admx;
  private Integer curlx;
  @Valid
  private DisplayPlacement display;
  @Valid
  private VideoPlacement video;
  @Valid
  private AudioPlacement audio;
  private Object ext;

  public String getTagid() {
    return this.tagid;
  }

  public Integer getSsai() {
    return this.ssai;
  }

  public String getSdk() {
    return this.sdk;
  }

  public String getSdkver() {
    return this.sdkver;
  }

  public Integer getReward() {
    return this.reward;
  }

  public Collection<String> getWlang() {
    return this.wlang;
  }

  public Integer getSecure() {
    return this.secure;
  }

  public Integer getAdmx() {
    return this.admx;
  }

  public Integer getCurlx() {
    return this.curlx;
  }

  public @Valid DisplayPlacement getDisplay() {
    return this.display;
  }

  public @Valid VideoPlacement getVideo() {
    return this.video;
  }

  public @Valid AudioPlacement getAudio() {
    return this.audio;
  }

  public Object getExt() {
    return this.ext;
  }

  public void setTagid(String tagid) {
    this.tagid = tagid;
  }

  public void setSsai(Integer ssai) {
    this.ssai = ssai;
  }

  public void setSdk(String sdk) {
    this.sdk = sdk;
  }

  public void setSdkver(String sdkver) {
    this.sdkver = sdkver;
  }

  public void setReward(Integer reward) {
    this.reward = reward;
  }

  public void setWlang(Collection<String> wlang) {
    this.wlang = wlang;
  }

  public void setSecure(Integer secure) {
    this.secure = secure;
  }

  public void setAdmx(Integer admx) {
    this.admx = admx;
  }

  public void setCurlx(Integer curlx) {
    this.curlx = curlx;
  }

  public void setDisplay(@Valid DisplayPlacement display) {
    this.display = display;
  }

  public void setVideo(@Valid VideoPlacement video) {
    this.video = video;
  }

  public void setAudio(@Valid AudioPlacement audio) {
    this.audio = audio;
  }

  public void setExt(Object ext) {
    this.ext = ext;
  }
}