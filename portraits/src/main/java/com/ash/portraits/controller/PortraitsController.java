package com.ash.portraits.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ash.portraits.model.PortraitDetail;
import com.ash.portraits.service.PortraitsService;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/paintings")
public class PortraitsController {

	@Autowired
	private PortraitsService portraitService;
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> addPortrait(
            @RequestParam(value = "id") String id,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "image", required = false) MultipartFile imageFile,
            @RequestParam(value = "portraitType", required = false) String portraitType,
            @RequestParam(value = "price", required = false) Double price,
            @RequestParam(value = "dimensions", required = false) String dimensions,
            @RequestParam(value = "mediumUsed", required = false) String mediumUsed,
            @RequestParam(value = "material", required = false) String material) {
 
		PortraitDetail portraitDetail = new PortraitDetail();
	    try {
	        portraitDetail.setId(id);
	        portraitDetail.setTitle(title);
	        portraitDetail.setDescription(description);
	        portraitDetail.setPortraitType(portraitType);
	        portraitDetail.setPrice(price);
	        portraitDetail.setDimensions(dimensions);
	        portraitDetail.setMaterial(material);
	        portraitDetail.setMediumUsed(mediumUsed);
	        //portraitDetail.setImage(imageFile);
	        portraitDetail.setImage(imageFile.getBytes());
	        
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Failed to create portrait: " + e.getMessage());
	    }
		
		return  portraitService.createPortrait(portraitDetail);
	}
	
	@PutMapping
	public ResponseEntity<String> updatePortrait(
            @RequestParam(value = "id") String id,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "image", required = false) MultipartFile imageFile,
            @RequestParam(value = "portraitType", required = false) String portraitType,
            @RequestParam(value = "price", required = false) Double price,
            @RequestParam(value = "dimensions", required = false) String dimensions,
            @RequestParam(value = "mediumUsed", required = false) String mediumUsed,
            @RequestParam(value = "material", required = false) String material,
	        @RequestParam(value = "status", required = false) String status) {
    	PortraitDetail portraitDetail = new PortraitDetail();
		 try {
		        portraitDetail.setId(id);
		        portraitDetail.setTitle(title);
		        portraitDetail.setDescription(description);
		        portraitDetail.setPortraitType(portraitType);
		        portraitDetail.setPrice(price);
		        portraitDetail.setDimensions(dimensions);
		        portraitDetail.setMaterial(material);
		        portraitDetail.setMediumUsed(mediumUsed);
		        portraitDetail.setPortraitStatus(status);
		        //portraitDetail.setImage(imageFile);

		        portraitService.updatePortrait(portraitDetail);
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
		                .body("Failed to update portrait: " + e.getMessage());
		    }
		return portraitService.updatePortrait(portraitDetail);
	}

	@GetMapping
	public List<PortraitDetail> getAllPortraits() {
		return portraitService.getAllPortraits();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> getPortraitDetail(@PathVariable String id) {
		if (id == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", "Id must not b null"));

		}
	    return portraitService.getPortraitDetail(id);
	}

}