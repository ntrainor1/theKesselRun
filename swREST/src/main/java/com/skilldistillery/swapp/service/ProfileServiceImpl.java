package com.skilldistillery.swapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.swapp.Profile;
import com.skilldistillery.swapp.repository.ProfileRepo;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepo profileRepo;
	
	@Override
	public List<Profile> index() {
		return profileRepo.findAll();
	}

	@Override
	public Profile show(Integer id) {
		return profileRepo.findById(id).get();
		
	}

	@Override
	public Profile create(Profile profile) {
		return profileRepo.saveAndFlush(profile);
		
	}

	@Override
	public Profile update(int id, Profile profile) {
		Profile managedProfile = profileRepo.findById(id).get();
		managedProfile.setName((profile.getName()));
		managedProfile.setUser((profile.getUser()));
		managedProfile.setImageUrl((profile.getImageUrl()));
		managedProfile.setItems(profile.getItems());
		managedProfile.setCrew(profile.getCrew());
		managedProfile.setCredits(profile.getCredits());
		managedProfile.setSpecies(profile.getSpecies());
		return profileRepo.saveAndFlush(managedProfile);		
	}

	@Override
	public void destroy(int id) {
		profileRepo.delete(profileRepo.findById(id).get());
	}

}
