package mybatis.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelArticle {
    
     
    Integer  articleno     ;
    String   boardcd       ;
    String   title         ;
    String   content       ;
    String   email         ;
    Integer  hit           ;
    Date     regdate       ;
    Boolean  UseYN         ;
    
    String   INSERTUID     ;
    Date     INSERTDT      ;
    String   UPDATEUID     ;
    Date     UPDATEDT      ;
    
    
    public Integer getArticleno() {
        return articleno;
    }
    public void setArticleno(Integer articleno) {
        this.articleno = articleno;
    }
    public String getBoardcd() {
        return boardcd;
    }
    public void setBoardcd(String boardcd) {
        this.boardcd = boardcd;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getHit() {
        return hit;
    }
    public void setHit(Integer hit) {
        this.hit = hit;
    }
    public Date getRegdate() {
        return regdate;
    }
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
    public Boolean getUseYN() {
        return UseYN;
    }
    public void setUseYN( Boolean UseYN) {
        this.UseYN = UseYN;
    }
    public String getINSERTUID() {
        return INSERTUID;
    }
    public void setINSERTUID(String INSERTUID) {
        this.INSERTUID = INSERTUID;
    }
    public Date getINSERTDT() {
        return INSERTDT;
    }
    public void setINSERTDT(Date INSERTDT) {
        this.INSERTDT = INSERTDT;
    }
    public String getUPDATEUID() {
        return UPDATEUID;
    }
    public void setUPDATEUID(String UPDATEUID) {
        this.UPDATEUID = UPDATEUID;
    }
    public Date getUPDATEDT() {
        return UPDATEDT;
    }
    public void setUPDATEDT(Date UPDATEDT) {
        this.UPDATEDT = UPDATEDT;
    }
    public ModelArticle() {
        super();
    }
    public ModelArticle(Integer articleno, String boardcd, String title,
            String content, String email, Integer hit, Date regdate,
            Boolean UseYN, String INSERTUID, Date INSERTDT, String UPDATEUID,
            Date UPDATEDT) {
        super();
        this.articleno = articleno;
        this.boardcd = boardcd;
        this.title = title;
        this.content = content;
        this.email = email;
        this.hit = hit;
        this.regdate = regdate;
        this.UseYN = UseYN;
        this.INSERTUID = INSERTUID;
        this.INSERTDT = INSERTDT;
        this.UPDATEUID = UPDATEUID;
        this.UPDATEDT = UPDATEDT;
    }
    @Override
    public String toString() {
        return "ModelArticle [articleno=" + articleno + ", boardcd=" + boardcd
                + ", title=" + title + ", content=" + content + ", email="
                + email + ", hit=" + hit + ", regdate=" + regdate + ", UseYN="
                + UseYN + ", INSERTUID=" + INSERTUID + ", INSERTDT=" + INSERTDT
                + ", UPDATEUID=" + UPDATEUID + ", UPDATEDT=" + UPDATEDT + "]";
    }
    
  
    
}
