package pojo;
// Generated Jun 15, 2020, 2:25:07 PM by Hibernate Tools 4.3.1



/**
 * DiemId generated by hbm2java
 */
public class DiemId  implements java.io.Serializable {


     private String mssv;
     private String maMon;

    public DiemId() {
    }

    public DiemId(String mssv, String maMon) {
       this.mssv = mssv;
       this.maMon = maMon;
    }
   
    public String getMssv() {
        return this.mssv;
    }
    
    public void setMssv(String mssv) {
        this.mssv = mssv;
    }
    public String getMaMon() {
        return this.maMon;
    }
    
    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DiemId) ) return false;
		 DiemId castOther = ( DiemId ) other; 
         
		 return ( (this.getMssv()==castOther.getMssv()) || ( this.getMssv()!=null && castOther.getMssv()!=null && this.getMssv().equals(castOther.getMssv()) ) )
 && ( (this.getMaMon()==castOther.getMaMon()) || ( this.getMaMon()!=null && castOther.getMaMon()!=null && this.getMaMon().equals(castOther.getMaMon()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getMssv() == null ? 0 : this.getMssv().hashCode() );
         result = 37 * result + ( getMaMon() == null ? 0 : this.getMaMon().hashCode() );
         return result;
   }   


}


