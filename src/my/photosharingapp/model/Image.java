package my.photosharingapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Images")
public class Image {
	
	@Column(name="Image_id")
	@Id
	@GeneratedValue
	private int imageId;

	@Column(name="Image_Name")
	private String imageName;
	
	@Column(name="Image_Loc")
	private String imageLoc;
	
	@Column(name="Image_Created_Dt")
	private Date imageCreatedDt;
		
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageLoc() {
		return imageLoc;
	}
	public void setImageLoc(String imageLoc) {
		this.imageLoc = imageLoc;
	}
	public Date getImageCreatedDt() {
		return imageCreatedDt;
	}
	public void setImageCreatedDt(Date imageCreatedDt) {
		this.imageCreatedDt = imageCreatedDt;
	}

}
