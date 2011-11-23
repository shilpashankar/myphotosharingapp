package my.photosharingapp.dao;

import java.util.List;

import my.photosharingapp.model.Image;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class UploadImageDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void saveImageDB(Image image) {
		sessionFactory.getCurrentSession().save(image);
		System.out.println(image.getImageName() + " location is "
				+ image.getImageLoc());
	}

	@Transactional
	public List<Image> retrieveImages() {

		List<Image> images = null;
		try {
			images = (List<Image>) sessionFactory.getCurrentSession()
					.createQuery("from Image").list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return images;
	}
}
