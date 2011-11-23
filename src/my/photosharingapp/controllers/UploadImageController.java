package my.photosharingapp.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.photosharingapp.model.ImageFile;
import my.photosharingapp.service.UploadImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadImageController {
	ServletConfig config;
	UploadImageService uploadImageService;
	
	@Autowired
	public void setUploadImageService(UploadImageService uploadImageService) {
		this.uploadImageService = uploadImageService;
	}

	@RequestMapping(value = "/browsefile", method = RequestMethod.GET)
	public String getUploadForm(Model model) {
		model.addAttribute(new ImageFile());
		return "/browsefile";
	}

	@RequestMapping(value = "/browsefile", method = RequestMethod.POST)
	public String create(ImageFile imageFile, BindingResult result,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		CommonsMultipartFile file = imageFile.getImageFileData();		
		uploadImageService.saveImage(file);
		return "redirect:/views/browsefile";
	}
	
	@RequestMapping(value = "/viewuploadedimages", method = RequestMethod.GET)
	public ModelAndView showRegistration(HttpSession session) {
		System.out.println("In view album");
		List<String> imagesPath = uploadImageService.retrieveUploadedImagesPath();
		session.setAttribute("sessionImage", imagesPath.get(0));
		return new ModelAndView("viewuploadedimages", "imagesPath", imagesPath);
	}	

}
