package pojo;
// Generated Jun 15, 2020, 2:25:07 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Lopmonhoc generated by hbm2java
 */
public class Lopmonhoc  implements java.io.Serializable {


     private LopmonhocId id;
     private Lop lop;
     private Monhoc monhoc;
     private Phong phong;
     private Set sinhviens = new HashSet(0);

    public Lopmonhoc() {
    }

	
    public Lopmonhoc(LopmonhocId id, Lop lop, Monhoc monhoc) {
        this.id = id;
        this.lop = lop;
        this.monhoc = monhoc;
    }
    public Lopmonhoc(LopmonhocId id, Lop lop, Monhoc monhoc, Phong phong, Set sinhviens) {
       this.id = id;
       this.lop = lop;
       this.monhoc = monhoc;
       this.phong = phong;
       this.sinhviens = sinhviens;
    }
   
    public LopmonhocId getId() {
        return this.id;
    }
    
    public void setId(LopmonhocId id) {
        this.id = id;
    }
    public Lop getLop() {
        return this.lop;
    }
    
    public void setLop(Lop lop) {
        this.lop = lop;
    }
    public Monhoc getMonhoc() {
        return this.monhoc;
    }
    
    public void setMonhoc(Monhoc monhoc) {
        this.monhoc = monhoc;
    }
    public Phong getPhong() {
        return this.phong;
    }
    
    public void setPhong(Phong phong) {
        this.phong = phong;
    }
    public Set getSinhviens() {
        return this.sinhviens;
    }
    
    public void setSinhviens(Set sinhviens) {
        this.sinhviens = sinhviens;
    }




}


