package net.media.adscert.models;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * Created by shiva.b on 14/12/18.
 */
public class DataAssetFormat {
  @NotNull
  private Integer type;
  private Integer len;
  private Map<String, Object> ext;

  public @NotNull Integer getType() {
    return this.type;
  }

  public Integer getLen() {
    return this.len;
  }

  public Map<String, Object> getExt() {
    return this.ext;
  }

  public void setType(@NotNull Integer type) {
    this.type = type;
  }

  public void setLen(Integer len) {
    this.len = len;
  }

  public void setExt(Map<String, Object> ext) {
    this.ext = ext;
  }
}