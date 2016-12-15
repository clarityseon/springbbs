package mybatis.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelComments {
    
    Integer     commentno    ;
    Integer     articleno    ;
    String      email        ;
    String      memo         ;
    Date        regdate      ;
   
    Boolean     UseYN        ;   
   
    String      InsertUID    ;     
    Date        InsertDT     ;
    String      UpdateUID    ;     
    Date        UpdateDT     ;
   
    
    
    public Integer getCommentno() {
        return commentno;
    }
    public void setCommentno(Integer commentno) {
        this.commentno = commentno;
    }
    public Integer getArticleno() {
        return articleno;
    }
    public void setArticleno(Integer articleno) {
        this.articleno = articleno;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
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
    public void setUseYN(Boolean useYN) {
        UseYN = useYN;
    }
    public String getInsertUID() {
        return InsertUID;
    }
    public void setInsertUID(String insertUID) {
        InsertUID = insertUID;
    }
    public Date getInsertDT() {
        return InsertDT;
    }
    public void setInsertDT(Date insertDT) {
        InsertDT = insertDT;
    }
    public String getUpdateUID() {
        return UpdateUID;
    }
    public void setUpdateUID(String updateUID) {
        UpdateUID = updateUID;
    }
    public Date getUpdateDT() {
        return UpdateDT;
    }
    public void setUpdateDT(Date updateDT) {
        UpdateDT = updateDT;
    }
    public ModelComments() {
        super();
    }
    public ModelComments(Integer commentno, Integer articleno, String email,
            String memo, Date regdate, Boolean useYN, String insertUID,
            Date insertDT, String updateUID, Date updateDT) {
        super();
        this.commentno = commentno;
        this.articleno = articleno;
        this.email = email;
        this.memo = memo;
        this.regdate = regdate;
        UseYN = useYN;
        InsertUID = insertUID;
        InsertDT = insertDT;
        UpdateUID = updateUID;
        UpdateDT = updateDT;
    }
    @Override
    public String toString() {
        return "ModelComments [commentno=" + commentno + ", articleno="
                + articleno + ", email=" + email + ", memo=" + memo
                + ", regdate=" + regdate + ", UseYN=" + UseYN + ", InsertUID="
                + InsertUID + ", InsertDT=" + InsertDT + ", UpdateUID="
                + UpdateUID + ", UpdateDT=" + UpdateDT + "]";
    }
    
    
}
