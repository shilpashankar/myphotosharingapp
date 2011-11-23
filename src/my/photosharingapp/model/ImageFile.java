package my.photosharingapp.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ImageFile {
	private String filename;
	private CommonsMultipartFile imageFileData;

	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public CommonsMultipartFile getImageFileData() {
		return imageFileData;
	}

	public void setImageFileData(CommonsMultipartFile imageFileData) {
		this.imageFileData = imageFileData;
	}
}
