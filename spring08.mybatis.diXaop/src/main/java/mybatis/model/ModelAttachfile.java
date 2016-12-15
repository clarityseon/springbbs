package mybatis.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelAttachfile {
   
    
    Integer    attachfileno   ;
    String     filename       ;
    String     filetype       ;
    Integer    filesize       ;
    Integer    articleno      ;
    Boolean    useyn          ;
    String     insertuid      ;
    Date       insertdt       ;
    String     updateuid      ;
    Date       updatedt       ;
    
    
    
    public Integer getAttachfileno() {
        return attachfileno;
    }
    public void setAttachfileno(Integer attachfileno) {
        this.attachfileno = attachfileno;
    }
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public String getFiletype() {
        return filetype;
    }
    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }
    public Integer getFilesize() {
        return filesize;
    }
    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }
    public Integer getArticleno() {
        return articleno;
    }
    public void setArticleno(Integer articleno) {
        this.articleno = articleno;
    }
    public Boolean getUseyn() {
        return useyn;
    }
    public void setUseyn(Boolean useyn) {
        this.useyn = useyn;
    }
    public String getInsertuid() {
        return insertuid;
    }
    public void setInsertuid(String insertuid) {
        this.insertuid = insertuid;
    }
    public Date getInsertdt() {
        return insertdt;
    }
    public void setInsertdt(Date insertdt) {
        this.insertdt = insertdt;
    }
    public String getUpdateuid() {
        return updateuid;
    }
    public void setUpdateuid(String updateuid) {
        this.updateuid = updateuid;
    }
    public Date getUpdatedt() {
        return updatedt;
    }
    public void setUpdatedt(Date updatedt) {
        this.updatedt = updatedt;
    }
    public ModelAttachfile() {
        super();
    }
    public ModelAttachfile(Integer attachfileno, String filename,
            String filetype, Integer filesize, Integer articleno, Boolean useyn,
            String insertuid, Date insertdt, String updateuid, Date updatedt) {
        super();
        this.attachfileno = attachfileno;
        this.filename = filename;
        this.filetype = filetype;
        this.filesize = filesize;
        this.articleno = articleno;
        this.useyn = useyn;
        this.insertuid = insertuid;
        this.insertdt = insertdt;
        this.updateuid = updateuid;
        this.updatedt = updatedt;
    }
    @Override
    public String toString() {
        return "ModelAttachfile [attachfileno=" + attachfileno + ", filename="
                + filename + ", filetype=" + filetype + ", filesize=" + filesize
                + ", articleno=" + articleno + ", useyn=" + useyn
                + ", insertuid=" + insertuid + ", insertdt=" + insertdt
                + ", updateuid=" + updateuid + ", updatedt=" + updatedt + "]";
    }
    
    
 
    
}
