package my.photosharingapp.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import my.photosharingapp.dao.UploadImageDAO;
import my.photosharingapp.model.Image;

public class UploadImageService {

	UploadImageDAO uploadImageDAO;

	@Autowired
	public void setUploadImageDAO(UploadImageDAO uploadImageDAO) {
		this.uploadImageDAO = uploadImageDAO;
	}
	
	public void saveImage(CommonsMultipartFile imageFileData){		
		try {
//			UploadImageDAO uploadImageDAO = new UploadImageDAO();
			File targetImageFile = File.createTempFile("image",".png", getSaveLocation());
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(targetImageFile));
			out.write(imageFileData.getBytes());
			out.close();
			Image image = new Image();
			image.setImageName(targetImageFile.getName());
			image.setImageLoc(targetImageFile.getAbsolutePath());
			uploadImageDAO.saveImageDB(image);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
//		System.out.println(getSaveLocation().getAbsolutePath());
	}
	
	public File getSaveLocation(){
		String fileLocation = System.getProperty("user.home")+File.separator+".baba";
		File parentDirectory = new File(fileLocation);
		if(!parentDirectory.exists()){
			parentDirectory.mkdir();	
		}
		return parentDirectory;
	}	
	
	public List<String> retrieveUploadedImagesPath() {
		List<String> imagesPath = new ArrayList<String>();
		Iterator<Image> iterator = uploadImageDAO.retrieveImages().iterator();
		while (iterator.hasNext()) {
			imagesPath.add(iterator.next().getImageLoc());
		}
		return imagesPath;
	}
}
