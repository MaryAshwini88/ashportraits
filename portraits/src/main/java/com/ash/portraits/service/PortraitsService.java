package com.ash.portraits.service;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ash.portraits.model.PortraitDetail;
import com.ash.portraits.repository.PortraitsRepository;

@Service
public class PortraitsService {
	
    @Autowired
    private PortraitsRepository portraitsRepository;
    
//    @Autowired
//	private ImageUploadService imageUploader;

 
    public ResponseEntity<String> createPortrait(PortraitDetail portrait) {
    	Optional<PortraitDetail> existingPortraitDetail = portraitsRepository.findById(portrait.getId());
    	if (existingPortraitDetail.isPresent()) {
    		throw new RuntimeException("Drawing with ID " + portrait.getId() + " already exists.");
    	} 
    	try {
    		System.out.println("Uploaded image size: " + portrait.getImage().length + " bytes");
//    		String imageUrl = imageUploader.uploadImage(portrait.getImage());
//    		portrait.setImageUrl(imageUrl);
    		portraitsRepository.save(portrait);

    	} catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload portrait");
        }
        return  ResponseEntity.status(HttpStatus.CREATED).body("Created successfully");
    }
    
    public ResponseEntity<String> updatePortrait(PortraitDetail updatedDrawing) {
    	Optional<PortraitDetail> existingPortraitDetail = portraitsRepository.findById(updatedDrawing.getId());

    	if (existingPortraitDetail.isPresent()) {
    		try {
//	    		String imageUrl = imageUploader.uploadImage(updatedDrawing.getImage());
//	    		updatedDrawing.setImageUrl(imageUrl);
	    		portraitsRepository.save(updatedDrawing);
    		} catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload portrait");
            }
    	} else {
    		throw new RuntimeException("Drawing with ID " + updatedDrawing.getId() + " not found.");
    	}
        return  ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
    }
    
    public List<PortraitDetail> getAllPortraits() {
    	
    	List<PortraitDetail> portraitList =  portraitsRepository.findAll();

        return portraitList;
    }

	public ResponseEntity<Map<String, Object>> getPortraitDetail(String id) {
    	Optional<PortraitDetail> portrait = portraitsRepository.findById(id);

		if (portrait.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }
		Map<String, Object> response = new HashMap<>();
	    response.put("id", portrait.get().getId());
	    response.put("title", portrait.get().getTitle());
	    response.put("description", portrait.get().getDescription());
	    response.put("price", portrait.get().getPrice());
	    response.put("mediumUsed", portrait.get().getMediumUsed());
	    response.put("material", portrait.get().getMaterial());
	    response.put("dimensions", portrait.get().getDimensions());
	    response.put("portraitType", portrait.get().getPortraitType());
//	    response.put("imageUrl", portrait.get().getImageUrl());
	    String base64Image = Base64.getEncoder().encodeToString(portrait.get().getImage());

	    response.put("image", base64Image);

	    return ResponseEntity.ok(response);
	}


}